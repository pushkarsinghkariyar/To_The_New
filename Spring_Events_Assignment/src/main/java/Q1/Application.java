package Q1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("one_springconfig.xml");
        CustomPublisher customPublisher = applicationContext.getBean(CustomPublisher.class);
        List<Employee> list=new ArrayList<>();
        list.add(new Employee(35,"ankit","ankit@",35000));
        list.add(new Employee(40,"vikesh","vikesh@",25000));
        list.add(new Employee(39,"kapil","kapil@",38000));
        for(Employee employee:list){
            CustomEvent customEvent=new CustomEvent(employee);
            customPublisher.publishEvent(customEvent);

        }

        System.out.println("rest of the code");

    }
}
