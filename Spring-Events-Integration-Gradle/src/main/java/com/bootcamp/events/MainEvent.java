package com.bootcamp.events;

import com.bootcamp.events.customEvents.CustomPublisher;
import com.bootcamp.events.customEvents.Email;
import com.bootcamp.events.customEvents.EmailEvent;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by nidhi on 31/3/17.
 */
public class MainEvent {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
        context.start();

        CustomPublisher publisher= (CustomPublisher) context.getBean("customPublisher");

        Email email=new Email().setToMail("abc.tothenew.com")
                .setSubject("Test mail for Synchronous Event")
                .setBody("Hi, \n Today's session is Spring Event and Integration");

        EmailEvent emailEvent=new EmailEvent(email);
        publisher.publish(emailEvent);
        context.stop();
    }
}