package comp3350.dishproject.tests.logic;

import android.widget.TextView;

import junit.framework.TestCase;

import java.util.ArrayList;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import org.junit.Test;

import comp3350.dishproject.R;
import comp3350.dishproject.logic.ShowRecipe;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;

public class ShowRecipeTest extends TestCase {

    @Test
    public void testShowIngredient() {
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient i=new Ingredient("Apple", "2", 2, 200.0,2.0);
        //Ingredient i1=new Ingredient("Banana", "1", 1, 200.0,1.0);
        //Ingredient i2=new Ingredient("Orange", "3", 3, 200.0,3.0);
        r.addIngredient(i);
//        r.addIngredient(i1);
//        r.addIngredient(i2);

        ShowRecipe s=new ShowRecipe(r);
        assert(s.showIngredient().equals("1. Apple  Amount: 2  Calorie: 2.0cal  Weight: 200.0g\n"));
    }
    @Test
    public void testShowTitle() {
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient i=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient i1=new Ingredient("Banana", "1", 1, 200.0,1.0);
        Ingredient i2=new Ingredient("Orange", "3", 3, 200.0,3.0);
        r.addIngredient(i);
        r.addIngredient(i1);
        r.addIngredient(i2);
        ShowRecipe s=new ShowRecipe(r);
        assert(s.showTitle().equals(r.getName()));
    }

    public void testShowDescription() {
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient i=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient i1=new Ingredient("Banana", "1", 1, 200.0,1.0);
        Ingredient i2=new Ingredient("Orange", "3", 3, 200.0,3.0);
        r.addIngredient(i);
        r.addIngredient(i1);
        r.addIngredient(i2);
    }

    public void testShowTitleDescription() {
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient i=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient i1=new Ingredient("Banana", "1", 1, 200.0,1.0);
        Ingredient i2=new Ingredient("Orange", "3", 3, 200.0,3.0);
        r.addIngredient(i);
        r.addIngredient(i1);
        r.addIngredient(i2);
    }

    public void testShowRatingTitle() {
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient i=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient i1=new Ingredient("Banana", "1", 1, 200.0,1.0);
        Ingredient i2=new Ingredient("Orange", "3", 3, 200.0,3.0);
        r.addIngredient(i);
        r.addIngredient(i1);
        r.addIngredient(i2);
    }

    public void testShowDirection() {
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient i=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient i1=new Ingredient("Banana", "1", 1, 200.0,1.0);
        Ingredient i2=new Ingredient("Orange", "3", 3, 200.0,3.0);
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
        r.setDirectionMethod(ss);
        r.addIngredient(i);
        r.addIngredient(i1);
        r.addIngredient(i2);
        ShowRecipe s=new ShowRecipe(r);
        assert(s.showDirection().equals(r.getDirection()));

    }
}