package com.company;

import java.util.ArrayList;
import java.util.List;

class Employee
{
    String name;
    Integer age;

    Employee(String name , Integer age)
    {
        this.name= name;
        this.age= age;
    }

    public void setage(Integer age)
    {
        this.age = age;
    }

    public void setname(String name)
    {
        this.name = name;
    }
    public Integer getage()
    {
        return this.age;
    }

    public String getname()
    {
        return this.name;
    }
}

public class Question6 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee("Pushkar", 23));
        list.add(new Employee("Archit", 23));
        list.add(new Employee("Swapnil", 27));
        list.add(new Employee("Payal", 26));
        list.add(new Employee("Neelesh", 25));
        list.add(new Employee("Shreyansh", 25));
        list.add(new Employee("Narayan", 26));

        System.out.println("The required employees are: ");

        list.stream().filter(p -> p.getname().startsWith("N")).filter(p ->p.getage()> 24)
                .map(p ->p.getname())
                .forEach(System.out::println);
    }
}
