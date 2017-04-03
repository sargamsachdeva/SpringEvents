package com.springevents.ques1;

public class Employee {

    Integer empId;
    String name;
    String emailId;
    Integer salary;

    public Integer getEmpId() {
        return empId;
    }

    public Employee setEmpId(Integer empId) {
        this.empId = empId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public Employee setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public Integer getSalary() {
        return salary;
    }

    public Employee setSalary(Integer salary) {
        this.salary = salary;
        return this;
    }
}
