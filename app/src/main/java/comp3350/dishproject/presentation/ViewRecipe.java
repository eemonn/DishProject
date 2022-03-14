package comp3350.dishproject.presentation;

import static android.widget.AdapterView.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import comp3350.dishproject.R;
import comp3350.dishproject.logic.AccessRecipes;
import comp3350.dishproject.logic.AccessSteps;
import comp3350.dishproject.logic.ShowRecipe;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.objects.Steps;

public class ViewRecipe extends AppCompatActivity {
    private RatingBar rating;
    private float rate;
    private TextView ratingText;
    private ShowRecipe showRecipe;
    private TextView ingredientListText;
    private Recipe recipe;

    //Android Specific Creator
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);

        AccessRecipes db = new AccessRecipes();
        AccessSteps db1 = new AccessSteps();

        Bundle extras = getIntent().getExtras();
        String dish = "";
        if(extras !=null) {
            dish = getIntent().getStringExtra("search");
        }

        String recipeID = db.findRecipeID(dish);
        recipe = db.getRecipe(recipeID);
        Steps step = new Steps(db1.getDirections(recipeID),recipe);
        showRecipe = new ShowRecipe(recipe,step);
        changePicture(dish);
        showRecipeDetaills();
        getRatingInput();
        setDropDownMenu();
    }


    public void changePicture(String dish) {
        String dishPicture = dish.toLowerCase();
        TypedValue value = new TypedValue();
        int resID = getResources().getIdentifier(dishPicture, "drawable", getPackageName());
        Log.d("TAG", "changePicture: " + resID);
        ImageView image = (ImageView) findViewById(R.id.imageView7);
        image.setImageResource(resID);

    }

    /*
    Input: No input
    Output: void
    Description: Show the details of the recipe such as ingredient list, direction, title
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
    Input: No input
    Output: void
    Description:Give user the option to rate the dish
     */
    public void getRatingInput() {
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rate = ratingBar.getRating();
                ratingText.setText(showRecipe.showTitleDescription() + "Rating: " + rate);
            }
        });
    }

    /*
    Input: No Input
    Output: void
    Description: Provide user with a drop down menu to choose the serving size
     */
    public void setDropDownMenu() {
        Spinner dropdown = findViewById(R.id.spinner);
        //create a list of items for the spinner.
        String[] items = new String[]{"1", "2", "3", "4", "5", "6"};
        //create an adapter to describe how the items are displayed, adapters are used in several
        // places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout
                .simple_spinner_dropdown_item, items);
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
    Input: no input
    Output: void function
    Description: Update the quantity of ingredients as the user selects
     */
    public void updateIngredient(int num) {
        ingredientListText.setText(showRecipe.updateIngredients(num));
    }
}