import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomEventPublisher implements ApplicationEventPublisherAware {
    private  ApplicationEventPublisher publisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher=publisher;
    }

    public void publish(CustomEvent customEvent){
        Employee employee = (Employee) customEvent.getSource();
        if(employee.getSalary()>30000)
        publisher.publishEvent(customEvent);
    }
}