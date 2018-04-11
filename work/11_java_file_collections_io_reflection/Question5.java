package com.company;

interface Custom {


    void abstract_fun(int num);

    default void print()
    {
        System.out.println("This is a default function");
    }

    static  void show()
    {
        System.out.println("This is a static function");
    }

}


public class Question5 implements Custom{
    @Override
    public void abstract_fun(int num) {

        System.out.println("Value of num is- " + num);
    }

    public static void main(String[] args)
    {
        Question5 obj = new Question5();

        obj.abstract_fun(5);
        obj.print();
        Custom.show();
    }
}
