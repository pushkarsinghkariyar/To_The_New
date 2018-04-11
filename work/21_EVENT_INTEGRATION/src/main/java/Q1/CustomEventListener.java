import org.springframework.context.ApplicationListener;

public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        Employee employee = (Employee) event.getSource();
        System.out.println(employee.getName()+ "has salary"+ employee.getSalary());
    }
}
