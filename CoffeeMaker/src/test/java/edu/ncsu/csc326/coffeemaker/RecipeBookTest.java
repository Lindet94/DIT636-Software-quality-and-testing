package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeBookTest {

    private RecipeBook rb;
    private Recipe addRecipe;
    private Recipe recipeToDelete;
    private Recipe editRecipe;
    private Recipe changedRecipe;
    private Recipe [] recipeArray;
    private Recipe nullRecipe;


    @Before
    public void setUp() throws Exception {
        //Setup for RecipeBook
        rb = new RecipeBook();
        //Setup Recipe Array
        recipeArray = new Recipe[4];

        //Set up for testAddRecipe
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
        //Empty recipe to contain the edited recipe
        changedRecipe = new Recipe();
        // Null recipe to test on a recipe that is not in the recipe book
        nullRecipe = new Recipe();
        editRecipe.setName("Mocha");
        editRecipe.setAmtChocolate("1");
        editRecipe.setAmtCoffee("2");
        editRecipe.setAmtMilk("0");
        editRecipe.setAmtSugar("1");
        editRecipe.setPrice("20");

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

        // Make sure that the deleted recipe is gone from the list.
        recipeArray = rb.getRecipes();
        assertNull(recipeArray[0]);

        //Test to delete recipe that is not in Recipe book
        String nullTest = rb.deleteRecipe(1);
        assertNull(nullTest);
    }
    @Test
    public void testEditRecipe() {
        rb.addRecipe(editRecipe);

        try {
            changedRecipe.setPrice("1");
            changedRecipe.setAmtCoffee("1");
            changedRecipe.setAmtMilk("1");
            changedRecipe.setAmtSugar("1");
            changedRecipe.setAmtChocolate("1");
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
        rb.editRecipe(0, changedRecipe);
        String name = changedRecipe.getName();
        assertEquals("Mocha", name);

        assertEquals(1, changedRecipe.getPrice());
        assertEquals(1, changedRecipe.getAmtCoffee());
        assertEquals(1, changedRecipe.getAmtMilk());
        assertEquals(1, changedRecipe.getAmtSugar());
        assertEquals(1, changedRecipe.getAmtChocolate());

        String nullTest = rb.editRecipe(2, nullRecipe);
        assertNull(nullTest);
    }
}