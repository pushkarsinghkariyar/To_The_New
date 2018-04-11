package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Question2 {
    public static void main(String[] args) {
        String str1= "Pushkar is new to JAVA. Pushkar works for to the new";

        Map<String, Integer> mymap= new HashMap<String, Integer>();
        String[] splitstr= str1.split(" ");
        for(String temp: splitstr)
        {
            if(mymap.get(temp)==null)
                mymap.put(temp,1);
            else {
                mymap.put(temp,mymap.get(temp)+1);
            }
        }
        for(Map.Entry<String,Integer> entry : mymap.entrySet()){
            if(entry.getValue()>1)
            {
                System.out.println(entry.getKey());
            }

        }

    }
}
