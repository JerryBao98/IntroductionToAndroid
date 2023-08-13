package org.example;

import org.example.chefs.*;
import org.example.school.Student;
import org.example.school.StudentFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    StudentFactory studentFactory = new StudentFactory();

    @Test
    public void testTwoStudentsCreated() {
        String studentName = "Jerry";
        String studentGrade = "Grade 12";

        Student jerry = studentFactory.createStudent(studentName, studentGrade);
        assertEquals(studentName, jerry.getName());
        assertEquals(0, jerry.getId());
        assertEquals(studentGrade, jerry.getGrade());

        Student alex = studentFactory.createStudent("Alex", "Grade 12");
        assertEquals("Alex", alex.getName());
        assertEquals(1, alex.getId());
        assertEquals("Grade 12", alex.getGrade());
    }

    @Test
    public void testStudentUpdated(){
        String studentName = "Jerry";
        String studentGrade = "Grade 12";

        Student jerry = studentFactory.createStudent(studentName, studentGrade);
        assertEquals(studentName, jerry.getName());
        assertEquals(0, jerry.getId());
        assertEquals(studentGrade, jerry.getGrade());

        studentFactory.updateStudentGrade(0, "Grade 11");
        Student updatedJerry = studentFactory.getStudentsDirectory().get(0);
        assertEquals("Grade 11", updatedJerry.getGrade());
    }

    @Test
    public void testSeniorChefAddedSuccessfully(){
        Restaurant restaurant = new Restaurant();
        Chef jrChef = new JuniorChef("Alex");
        restaurant.addChef(jrChef);

        assertTrue(restaurant.getChefs().contains(jrChef));

        Chef srChef = new SeniorChef("Austin");
        restaurant.addChef(srChef);

        assertTrue(restaurant.getChefs().contains(srChef));
    }

    @Test
    public void testSeniorChefLimitWithoutJuniors(){
        Restaurant restaurant = new Restaurant();
        Chef srChef = new SeniorChef("Austin");
        restaurant.addChef(srChef);

        assertFalse(restaurant.getChefs().contains(srChef));
    }

    @Test
    public void testSeniorChefLimitWithJuniors(){
        Restaurant restaurant = new Restaurant();
        Chef jrChef = new JuniorChef("Alex");
        restaurant.addChef(jrChef);

        Chef srChef = new SeniorChef("Austin");
        restaurant.addChef(srChef);

        Chef srChef2 = new SeniorChef("Gally");
        restaurant.addChef(srChef2);

        assertFalse(restaurant.getChefs().contains(srChef2));
    }

    @Test
    public void testSeniorChefLimitWithJuniorsFlipping(){
        Restaurant restaurant = new Restaurant();
        Chef jrChef = new JuniorChef("Alex");
        restaurant.addChef(jrChef);

        Chef srChef = new SeniorChef("Austin");
        restaurant.addChef(srChef);

        Chef srChef2 = new SeniorChef("Gally");
        restaurant.addChef(srChef2);

        Chef jrChef2 = new JuniorChef("Albert");
        restaurant.addChef(jrChef2);

        // add the senior chef again
        // gets added, since we have 2 juniors now
        restaurant.addChef(srChef2);
        assertTrue(restaurant.getChefs().contains(srChef2));
    }

    @Test
    public void testChefFound(){
        Restaurant restaurant = new Restaurant();
        Chef jrChef = new JuniorChef("Alex");
        restaurant.addChef(jrChef);

        Optional<Chef> alex = restaurant.getChefByName("Alex");
        Chef chef = alex.get();

        assertEquals("Alex", chef.getName());
    }

    @Test
    public void testChefNotFoundWithEmptyChefs(){
        Restaurant restaurant = new Restaurant();
        Optional<Chef> alex = restaurant.getChefByName("Alex");

        boolean isPresent = alex.isPresent();
        assertFalse(isPresent);
    }

    @Test
    public void testChefNotFoundWithNonEmptyChefs(){
        Restaurant restaurant = new Restaurant();
        Chef jrChef = new JuniorChef("Alex");
        restaurant.addChef(jrChef);

        Optional<Chef> alex = restaurant.getChefByName("Alex 123");
        boolean isEmpty = alex.isEmpty();
        assertTrue(isEmpty);
    }

    @Test
    public void testChefRatingWithNoChefs(){
        Restaurant restaurant = new Restaurant();
        double averageRating = restaurant.averageRating();
        assertEquals(0, averageRating);
    }

    @Test
    public void testChefRatingWithMultipleChefs(){
        Restaurant restaurant = new Restaurant();

        Chef jrChef = new JuniorChef("Jerry");
        restaurant.addChef(jrChef);

        Chef intChef = new IntermediateChef("Albert");
        restaurant.addChef(intChef);

        Chef srChef = new SeniorChef("Alex");
        restaurant.addChef(srChef);

        double averageRating = restaurant.averageRating();
        assertEquals(4, averageRating);
    }

    @Test
    public void testPromoteJuniorChefToIntermediate(){
        Restaurant restaurant = new Restaurant();
        Chef jrChef = new JuniorChef("Jerry");
        restaurant.addChef(jrChef);
        restaurant.promoteChef("Jerry");

        List<Chef> chefs = restaurant.getChefs();
        IntermediateChef expectedChef = new IntermediateChef("Jerry");
        List<Chef> expectedChefs = Arrays.asList(expectedChef);
        assertEquals(expectedChefs, chefs);
    }

    @Test
    public void testPromoteIntermediateChefToSenior(){
        Restaurant restaurant = new Restaurant();
        Chef intChef = new IntermediateChef("Jerry");
        restaurant.addChef(intChef);
        restaurant.promoteChef("Jerry");

        List<Chef> chefs = restaurant.getChefs();
        SeniorChef expectedChef = new SeniorChef("Jerry");
        List<Chef> expectedChefs = Arrays.asList(expectedChef);
        assertEquals(expectedChefs, chefs);
    }

    @Test
    public void testPromoteSeniorChef(){
        Restaurant restaurant = new Restaurant();
        Chef jrChef = new JuniorChef("Albert");
        restaurant.addChef(jrChef);

        Chef srChef = new SeniorChef("Jerry");
        restaurant.addChef(srChef);
        restaurant.promoteChef("Jerry");

        List<Chef> chefs = restaurant.getChefs();
        SeniorChef expectedChef = new SeniorChef("Jerry");
        JuniorChef expectedChefB = new JuniorChef("Albert");

        List<Chef> expectedChefs = Arrays.asList(expectedChefB, expectedChef);
        assertEquals(expectedChefs, chefs);
    }

    @Test
    public void testDoublePromotion(){
        // works!
    }

    @Test
    public void testPromotionForChefThatDoesNotExist(){
        Restaurant restaurant = new Restaurant();
        Chef jrChef = new JuniorChef("Albert");
        restaurant.addChef(jrChef);
        restaurant.promoteChef("Albert 123");

        List<Chef> chefs = restaurant.getChefs();
        JuniorChef expectedChefA = new JuniorChef("Albert");

        List<Chef> expectedChefs = Arrays.asList(expectedChefA);
        assertEquals(expectedChefs, chefs);
    }


    @Test
    public void testMasterChefIsValid(){
//        SeniorChef seniorChef = new SeniorChef("Betty White");
//        seniorChef.giveOrders();

        MasterChef masterChef = new MasterChef("Golden Resume");
        masterChef.giveOrders();
    }


}