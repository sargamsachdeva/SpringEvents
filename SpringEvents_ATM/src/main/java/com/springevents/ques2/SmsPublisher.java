package com.springevents.ques2;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class SmsPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

        publisher=applicationEventPublisher;

    }

    public void publish(SmsEvent event) {

        publisher.publishEvent(event);
    }
}
