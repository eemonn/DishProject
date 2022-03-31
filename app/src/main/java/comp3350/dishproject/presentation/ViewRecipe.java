package comp3350.dishproject.presentation;

import static android.widget.AdapterView.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import comp3350.dishproject.R;
import comp3350.dishproject.logic.AccessRecipes;
import comp3350.dishproject.logic.AccessSteps;
import comp3350.dishproject.logic.ShowRecipe;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.objects.Steps;

public class ViewRecipe extends AppCompatActivity {
    private RatingBar rating;
    private TextView ratingText;
    private ShowRecipe showRecipe;
    ListView listViewData;
    ArrayAdapter<String> adapter;
    private Recipe recipe;
    private Steps step;
    AccessRecipes ar = new AccessRecipes();
    AccessSteps as = new AccessSteps();


    //Android Specific Creator
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);

        //getting passed in value
        Bundle extras = getIntent().getExtras();
        String dish = "";

        //Setting up the recipe object for which the page is being seen
        if(extras !=null) {
            dish = getIntent().getStringExtra("search");
            String recipeID = ar.findRecipeID(dish);
            recipe = ar.getRecipe(recipeID);
            step = new Steps(as.getDirections(recipeID),recipe.getRecipeID());
            showRecipe = new ShowRecipe(recipe);
        }

        //Inits
        changePicture(dish);
        showRecipeDetails();
        getRatingInput();
        setDropDownMenu();
        updateListViewer();
    }

    //Android Specific Creator
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    //Android Specific Creator
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id=item.getItemId();
        if(id==R.id.item_done){
            String itemSelected="Added to your cart: \n";
            for(int i=0;i<listViewData.getCount();i++){
                if(listViewData.isItemChecked(i)){
                    itemSelected+=listViewData.getItemAtPosition(i)+"\n";
                }
            }
            Toast.makeText(this,itemSelected,Toast.LENGTH_LONG).show();
            System.out.println(itemSelected);
        }
        return super.onOptionsItemSelected(item);
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
        image.setImageResource(resID);
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
        ratingText = (TextView) findViewById(R.id.des_text);
        TextView directionText = (TextView) findViewById(R.id.direction_text);
        ratingText.setText(showRecipe.showTitleDescription());
        directionText.setText(step.toString());
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
                ratingText.setText(showRecipe.showTitleDescription());

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
        showRecipe.updateIngredients(num);
    }

    /*
    Input: no input
    Output: void function
    Description: Update list viewer
     */
    public void updateListViewer(){
        String [] arrayOfIngredients =showRecipe.getIngredientListName().clone();
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