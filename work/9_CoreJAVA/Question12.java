package com.company;

class Bank {

    String country ;
    void getDetails() {};
    Bank() {
        country = "India";
    }
}
class SBI extends  Bank {
    String branchlocation ;
    String bankName ;
    SBI(){
        super();
        branchlocation = "Noida Sector-127";
        bankName = "State Bank Of India";
    }
    void getDetails() {
        System.out.println(country);
        System.out.println(branchlocation);
        System.out.println(bankName);

    }
}
class BOI extends  Bank {
    String branchlocation ;
    String bankName ;
    BOI(){
        super();
        branchlocation = "Noida Sector-63";
        bankName = "Bank Of India";
    }
    void getDetails() {
        System.out.println(country);
        System.out.println(branchlocation);
        System.out.println(bankName);

    }
}
class ICICI extends  Bank {
    String branchlocation ;
    String bankName ;
    ICICI(){
        super();
        branchlocation = "Noida Sector-137";
        bankName = "ICICI Limited.";
    }
    void getDetails() {
        System.out.println(country);
        System.out.println(branchlocation);
        System.out.println(bankName);

    }
}

public class Question12 {
    public static void main(String[] args) {
        Bank sbi = new SBI();
        sbi.getDetails();
        Bank boi = new BOI();
        boi.getDetails();
        Bank icici = new ICICI();
        icici.getDetails();

    }

}