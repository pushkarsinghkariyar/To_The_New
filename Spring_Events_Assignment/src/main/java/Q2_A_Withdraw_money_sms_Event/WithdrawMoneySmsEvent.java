package Q2_A_Withdraw_money_sms_Event;

import org.springframework.context.ApplicationEvent;

public class WithdrawMoneySmsEvent extends ApplicationEvent {

    public WithdrawMoneySmsEvent(Object source) {
        super(source);
    }
}
