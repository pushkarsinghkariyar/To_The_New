package com.company;

public class Question3 {
    public static void main(String[] args) {
        String str1= "JAVA IS AWESOME BABUA";
        //finding the occurence of A
        String str2=str1.replaceAll("A","");
        System.out.println(str1.length()-str2.length());
    }
}
