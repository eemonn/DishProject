package comp3350.dishproject.tests.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.logic.RecipeValidator;
import comp3350.dishproject.objects.Recipe;

public class RecipeValidatorTest {

    private List<Recipe> lr;
    private String[] names;

    @Before
    public void setUp() {
        Recipe r1 = new Recipe("Pizza","100",5);
        Recipe r2 = new Recipe("Burger","200",2.5);
        names = new String[]{"Pizza", "Burger"};
        lr = new ArrayList<>();
        lr.add(r1);
        lr.add(r2);
    }

    @Test
    public void testCheckIfDishInSystem() {
        String dish = "Pizza";
        String lowerCaseDish = "burger";
        String badDish = "Pasta";
        boolean isInSystem = RecipeValidator.checkIfDishInSystem(dish,lr);
        Assert.assertTrue("Pizza should be in system",isInSystem);

        isInSystem = RecipeValidator.checkIfDishInSystem(lowerCaseDish,lr);
        Assert.assertTrue("lower case burger should be in system",isInSystem);

        isInSystem = RecipeValidator.checkIfDishInSystem(badDish,lr);
        Assert.assertFalse("Pasta should not be in system",isInSystem);
    }

    @Test
    public void testValidateRecipeID(){
        String recipeID = "100";
        String badRecipeID = "12354325";

        boolean isRecipeIDInSystem = RecipeValidator.validateRecipeID(recipeID,lr);
        Assert.assertTrue("100 should be in system",isRecipeIDInSystem);

        isRecipeIDInSystem = RecipeValidator.validateRecipeID(badRecipeID,lr);
        Assert.assertFalse("12354325 should not be in system",isRecipeIDInSystem);
    }

    @Test
    public void testSearchSuggestions() {
        String query = "bur";
        ArrayList<String> searchSuggestions = RecipeValidator.filterSearchSuggestions(query,names);
        Assert.assertTrue("Only one search suggestions should show",1 == searchSuggestions.size());
    }
}
