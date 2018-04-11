package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
    private HotDrink hotDrink;

//    public Restaurant(HotDrink hotDrink) {
//        this.hotDrink = hotDrink;
//    }

    public HotDrink getHotDrink() {
        return hotDrink;
    }

    @Required
    @Autowired
    public void setHotDrink(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "hotDrink=" + hotDrink +
                '}';
    }
}
