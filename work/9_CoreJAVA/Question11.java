package com.company;

public class Question11 {

    static int add(int a , int b) { return a + b ;}
    static double add(double a , double b) {return a + b;}

    static int mul(int a , int b) { return a * b ;}
    static double mul(double a , double b ) { return a * b;}

    static String con(String a  ,String b) { return (a.concat(b));}
    static String con(String a , String b , String c) { return (a.concat(b)).concat(c);}

    public static void main(String[] args) {

        System.out.println(add(2 , 3));
        System.out.println(add(3.3, 2.3));
        System.out.println( mul(12 , 2));
        System.out.println(mul(1.1 , 3.4));
        System.out.println(con("Pushkar " , "Singh"));
        System.out.println(con("Pushkar " , "Singh " , "Katiyar"));

    }
}