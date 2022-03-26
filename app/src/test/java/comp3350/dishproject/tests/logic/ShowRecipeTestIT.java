package comp3350.dishproject.tests.logic;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.application.Services;
import comp3350.dishproject.logic.ShowRecipe;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.tests.utils.TestUtils;


public class ShowRecipeTestIT {
    private Recipe r;
    private Ingredient i1;
    private Ingredient i2;
    private Ingredient i3;
    private ShowRecipe sr;
    List<Ingredient> li;
    private File tempDB;


    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        r = new Recipe("Pizza","100",5);
        i1 = new Ingredient("Cheese",1,20,50,r.getRecipeID());
        i2 = new Ingredient("Dough",1,20,50,r.getRecipeID());
        i3 = new Ingredient("Sauce",1,20,50,r.getRecipeID());
        li = new ArrayList<>();
        li.add(i1);
        li.add(i2);
        li.add(i3);
        sr = new ShowRecipe(r,"100",li);
    }

    @Test
    public void testConstructor() {
        Assert.assertNotNull("Show Recipe should not be null", sr);
    }

    @Test
    public void testUpdateIngredients() {
        sr.updateIngredients(3);
        Assert.assertEquals("Weight of Ingredient should be 3x20=60", 60, i1.getWeight(), 0.01);
        Assert.assertEquals("Calorie of Ingredient should be 3x50=150", 150, i1.getCalorie(), 0.01);
        Assert.assertEquals("Quantity of Ingredient should be 3x1=3", 3, i1.getQuantity(), 0.01);
        sr.updateIngredients(5);
        Assert.assertEquals("Weight of Ingredient should be 5x20=100", 100, i1.getWeight(), 0.01);
        Assert.assertEquals("Calorie of Ingredient should be 5x50=250", 250, i1.getCalorie(), 0.01);
        Assert.assertEquals("Quantity of Ingredient should be 5x1=5", 5, i1.getQuantity(), 0.01);
    }

    @Test
    public void testShowTitleDescription() {
        String title = "";
        double totalCalories = 50*3;
        double totalWeight = 20*3;
        title += "Calorie: " + totalCalories + "kcal "+ " Weight: " +  totalWeight + "g " + "Rating: " + r.getRating() + "\n";
        Assert.assertEquals("Titles should be the same",title,sr.showTitleDescription());
    }

    @Test
    public void testCalculateCalories() {
        double totalCalories = 50*3;
        Assert.assertEquals("Total calories of all ingredients should be the same",totalCalories,sr.calculateCalories(),0.01);
    }

    @Test
    public void testCalculateWeight() {
        double totalWeight = 20*3;
        Assert.assertEquals("Total weight of all ingredients should be the same",totalWeight,sr.calculateWeight(),0.01);
    }

    @Test
    public void testGetIngredientListName() {
        Assert.assertEquals("Lengths(number of ingredients) should be the same",li.size(),sr.getIngredientListName().length);
    }

    @After
    public void tearDown() {
        this.tempDB.delete();
        Services.clean();
    }
}