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
        Assert.assertEquals("ID's should be the same",100,ar.findRecipeID(recipeName));

        String badName = "Water";
        Assert.assertEquals("There should be No Id",-1,ar.findRecipeID(badName));
    }

    @Test
    public void testGetAllRecipes() {
        List<Recipe> allRecipes = ar.getAllRecipes();
        Assert.assertTrue("Length should be greater than 1",allRecipes.size()>=1);
    }

    @Test
    public void testInsertRecipe() {
        Recipe r = new Recipe("Apple",123,5,false,"Bake it");
        Recipe badRecipe = new Recipe("burger",100,3,false,"Burger on Bun");

        Assert.assertTrue("Add should be good",ar.insertRecipe(r));

        Assert.assertFalse("Add should be bad",ar.insertRecipe(badRecipe));
    }

    @Test
    public void testGetRecipe() {
        int recipeID = 100;//burger
        int badRecipeID = 87138975;

        Assert.assertNotNull("Should return a recipe",ar.getRecipe(recipeID));
        Assert.assertTrue("Should return a recipe with name Null",ar.getRecipe(badRecipeID).getName().equals("Null"));
    }

    @Test
    public void testDeleteRecipe(){
        int recipeID = 100;//burger
        ar.deleteRecipe(100);
        Assert.assertTrue("Should return a recipe with name Null",ar.getRecipe(recipeID).getName().equals("Null"));
    }

    @Test
    public void testChangeRating() {
        int recipeID = 100;//burger
        double newRating = 3;
        ar.changeRating(newRating,recipeID);
        Assert.assertEquals("rating should be 3.4",3,ar.getRecipe(recipeID).getRating(),0.01);
    }

    @Test
    public void testChangeFav() {
        int recipeID = 100;//burger
        boolean newFav = true;
        ar.changeFav(newFav,recipeID);
        Assert.assertTrue("Burger should now be fav",ar.getRecipe(recipeID).getFav());
    }




    @Test
    public void testUpdateDirections() {
        int recipeID = 300;//Tacos in the system
        ar.updateDirections(recipeID,"Boil the meat(eww)");
        Recipe r = ar.getRecipe(recipeID);
        Assert.assertEquals("directions should be updated","Boil the meat(eww)",r.getSteps());
    }

    @After
    public void tearDown() {
        tempDB.delete();
        Services.clean();
    }
}
