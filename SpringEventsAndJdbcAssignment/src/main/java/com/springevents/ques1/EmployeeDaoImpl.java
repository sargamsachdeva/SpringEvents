package com.springevents.ques1;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insertEmployeeRecords(List<Employee> emps) {

        String query = "insert into employee (empId,name,emailId,salary) values (?,?,?,?)";
        List<Object[]> inputList = new ArrayList<Object[]>();
        for (Employee emp : emps) {
            Object[] temp = {emp.getEmpId(), emp.getName(), emp.getEmailId(), emp.getSalary()};
            inputList.add(temp);
        }
        jdbcTemplate.batchUpdate(query, inputList);
    }
}
