package com.company;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

public class Question6 {
    public static void main(String[] args) {
        int[] arr1= new int[10];
        int max1=0;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter array");
        for(int i=0;i<10;i++)
        {
            arr1[i]=in.nextInt();
            if(i==0)
                max1=arr1[i];
            else
                max1=max(max1,arr1[i]);
        }

        int[] hash = new int[max1+1];
        Arrays.fill(hash,0);

        for(int i=0;i<10;i++)
            hash[arr1[i]]++;

        for(int i=0;i<max1+1;i++)
        {
            if(hash[i]==1)
                System.out.println(i);
        }
    }
}
