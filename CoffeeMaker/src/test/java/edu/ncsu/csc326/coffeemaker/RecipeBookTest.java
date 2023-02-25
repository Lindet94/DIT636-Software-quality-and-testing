package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeBookTest {

    private RecipeBook rb;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;
    private Recipe r5;
    private Recipe [] recipeArray;



    @Before
    public void setUp() throws Exception {
        //Setup for RecipeBook
        rb = new RecipeBook();
        //Setup Recipe Array
        recipeArray = new Recipe[4];

        //Set up for testAddRecipe
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("0");
        r1.setAmtSugar("1");
        r1.setPrice("50");

        //Set up for recipeToDelete
        r2 = new Recipe();
        r2.setName("Cappuccino");
        r2.setAmtChocolate("0");
        r2.setAmtCoffee("2");
        r2.setAmtMilk("0");
        r2.setAmtSugar("1");
        r2.setPrice("20");

        //Set up for editRecipe
        r3 = new Recipe();
        //Empty recipe to contain the edited recipe
        r4 = new Recipe();
        // Null recipe to test on a recipe that is not in the recipe book
        r5 = new Recipe();
        r3.setName("Mocha");
        r3.setAmtChocolate("1");
        r3.setAmtCoffee("2");
        r3.setAmtMilk("0");
        r3.setAmtSugar("1");
        r3.setPrice("20");

    }

    @Test
    public void testGetRecipes() {
        rb.addRecipe(r1);
        recipeArray = rb.getRecipes();
        assert(recipeArray != null);
    }

    @Test
    public void testAddRecipe() {
        boolean result = rb.addRecipe(r1);
        assertTrue(result);
    }

    @Test
    public void testAddTwoRecipes() {
        boolean result = rb.addRecipe(r1);
        boolean resultTwo = rb.addRecipe(r2);
        assertTrue(result);
        assertTrue(resultTwo);
    }

    @Test
    public void testAddFiveRecipes() {
        rb.addRecipe(r1);
        rb.addRecipe(r2);
        rb.addRecipe(r3);
        rb.addRecipe(r4);
        boolean result = rb.addRecipe(r5);
        assertFalse(result);
    }

    @Test
    public void testAddAlreadyInBookRecipe() {
        //Test if added recipe is already in the recipe book
        rb.addRecipe(r1);
        boolean result = rb.addRecipe(r1);
        assertFalse(result);
    }
    @Test
    public void testDeleteRecipe() {
        rb.addRecipe(r2);
        String result = rb.deleteRecipe(0);
        assertEquals("Cappuccino", result);

        // Make sure that the deleted recipe is gone from the list.
        recipeArray = rb.getRecipes();
        assertNull(recipeArray[0]);
    }

    @Test
    public void testDeleteRecipeNotInRecipeBook() {
        //Test to delete recipe that is not in Recipe book
        String nullTest = rb.deleteRecipe(1);
        assertNull(nullTest);
    }

    @Test
    public void testEditRecipe() {
        rb.addRecipe(r3);

        try {
            r4.setPrice("1");
            r4.setAmtCoffee("1");
            r4.setAmtMilk("1");
            r4.setAmtSugar("1");
            r4.setAmtChocolate("1");
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
        // Edit recipe r3
        rb.editRecipe(0, r4);
        String name = r4.getName();
        assertEquals("Mocha", name);

        assertEquals(1, r4.getPrice());
        assertEquals(1, r4.getAmtCoffee());
        assertEquals(1, r4.getAmtMilk());
        assertEquals(1, r4.getAmtSugar());
        assertEquals(1, r4.getAmtChocolate());
    }

    @Test
    public void testEditOnlyPrice() {
        rb.addRecipe(r3);
        try {
            r4.setPrice("1");
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
        assertEquals(1, r4.getPrice());
    }

    @Test
    public void testEditOnlyCoffee() {
        rb.addRecipe(r3);
        try {
            r4.setAmtCoffee("3");
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
        assertEquals(3, r4.getAmtCoffee());
    }

    @Test
    public void testEditOnlyMilk() {
        rb.addRecipe(r3);
        try {
            r4.setAmtMilk("2");
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
        assertEquals(2, r4.getAmtMilk());
    }

    @Test
    public void testEditOnlySugar() {
        rb.addRecipe(r3);
        try {
            r4.setAmtSugar("3");
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
        assertEquals(3, r4.getAmtSugar());
    }

    @Test
    public void testEditOnlySChocolate() {
        rb.addRecipe(r3);
        try {
            r4.setAmtCoffee("5");
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
        assertEquals(5, r4.getAmtCoffee());
    }

    @Test
    public void testEditIncorrectProperty() {
        rb.addRecipe(r3);
        // Edit recipe r3
        rb.editRecipe(0, r4);
        Throwable exception = assertThrows(
                RecipeException.class, () -> {
                    r4.setAmtChocolate("-1"); // Should throw an InventoryException
                }
        );
    }
    @Test
    public void testAddNullRecipe() {
        String nullTest = rb.editRecipe(2, r5);
        assertNull(nullTest);
    }

}