package com.bootcamp.events.customEvents;

import org.springframework.context.ApplicationListener;

/**
 * Created by nidhi on 31/3/17.
 */
public class EmailListener implements ApplicationListener<EmailEvent> {
    @Override
    public void onApplicationEvent(EmailEvent event) {
        if(event.getSource() instanceof Email){
            Email email= (Email) event.getSource();
            System.out.println("Email is sent to: "+ email.getToMail()+"\n from: "+email.getFromMail()
                    +"\n with subject: "+email.getSubject());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("email is: \n"+email.getBody());
        }
        else{
            System.out.println("This event is not of Email class");
        }
    }
}