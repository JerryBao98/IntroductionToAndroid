package org.example.chefs;

import java.util.Objects;

public class JuniorChef implements Chef {

    private final String name;

    public JuniorChef(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRating() {
        return 3;
    }

    @Override
    public IntermediateChef promote() {
        return new IntermediateChef(this.name);
    }

    @Override
    public Integer createBurger(){
        System.out.println("Cooking Big Mac not as good");
        return 1;
    }

    @Override
    public void createSalad() {
        System.out.println("Cooking salad not as good");
    }

    @Override
    public String toString() {
        return "JuniorChef{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JuniorChef that = (JuniorChef) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
