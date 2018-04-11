package com.company;

public class Question4 {
    public static void main(String[] args) {
        String str1= "My name is Pushkar Singh. I work for TO_THE_NEW. My employee code is- 2821. I earn 15100-/- per month as a trainee";
        int lower=0,upper=0,digit=0,special=0;
        for(int i=0;i<str1.length();i++)
        {
            if(Character.isLowerCase(str1.charAt(i)))
            {
                lower++;
            }
            else if(Character.isUpperCase(str1.charAt(i)))
            {
                upper++;
            }
            else if(Character.isDigit(str1.charAt(i)))
            {
                digit++;
            }
            else
                special++;
        }
        System.out.println("lower case percentage- " + lower*100/str1.length());
        System.out.println("upper case percentage- " + upper*100/str1.length());
        System.out.println("digits percentage- " + digit*100/str1.length());
        System.out.println("special case percentage- " + special*100/str1.length());
    }
}
