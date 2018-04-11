package Q2_C_Change_Mobile_Number_alert_Event_using_Asynchronous;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class AsynchronousConfig {
    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster(){
        SimpleApplicationEventMulticaster eventMulticaster=new SimpleApplicationEventMulticaster();
 eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
 return eventMulticaster;
    }
}
