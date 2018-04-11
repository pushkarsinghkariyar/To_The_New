package Q1;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<CustomEvent> {

    public void onApplicationEvent(CustomEvent customEvent){
        System.out.println("onApplicationEvent is called");
       Employee employee=(Employee) customEvent.getSource();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(employee.getName()+" has salary more than salary 30000 : "+employee.getSalary());
    }
}
