package Q2_B_Change_ATM_Pin_Event;

import org.springframework.context.ApplicationEvent;

public class ChangePinEvent extends ApplicationEvent {

    public ChangePinEvent(Object source) {
        super(source);
    }
}
