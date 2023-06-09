package comp3350.dishproject.tests.logic;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import comp3350.dishproject.application.Services;
import comp3350.dishproject.logic.AddRecipe;
import comp3350.dishproject.tests.utils.TestUtils;

public class AddRecipeTestIT {
    private String recipeName;
    private String directions;
    private String[] ingredientNames;
    private Double[] ingredientWeights;
    private Double[] ingredientCals;
    private File tempDB;


    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        directions = "Cook it in pot";
        ingredientNames = new String[]{"Noodles", "Sauce"};
        ingredientWeights = new Double[]{5.2,23.6};
        ingredientCals = new Double[]{7.8,65.5};
    }

    @Test(expected = Exception.class)
    public void testAddRecipe() throws Exception {
        recipeName = "DeepFried Pizza";
        boolean isSuccess = AddRecipe.createRecipe(recipeName,directions,ingredientNames,ingredientWeights,ingredientCals);
        Assert.assertTrue("Add should of happened",isSuccess);

        recipeName = "burger";
        boolean isSuccessBad = AddRecipe.createRecipe(recipeName,directions,ingredientNames,ingredientWeights,ingredientCals);
    }


    @After
    public void tearDown() {
        this.tempDB.delete();
        Services.clean();
    }
}
