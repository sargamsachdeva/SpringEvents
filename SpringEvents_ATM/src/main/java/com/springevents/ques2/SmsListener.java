package com.springevents.ques2;

import org.springframework.context.ApplicationListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class SmsListener implements ApplicationListener<SmsEvent> {


    public void onApplicationEvent(SmsEvent event) {

        if (event.getSource() instanceof Atm) {
            Atm atm = (Atm) event.getSource();
            System.out.println("Withdrawl event fired");
            JOptionPane.showMessageDialog(null, "Left amount is: " + atm.getBalance());


        }
    }
}


