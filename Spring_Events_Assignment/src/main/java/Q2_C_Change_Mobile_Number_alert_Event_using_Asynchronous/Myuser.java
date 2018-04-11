package Q2_C_Change_Mobile_Number_alert_Event_using_Asynchronous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Myuser  {
    private String uname;
    private int upin;
    private int uamount;
    private long uphone;
    private int withdrawamt;

    @Autowired
    private CustomPublisher customPublisher;

   public void changeMobile(){
       System.out.println("please enter your new number");
       long num=new Scanner(System.in).nextLong();
       this.setUphone(num);
        customPublisher.publishEvent(new ChangeMobileNumberAlertEvent(this));
   }
    public int getWithdrawamt() {
        return withdrawamt;
    }

    public void setWithdrawamt(int withdrawamt) {
        this.withdrawamt = withdrawamt;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUpin() {
        return upin;
    }

    public void setUpin(int upin) {
        this.upin = upin;
    }

    public int getUamount() {
        return uamount;
    }

    public void setUamount(int uamount) {
        this.uamount = uamount;
    }

    public long getUphone() {
        return uphone;
    }

    public void setUphone(long uphone) {
        this.uphone = uphone;
    }



}
