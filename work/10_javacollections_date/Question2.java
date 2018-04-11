package com.company;

import java.util.*;

public class Question2 {
    public static int fun(String str) {

        Set<Character> myset = new HashSet<Character>();
        Integer si = str.length();
        for(Integer i = 0 ; i < si ; i++){
            myset.add(str.charAt(i));
        }
        return (Integer)(myset.size());


    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the string");
        String str1=sc.next();
        System.out.println(fun(str1));
    }
}
