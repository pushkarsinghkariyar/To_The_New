package Q1;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class CustomPublisher implements ApplicationEventPublisherAware {

    ApplicationEventPublisher publisher;

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher){
        System.out.println("setApplicationEventPublisher called");
        publisher=applicationEventPublisher;
    }


    public void publishEvent(CustomEvent customEvent){
        Employee employee=(Employee) customEvent.getSource();
        if(employee.getSalary()>30000) {
            publisher.publishEvent(customEvent);
        }
        }
}
