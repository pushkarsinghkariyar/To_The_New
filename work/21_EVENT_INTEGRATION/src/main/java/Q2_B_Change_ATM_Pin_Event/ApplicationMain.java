package Q2_B_Change_ATM_Pin_Event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ApplicationConfig.class);
       /* JdbcTemplate jdbcTemplate=applicationContext.getBean(JdbcTemplate.class);
        jdbcTemplate.update("insert into user (name,pin,amount,mobile) VALUES (?,?,?,?)",new Object[]{"ankit",1234,"30000","9717516550"});*/

       Myuser user=applicationContext.getBean(Myuser.class);
       user.setUname("pushkar");
       user.setUpin(12345);
       user.changeAtmPin();
        System.out.println("done");
    }

}
