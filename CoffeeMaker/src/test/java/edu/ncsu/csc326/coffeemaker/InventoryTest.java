package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class InventoryTest {
    private Inventory inventory;
    private Recipe r1;

    @Before
    public void setUp() throws Exception {
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("5");
        r1.setAmtCoffee("4");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("50");
    }

    @Test
    public void testInventoryShouldContainFifteenMilk() {
        inventory = new Inventory();
        assertEquals(15, inventory.getMilk());
    }

    @Test
    public void testInventoryShouldContainFifteenSugar() {
        inventory = new Inventory();
        assertEquals(15, inventory.getSugar());
    }

    @Test
    public void testInventoryShouldContainFifteenChocolate() {
        inventory = new Inventory();
        assertEquals(15, inventory.getChocolate());
    }

    @Test
    public void testInventoryShouldContainFifteenCoffee() {
        inventory = new Inventory();
        assertEquals(15, inventory.getCoffee());
    }

    // setChocolate tests
    @Test
    public void testSettingChocolateToLessThanZeroShouldNotWork() {
        inventory = new Inventory();
        inventory.setChocolate(-1);
        assertNotEquals(-1, inventory.getChocolate());
    }

    @Test
    public void testSettingChocolateToZeroShouldWork() {
        inventory = new Inventory();
        inventory.setChocolate(0);
        assertEquals(0, inventory.getChocolate());
    }

    @Test
    public void testSettingChocolateToOneShouldWork() {
        inventory = new Inventory();
        inventory.setChocolate(1);
        assertEquals(1, inventory.getChocolate());
    }

    // setMilk tests
    @Test
    public void testSettingMilkToLessThanZeroShouldNotWork() {
        inventory = new Inventory();
        inventory.setMilk(-1);
        assertNotEquals(-1, inventory.getMilk());
    }

    @Test
    public void testSettingMilkToZeroShouldWork() {
        inventory = new Inventory();
        inventory.setMilk(0);
        assertEquals(0, inventory.getMilk());
    }

    @Test
    public void testSettingMilkToOneShouldWork() {
        inventory = new Inventory();
        inventory.setMilk(1);
        assertEquals(1, inventory.getMilk());
    }

    // setSugar tests
    @Test
    public void testSettingSugarToLessThanZeroShouldNotWork() {
        inventory = new Inventory();
        inventory.setSugar(-1);
        assertNotEquals(-1, inventory.getSugar());
    }

    @Test
    public void testSettingSugarToZeroShouldWork() {
        inventory = new Inventory();
        inventory.setSugar(0);
        assertEquals(0, inventory.getSugar());
    }

    @Test
    public void testSettingSugarToOneShouldWork() {
        inventory = new Inventory();
        inventory.setSugar(1);
        assertEquals(1, inventory.getSugar());
    }

    // setCoffee tests
    @Test
    public void testSettingCoffeeToLessThanZeroShouldNotWork() {
        inventory = new Inventory();
        inventory.setCoffee(-1);
        assertNotEquals(-1, inventory.getCoffee());
    }

    @Test
    public void testSettingCoffeeToZeroShouldWork() {
        inventory = new Inventory();
        inventory.setCoffee(0);
        assertEquals(0, inventory.getCoffee());
    }

    @Test
    public void testSettingCoffeeToOneShouldWork() {
        inventory = new Inventory();
        inventory.setCoffee(1);
        assertEquals(1, inventory.getCoffee());
    }

    // addChocolate tests
    @Test(expected = InventoryException.class)
    public void testAddingNegativeChocolateShouldThrowError() throws InventoryException {
        inventory = new Inventory();
        inventory.addChocolate("-1");
    }

    @Test(expected = InventoryException.class)
    public void testAddingNullChocolateShouldThrowError() throws InventoryException {
        inventory = new Inventory();
        inventory.addChocolate(null);
    }

    @Test(expected = InventoryException.class)
    public void testAddingCharacterChocolateShouldThrowError() throws InventoryException {
        inventory = new Inventory();
        inventory.addChocolate("a");
    }

    @Test
    public void testAddingZeroChocolateShouldWork() throws InventoryException {
        inventory = new Inventory();
        inventory.addChocolate("0");
        assertEquals(15, inventory.getChocolate());
    }

    @Test
    public void testAddingOneChocolateShouldWork() throws InventoryException {
        inventory = new Inventory();
        inventory.addChocolate("1");
        assertEquals(15 + 1, inventory.getChocolate());
    }

    // addMilk tests
    @Test(expected = InventoryException.class)
    public void testAddingNegativeMilkShouldThrowError() throws InventoryException {
        inventory = new Inventory();
        inventory.addMilk("-1");
    }

    @Test(expected = InventoryException.class)
    public void testAddingNullMilkShouldThrowError() throws InventoryException {
        inventory = new Inventory();
        inventory.addMilk(null);
    }

    @Test(expected = InventoryException.class)
    public void testAddingCharacterMilkShouldThrowError() throws InventoryException {
        inventory = new Inventory();
        inventory.addMilk("a");
    }

    @Test
    public void testAddingZeroMilkShouldWork() throws InventoryException {
        inventory = new Inventory();
        inventory.addMilk("0");
        assertEquals(15, inventory.getMilk());
    }

    @Test
    public void testAddingOneMilkShouldWork() throws InventoryException {
        inventory = new Inventory();
        inventory.addMilk("1");
        assertEquals(15 + 1, inventory.getMilk());
    }

    // addSugar tests
    @Test(expected = InventoryException.class)
    public void testAddingNegativeSugarShouldThrowError() throws InventoryException {
        inventory = new Inventory();
        inventory.addSugar("-1");
    }

    @Test(expected = InventoryException.class)
    public void testAddingNullSugarShouldThrowError() throws InventoryException {
        inventory = new Inventory();
        inventory.addSugar(null);
    }

    @Test(expected = InventoryException.class)
    public void testAddingCharacterSugarShouldThrowError() throws InventoryException {
        inventory = new Inventory();
        inventory.addSugar("a");
    }

    @Test
    public void testAddingZeroSugarShouldWork() throws InventoryException {
        inventory = new Inventory();
        inventory.addSugar("0");
        assertEquals(15, inventory.getSugar());
    }

    @Test
    public void testAddingOneSugarShouldWork() throws InventoryException {
        inventory = new Inventory();
        inventory.addSugar("1");
        assertEquals(15 + 1, inventory.getSugar());
    }

    // addCoffee tests
    @Test(expected = InventoryException.class)
    public void testAddingNegativeCoffeeShouldThrowError() throws InventoryException {
        inventory = new Inventory();
        inventory.addCoffee("-1");
    }

    @Test(expected = InventoryException.class)
    public void testAddingNullCoffeeShouldThrowError() throws InventoryException {
        inventory = new Inventory();
        inventory.addCoffee(null);
    }

    @Test(expected = InventoryException.class)
    public void testAddingCharacterCoffeeShouldThrowError() throws InventoryException {
        inventory = new Inventory();
        inventory.addCoffee("a");
    }

    @Test
    public void testAddingZeroCoffeeShouldWork() throws InventoryException {
        inventory = new Inventory();
        inventory.addCoffee("0");
        assertEquals(15, inventory.getCoffee());
    }

    @Test
    public void testAddingOneCoffeeShouldWork() throws InventoryException {
        inventory = new Inventory();
        inventory.addCoffee("1");
        assertEquals(15 + 1, inventory.getCoffee());
    }

    // enoughIngredients() tests
    @Test
    public void testEnoughIngredientsReturnsTrueWhenAllLevelsEqual() throws RecipeException {
        inventory = new Inventory();

        r1.setAmtChocolate("2");
        r1.setAmtCoffee("2");
        r1.setAmtMilk("2");
        r1.setAmtSugar("2");

        inventory.setCoffee(2);
        inventory.setMilk(2);
        inventory.setSugar(2);
        inventory.setChocolate(2);

        assertTrue(inventory.enoughIngredients(r1));
    }

    @Test
    public void testEnoughIngredientsReturnsTrueWhenAllLevelsGreaterThanRecipe() throws RecipeException {
        inventory = new Inventory();

        r1.setAmtChocolate("2");
        r1.setAmtCoffee("2");
        r1.setAmtMilk("2");
        r1.setAmtSugar("2");

        inventory.setCoffee(3);
        inventory.setMilk(3);
        inventory.setSugar(3);
        inventory.setChocolate(3);

        assertTrue(inventory.enoughIngredients(r1));
    }

    @Test
    public void testEnoughIngredientsReturnsFalseWhenOneLevelLessThanRecipe() throws RecipeException {
        inventory = new Inventory();

        r1.setAmtChocolate("2");
        r1.setAmtCoffee("2");
        r1.setAmtMilk("2");
        r1.setAmtSugar("2");

        inventory.setCoffee(2);
        inventory.setMilk(2);
        inventory.setSugar(2);
        inventory.setChocolate(1);

        assertFalse(inventory.enoughIngredients(r1));
    }

    @Test
    public void testEnoughIngredientsReturnsFalseWhenAllLevelsLessThanRecipe() throws RecipeException {
        inventory = new Inventory();

        r1.setAmtChocolate("2");
        r1.setAmtCoffee("2");
        r1.setAmtMilk("2");
        r1.setAmtSugar("2");

        inventory.setCoffee(1);
        inventory.setMilk(1);
        inventory.setSugar(1);
        inventory.setChocolate(1);

        assertFalse(inventory.enoughIngredients(r1));
    }

    // useIngredients(Recipe r) tests
    @Test
    public void testUseValidIngredientsShouldReturnTrue() throws RecipeException {
        inventory = new Inventory();
        inventory.setChocolate(1);
        inventory.setCoffee(1);
        inventory.setMilk(1);
        inventory.setSugar(1);
        r1.setAmtChocolate("1");
        r1.setAmtCoffee("1");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");

        assertTrue(inventory.useIngredients(r1));
    }

    @Test
    public void testUseTooManyIngredientsShouldReturnFalse() throws RecipeException {
        inventory = new Inventory();
        inventory.setChocolate(1);
        inventory.setCoffee(1);
        inventory.setMilk(1);
        inventory.setSugar(1);
        r1.setAmtChocolate("2");
        r1.setAmtCoffee("2");
        r1.setAmtMilk("2");
        r1.setAmtSugar("2");

        assertFalse(inventory.useIngredients(r1));
    }

    @Test
    public void testUsingChocolateShouldDecreaseInventory() throws RecipeException {
        inventory = new Inventory();
        inventory.setChocolate(1);
        r1.setAmtChocolate("1");
        inventory.useIngredients(r1);

        assertEquals(0, inventory.getChocolate());
    }

    @Test
    public void testUsingCoffeeShouldDecreaseInventory() throws RecipeException {
        inventory = new Inventory();
        inventory.setCoffee(1);
        r1.setAmtCoffee("1");
        inventory.useIngredients(r1);

        assertEquals(0, inventory.getCoffee());
    }

    @Test
    public void testUsingSugarShouldDecreaseInventory() throws RecipeException {
        inventory = new Inventory();
        inventory.setSugar(1);
        r1.setAmtSugar("1");
        inventory.useIngredients(r1);

        assertEquals(0, inventory.getSugar());
    }

    @Test
    public void testUsingMilkShouldDecreaseInventory() throws RecipeException {
        inventory = new Inventory();
        inventory.setMilk(1);
        r1.setAmtMilk("1");
        inventory.useIngredients(r1);

        assertEquals(0, inventory.getMilk());
    }

    @Test
    public void testToStringShouldReturnCorrectFormat() {
        inventory = new Inventory();
        inventory.setMilk(10);
        inventory.setChocolate(10);
        inventory.setCoffee(10);
        inventory.setSugar(10);

        String expected = """
                Coffee: 10
                Milk: 10
                Sugar: 10
                Chocolate: 10
                """;

        assertEquals(expected, inventory.toString());
    }
}