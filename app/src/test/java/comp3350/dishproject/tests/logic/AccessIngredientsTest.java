package comp3350.dishproject.tests.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import comp3350.dishproject.logic.AccessIngredients;
import comp3350.dishproject.logic.AccessRecipes;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.IngredientPersistence;
import comp3350.dishproject.persistence.RecipePersistence;
import comp3350.dishproject.persistence.stubs.IngredientPersistenceStub;
import comp3350.dishproject.persistence.stubs.RecipePersistenceStub;

public class AccessIngredientsTest {
    private IngredientPersistence ingredientPersistence;
    private RecipePersistence recipePersistence;
    private AccessRecipes ar;
    private AccessIngredients ai;
    Recipe r;
    String recipeID;


    @Before
    public void setUp() {
        ingredientPersistence = new IngredientPersistenceStub();
        recipePersistence = new RecipePersistenceStub();
        ai = new AccessIngredients(ingredientPersistence);
        ar = new AccessRecipes(recipePersistence);
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
        Ingredient i1 = new Ingredient("Fries",2,50,150,r.getRecipeID());
        ai.addIngredients(i1,recipeID);
        int newSize  = ai.getIngredients(recipeID).size();
        Assert.assertTrue("Ingredient should of been added so size + 1",originalSize+1 == newSize);

    }

}
