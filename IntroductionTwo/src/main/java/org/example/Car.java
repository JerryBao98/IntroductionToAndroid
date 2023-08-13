package org.example;

public class Car {

    private String colour;

    public void drive(String speed) {
        System.out.println("Driving at " + speed + " speed");
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
