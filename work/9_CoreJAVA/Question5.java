package com.company;

import java.util.Arrays;
import java.util.Scanner;

import static sun.swing.MenuItemLayoutHelper.max;

public class Question5 {
    public static void main(String[] args) {
    int[] arr1= new int[10];
    int[] arr2= new int[10];
    int max1=0;
    Scanner in = new Scanner(System.in);

        System.out.println("Enter first array");
    for(int i=0;i<10;i++)
    {
        arr1[i]=in.nextInt();
        if(i==0)
            max1=arr1[i];
        else
            max1=max(max1,arr1[i]);
    }


        System.out.println("Enter second array");
        for(int i=0;i<10;i++) {
            arr2[i] = in.nextInt();
            max1=max(max1,arr2[i]);
        }

        int[] hash = new int[max1+1];
        Arrays.fill(hash,0);

        for(int i=0;i<10;i++)
            hash[arr1[i]]=1;
        for(int j=0;j<10;j++)
        {
            if(hash[arr2[j]]==1)
                System.out.println(arr2[j]);
        }
    }
}
