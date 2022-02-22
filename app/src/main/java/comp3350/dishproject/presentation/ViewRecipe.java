package comp3350.dishproject.presentation;

import static android.widget.AdapterView.*;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.ScrollView;
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
    TextView t2;
    ShowRecipe s;
    TextView t;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
        //you must pass a recipe from data class which has a list of recipes
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient i=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient i1=new Ingredient("Banana", "1", 1, 200.0,1.0);
        Ingredient i2=new Ingredient("Orange", "3", 3, 200.0,3.0);
        r.addIngredient(i);
        r.addIngredient(i1);
        r.addIngredient(i2);
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
        s= new ShowRecipe(r);
        showRecipeDetaills();
        getRatingInput();
        setDropDownMenu(r);

    }
//    {
//        Dataview=new dta();
//        view
//    }
    public void showRecipeDetaills(){


         t= (TextView) findViewById(R.id.ing_list);
        TextView t1= (TextView) findViewById(R.id.des_title);
        rating=(RatingBar) findViewById(R.id.ratingBar2);
         t2= (TextView) findViewById(R.id.des_text);
        TextView t3= (TextView) findViewById(R.id.direction_text);
        //t.setText(s.showIngredient());
        t2.setText(s.showTitleDescription()+"Rating: "+rate);
        t3.setText(s.showDirection());
        t1.setText(s.showTitle());
    }

    public void getRatingInput(){
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rate=ratingBar.getRating();
                t2.setText(s.showTitleDescription()+"Rating: "+rate);
            }
        });
    }

    public void setDropDownMenu(Recipe r){
        Spinner dropdown = findViewById(R.id.spinner);
//create a list of items for the spinner.
        String [] items = new String[]{"1","2","3","4","5","6"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                int num= Integer.parseInt(String.valueOf(item));
                updateIngredient(num);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void updateIngredient(int num){
        t.setText(s.updateIngredients(num));
    }
}