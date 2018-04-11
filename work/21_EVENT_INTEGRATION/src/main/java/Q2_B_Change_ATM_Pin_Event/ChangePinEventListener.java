package Q2_B_Change_ATM_Pin_Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ChangePinEventListener implements ApplicationListener<ChangePinEvent> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void onApplicationEvent(ChangePinEvent event){

        Myuser user=(Myuser) event.getSource();

        System.out.println("please enter new pin");

        String nm=user.getUname();
        int newpin=new Scanner(System.in).nextInt();
        jdbcTemplate.update("update user set pin=? where name=?",new Object[]{newpin,nm});



    }
}
