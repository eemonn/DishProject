package comp3350.dishproject.tests.objects;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.dishproject.objects.Ingredient;

public class IngredientTest {
    @Test
    public void testConstructor(){
        Ingredient i=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assertNotNull(i!=null);
    }
    @Test
    public void testGetCalorie(){
        Ingredient i=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assertEquals(180.0, i.getCalorie(), 0.0);
        assert(i.getCalorie()!=18.0);
    }
    @Test
    public void testSetCalorie(){
        Ingredient i=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assertEquals(180.0, i.getCalorie(), 0.0);
        i.setCalorie(150.0);
        assertEquals(150.0, i.getCalorie(), 0.0);

    }
    @Test
    public void testGetWeight(){
        Ingredient i=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assertEquals(200.0, i.getWeight(), 0.0);
        assert(i.getWeight()!=18.0);
    }
    @Test
    public void testSetWeight(){
        Ingredient i=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assertEquals(200.0, i.getWeight(), 0.0);
        i.setWeight(150.0);
        assertEquals(150.0, i.getWeight(), 0.0);
    }
    @Test
    public void testGetQuantity(){
        Ingredient i=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assertEquals(1, i.getQuantity(), 0.0);
        assert(i.getQuantity()!=18);
    }
    @Test
    public void testSetQuantity(){
        Ingredient i=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assertEquals(1, i.getQuantity(), 0.0);
        i.setQuantity(13);
        assertEquals(13, i.getQuantity(), 0.0);
    }
    @Test
    public void testIncrementQuantity(){
        Ingredient i=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assertEquals(1, i.getQuantity(), 0.0);
        i.incrementQuantity(4);
        assertEquals(5, i.getQuantity(), 0.0);
        i.incrementQuantity(-2);
        assertEquals(3, i.getQuantity(), 0.0);
    }
    @Test
    public void testGetId(){
        Ingredient i=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assert(i.getId().equals("2"));
    }
    @Test
    public void testSetId(){
        Ingredient i=new Ingredient("Apple", "2", 1, 200.0,180.0);
        i.setId("22");
        assert(!i.getId().equals("2"));
        assert(i.getId().equals("22"));
    }
    @Test
    public void testGetName(){
        Ingredient i=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assert(i.getName().equals("Apple"));
    }
    @Test
    public void testSetName(){
        Ingredient i=new Ingredient("Apple", "2", 1, 200.0,180.0);
        i.setName("Banana");
        assert(!i.getName().equals("2"));
        assert(i.getName().equals("Banana"));
    }
    @Test
    public void testIsEqual(){
        Ingredient i=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assert(i.isEqual(new Ingredient("Apple","2",1, 200.0,180.0)));
        assert(i.isEqual(new Ingredient("Apple","2",10, 203.0,180.0)));
        assert(!i.isEqual(new Ingredient("Banana","2",1, 200.0,180.0)));
    }
    @Test
    public void testToString(){
        Ingredient i=new Ingredient("Apple", "2", 1, 200.0,180.0);
        assert(i.toString().equals("Ingredient{name='Apple', id='2', quantity=1, weight=200.0}"));
        assert(!i.toString().equals("Ingredient{name='Banana', id='2', quantity=1, weight=200.0}"));

    }
}
