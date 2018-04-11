package com.bootcamp.events.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");

        PersonDao personDao = (PersonDao) context.getBean("personDao");
        Person person = new Person(14, "Lovjit","Bedi");
        personDao.insert(person);
    }
}