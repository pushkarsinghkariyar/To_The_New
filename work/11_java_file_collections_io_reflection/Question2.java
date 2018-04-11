package com.company;

import java.io.*;

class Emp implements java.io.Serializable
{
    public String name;
    public Integer age;

    public Emp(String name , Integer age)
    {
        this.name = name;
        this.age = age;
    }
}

public class Question2 {
    public static void main(String[] args) {
        Emp object = new Emp("Pushkar Singh", 23);
        String filename = "file.ser";

        try
        {

            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);


            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch(IOException e)
        {
            System.out.println("IOException is caught");
        }


        Emp obj1 = null;


        try
        {

            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);


            obj1 = (Emp)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("name is " + obj1.name);
            System.out.println("age is " + obj1.age);

        }

        catch(IOException e)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException e)
        {
            System.out.println("ClassNotFoundException is caught");
        }

    }
}
