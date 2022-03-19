package comp3350.dishproject.tests.logic;

import junit.framework.TestCase;

import java.util.ArrayList;

import org.junit.Test;

import comp3350.dishproject.logic.ShowRecipe;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;

public class ShowRecipeTest extends TestCase {
/*
    @Test
    public void testShowIngredient() {
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient ingredient=new Ingredient("Apple", "2", 2, 200.0,2.0);
        recipe.addIngredient(ingredient);
        ShowRecipe showRecipe=new ShowRecipe(recipe);
        assert(showRecipe.showIngredient().equals("1. Apple  Amount: 2  Calorie: 2.0cal  Weight: 200.0g\n"));
    }
    @Test
    public void testShowTitle() {
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient apple=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient banana=new Ingredient("Banana", "1", 1, 200.0,1.0);
        Ingredient orange=new Ingredient("Orange", "3", 3, 200.0,3.0);
        recipe.addIngredient(apple);
        recipe.addIngredient(banana);
        recipe.addIngredient(orange);
        ShowRecipe showRecipe=new ShowRecipe(recipe);
        assert(showRecipe.showTitle().equals("Pizza"));
    }
    @Test
    public void testShowTitleDescription() {
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient apple=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient banana=new Ingredient("Banana", "1", 1, 200.0,1.0);
        Ingredient orange=new Ingredient("Orange", "3", 3, 200.0,3.0);
        recipe.addIngredient(apple);
        recipe.addIngredient(banana);
        recipe.addIngredient(orange);
        ShowRecipe showRecipe=new ShowRecipe(recipe);
        assert(showRecipe.showTitleDescription().equals("Calorie: "+showRecipe.getRec().getCalorie()+"cal Weight: "+showRecipe.getRec().getWeight()+"g\n"));
    }
    @Test
    public void testUpdateIngredients(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient apple=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient banana=new Ingredient("Banana", "1", 1, 100.0,1.0);
        Ingredient orange=new Ingredient("Orange", "3", 3, 300.0,3.0);
        recipe.addIngredient(apple);
        recipe.addIngredient(banana);
        recipe.addIngredient(orange);
        ShowRecipe showRecipe=new ShowRecipe(recipe);
        showRecipe.updateIngredients(2);
        assert(showRecipe.getRec().getIngredientArrayList().get(0).getQuantity()==4);
        assert(showRecipe.getRec().getIngredientArrayList().get(1).getQuantity()==2);
        assert(showRecipe.getRec().getIngredientArrayList().get(2).getQuantity()==6);
        assert(showRecipe.getRec().getIngredientArrayList().get(0).getCalorie()==4.0);
        assert(showRecipe.getRec().getIngredientArrayList().get(1).getCalorie()==2.0);
        assert(showRecipe.getRec().getIngredientArrayList().get(2).getCalorie()==6.0);
        assert(showRecipe.getRec().getIngredientArrayList().get(0).getWeight()==400.0);
        assert(showRecipe.getRec().getIngredientArrayList().get(1).getWeight()==200.0);
        assert(showRecipe.getRec().getIngredientArrayList().get(2).getWeight()==600.0);
    }
    @Test
    public void testGetRec(){
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        ShowRecipe showRecipe=new ShowRecipe(recipe);
        assert(showRecipe.getRec().isEquals(new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>())));
    }

    @Test
    public void testShowDirection() {
        Recipe recipe=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient apple=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient banana=new Ingredient("Banana", "1", 1, 200.0,1.0);
        Ingredient orange =new Ingredient("Orange", "3", 3, 200.0,3.0);
        String ss="Step 1\n" +
                "In a bowl, mix ground beef, egg, onion, bread crumbs, Worcestershire, garlic, 1/2 teaspoon salt, and 1/4 teaspoon pepper until well blended. Divide mixture into four equal portions and shape each into a patty about 4 inches wide.\n" +
                "\n" +
                "Step 2\n" +
                "Lay burgers on an oiled barbecue grill over a solid bed of hot coals or high heat on a gas grill (you can hold your hand at grill level only 2 to 3 seconds); close lid on gas grill. Cook burgers, turning once, until browned on both sides and no longer pink inside (cut to test), 7 to 8 minutes total. Remove from grill.\n" +
                "\n" +
                "Step 3\n" +
                "Lay buns, cut side down, on grill and cook until lightly toasted, 30 seconds to 1 minute.\n" +
                "\n" +
                "Step 4\n" +
                "Spread mayonnaise and ketchup on bun bottoms. Add lettuce, tomato, burger, onion, and salt and pepper to taste. Set bun tops in place.";
        recipe.setDirectionMethod(ss);
        recipe.addIngredient(apple);
        recipe.addIngredient(banana);
        recipe.addIngredient(orange);
        ShowRecipe showRecipe=new ShowRecipe(recipe);
        assert(showRecipe.showDirection().equals(recipe.getDirection()));

    }

 */
}