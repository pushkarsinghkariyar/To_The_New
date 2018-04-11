package com.company;

public class Question7 {
    static String firstname;
    static String lastname;
    static int age;
    static{
        firstname="Pushkar";
        lastname= "Singh";
        age= 23;
    }
         static void p(int age,String firstname,String lastname)
         {
                  System.out.println("Firstname- " + firstname + " Lastname- " + lastname + " Age- " + age); 
         }
    public static void main(String[] args) {

        Question7 a=new Question7();
        a.p(age,firstname,lastname);
    }
}