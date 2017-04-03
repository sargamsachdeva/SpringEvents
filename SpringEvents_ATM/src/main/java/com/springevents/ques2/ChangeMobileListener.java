package com.springevents.ques2;

import org.springframework.context.ApplicationListener;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChangeMobileListener implements ApplicationListener<ChangeMobileEvent> {

    public void onApplicationEvent(ChangeMobileEvent event) {


        if (event.getSource() instanceof Atm) {
            Atm atm = (Atm) event.getSource();

                JOptionPane.showMessageDialog(null, "New mobile Number is: " + atm.getMobileNumber());
            }
        }
    }

