package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Test
{

    private String s;

    public Test()  {  s = "TO_THE NEW"; }

    public void method1()  {
        System.out.println("String is " + s);
    }


    public void method2(Integer n)  {
        System.out.println("Number is " + n);
    }

    private void method3() {
        System.out.println("This is Private Method");
    }
}

public class Question3 {
    public static void main(String args[]) throws Exception
    {

        Test obj = new Test();

        Class cls = obj.getClass();
        System.out.println("Class Name- " + cls.getName());

        Constructor constructor = cls.getConstructor();
        System.out.println("Costructor Name- " + constructor.getName());

        System.out.println("Public Methods- ");

        Method[] methods = cls.getMethods();

        for (Method method:methods)
            System.out.println(method.getName());

        Method methodcall1 = cls.getDeclaredMethod("method2", Integer.class);

        methodcall1.invoke(obj, 19);

        Field field = cls.getDeclaredField("s");

        field.setAccessible(true);

        field.set(obj, "JAVA");

        Method methodcall2 = cls.getDeclaredMethod("method1");


        methodcall2.invoke(obj);
        Method methodcall3 = cls.getDeclaredMethod("method3");

        methodcall3.setAccessible(true);

        methodcall3.invoke(obj);
    }

}