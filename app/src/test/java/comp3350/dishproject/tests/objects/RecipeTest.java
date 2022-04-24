package comp3350.dishproject.tests.objects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;


public class RecipeTest {
    private Recipe recipe;
    private Ingredient i1;
    private Ingredient i2;
    private Ingredient i3;
    private List<Ingredient> li;


    @Before
    public void setUp() {
        recipe=new Recipe("Pizza",1025,5,false,"Sauce and Cheese on dough and cook");
        i1 = new Ingredient("Cheese",1,20,50,recipe.getRecipeID());
        i2 = new Ingredient("Dough",1,20,50,recipe.getRecipeID());
        i3 = new Ingredient("Sauce",1,20,50,recipe.getRecipeID());
        li = new ArrayList<>();
        li.add(i1);
        li.add(i2);
        li.add(i3);


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
        Assert.assertEquals("Recipe ID should be 1025",1025,recipe.getRecipeID());
    }

    @Test
    public void testSetId(){
        recipe.setRecipeID(2256);
        Assert.assertEquals("Recipe ID should now be 2256", 2256, recipe.getRecipeID());
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

    @Test
    public void testGetDirections() {
        Assert.assertEquals("Directions should be the same", "Sauce and Cheese on dough and cook", recipe.getSteps());
    }

    @Test
    public void testSetDirections() {
        recipe.setSteps("Now boil it");
        Assert.assertEquals("Directions should now be now boil it","Now boil it", recipe.getSteps());
    }

    @Test
    public void testUpdateIngredients() {
        recipe.updateIngredients(3,li);
        Assert.assertEquals("Weight of Ingredient should be 3x20=60", 60, i1.getWeight(), 0.01);
        Assert.assertEquals("Calorie of Ingredient should be 3x50=150", 150, i1.getCalorie(), 0.01);
        Assert.assertEquals("Quantity of Ingredient should be 3x1=3", 3, i1.getQuantity(), 0.01);
        recipe.updateIngredients(5,li);
        Assert.assertEquals("Weight of Ingredient should be 5x20=100", 100, i1.getWeight(), 0.01);
        Assert.assertEquals("Calorie of Ingredient should be 5x50=250", 250, i1.getCalorie(), 0.01);
        Assert.assertEquals("Quantity of Ingredient should be 5x1=5", 5, i1.getQuantity(), 0.01);
    }

    @Test
    public void testShowTitleDescription() {
        String title = "";
        double totalCalories = 50*3;
        double totalWeight = 20*3;
        title += "Calorie: " + totalCalories + "kcal "+ " Weight: " +  totalWeight + "g " + "Rating: " + recipe.getRating() + "\n";
        Assert.assertEquals("Titles should be the same",title,recipe.showTitleDescription(li));
    }

    @Test
    public void testCalculateCalories() {
        double totalCalories = 50*3;
        Assert.assertEquals("Total calories of all ingredients should be the same",totalCalories,recipe.calculateCalories(li),0.01);
    }

    @Test
    public void testCalculateWeight() {
        double totalWeight = 20*3;
        Assert.assertEquals("Total weight of all ingredients should be the same",totalWeight,recipe.calculateWeight(li),0.01);
    }

    @Test
    public void testGetIngredientListName() {
        Assert.assertEquals("Lengths(number of ingredients) should be the same",li.size(),recipe.getIngredientListName(li).length);
    }


}
