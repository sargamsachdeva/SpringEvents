package com.springevents.ques2;

import java.util.List;

public interface AtmDao {

    public Atm withdraw(Integer pin);
    public Atm changePin(Integer pin);
    public Atm changeMobileNumber(Integer pin);
}
