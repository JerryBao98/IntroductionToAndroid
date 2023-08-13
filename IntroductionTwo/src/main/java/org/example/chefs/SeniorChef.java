package org.example.chefs;

import java.util.Objects;

public class SeniorChef implements Chef {

    private final String name;

    public SeniorChef(String name) {
        this.name = name;
    }

    public void giveOrders(){
        System.out.println("Do this thing");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRating() {
        return 5;
    }

    @Override
    public MasterChef promote() {
        return new MasterChef(this.name);
    }

    @Override
    public Integer createBurger(){
        System.out.println("Cooking Big Mac");
        return 0;
    }

    @Override
    public void createSalad() {
        System.out.println("Cooking salad");
    }

    @Override
    public String toString() {
        return "SeniorChef{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeniorChef that = (SeniorChef) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
