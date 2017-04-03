package com.springevents.ques1;

import org.springframework.context.ApplicationListener;

import javax.swing.*;

public class CustomEventListener implements ApplicationListener<CustomEvent> {

    public void onApplicationEvent(CustomEvent event) {

        if(event.getSource() instanceof Employee)
        {
            Employee employee = (Employee) event.getSource();

            System.out.println(" Emp Id: " + employee.getEmpId() + "\n Emp name:" +employee.getName() +
                    "\n Emp email Id:" +employee.getEmailId() + "\n Emp salary:" +employee.getSalary());
            if(employee.getSalary() > 30000) {

                JOptionPane.showMessageDialog(null, employee.getName()+"'s"  +
                        " salary is greater than 30k");
            }



        }
    }
}
