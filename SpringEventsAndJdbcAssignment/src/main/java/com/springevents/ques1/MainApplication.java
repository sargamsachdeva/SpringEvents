package com.springevents.ques1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");

        EmployeeDao employeeDao = (EmployeeDao) applicationContext.getBean("employeeDao");

        List<Employee> inputs = new ArrayList<Employee>();
        Employee e1 = new Employee();
        e1.setEmpId(1);
        e1.setName("John");
        e1.setEmailId("john@gmail.com");
        e1.setSalary(50000);
        inputs.add(e1);

        Employee e2 = new Employee();
        e2.setEmpId(2);
        e2.setName("Amar");
        e2.setEmailId("amar@gmail.com");
        e2.setSalary(150000);
        inputs.add(e2);

        Employee e3 = new Employee();
        e3.setEmpId(3);
        e3.setName("Amit");
        e3.setEmailId("amit@gmail.com");
        e3.setSalary(1500);
        inputs.add(e3);

        Employee e4 = new Employee();
        e4.setEmpId(4);
        e4.setName("Sargam");
        e4.setEmailId("sargam@gmail.com");
        e4.setSalary(250000);
        inputs.add(e4);

        EventPublisher publisher = applicationContext.getBean("eventPublisher",EventPublisher.class);
        CustomEvent event = new CustomEvent(e1);
        CustomEvent event1 = new CustomEvent(e2);
        CustomEvent event2 = new CustomEvent(e3);
        CustomEvent event3 = new CustomEvent(e4);
        publisher.publish(event);
        publisher.publish(event1);
        publisher.publish(event2);
        publisher.publish(event3);
        employeeDao.insertEmployeeRecords(inputs);

    }

}

