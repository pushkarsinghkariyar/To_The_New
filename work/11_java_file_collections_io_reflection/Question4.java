package com.company;

import java.util.Scanner;

interface Myfuncint
{
    void abstractfun(int x);

    default void defaultFun()
    {
        System.out.println("Hello");
    }
}

public class Question4 {

    public static void main(String args[])
    {

        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        int temp = scanner.nextInt();

        Myfuncint obj = (int x)->System.out.println(temp*x);

        System.out.println("The Multiplication table of "+ temp +" is :");

        for (int i = 1; i <=10 ; i++) {

            obj.abstractfun(i);
        }

    }
}
