package com.company;

import java.util.*;

public class Question6 {
    public static void main(String[] args) {
        List<Temp> mylist = new ArrayList<>();
        int temp, size;
        System.out.println("Enter the size of the array");
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            temp = sc.nextInt();
            Temp obj1=new Temp();
            obj1.setCount(1);
            obj1.setPosition(i);
            obj1.setValue(temp);
            if(mylist.contains(obj1)){
                mylist.get(mylist.indexOf(obj1)).increaseCount();
            }else{
                mylist.add(obj1);
            }
        }

        Collections.sort(mylist, new Comparator<Temp>() {
            @Override
            public int compare(Temp o1, Temp o2) {

                if (o1.getCount() != o2.getCount()) {
                    return o2.getCount()-o1.getCount();
                } else {
                    return o1.getPosition() - o2.getPosition();
                }
            }
        });
        for (Temp temp1 : mylist) {
            System.out.println(temp1.getValue() + " -> " + temp1.getCount());
        }
    }
}