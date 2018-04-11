package Q2_C_Change_Mobile_Number_alert_Event_using_Asynchronous;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ApplicationConfig.class);
       /* JdbcTemplate jdbcTemplate=applicationContext.getBean(JdbcTemplate.class);
        jdbcTemplate.update("insert into user (name,pin,amount,mobile) VALUES (?,?,?,?)",new Object[]{"ankit",1234,"30000","9717516550"});*/

       Myuser user=applicationContext.getBean(Myuser.class);
       user.setUname("ttn");
       user.setUpin(1234);
        user.changeMobile();

        System.out.println("your mobile has changed");
    }

}
