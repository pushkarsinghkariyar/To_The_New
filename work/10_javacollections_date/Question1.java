package com.company;

import java.util.ArrayList;

public class Question1 {
    public static void main(String[] args) {
        ArrayList<Float> list=new ArrayList<Float>();
        list.add((float) 1.0);
        list.add((float) 2.1);
        list.add((float) 3.2);
        list.add((float) 4.3);
        list.add((float) 5.4);
        float sum=0;
        for(Float a: list)
        {
            sum+=a;
        }
        System.out.println(sum);
    }
}
