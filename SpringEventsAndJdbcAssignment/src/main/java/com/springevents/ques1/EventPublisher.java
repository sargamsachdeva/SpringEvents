package com.springevents.ques1;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class EventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

        publisher=applicationEventPublisher;

    }

    public void publish(CustomEvent event) {

        publisher.publishEvent(event);
    }
}
