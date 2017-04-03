package com.springevents.ques2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");

        AtmDao atmDao = (AtmDao) applicationContext.getBean("atmDao");
        Atm atm = new Atm();

       // atm.setBalance(5454);
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("Automated Teller Machine");
            System.out.println("Choose 1 for Withdraw");
            System.out.println("Choose 2 for Change Pin");
            System.out.println("Choose 3 for Change Mobile Number");
            System.out.println("Choose 4 for EXIT");
            System.out.print("Choose the operation you want to perform:");
            int n = s.nextInt();
            switch (n) {
                case 1:
                    SmsPublisher publisher = applicationContext.getBean("smsEventPublisher",SmsPublisher.class);
                    SmsEvent event = new SmsEvent(atmDao.withdraw(1011));
                    publisher.publish(event);
                    break;

                case 2:
                    ChangePinPublisher changePinPublisher = applicationContext.getBean("changePinPublisher",ChangePinPublisher.class);
                    ChangePinEvent changePinEvent = new ChangePinEvent(atmDao.changePin(2345));
                    changePinPublisher.publish(changePinEvent);
                    break;

                case 3:
                    ChangeMobilePublisher changeMobilePublisher = applicationContext.getBean("changeMobilePublisher",ChangeMobilePublisher.class);
                    ChangeMobileEvent changeMobileEvent = new ChangeMobileEvent( atmDao.changeMobileNumber(1011));
                    changeMobilePublisher.publish(changeMobileEvent);
                    break;

                case 4:
                    System.exit(0);

            }
        }
    }
}
