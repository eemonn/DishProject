package comp3350.dishproject.tests.logic;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import comp3350.dishproject.application.Services;
import comp3350.dishproject.logic.AccessRecipes;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.tests.utils.TestUtils;

public class AccessRecipesTestIT {
    private File tempDB;
    private AccessRecipes ar;

    @Before
    public void setUp() throws IOException {
        tempDB = TestUtils.copyDB();
        ar = new AccessRecipes();
    }

    @Test
    public void testConstructor() {
        Assert.assertNotNull("Should not be null",ar);
    }

    @Test
    public void testFindRecipeID() {
        String recipeName = "burger";
        Assert.assertEquals("ID's should be the same","100",ar.findRecipeID(recipeName));

        String badName = "Water";
        Assert.assertEquals("There should be No Id","No ID",ar.findRecipeID(badName));
    }

    @Test
    public void testGetAllRecipes() {
        List<Recipe> allRecipes = ar.getAllRecipes();
        Assert.assertTrue("Length should be greater than 1",allRecipes.size()>=1);
    }

    @Test
    public void testInsertRecipe() {
        Recipe r = new Recipe("Apple","123",5);
        Recipe badRecipe = new Recipe("burger","100",3);

        Assert.assertTrue("Add should be good",ar.insertRecipe(r));

        Assert.assertFalse("Add should be bad",ar.insertRecipe(badRecipe));
    }

    @Test
    public void testGetRecipe() {
        String recipeID = "100";//burger
        String badRecipeID = "87138975";

        Assert.assertNotNull("Should return a recipe",ar.getRecipe(recipeID));
        Assert.assertNull("Should return a recipe",ar.getRecipe(badRecipeID));
    }

    @Test
    public void testDeleteRecipe(){
        String recipeID = "100";//burger
        ar.deleteRecipe("100");
        Assert.assertNull("Should not return a recipe",ar.getRecipe(recipeID));
    }

    @Test
    public void changeRating() {
        String recipeID = "100";//burger
        double newRating = 3;
        ar.changeRating(newRating,recipeID);
        Assert.assertEquals("rating should be 3.4",3,ar.getRecipe(recipeID).getRating(),0.01);
    }

    @After
    public void tearDown() {
        tempDB.delete();
        Services.clean();
    }
}
