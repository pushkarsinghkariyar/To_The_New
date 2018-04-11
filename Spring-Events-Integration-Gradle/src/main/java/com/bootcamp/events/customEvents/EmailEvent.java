package com.bootcamp.events.customEvents;

import org.springframework.context.ApplicationEvent;

/**
 * Created by nidhi on 31/3/17.
 */
public class EmailEvent extends ApplicationEvent{
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public EmailEvent(Object source) {
        super(source);
    }
}