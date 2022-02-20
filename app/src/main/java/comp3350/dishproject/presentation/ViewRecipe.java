package comp3350.dishproject.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350.dishproject.R;
import comp3350.dishproject.logic.ShowRecipe;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;

public class ViewRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
        showIngredient();
    }

    protected void showIngredient(){
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient i=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient i1=new Ingredient("Banana", "1", 1, 200.0,1.0);
        Ingredient i2=new Ingredient("Orange", "3", 3, 200.0,3.0);
        r.addIngredient(i);
        r.addIngredient(i1);
        TextView t= (TextView) findViewById(R.id.ing_list);
        TextView t2= (TextView) findViewById(R.id.des_text);
        ShowRecipe s= new ShowRecipe(r);
        s.showIngredient(t);
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
        s.showDescription(t2,ss);
    }
}