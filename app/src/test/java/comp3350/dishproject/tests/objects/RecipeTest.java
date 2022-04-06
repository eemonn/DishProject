package comp3350.dishproject.tests.objects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import comp3350.dishproject.objects.Recipe;


public class RecipeTest {
    private Recipe recipe;

    @Before
    public void setUp() {
        recipe=new Recipe("Pizza","1025",5,false);

    }


    @Test
    public void testConstructor(){
        Assert.assertNotNull("Object should not be null",recipe);
    }

    @Test
    public void testGetRating(){
        Assert.assertEquals("Rating should be 5",5,recipe.getRating(),0.01);
    }

    @Test
    public void testGetId(){
        Assert.assertEquals("Recipe ID should be 1025","1025",recipe.getRecipeID());
    }

    @Test
    public void testSetId(){
        recipe.setRecipeID("2256");
        Assert.assertEquals("Recipe ID should now be 2256", "2256", recipe.getRecipeID());
    }

    @Test
    public void testSetRating(){
        recipe.setRating((float) 4.5);
        Assert.assertEquals("Rating should now be 4.5",4.5,recipe.getRating(),0.01);
    }
    @Test
    public void testGetName(){
        Assert.assertEquals("Name should be Pizza","Pizza",recipe.getName());
    }
    @Test
    public void testSetName(){
        recipe.setName("Burger");
        Assert.assertEquals("Recipe Name should be Burger now", "Burger", recipe.getName());
    }
}
