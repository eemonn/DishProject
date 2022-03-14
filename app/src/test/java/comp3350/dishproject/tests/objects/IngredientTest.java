package comp3350.dishproject.tests.objects;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;

public class IngredientTest {

    private Recipe r = new Recipe("Fruit", "100");
    @Test
    public void testConstructor(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0,r);
        assert(ingredient!=null);
    }

    @Test
    public void testGetCalorie(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0,r);
        assertEquals(180.0, ingredient.getCalorie(), 0.0);
        assert(ingredient.getCalorie()!=18.0);
    }
    @Test
    public void testSetCalorie(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0,r);
        assertEquals(180.0, ingredient.getCalorie(), 0.0);
        ingredient.setCalorie(150.0);
        assertEquals(150.0, ingredient.getCalorie(), 0.0);

    }
    @Test
    public void testGetWeight(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0,r);
        assertEquals(200.0, ingredient.getWeight(), 0.0);
        assert(ingredient.getWeight()!=18.0);
    }
    @Test
    public void testSetWeight(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0,r);
        assertEquals(200.0, ingredient.getWeight(), 0.0);
        ingredient.setWeight(150.0);
        assertEquals(150.0, ingredient.getWeight(), 0.0);
    }
    @Test
    public void testGetQuantity(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0,r);
        assertEquals(1, ingredient.getQuantity(), 0.0);
        assert(ingredient.getQuantity()!=18);
    }
    @Test
    public void testSetQuantity(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0,r);
        assertEquals(1, ingredient.getQuantity(), 0.0);
        ingredient.setQuantity(13);
        assertEquals(13, ingredient.getQuantity(), 0.0);
    }

    @Test
    public void testGetId(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0,r);
        assert(ingredient.getID().equals("2"));
    }
    @Test
    public void testSetId(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0,r);
        ingredient.setId("22");
        assert(!ingredient.getID().equals("2"));
        assert(ingredient.getID().equals("22"));
    }
    @Test
    public void testGetName(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0,r);
        assert(ingredient.getName().equals("Apple"));
    }
    @Test
    public void testSetName(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0,r);
        ingredient.setName("Banana");
        assert(!ingredient.getName().equals("2"));
        assert(ingredient.getName().equals("Banana"));
    }
    @Test
    public void testIsEqual(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0,r);
        assert(ingredient.isEqual(new Ingredient("Apple","2",1, 200.0,180.0,r)));
        assert(ingredient.isEqual(new Ingredient("Apple","2",10, 203.0,180.0,r)));
        assert(!ingredient.isEqual(new Ingredient("Banana","2",1, 200.0,180.0,r)));
    }
    @Test
    public void testToString(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0,r);
        assert(ingredient.toString().equals("Ingredient{name='Apple', id='2', quantity=1, weight=200.0}"));
        assert(!ingredient.toString().equals("Ingredient{name='Banana', id='2', quantity=1, weight=200.0}"));

    }


}
