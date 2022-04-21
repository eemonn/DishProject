package comp3350.dishproject.tests.objects;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;

public class IngredientTest {


    private Recipe r;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        r = new Recipe("Fruit", "100",5,false, "How do you cook a fruit");
        ingredient=new Ingredient("Apple",  1, 200.0,180.0,r.getRecipeID());
    }

    @Test
    public void testConstructor(){
        Assert.assertNotNull("Object should not be null",ingredient);
    }

    @Test
    public void testGetCalorie(){
        assertEquals(180.0, ingredient.getCalorie(), 0.0);
        assert(ingredient.getCalorie()!=18.0);
    }

    @Test
    public void testSetCalorie(){
        assertEquals(180.0, ingredient.getCalorie(), 0.0);
        ingredient.setCalorie(150.0);
        assertEquals(150.0, ingredient.getCalorie(), 0.0);

    }
    @Test
    public void testGetWeight(){
        assertEquals(200.0, ingredient.getWeight(), 0.0);
        assert(ingredient.getWeight()!=18.0);
    }
    @Test
    public void testSetWeight(){
        assertEquals(200.0, ingredient.getWeight(), 0.0);
        ingredient.setWeight(150.0);
        assertEquals(150.0, ingredient.getWeight(), 0.0);
    }
    @Test
    public void testGetQuantity(){
        assertEquals(1, ingredient.getQuantity(), 0.0);
        assert(ingredient.getQuantity()!=18);
    }
    @Test
    public void testSetQuantity(){
        assertEquals(1, ingredient.getQuantity(), 0.0);
        ingredient.setQuantity(13);
        assertEquals(13, ingredient.getQuantity(), 0.0);
    }

    @Test
    public void testGetName(){
        assert(ingredient.getName().equals("Apple"));
    }
    @Test
    public void testSetName(){
        ingredient.setName("Banana");
        assert(!ingredient.getName().equals("2"));
        assert(ingredient.getName().equals("Banana"));
    }
    @Test
    public void testIsEqual(){
        assert(ingredient.isEqual(new Ingredient("Apple",1, 200.0,180.0,r.getRecipeID())));
        assert(ingredient.isEqual(new Ingredient("Apple",10, 203.0,180.0,r.getRecipeID())));
        assert(!ingredient.isEqual(new Ingredient("Banana",1, 200.0,180.0,r.getRecipeID())));
    }
    @Test
    public void testToString(){
        assert(ingredient.toString().equals("Ingredient{name='Apple', weight=200.0}"));
        assert(!ingredient.toString().equals("Ingredient{name='Banana', weight=200.0}"));
    }

    @Test
    public void testRecipeID() {
        Assert.assertEquals("Recipe Id must be 100",ingredient.getRecipeID(),"100");
    }

}
