package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;


public class RecipeTest {

    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;

    @Before
    public void setUp() throws Exception {

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
    public void testSetChocolateStringException() {
        assertThrows(
                RecipeException.class, () -> {
                    r1.setAmtChocolate("a"); // Should throw an Exception
                }
        );
    }

    @Test
    public void testSetChocolateNegativeIntException() {
        assertThrows(
                RecipeException.class, () -> {
                    r1.setAmtChocolate("-1"); // Should throw an Exception
                }
        );
    }

    @Test
    public void testGetAmtCoffee() {
        assertEquals(3, r1.getAmtCoffee());
    }

    @Test
    public void testSetAmtCoffee() {
        try {
            r1.setAmtCoffee("2");
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
        assertEquals(2, r1.getAmtCoffee());
    }

    @Test
    public void testSetCoffeeStringException() {
        assertThrows(
                RecipeException.class, () -> {
                    r1.setAmtCoffee("a"); // Should throw an Exception
                }
        );
    }

    @Test
    public void testSetCoffeeNegativeException() {
        assertThrows(
                RecipeException.class, () -> {
                    r1.setAmtCoffee("-4"); // Should throw an Exception
                }
        );
    }

    @Test
    public void testSetCoffeeNegativeIntException() {
        assertThrows(
                RecipeException.class, () -> {
                    r1.setAmtCoffee("-4"); // Should throw an Exception
                }
        );
    }

    @Test
    public void testGetAmtMilk() {
        assertEquals(1, r1.getAmtMilk());
    }

    @Test
    public void testSetAmtMilk() {
        try {
            r1.setAmtMilk("0");
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
        assertEquals(0, r1.getAmtMilk());
    }

    @Test
    public void testSetMilkStringException() {
        assertThrows(
                RecipeException.class, () -> {
                    r1.setAmtMilk("a"); // Should throw an Exception
                }
        );
    }

    @Test
    public void testSetMilkNegativeException() {
        assertThrows(
                RecipeException.class, () -> {
                    r1.setAmtMilk("-4"); // Should throw an Exception
                }
        );
    }

    @Test
    public void testGetAmtSugar() {
        assertEquals(1, r1.getAmtSugar());
    }

    @Test
    public void testSetAmtSugar() {
        try {
            r1.setAmtSugar("5");
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
        assertEquals(5, r1.getAmtSugar());
    }

    @Test
    public void testSetSugarStringException() {
        assertThrows(
                RecipeException.class, () -> {
                    r1.setAmtSugar("a"); // Should throw an Exception
                }
        );
    }

    @Test
    public void testSetSugarNegativeException() {
        assertThrows(
                RecipeException.class, () -> {
                    r1.setAmtSugar("-4"); // Should throw an Exception
                }
        );
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
    public void testSetNameNull() {
        r1.setName(null);
        assertNotNull(r1.getName());
    }
    /*
    @Test
    public void testSetNameNullShouldThrowException() {
        Throwable exception = assertThrows(
                RecipeException.class, () -> {
                    r1.setName(null); // Should throw an Exception
                }
        );
    }

     */

    @Test
    public void testGetPrice() {
        assertEquals(50, r1.getPrice());
    }

    @Test
    public void testSetPrice() {
        try {
            r1.setPrice("40");
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
        assertEquals(40, r1.getPrice());
    }

    @Test
    public void testSetPriceStringException() {
        assertThrows(
                RecipeException.class, () -> {
                    r1.setPrice("a"); // Should throw an Exception
                }
        );
    }

    @Test
    public void testSetPriceNegativeException() {
        assertThrows(
                RecipeException.class, () -> {
                    r1.setPrice("-4"); // Should throw an Exception
                }
        );
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
    public void testEqualsSame() {
        assertTrue(r1.equals(r1)); // Should return false when compared to an object of a different class
    }

    @Test
    public void testEqualsFalse() {
        assertFalse(r1.equals(r3)); // Different name, should not be equal
    }

    @Test
    public void testEqualsnull() {
        assertFalse(r1.equals(null)); // Should return false when compared to null
    }

    @Test
    public void testEqualsObject() {
        assertFalse(r1.equals(new Object())); // Should return false when compared to an object of a different class
    }

    @Test
    public void testEqualsFirstAndSecondName() {
        try {
            Recipe recipe1 = new Recipe();
            recipe1.setName("Espresso");
            recipe1.setAmtChocolate("0");
            recipe1.setAmtCoffee("3");
            recipe1.setAmtMilk("1");
            recipe1.setAmtSugar("1");
            recipe1.setPrice("50");

            Recipe recipe2 = new Recipe();
            recipe2.setName(null);
            recipe2.setAmtChocolate("0");
            recipe2.setAmtCoffee("3");
            recipe2.setAmtMilk("1");
            recipe2.setAmtSugar("1");
            recipe2.setPrice("50");
            assertFalse(recipe2.equals(recipe1)); // Should return false when compared to an object of a different class
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
    }
}