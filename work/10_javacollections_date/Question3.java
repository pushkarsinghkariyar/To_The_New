package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question3 {
    public static void fun(String str){
        Map<Character, Integer> mymap= new HashMap<Character, Integer>();
        for(int i=0; i<str.length();i++)
        {
            if(mymap.get(str.charAt(i))==null)
                mymap.put(str.charAt(i),1);
            else {
                mymap.put(str.charAt(i),mymap.get(str.charAt(i))+1);
            }
        }

        for(Map.Entry<Character,Integer> entry: mymap.entrySet()){
            System.out.println(entry.getKey() + " occured " + entry.getValue() + " times.");
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the string");
        String str1=sc.next();
        fun(str1);
    }
}
