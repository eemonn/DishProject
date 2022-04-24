package comp3350.dishproject.presentation;

import static android.widget.AdapterView.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import comp3350.dishproject.R;
import comp3350.dishproject.logic.AccessIngredients;
import comp3350.dishproject.logic.AccessRecipes;
import comp3350.dishproject.logic.AccessShoppingCart;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;

public class ViewRecipe extends AppCompatActivity {
    private RatingBar rating;
    private Switch sw;
    private TextView ratingText;
    private ListView listViewData;
    private ArrayAdapter<String> adapter;
    private Recipe recipe;
    private AccessRecipes ar;
    private AccessIngredients ai;
    private AccessShoppingCart sc;
    private Toast t;
    private List<Ingredient> ingredientList;


    //Android Specific Creator
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);

        //getting passed in value
        Bundle extras = getIntent().getExtras();
        String dish = "";

        //Setting up logic layer access
        ar = new AccessRecipes();
        ai = new AccessIngredients();
        sc= new AccessShoppingCart();

        //Setting up the recipe object for which the page is being seen
        if(extras !=null) {
            dish = getIntent().getStringExtra("search");
            int recipeID = ar.findRecipeID(dish);
            recipe = ar.getRecipe(recipeID);
            ingredientList = ai.getIngredients(recipeID);
        }

        //Inits
        changePicture(dish);
        showRecipeDetails();
        getRatingInput();
        getFavInput();
        setDropDownMenu();
        updateListViewer();
    }

    //Android Specific Creator for menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    //Android Specific Creator for item checked on menuitem
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id=item.getItemId();
        if(id==R.id.item_done){
            String itemSelected="Added to your cart: \n";
            for(int i=0;i<listViewData.getCount();i++){
                if(listViewData.isItemChecked(i)){
                    String temp=(String) listViewData.getItemAtPosition(i);
                    itemSelected+=temp+"\n";
                    sc.addToList(makeIngredients(temp));
                }
            }
            makeToast(itemSelected);
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    Input: Takes in a string containing information about a given ingredient
    Output: returns an ingredient
    Description: private helper used for converting information form the UI to ingredients
   */
    private Ingredient makeIngredients(String s){
        Ingredient ingredient;
        String[] info = s.split("Am");
        String[] ingredientsInfo= info[1].split(" ");
        ingredient=new Ingredient(info[0],Integer.parseInt(ingredientsInfo[1]),Double.parseDouble(ingredientsInfo[5]),
                Double.parseDouble(ingredientsInfo[3]),0);
        return ingredient;

    }

    /*
    Input: Takes in a string to display
    Output: void function
    Description: Helper for displaying string message about adding to shopping cart
   */
    public void makeToast(String s){
        if(t!=null) t.cancel();
        t=Toast.makeText(this.getApplicationContext(),s,Toast.LENGTH_LONG);
        TextView tv=new TextView(this.getApplicationContext());
        tv.setBackgroundColor(Color.WHITE);
        tv.setPadding(10,10,10,10);
        tv.setTextSize(25);
        tv.setText(s);
        t.setView(tv);
        t.show();
    }


    /*
    Input: Takes in a name of a dish
    Output: void function
    Description: Changes the picture of the recipe, right now we only have pictures of our 5 most popular dishes
   */
    public void changePicture(String dish) {
        String dishPicture = dish.toLowerCase();
        int resID = getResources().getIdentifier(dishPicture, "drawable", getPackageName());
        ImageView image = (ImageView) findViewById(R.id.imageView7);
        if(resID !=0) {//meaing we have a picture
            image.setImageResource(resID);
        } else {
            image.setImageResource(R.drawable.cook);
        }
    }

    /*
    Input: No input
    Output: void
    Description: Show the details of the recipe such as ingredient list, direction, title
     */
    public void showRecipeDetails() {
        TextView descriptionTextbox = (TextView) findViewById(R.id.des_title);
        rating = (RatingBar) findViewById(R.id.ratingBar2);
        rating.setRating((float)recipe.getRating());
        sw = (Switch) findViewById(R.id.switch1);
        sw.setChecked(recipe.getFav());
        ratingText = (TextView) findViewById(R.id.des_text);
        TextView directionText = (TextView) findViewById(R.id.direction_text);
        ratingText.setText(recipe.showTitleDescription(ingredientList));
        directionText.setText(recipe.toString());
        descriptionTextbox.setText(recipe.getName());
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
                ar.changeRating(rating,recipe.getRecipeID());
                ratingText.setText(recipe.showTitleDescription(ingredientList));

            }
        });
    }
    /*
    Input: No input
    Output: void function
    Description: Sets the "favorite" boolean for a recipe
     */
    public void getFavInput(){
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ar.changeFav(isChecked,recipe.getRecipeID());
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
        String[] items = new String[]{"1", "2", "3", "4", "5", "6"};//this has to be hardcoded
        //create an adapter to describe how the items are displayed, adapters are used in several
        // places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout
                .simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter2);
        dropdown.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                int num = Integer.parseInt(String.valueOf(item));
                updateIngredient(num);
                updateListViewer();
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
        recipe.updateIngredients(num,ingredientList);
    }

    /*
    Input: no input
    Output: void function
    Description: Update list viewer
     */
    public void updateListViewer(){
        String [] arrayOfIngredients =recipe.getIngredientListName(ingredientList).clone();
        listViewData=findViewById(R.id.listView_data);
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,arrayOfIngredients){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
                return view;
            }
        };
        listViewData.setAdapter(adapter);
        updateHeightOfList(listViewData);
    }

    /*
    Input: no input
    Output: void function
    Description: Update height of shown list
     */
    public void updateHeightOfList(ListView listViewData){
        ListAdapter listadp = listViewData.getAdapter();
        if (listadp != null) {
            int totalHeight = 0;
            for (int i = 0; i < listadp.getCount(); i++) {
                View listItem = listadp.getView(i, null, listViewData);
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight() + (listItem.getMeasuredHeightAndState()/2);
            }
            ViewGroup.LayoutParams params = listViewData.getLayoutParams();
            params.height = totalHeight + (listViewData.getDividerHeight() * (listadp.getCount()-1));
            listViewData.setLayoutParams(params);
            listViewData.requestLayout();

        }
    }
}