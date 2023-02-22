package edu.ncsu.csc326.coffeemaker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeBookTest {

    private RecipeBook rb;
    private Recipe addRecipe;
    private Recipe recipeToDelete;
    private Recipe editRecipe;
    private Recipe emptyRecipe;
    private Recipe [] recipeArray;


    @Before
    public void setUp() throws Exception {
        //Setup for RecipeBook
        rb = new RecipeBook();
        recipeArray = new Recipe[4];

        //Set up for testRecipe
        addRecipe = new Recipe();
        addRecipe.setName("Coffee");
        addRecipe.setAmtChocolate("0");
        addRecipe.setAmtCoffee("3");
        addRecipe.setAmtMilk("0");
        addRecipe.setAmtSugar("1");
        addRecipe.setPrice("50");

        //Set up for recipeToDelete
        recipeToDelete = new Recipe();
        recipeToDelete.setName("Cappuccino");
        recipeToDelete.setAmtChocolate("0");
        recipeToDelete.setAmtCoffee("2");
        recipeToDelete.setAmtMilk("0");
        recipeToDelete.setAmtSugar("1");
        recipeToDelete.setPrice("20");

        //Set up for editRecipe
        editRecipe = new Recipe();
        //Empty recipe
        emptyRecipe = new Recipe();
        editRecipe.setName("Mocha");
        editRecipe.setAmtChocolate("1");
        editRecipe.setAmtCoffee("2");
        editRecipe.setAmtMilk("0");
        editRecipe.setAmtSugar("1");
        editRecipe.setPrice("20");

    }

    public void tearDown() throws Exception {
    }

    @Test
    public void testGetRecipes() {
        rb.addRecipe(addRecipe);
        recipeArray = rb.getRecipes();
        assert(recipeArray != null);
    }

    @Test
    public void testAddRecipe() {
        boolean result = rb.addRecipe(addRecipe);
        assertTrue(result);

        //Test if added recipe is already in the recipe book
        result = rb.addRecipe(addRecipe);
        assertFalse(result);
    }
    @Test
    public void testDeleteRecipe() {
        rb.addRecipe(recipeToDelete);
        String result = rb.deleteRecipe(0);
        assertEquals("Cappuccino", result);

        //Test to delete recipe that is not in Recipe book
        String nullTest = rb.deleteRecipe(1);
        assertNull(nullTest);
    }
    @Test
    public void testEditRecipe() {
        rb.addRecipe(editRecipe);
        String result = rb.editRecipe(0, emptyRecipe);
        assertEquals("Mocha", result);

        result = rb.editRecipe(2, emptyRecipe);
        assertNull(result);
    }
}