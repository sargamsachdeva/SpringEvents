package com.springevents.ques2;

import org.springframework.context.ApplicationEvent;

public class ChangePinEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public ChangePinEvent(Object source) {
        super(source);
    }
}
