package Q2_A_Withdraw_money_sms_Event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class CustomPublisher implements ApplicationEventPublisherAware {

private ApplicationEventPublisher publisher;


public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher){
    publisher=applicationEventPublisher;
}

public void publishEvent(WithdrawMoneySmsEvent withdrawMoneySmsEvent){
    publisher.publishEvent(withdrawMoneySmsEvent);
}

}
