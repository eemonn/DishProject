package comp3350.dishproject.presentation;

import static android.widget.AdapterView.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350.dishproject.R;
import comp3350.dishproject.logic.ShowRecipe;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;

public class ViewRecipe extends AppCompatActivity {
    RatingBar rating;
    float rate;
    TextView ratingText;
    ShowRecipe showRecipe;
    TextView ingredientListText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
        //you must pass a recipe from data class which has a list of recipes
        Recipe recipe = new Recipe("Bobby's Burger", "1", 600.0, 450, new ArrayList<Ingredient>());
        Ingredient i = new Ingredient("Apple", "2", 2, 200.0, 2.0);
        Ingredient i1 = new Ingredient("Banana", "1", 1, 100.0, 1.0);
        Ingredient i2 = new Ingredient("Orange", "3", 3, 300.0, 3.0);
        recipe.addIngredient(i);
        recipe.addIngredient(i1);
        recipe.addIngredient(i2);
        String ss = "Step 1\n" +
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
        showRecipe = new ShowRecipe(recipe);
        showRecipeDetaills();
        getRatingInput();
        setDropDownMenu(recipe);

    }

    /*
    Show the details of the recipe such as ingredient list, direction, title
     */
    public void showRecipeDetaills() {
        ingredientListText = (TextView) findViewById(R.id.ing_list);
        TextView descriptionTextbox = (TextView) findViewById(R.id.des_title);
        rating = (RatingBar) findViewById(R.id.ratingBar2);
        ratingText = (TextView) findViewById(R.id.des_text);
        TextView directionText = (TextView) findViewById(R.id.direction_text);
        //t.setText(s.showIngredient());
        ratingText.setText(showRecipe.showTitleDescription() + "Rating: " + rate);
        directionText.setText(showRecipe.showDirection());
        descriptionTextbox.setText(showRecipe.showTitle());
    }

    /*
    Give user the option to rate the dish
     */
    public void getRatingInput() {
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rate = ratingBar.getRating();
                ratingText.setText(showRecipe.showTitleDescription() + "Rating: " + rate);
                showRecipe.getRec().setRating((int) rate);
            }
        });
    }

    /*
    provide user with a drop down menu to choose the serving size
     */
    public void setDropDownMenu(Recipe r) {
        Spinner dropdown = findViewById(R.id.spinner);
        //create a list of items for the spinner.
        String[] items = new String[]{"1", "2", "3", "4", "5", "6"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                int num = Integer.parseInt(String.valueOf(item));
                updateIngredient(num);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    /*
    update the quantity of ingredients as the user selects
     */
    public void updateIngredient(int num) {
        ingredientListText.setText(showRecipe.updateIngredients(num));

    }
}