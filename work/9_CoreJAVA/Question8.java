package com.company;

public class Question8 {
    public static void main(String[] args) {
        StringBuffer str1 = new StringBuffer("JAVA IS AWESOME BABA");
        System.out.println("The String is- " + str1);

        str1.reverse();
        System.out.println("Reversed String is- " + str1);

        str1.delete(4, 8);
        System.out.println("After Deleting Characters- " + str1);
        }
}
