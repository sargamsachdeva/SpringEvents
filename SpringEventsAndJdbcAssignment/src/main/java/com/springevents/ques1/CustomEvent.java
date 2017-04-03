package com.springevents.ques1;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent{

    public CustomEvent(Object source) {
        super(source);
    }
}
