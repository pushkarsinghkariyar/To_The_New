package Q2_C_Change_Mobile_Number_alert_Event_using_Asynchronous;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class CustomPublisher implements ApplicationEventPublisherAware {

private ApplicationEventPublisher publisher;


public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher){
    publisher=applicationEventPublisher;
}

public void publishEvent(ChangeMobileNumberAlertEvent changeMobileNumberAlertEvent){
    publisher.publishEvent(changeMobileNumberAlertEvent);
}

}
