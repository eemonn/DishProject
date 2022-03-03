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
import comp3350.dishproject.persistence.DataAcess;

public class ViewRecipe extends AppCompatActivity {
    RatingBar rating;
    float rate;
    TextView ratingText;
    ShowRecipe showRecipe;
    TextView ingredientListText;
    Recipe recipe;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
        DataAcess db = new DataAcess();
        recipe = db.getRecipe();
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