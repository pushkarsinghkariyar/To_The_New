package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
class stack{
    Integer top;
    Integer max_size;
    List<Integer> list1;
    List<Integer> list2;

    stack(Integer max_size){
        list1= new ArrayList<Integer>();
        list2= new ArrayList<Integer>();
        this.top=0;
        this.max_size=max_size;
    }

    public boolean is_full(){
        if(top >=max_size)
            return true;
        else
            return false;
    }

    public  boolean is_empty(){
        if(top==0)
            return true;
        else
            return false;

    }


    public void push(Integer num) {
        if (is_full()) {
            System.out.println("Stack is full");
            return;
        }
        else
            {
            if (top == 0) {
                list1.add(num);
                list2.add(num);
            } else {
                list1.add(num);
                if (num < list2.get(top-1))
                    list2.add(num);
                else {
                    list2.add(list2.get(top-1));
                }
            }
            top++;
        }
    }
    public int gettop() throws MyException{
        if(top != 0) {
            int temp = list1.get(top-1);
            return temp;
        }
        else {
            throw new MyException("Stack is Empty");
        }

    }

    public void pop() throws MyException{
            if(top != 0) {
                int temp = list1.remove(top-1);
                list2.remove(top-1);
                top--;
            }
            else {
                throw new MyException("Stack is Empty");
            }

    }

    public Integer getmin() throws MyException{
        if(top!=0)
        {
            return list2.get(top-1);
        }
        else
        {
            throw new  MyException("Stack is empty. No minimum value");
        }
    }
}

public class Question7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size;
        System.out.println("Enter the max size of the stack");
        size=sc.nextInt();

        stack mystack;
        mystack = new stack(size);
        int choice,temp;
        do {
            System.out.println("Enter your choice. \n 1. Push. \n 2. Pop. \n 3. Get Top. \n 4. Get Min. \n 5. Exit");
            choice=sc.nextInt();
            if(choice==1)
            {
                temp=sc.nextInt();
                mystack.push(temp);
            }
            else if(choice==2)
            {
                try{
                    mystack.pop();
                }catch (MyException e){
                    System.out.println(e.getMessage());
                }
            }
            else if(choice==3){
                try{
            System.out.println("The top element is- " + mystack.gettop());
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
            }
            else if(choice==4){
                try{
            System.out.println("min element is- " + mystack.getmin());
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
            }
        }while (choice!=5);


//        mystack.push(2);
//        mystack.push(3);
//        mystack.push(8);
//        mystack.push(1);
//        mystack.push(0);
//        mystack.push(5);
//        mystack.push(-1);
//
//        try{
//            System.out.println("min element is- " + mystack.getmin());
//        }catch (MyException e){
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            System.out.println("The top element is- " + mystack.gettop());
//        }catch (MyException e){
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            mystack.pop();
//        }catch (MyException e){
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            System.out.println("new min element is- " + mystack.getmin());
//        }catch (MyException e){
//            System.out.println(e.getMessage());
//        }

    }
}