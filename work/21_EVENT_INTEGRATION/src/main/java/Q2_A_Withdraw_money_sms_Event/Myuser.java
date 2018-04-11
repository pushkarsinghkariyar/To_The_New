package Q2_A_Withdraw_money_sms_Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Myuser  {
    private String uname;
    private int upin;
    private int uamount;
    private long uphone;
    private int withdrawamt;

    @Autowired
    private CustomPublisher customPublisher;

    public void withrawMoney(){
        customPublisher.publishEvent(new WithdrawMoneySmsEvent(this));
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
