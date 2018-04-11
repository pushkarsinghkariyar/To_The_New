package com.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("config.xml");

//        Database database= applicationContext.getBean(Database.class);
//        System.out.println(database);


//        Restaurant restaurant = applicationContext.getBean("restaurantbean",Restaurant.class);
//        restaurant.getHotDrink().preparehotdrink();


//        Restaurant restaurant2 = applicationContext.getBean("restaurantbean2",Restaurant.class);
//        restaurant2.getHotDrink().preparehotdrink();


//        Complex complex= applicationContext.getBean("complexbean",Complex.class);
//        System.out.println(complex.getList());
//        System.out.println(complex.getSet());
//        System.out.println(complex.getMap());


//        Restaurant restaurant3= applicationContext.getBean("restaurantbean3",Restaurant.class);
//        restaurant3.getHotDrink().preparehotdrink();


//        Restaurant restaurant4= applicationContext.getBean("restaurantbean4",Restaurant.class);
//        restaurant4.getHotDrink().preparehotdrink();


        Restaurant restaurant5= (Restaurant) applicationContext.getBean("restaurantbean5",Restaurant.class);
        restaurant5.getHotDrink().preparehotdrink();


//        System.out.println(applicationContext.isPrototype("restaurantbean6"));


//        Restaurant restaurant6= applicationContext.getBean("restaurantbean7",Restaurant.class);
//        restaurant6.getHotDrink().preparehotdrink();

//        Restaurant rest= applicationContext.getBean(Restaurant.class);
//        rest.getHotDrink().preparehotdrink();
    }
}