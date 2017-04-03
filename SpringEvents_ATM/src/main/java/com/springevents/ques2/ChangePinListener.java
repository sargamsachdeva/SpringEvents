package com.springevents.ques2;

import org.springframework.context.ApplicationListener;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChangePinListener implements ApplicationListener<ChangePinEvent> {

    public void onApplicationEvent(ChangePinEvent event) {

        if (event.getSource() instanceof Atm) {
            Atm atm = (Atm) event.getSource();
            System.out.println("Change pin event fired..");
            JOptionPane.showMessageDialog(null,"New Pin is: " +atm.getPin());
        }
    }
}
