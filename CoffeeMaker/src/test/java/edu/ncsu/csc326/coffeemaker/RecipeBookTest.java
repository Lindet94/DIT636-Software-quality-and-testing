package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;

public class RecipeBookTest extends TestCase {

    private Recipe testRecipe;
    private RecipeBook rb;

    private Recipe nullRecipe;

    public void setUp() throws Exception {

        //Set up for r1
        testRecipe = new Recipe();
        testRecipe.setName("Coffee");
        testRecipe.setAmtChocolate("0");
        testRecipe.setAmtCoffee("3");
        testRecipe.setAmtMilk("0");
        testRecipe.setAmtSugar("1");
        testRecipe.setPrice("50");
        rb = new RecipeBook();

        nullRecipe = new Recipe();
    }

    public void tearDown() throws Exception {
    }

    public void testGetRecipes() {
    }

    public void testAddRecipe() {
        boolean result = rb.addRecipe(testRecipe);
        assertTrue(result);

        result = rb.addRecipe(nullRecipe);
        assertFalse(result);

    }

    public void testDeleteRecipe() {
    }

    public void testEditRecipe() {
    }
}