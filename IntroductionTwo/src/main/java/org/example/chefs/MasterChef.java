package org.example.chefs;

public class MasterChef extends SeniorChef implements Chef {

    private final String name;

    public MasterChef(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void giveOrders(){
        System.out.println("Give hella orders");
    }

    @Override
    public Integer createBurger() {
        return null;
    }

    @Override
    public void createSalad() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getRating() {
        return 0;
    }

    @Override
    public MasterChef promote() {
        return this;
    }
}
