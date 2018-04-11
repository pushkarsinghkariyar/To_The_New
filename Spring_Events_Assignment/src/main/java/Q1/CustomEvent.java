package Q1;


import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

public CustomEvent(Object source){
    super(source);
    System.out.println("Custom event contructor is called");
}


    @Override
    public String toString() {
        return "employee event occured";
    }
}
