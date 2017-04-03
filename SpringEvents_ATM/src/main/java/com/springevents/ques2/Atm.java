package com.springevents.ques2;

public class Atm {

    Integer balance;
    Integer pin;
    Integer mobileNumber;

    public Integer getBalance() {
        return balance;
    }

    public Atm setBalance(Integer balance) {
        this.balance = balance;
        return this;
    }

    public Integer getPin() {
        return pin;
    }

    public Atm setPin(Integer pin) {
        this.pin = pin;
        return this;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public Atm setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }
}
