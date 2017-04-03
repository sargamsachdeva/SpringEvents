package com.springevents.ques2;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtmDaoImpl implements AtmDao {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public Atm withdraw(final Integer pin) {

        String sql = "select * from Atm2 where pin = ?";

        final Integer withdrawlAmount;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter money to be withdrawn:");
        withdrawlAmount = input.nextInt();

        Atm atm= jdbcTemplate.queryForObject(sql, new Object[]{pin}, new RowMapper<Atm>() {

            public Atm mapRow(ResultSet resultSet, int i) throws SQLException {

                Atm atm1 = new Atm();
                Integer balance1 = resultSet.getInt("balance");
                Integer pin=resultSet.getInt("pin");

                if (balance1 >= withdrawlAmount) {
                    balance1 = balance1 - withdrawlAmount;

                    System.out.println("Please collect your money");
                    System.out.println("Left balance in your account is: " + balance1);

                    atm1.setBalance(balance1);
                   update(balance1,pin);
                } else {
                    System.out.println("Not enough money in your account!!");
                }

                    return atm1;
            }
        });
        return atm;
    }

    public Atm changePin(Integer pin) {


        Atm atm1 = new Atm();
        final Integer newPin;
        Integer otp;
        int a = 1000 + (int) (Math.random() * ((10000 - 1000) + 1));
        System.out.println("Your OTP is: ");
        System.out.println(a);

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the OTP: ");
        otp = input.nextInt();

        if (otp == a) {
            System.out.print("Enter new pin: ");
            newPin = input.nextInt();

            String sql1 = "update Atm2 set pin = " + newPin + "  where pin = ?";
            jdbcTemplate.update(sql1, new Object[]{pin});

            System.out.println("Updated Record with new pin= " + newPin);

            atm1.setPin(newPin);
        }
        else {
            System.out.println("OTP doesn't match!!");
        }

        return atm1;
    }

    public Atm changeMobileNumber(Integer pin) {

        Atm atm1 = new Atm();
        final Integer newMobileNumber;

        Integer otp;
        int a = 1000 + (int) (Math.random() * ((10000 - 1000) + 1));
        System.out.println("Your OTP is: ");
        System.out.println(a);

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the OTP: ");
        otp = input.nextInt();

        if (otp == a) {
            System.out.print("Enter new mobile number: ");
            newMobileNumber = input.nextInt();

            String sql1 = "update Atm2 set mobileNumber = " + newMobileNumber + "  where pin = ?";
            jdbcTemplate.update(sql1, new Object[]{pin});

            System.out.println("Updated Record with new mobile number= " + newMobileNumber);

            atm1.setMobileNumber(newMobileNumber);
        }

        else {

            System.out.println("OTP doesn't match!!");
        }
        return atm1;

    }



    public void update(Integer balance,Integer pin) {

            String sql1 = "update Atm2 set balance = ?  where pin = ?" ;
            jdbcTemplate.update(sql1, new Object[]{balance,pin});

             System.out.println("Updated Record with balance= " + balance);

        }


}
