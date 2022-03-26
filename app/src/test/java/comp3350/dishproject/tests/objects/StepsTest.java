package comp3350.dishproject.tests.objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.objects.Steps;


public class StepsTest {

    private Recipe r;
    private String directions;
    private Steps s;

    @Before
    public void setUp() {
         r = new Recipe("Pizza","100",5);
         directions = "Cook the dish";
         s = new Steps(directions,r.getRecipeID());
    }

    @Test
    public void testConstructor() {
        Assert.assertNotNull("Object should not be null",s);
    }

    @Test
    public void testGetDirections() {
        Assert.assertEquals("Directions should be the same", directions, s.getDirections());
    }

    @Test
    public void testGetRecipeID() {
        Assert.assertEquals("Recipe ID should be 100", "100", s.getRecipeID());
    }

    @Test
    public void testSetDirections() {
        s.setDirections("Now boil it");
        Assert.assertEquals("Directions should now be now boil it","Now boil it", s.getDirections());
    }

}
