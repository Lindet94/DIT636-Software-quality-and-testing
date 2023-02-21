package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;


public class RecipeTest {

    private CoffeeMaker cm;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;

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

        r2 = new Recipe();
        r2.setName("Nespresso");
        r2.setAmtChocolate("0");
        r2.setAmtCoffee("3");
        r2.setAmtMilk("1");
        r2.setAmtSugar("1");
        r2.setPrice("50");

        r3 = new Recipe();
        r3.setName("Nespresso");
        r3.setAmtChocolate("0");
        r3.setAmtCoffee("3");
        r3.setAmtMilk("1");
        r3.setAmtSugar("1");
        r3.setPrice("50");

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
    public void testSetName() {
        r1.setName("Espresso");
        assertEquals("Espresso", r1.getName());
    }

    @Test
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

    @Test
    public void testToString() {
        assertEquals(r1.toString(), "Coffee");
    }

    @Test
    public void testHashCode() {
        assertEquals(r2.hashCode(), r3.hashCode());
    }

    @Test
    public void testEquals() {

        r2.setName("Nespresso");
        r3.setName("Nespresso");
        assertTrue(r2.equals(r3));
        r2.setName("Coffee");
        r3.setName("Nespresso");
        assertFalse(r2.equals(r3));
        r2.setName(null);
        r3.setName("Nespresso");
        assertFalse(r2.equals(r3));

        assertNotNull(r3);
        r4 = null;
        assertNull(r4);

        assertFalse(r3.equals(r4));
    }
}