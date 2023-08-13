package org.example.chefs;

import java.util.Objects;

public class IntermediateChef implements Chef {

    private final String name;

    public IntermediateChef(String name) {
        this.name = name;
    }

    @Override
    public Integer createBurger() {
        System.out.println("Cooking Big Mac decently well");
        return 2;
    }

    @Override
    public void createSalad() {
        System.out.println("Cooking salad decently well");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getRating() {
        return 4;
    }

    @Override
    public SeniorChef promote() {
        return new SeniorChef(this.name);
    }

    @Override
    public String toString() {
        return "IntermediateChef{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntermediateChef that = (IntermediateChef) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
