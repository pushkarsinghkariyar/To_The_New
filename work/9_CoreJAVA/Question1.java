package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Question1 {
    public static void main(String[] args) {

        String str1= "My Name is Pushkar Singh";
        System.out.println(str1);
        String str2= "Pushkar Singh Katiyar";
        str1=str1.replaceAll("Pushkar Singh", str2);
        System.out.println("After modification str1 becomes- " + str1);
    }
    }
