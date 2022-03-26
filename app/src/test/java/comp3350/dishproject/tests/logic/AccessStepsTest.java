package comp3350.dishproject.tests.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import comp3350.dishproject.logic.AccessRecipes;
import comp3350.dishproject.logic.AccessSteps;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.RecipePersistence;
import comp3350.dishproject.persistence.StepsPersistence;
import comp3350.dishproject.persistence.stubs.RecipePersistenceStub;
import comp3350.dishproject.persistence.stubs.StepsPersistenceStub;

public class AccessStepsTest {
    private StepsPersistence stepsPersistence;
    private RecipePersistence recipePersistence;
    private AccessSteps as;
    private AccessRecipes ar;


    @Before
    public void setUp() {
        stepsPersistence = new StepsPersistenceStub();
        recipePersistence = new RecipePersistenceStub();
        as = new AccessSteps(stepsPersistence);
        ar = new AccessRecipes(recipePersistence);
    }

    @Test
    public void testConstructor() {
        Assert.assertNotNull("Should not be null",as);
        Assert.assertNotNull("Should not be null",ar);
    }

    @Test
    public void testGetDirections() {
        String recipeID = "100";//Burger in the system
        String directions = as.getDirections(recipeID);
        Assert.assertTrue("Length greater than 0", directions.length() >= 1);
        Assert.assertNotEquals("Not No directions", "No Directions", directions);
    }

    @Test
    public void testBadGetDirections() {
        String badRecipeID = "1242355";//not in the system
        String badDirections = as.getDirections(badRecipeID);
        Assert.assertEquals("No directions found","No Directions",badDirections);
    }

    @Test
    public void testUpdateDirections() {
        String recipeID = "100";//Burger in the system
        as.updateDirections(recipeID,"Boil the meat(eww)");
        Assert.assertEquals("directions should be updated","Boil the meat(eww)",as.getDirections(recipeID));
    }

    @Test
    public void testInsertSteps(){
        Recipe recipe = new Recipe("Pasta","1234",3);
        String d1 = "Boil the noodles in water";
        boolean isAdded = as.insertSteps(d1,recipe);
        Assert.assertTrue("add should be true(meaning good add)",isAdded);
    }

}
