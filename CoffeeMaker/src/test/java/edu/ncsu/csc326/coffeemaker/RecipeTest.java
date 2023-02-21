package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class RecipeTest {

    private CoffeeMaker cm;
    private Recipe r1;

    @Before
    public void setUp() throws Exception {
        cm = new CoffeeMaker();

        //Set up for r1
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("50");
    }

    public void tearDown() throws Exception {
    }

    @Test
    public void testGetAmtChocolate() {
        assertEquals(0, r1.getAmtChocolate());
    }

    @Test
    public void testSetAmtChocolate() {
        try {
            r1.setAmtChocolate("2");
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
        assertEquals(2, r1.getAmtChocolate());
    }
    @Test
    public void testGetAmtCoffee() {
        assertEquals(3, r1.getAmtCoffee());
    }

    @Test
    public void testSetAmtCoffee() {
        try{
            r1.setAmtCoffee("2");
        }catch(RecipeException e){
            throw new RuntimeException(e);
        }
        assertEquals(2, r1.getAmtCoffee());
    }

    @Test
    public void testGetAmtMilk() {
        assertEquals(1, r1.getAmtMilk());
    }

    @Test
    public void testSetAmtMilk() {
        try{
            r1.setAmtMilk("0");
        } catch(RecipeException e){
            throw new RuntimeException(e);
        }
        assertEquals(0, r1.getAmtMilk());
    }

    @Test
    public void testGetAmtSugar() {
        assertEquals(1, r1.getAmtSugar());
    }

    @Test
    public void testSetAmtSugar() {
        try{
            r1.setAmtSugar("5");
        }catch(RecipeException e){
            throw new RuntimeException(e);
        }
        assertEquals(5, r1.getAmtSugar());
    }

    @Test
    public void testTestGetName() {
        assertEquals("Coffee", r1.getName());
    }

    @Test
    public void testTestSetName() {
        r1.setName("Espresso");
        assertEquals("Espresso", r1.getName());
    }

    public void testGetPrice() {
        assertEquals(50, r1.getPrice());
    }

    @Test
    public void testSetPrice() {
        try{
            r1.setPrice("40");
        }catch(RecipeException e){
            throw new RuntimeException(e);
        }
        assertEquals(40, r1.getPrice());
    }

    public void testTestToString() {
    }

    public void testTestHashCode() {
    }

    public void testTestEquals() {
    }
}