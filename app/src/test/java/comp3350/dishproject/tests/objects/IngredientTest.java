package comp3350.dishproject.tests.objects;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.dishproject.objects.Ingredient;

public class IngredientTest {
    /*
    @Test
    public void testConstructor(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assert(ingredient!=null);
    }
    @Test
    public void testGetOriginalCount() {
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        ingredient.setQuantity(2);
        assert(ingredient.getOriginalCount()==1);
    }
    @Test
    public void testGetOriginalCalorie() {
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        ingredient.setCalorie(200.0);
        assert(ingredient.getOriginalCalorie()==180.0);
    }
    @Test
    public void testGetOriginalWeight() {
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        ingredient.setWeight(2000.0);
        assert(ingredient.getOriginalWeight()==200.0);
    }
    @Test
    public void testGetCalorie(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assertEquals(180.0, ingredient.getCalorie(), 0.0);
        assert(ingredient.getCalorie()!=18.0);
    }
    @Test
    public void testSetCalorie(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assertEquals(180.0, ingredient.getCalorie(), 0.0);
        ingredient.setCalorie(150.0);
        assertEquals(150.0, ingredient.getCalorie(), 0.0);

    }
    @Test
    public void testGetWeight(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assertEquals(200.0, ingredient.getWeight(), 0.0);
        assert(ingredient.getWeight()!=18.0);
    }
    @Test
    public void testSetWeight(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assertEquals(200.0, ingredient.getWeight(), 0.0);
        ingredient.setWeight(150.0);
        assertEquals(150.0, ingredient.getWeight(), 0.0);
    }
    @Test
    public void testGetQuantity(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assertEquals(1, ingredient.getQuantity(), 0.0);
        assert(ingredient.getQuantity()!=18);
    }
    @Test
    public void testSetQuantity(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assertEquals(1, ingredient.getQuantity(), 0.0);
        ingredient.setQuantity(13);
        assertEquals(13, ingredient.getQuantity(), 0.0);
    }
    @Test
    public void testIncrementQuantity(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assertEquals(1, ingredient.getQuantity(), 0.0);
        ingredient.incrementQuantity(4);
        assertEquals(5, ingredient.getQuantity(), 0.0);
        ingredient.incrementQuantity(-2);
        assertEquals(3, ingredient.getQuantity(), 0.0);
    }
    @Test
    public void testGetId(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assert(ingredient.getId().equals("2"));
    }
    @Test
    public void testSetId(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        ingredient.setId("22");
        assert(!ingredient.getId().equals("2"));
        assert(ingredient.getId().equals("22"));
    }
    @Test
    public void testGetName(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assert(ingredient.getName().equals("Apple"));
    }
    @Test
    public void testSetName(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        ingredient.setName("Banana");
        assert(!ingredient.getName().equals("2"));
        assert(ingredient.getName().equals("Banana"));
    }
    @Test
    public void testIsEqual(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assert(ingredient.isEqual(new Ingredient("Apple","2",1, 200.0,180.0)));
        assert(ingredient.isEqual(new Ingredient("Apple","2",10, 203.0,180.0)));
        assert(!ingredient.isEqual(new Ingredient("Banana","2",1, 200.0,180.0)));
    }
    @Test
    public void testToString(){
        Ingredient ingredient=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assert(ingredient.toString().equals("Ingredient{name='Apple', id='2', quantity=1, weight=200.0}"));
        assert(!ingredient.toString().equals("Ingredient{name='Banana', id='2', quantity=1, weight=200.0}"));

    }

     */
}
