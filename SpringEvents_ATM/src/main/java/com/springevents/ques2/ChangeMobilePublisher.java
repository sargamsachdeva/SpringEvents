package com.springevents.ques2;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class ChangeMobilePublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

        publisher=applicationEventPublisher;

    }

    public void publish(ChangeMobileEvent event) {

        publisher.publishEvent(event);
    }
}
