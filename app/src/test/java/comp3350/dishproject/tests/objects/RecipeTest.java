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
//    private static ArrayList<Ingredient>list=new ArrayList<Ingredient>();
//    private static Ingredient i1,i2,i3;
//    private static Recipe recipe;
    //@BeforeClass
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
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient i=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient i1=new Ingredient("Banana", "1", 1, 200.0,1.0);
        Ingredient i2=new Ingredient("Orange", "3", 3, 200.0,3.0);
        System.out.println("Calorie "+r.getCalorie());
        assert(r.getCalorie()==600.0);
        r.addIngredient(i);
        r.addIngredient(i1);

        r.addIngredient(i2);
        assert(r.getCalorie()==614.0);
        assertTrue(r.hasIngredient(i2));
        assert(r.getIngredientArrayList().get(2).getQuantity()==3);
        r.addIngredient(i2);
        assert(r.getCalorie()==623.0);
        assert(r.getIngredientArrayList().get(2).getQuantity()==6);
        assert(r.getIngredientArrayList().size()==3);

    }
    @Test
    public void testSetArrayList(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient i=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient i1=new Ingredient("Banana", "1", 1, 200.0,1.0);
        Ingredient i2=new Ingredient("Orange", "3", 3, 200.0,3.0);
        System.out.println("Calorie "+r.getCalorie());
        assert(r.getCalorie()==600.0);
        r.addIngredient(i);
        r.addIngredient(i1);

        r.addIngredient(i2);
        assert(r.getCalorie()==614.0);
        assertTrue(r.hasIngredient(i2));
        assert(r.getIngredientArrayList().get(2).getQuantity()==3);
        r.addIngredient(i2);
        ArrayList<Ingredient>list=new ArrayList<Ingredient>();
        Ingredient i3=new Ingredient("kiwi", "2", 2, 200.0,2.0);
        Ingredient i4=new Ingredient("melon", "1", 1, 200.0,1.0);
        r.setIngredientArrayList(list);
        System.out.println("2");
        r.addIngredient(i3);
        assert(r.getCalorie()==627.0);
        assert(r.toString().equals("Recipe{name='Pizza', id='1', calorie=627.0, weight=627.0, ingredientArrayList=[Ingredient{name='kiwi', id='2', quantity=2, weight=200.0}]}"));
        r.addIngredient(i4);
        r.removeIngredientFromRecipe(i3);
        assert(r.getCalorie()==626.0);
        r.removeIngredientFromRecipe(i3);
        r.removeIngredientFromRecipe(i4);
        assert(r.getCalorie()==623.0);
        assert(r.toString().equals("Recipe{name='Pizza', id='1', calorie=623.0, weight=623.0, ingredientArrayList=[]}"));


    }
    @Test
    public void testIsEqual(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assert(r.isEquals(new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>())));
        assert(r.isEquals(new Recipe("Pizza","1", 600.0,420, new ArrayList<Ingredient>())));
        assert(!r.isEquals(new Recipe("Burger","1", 600.0,450, new ArrayList<Ingredient>())));

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
