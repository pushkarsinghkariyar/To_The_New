import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext= new ClassPathXmlApplicationContext("web.xml");
        Employee employee= configurableApplicationContext.getBean("employee1",Employee.class);
        CustomEventPublisher customEventPublisher = (CustomEventPublisher)configurableApplicationContext.getBean("CustomEventPublisher",CustomEventPublisher.class);
        CustomEvent customEvent=new CustomEvent(employee);
        customEventPublisher.publish(customEvent);
        //System.out.println(employee);
//
//        customEventPublisher.publish(employee);
//        System.out.println("File Executed");
    }
}
