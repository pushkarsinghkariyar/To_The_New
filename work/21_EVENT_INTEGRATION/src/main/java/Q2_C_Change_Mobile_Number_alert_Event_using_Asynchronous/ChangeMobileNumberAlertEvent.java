package Q2_C_Change_Mobile_Number_alert_Event_using_Asynchronous;

import org.springframework.context.ApplicationEvent;

public class ChangeMobileNumberAlertEvent extends ApplicationEvent {

    public ChangeMobileNumberAlertEvent(Object source) {
        super(source);
    }
}
