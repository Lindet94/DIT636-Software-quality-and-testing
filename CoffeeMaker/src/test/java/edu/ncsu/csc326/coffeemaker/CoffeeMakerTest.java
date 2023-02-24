package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CoffeeMakerTest {

    private RecipeBook rb;
    private Inventory inventory;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private CoffeeMaker cm;

    private Recipe [] recipeArray;

    @Before
    public void setUp() throws Exception {
        rb = new RecipeBook();
        inventory = new Inventory();
        cm = new CoffeeMaker();

        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("0");
        r1.setAmtSugar("1");
        r1.setPrice("50");

        r2 = new Recipe();
        r2.setName("Cappuccino");
        r2.setAmtChocolate("0");
        r2.setAmtCoffee("3");
        r2.setAmtMilk("0");
        r2.setAmtSugar("1");
        r2.setPrice("50");

        r3 = new Recipe();

    }
    @Test
    public void testAddRecipe() {
        boolean result = cm.addRecipe(r1);
        assertTrue(result);
    }

    @Test
    public void testAddRecipeInRecipeBook() {
        cm.addRecipe(r1);
        boolean result = cm.addRecipe(r1);
        assertFalse(result);
    }

    @Test
    public void testDeleteRecipeFromCoffeeMaker() {
        cm.addRecipe(r1);
        String result = cm.deleteRecipe(0);
        assertEquals("Coffee", result);

        // Make sure that the deleted recipe is gone from the list.
        recipeArray = rb.getRecipes();
        assertNull(recipeArray[0]);
    }

    @Test
    public void testEditRecipe() {
        cm.addRecipe(r2);

        try {
            r3.setPrice("1");
            r3.setAmtCoffee("1");
            r3.setAmtMilk("1");
            r3.setAmtSugar("1");
            r3.setAmtChocolate("1");
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
        // Edit recipe r3
        cm.editRecipe(0, r3);
        String name = r3.getName();
        assertEquals("Cappuccino", name);

        assertEquals(1, r3.getPrice());
        assertEquals(1, r3.getAmtCoffee());
        assertEquals(1, r3.getAmtMilk());
        assertEquals(1, r3.getAmtSugar());
        assertEquals(1, r3.getAmtChocolate());

    }
    @Test
    public void testValidInputToInventory() throws InventoryException {
            cm.addInventory("1", "2", "0", "1");
            //Inventory is initialized with 15. Adding 1 should result in 16
            assertEquals(16, inventory.getCoffee());
    }
    @Test
    public void testAddInventory() {
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    cm.addInventory("-1", "2", "0", "0"); // Should throw an InventoryException
                }
        );
    }
    @Test
    public void testCheckInventory() {
        String result = cm.checkInventory();
        assertEquals("Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n", result);
    }
    @Test
    public void testMakeCoffee() {
    }
    @Test
    public void testGetRecipes() {
    }
}