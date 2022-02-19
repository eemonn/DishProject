package comp3350.dishproject.tests.objects;
import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;


public class RecipeTest {
//    private static final ArrayList<Ingredient>list=new ArrayList<Ingredient>();
//    private static Ingredient i1,i2,i3;
//    private static Recipe recipe;
//    @BeforeClass
//    public static void beforeClass(){
//        Ingredient i1=new Ingredient("Orange", "1", 1, 250.0,30.0);
//        Ingredient i2=new Ingredient("Banana", "2", 2, 200.0,60.0);
//        Ingredient i3=new Ingredient("Kiwi", "3", 3, 500.0,25.0);
//        recipe=new Recipe("Fruit salad","1", 600.0,450, new ArrayList<Ingredient>());
//        recipe.addIngredient(i2);
//        recipe.addIngredient(i2);
//        recipe.addIngredient(i3);
//        //System.out.println(recipe.getIngredientArrayList());
////        list=new ArrayList<Ingredient>();
////        list.add(i1);
////        list.add(i2);
////        list.add(i3);
//    }
    @Test
    public void testHasIngredient(){
        //Recipe r=new Recipe("Fruit salad","1", 600.0,450, new ArrayList<Ingredient>());
        //System.out.println(recipe.hasIngredient(i3));
        //r.hasIngredient(i1);
        //assert(r.hasIngredient(i2));
    }
    @Test
    public void testConstructor(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assertNotNull(r!=null);
        assert(r.getRating()==0);
        assert(r.getDirection().equals(""));
    }
    @Test
    public void testGetCalorie(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assertEquals(600.0, r.getCalorie(), 0.0);
        assert(r.getCalorie()!=18.0);
    }
    @Test
    public void testSetCalorie(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assertEquals(600.0, r.getCalorie(), 0.0);
        r.setCalorie(150.0);
        assertEquals(150.0, r.getCalorie(), 0.0);

    }
    @Test
    public void testGetWeight(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assertEquals(450.0, r.getWeight(), 0.0);
        assert(r.getWeight()!=18.0);
    }
    @Test
    public void testSetWeight(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assertEquals(450.0, r.getWeight(), 0.0);
        r.setWeight(150.0);
        assertEquals(150.0, r.getWeight(), 0.0);
    }
    @Test
    public void testGetDirection(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assert(r.getDirection().equals(""));
    }
    @Test
    public void testSetDirection(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        r.setDirectionMethod("do this then that etc");
        assert(r.getDirection().equals("do this then that etc"));

    }
    @Test
    public void testGetId(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assert(r.getId().equals("1"));
    }
    @Test
    public void testSetId(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        r.setId("22");
        assert(!r.getId().equals("1"));
        assert(r.getId().equals("22"));
    }
    @Test
    public void testGetRating(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assert(r.getRating()==0);
    }
    @Test
    public void testSetRating(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        r.setRating(4);
        assert(r.getRating()!=0);
        assert(r.getRating()==4);
    }
    @Test
    public void testGetName(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assert(r.getName().equals("Pizza"));
    }
    @Test
    public void testSetName(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        r.setName("Burger");
        assert(!r.getName().equals("Pizza"));
        assert(r.getName().equals("Burger"));
    }
}
