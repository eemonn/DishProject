package comp3350.dishproject.tests.logic;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import comp3350.dishproject.application.Services;
import comp3350.dishproject.logic.AccessIngredients;
import comp3350.dishproject.logic.AccessRecipes;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.IngredientPersistence;
import comp3350.dishproject.persistence.RecipePersistence;
import comp3350.dishproject.tests.utils.TestUtils;

public class AccessIngredientsTestIT {
    private File tempDB;
    private IngredientPersistence ingredientPersistence;
    private RecipePersistence recipePersistence;
    private AccessRecipes ar;
    private AccessIngredients ai;
    Recipe r;
    String recipeID;


    @Before
    public void setUp() throws IOException {
        tempDB = TestUtils.copyDB();
        ai = new AccessIngredients();
        ar = new AccessRecipes();
        recipeID = "100";
        r = ar.getRecipe(recipeID);

    }

    @Test
    public void testConstructor() {
        Assert.assertNotNull("Should not be null",ai);
        Assert.assertNotNull("Should not be null",ar);
    }

    @Test
    public void testGetIngredients() {
        String badRecipeID = "124235";

        List<Ingredient> li = ai.getIngredients(recipeID);
        List<Ingredient> liBad = ai.getIngredients(badRecipeID);

        Assert.assertTrue("Should have length 3",li.size() == 3);
        Assert.assertNotNull("Should not be null",li);

        Assert.assertTrue("Should be empty since recipeID not in system",liBad.size() == 0);
    }

    @Test
    public void testAddIngredients() {
        int originalSize  = ai.getIngredients(recipeID).size();
        Ingredient i1 = new Ingredient("Fries",2,50,150,r);
        ai.addIngredients(i1,recipeID,ar.getAllRecipes());
        int newSize  = ai.getIngredients(recipeID).size();
        Assert.assertTrue("Ingredient should of been added so size + 1",originalSize+1 == newSize);

    }

    @Test
    public void testBadAddIngredients() {
        int originalSize  = ai.getIngredients(recipeID).size();
        Ingredient i1 = new Ingredient("Mustard",1,23,123,r);
        String badRecipeID = "124235";
        ai.addIngredients(i1,badRecipeID,ar.getAllRecipes());
        int newSize  = ai.getIngredients(recipeID).size();
        Assert.assertFalse("Ingredient should of been added so size is still size",originalSize+1 == newSize);
    }

    @After
    public void tearDown() {
        tempDB.delete();
        Services.clean();
    }
}
