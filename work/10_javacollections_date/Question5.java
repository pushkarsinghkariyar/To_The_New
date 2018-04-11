package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
    Double age;
    Double score;
    String name;

    public Student(double age, double score, String name) {
        this.age = age;
        this.score=score;
        this.name=name;
    }

    public void getdata(){
        System.out.println("Name- " + this.name + " Age- " + this.age + " Score- " + this.score);
    }
}

class comp1 implements Comparator<Student>{
    public int compare(Student a, Student b){
        int comparison= a.score.compareTo(b.score);
        if(comparison>1)
            return 1;
        else if(comparison<1)
            return -1;
        else
        {
            int aa=a.name.compareTo(b.name);
            if(aa>0)
                return 1;
            else
                return -1;
        }
    }
}

public class Question5{

    public static void main(String[] args) {

        List<Student> E = new ArrayList<Student>();
        E.add(new Student(23.0,85,"Pushkar Singh"));
        E.add(new Student(23.0,75,"Archit Chauhan"));
        E.add(new Student(23.0,70,"Swapil Khanna"));
        E.add(new Student(23.0,70,"Neelesh Bansal"));
        Collections.sort(E , new comp1());

        for(int i=0;i<E.size();i++){
            E.get(i).getdata();
        }
    }
}
