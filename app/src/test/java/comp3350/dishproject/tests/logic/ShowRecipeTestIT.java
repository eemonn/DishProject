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
import comp3350.dishproject.logic.AccessIngredients;
import comp3350.dishproject.logic.ShowRecipe;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.tests.utils.TestUtils;


public class ShowRecipeTestIT {
    private Recipe r;
    private Ingredient i1;
    private ShowRecipe sr;
    private File tempDB;
    List<Ingredient> li;
    private AccessIngredients ai;


    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        ai = new AccessIngredients();
        r = new Recipe("burger","100",5,false);
        li = ai.getIngredients(r.getRecipeID());
        i1 = li.get(0);//This will be Buns with a weight of 0.5, calorie of 20, quantity of 1
        sr = new ShowRecipe(r);
    }

    @Test
    public void testConstructor() {
        Assert.assertNotNull("Show Recipe should not be null", sr);
    }



    @Test
    public void testUpdateIngredients() {
        //cant test this here as this is used to display UI elements(that dont change the database)
    }


    /* - Ingredients of Burger Reference
    INSERT INTO INGREDIENTS VALUES('Buns',1,0.5,20,'100')
    INSERT INTO INGREDIENTS VALUES('Ground Beef',2,1.5,32.5,'100')
    INSERT INTO INGREDIENTS VALUES('Cheese',2,1.5,32.5,'100')
     */
    @Test
    public void testShowTitleDescription() {
        String title = "";
        double totalCalories = 20 + 32 + 32;
        double totalWeight = 0 + 1 + 1;
        title += "Calorie: " + totalCalories + "kcal "+ " Weight: " +  totalWeight + "g " + "Rating: " + r.getRating() + "\n";
        Assert.assertEquals("Titles should be the same",title,sr.showTitleDescription());
    }

    @Test
    public void testCalculateCalories() {
        double totalCalories = 20 + 32 + 32;
        Assert.assertEquals("Total calories of all ingredients should be the same",totalCalories,sr.calculateCalories(),0.01);
    }

    @Test
    public void testCalculateWeight() {
        double totalWeight = 0 + 1 + 1;
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