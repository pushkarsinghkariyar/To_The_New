package Q2_B_Change_ATM_Pin_Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Myuser  {
    private String uname;
    private int upin;
    private int uamount;
    private long uphone;

    @Autowired
    private CustomPublisher customPublisher;

    public void changeAtmPin(){
customPublisher.publishEvent(new ChangePinEvent(this));
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
