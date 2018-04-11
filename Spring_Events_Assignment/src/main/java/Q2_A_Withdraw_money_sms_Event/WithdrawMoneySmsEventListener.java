package Q2_A_Withdraw_money_sms_Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class WithdrawMoneySmsEventListener implements ApplicationListener<WithdrawMoneySmsEvent> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void onApplicationEvent(WithdrawMoneySmsEvent event){

        Myuser user=(Myuser) event.getSource();
        int wamt =user.getWithdrawamt();

        String nm=user.getUname();
        int oldpin=user.getUpin();
        jdbcTemplate.update("update user set amount=amount-? where name=? and pin=?",new Object[]{wamt,nm,oldpin});
        System.out.println("your account has debited by amount : "+wamt);



    }
}
