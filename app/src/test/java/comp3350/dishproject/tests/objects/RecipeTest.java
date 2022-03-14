package comp3350.dishproject.tests.objects;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;


public class RecipeTest {
    /*
    @Test
    public void testHasIngredient(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient apple=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient banana=new Ingredient("Banana", "1", 1, 200.0,1.0);
        Ingredient orange=new Ingredient("Orange", "3", 3, 200.0,3.0);
        System.out.println("Calorie "+recipe.getCalorie());
        assert(recipe.getCalorie()==600.0);
        recipe.addIngredient(apple);
        recipe.addIngredient(banana);

        recipe.addIngredient(orange);
        assert(recipe.getCalorie()==614.0);
        assertTrue(recipe.hasIngredient(orange));
        assert(recipe.getIngredientArrayList().get(2).getQuantity()==3);
        recipe.addIngredient(orange);
        assert(recipe.getCalorie()==623.0);
        assert(recipe.getIngredientArrayList().get(2).getQuantity()==6);
        assert(recipe.getIngredientArrayList().size()==3);

    }
    @Test
    public void testSetArrayList(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient apple =new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient banana=new Ingredient("Banana", "1", 1, 200.0,1.0);
        Ingredient orange=new Ingredient("Orange", "3", 3, 200.0,3.0);
        System.out.println("Calorie "+recipe.getCalorie());
        assert(recipe.getCalorie()==600.0);
        recipe.addIngredient(apple);
        recipe.addIngredient(banana);

        recipe.addIngredient(orange);
        assert(recipe.getCalorie()==614.0);
        assertTrue(recipe.hasIngredient(orange));
        assert(recipe.getIngredientArrayList().get(2).getQuantity()==3);
        recipe.addIngredient(orange);
        ArrayList<Ingredient>list=new ArrayList<Ingredient>();
        Ingredient kiwi=new Ingredient("kiwi", "2", 2, 200.0,2.0);
        Ingredient melon=new Ingredient("melon", "1", 1, 200.0,1.0);
        recipe.setIngredientArrayList(list);
        System.out.println("2");
        recipe.addIngredient(kiwi);
        assert(recipe.getCalorie()==627.0);
        assert(recipe.toString().equals("Recipe{name='Pizza', id='1', calorie=627.0, weight=627.0, ingredientArrayList=[Ingredient{name='kiwi', id='2', quantity=2, weight=200.0}]}"));
        recipe.addIngredient(melon);
        recipe.removeIngredientFromRecipe(kiwi);
        assert(recipe.getCalorie()==626.0);
        recipe.removeIngredientFromRecipe(kiwi);
        recipe.removeIngredientFromRecipe(melon);
        assert(recipe.getCalorie()==623.0);
        assert(recipe.toString().equals("Recipe{name='Pizza', id='1', calorie=623.0, weight=623.0, ingredientArrayList=[]}"));


    }
    @Test
    public void testIsEqual(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assert(recipe.isEquals(new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>())));
        assert(recipe.isEquals(new Recipe("Pizza","1", 600.0,420, new ArrayList<Ingredient>())));
        assert(!recipe.isEquals(new Recipe("Burger","1", 600.0,450, new ArrayList<Ingredient>())));

    }
    @Test
    public void testConstructor(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assertNotNull(recipe!=null);
        assert(recipe.getRating()==0);
        assert(recipe.getDirection().equals(""));
    }
    @Test
    public void testGetCalorie(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assertEquals(600.0, recipe.getCalorie(), 0.0);
        assert(recipe.getCalorie()!=18.0);
    }
    @Test
    public void testSetCalorie(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assertEquals(600.0, recipe.getCalorie(), 0.0);
        recipe.setCalorie(150.0);
        assertEquals(150.0, recipe.getCalorie(), 0.0);
    }
    @Test
    public void testGetWeight(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assertEquals(450.0, recipe.getWeight(), 0.0);
        assert(recipe.getWeight()!=18.0);
    }
    @Test
    public void testSetWeight(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assertEquals(450.0, recipe.getWeight(), 0.0);
        recipe.setWeight(150.0);
        assertEquals(150.0, recipe.getWeight(), 0.0);
    }
    @Test
    public void testGetDirection(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assert(recipe.getDirection().equals(""));
    }
    @Test
    public void testSetDirection(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        recipe.setDirectionMethod("do this then that etc");
        assert(recipe.getDirection().equals("do this then that etc"));

    }
    @Test
    public void testGetId(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assert(recipe.getId().equals("1"));
    }
    @Test
    public void testSetId(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        recipe.setId("22");
        assert(!recipe.getId().equals("1"));
        assert(recipe.getId().equals("22"));
    }
    @Test
    public void testGetRating(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assert(recipe.getRating()==0);
    }
    @Test
    public void testSetRating(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        recipe.setRating((float) 4.5);
        assert(recipe.getRating()!=0);
        assert(recipe.getRating()==4.5);
    }
    @Test
    public void testGetName(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        assert(recipe.getName().equals("Pizza"));
    }
    @Test
    public void testUpdateIngredientList(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient apple=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient banana=new Ingredient("Banana", "1", 1, 100.0,1.0);
        Ingredient orange=new Ingredient("Orange", "3", 3, 300.0,3.0);
        recipe.addIngredient(apple);
        recipe.addIngredient(banana);
        recipe.addIngredient(orange);
        recipe.updateIngredientList(2);
        assert(recipe.getIngredientArrayList().get(0).getQuantity()==4);
        assert(recipe.getIngredientArrayList().get(1).getQuantity()==2);
        assert(recipe.getIngredientArrayList().get(2).getQuantity()==6);
        assert(recipe.getIngredientArrayList().get(0).getCalorie()==4.0);
        assert(recipe.getIngredientArrayList().get(1).getCalorie()==2.0);
        assert(recipe.getIngredientArrayList().get(2).getCalorie()==6.0);
        assert(recipe.getIngredientArrayList().get(0).getWeight()==400.0);
        assert(recipe.getIngredientArrayList().get(1).getWeight()==200.0);
        assert(recipe.getIngredientArrayList().get(2).getWeight()==600.0);
    }
    @Test
    public void testSetName(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        recipe.setName("Burger");
        assert(!recipe.getName().equals("Pizza"));
        assert(recipe.getName().equals("Burger"));
    }

     */
}
