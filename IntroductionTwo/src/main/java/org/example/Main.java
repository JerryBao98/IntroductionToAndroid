package org.example;

import org.example.chefs.Chef;
import org.example.chefs.JuniorChef;
import org.example.chefs.Restaurant;
import org.example.chefs.SeniorChef;

import javax.sound.midi.SysexMessage;

public class Main {

    public static void main(String[] args) {

        Car car = new Car();
        car.setColour("Blue");
        String colour = car.getColour();
        System.out.println(colour);

        car.drive("fast");


//        Restaurant restaurant = new Restaurant();
//
//        Chef srChef = new SeniorChef("Jerry");
//        Chef jrChef = new JuniorChef("Albert");
//
//        restaurant.addChef(jrChef);
//        restaurant.addChef(srChef);
//
//        System.out.println(restaurant.getChefs());
//        System.out.println(restaurant.averageRating());
    }
}