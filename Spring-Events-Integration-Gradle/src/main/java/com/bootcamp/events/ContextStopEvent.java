package com.bootcamp.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class ContextStopEvent implements ApplicationListener<ContextStoppedEvent>{
    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("EVENT STOPPED");
    }
}
