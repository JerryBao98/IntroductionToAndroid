package org.example.chefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Restaurant {

    private final List<Chef> chefs;

    public Restaurant() {
        this.chefs = new ArrayList<>();
    }

    public List<Chef> getChefs() {
        return chefs;
    }

    public void promoteChef(String name){
        Optional<Chef> chefByName = getChefByName(name);
        if (chefByName.isEmpty()){
            return;
        }
        Chef chef = chefByName.get();
        Chef promotedChef = chef.promote();
        chefs.add(promotedChef);
        chefs.remove(chef);
    }

    public void addChef(Chef chef){
        int numberOfJuniors = getNumberOfJuniorChefs();
        int numberOfSeniors = getNumberOfSeniorChefs();
        if (chef instanceof JuniorChef || chef instanceof IntermediateChef){
            chefs.add(chef);
        }
        else if (numberOfSeniors < numberOfJuniors) {
            chefs.add(chef);
        }
    }

    public Optional<Chef> getChefByName(String name){
        for (Chef chef: chefs) {
            if (name == chef.getName()){
                return Optional.of(chef);
            }
        }
        return Optional.empty();
    }

    public double averageRating(){
        int sumOfRatings = 0;
        if (chefs.isEmpty()){
            return 0;
        }
        for (Chef chef: chefs){
            sumOfRatings += chef.getRating();
        }
        return (double) sumOfRatings / chefs.size();
    }

    public int getNumberOfJuniorChefs(){
        int numberOfJuniors = 0;
        for (Chef chef: chefs){
            if (chef instanceof JuniorChef){
                numberOfJuniors += 1;
            }
        }
        return numberOfJuniors;
    }

    public int getNumberOfSeniorChefs(){
        int numberOfSeniors = 0;
        for (Chef chef: chefs){
            if (chef instanceof SeniorChef){
                numberOfSeniors += 1;
            }
        }
        return numberOfSeniors;
    }
}
