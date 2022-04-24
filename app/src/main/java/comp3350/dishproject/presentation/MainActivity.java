package comp3350.dishproject.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import comp3350.dishproject.R;
import comp3350.dishproject.logic.AccessIngredients;
import comp3350.dishproject.logic.AccessRecipes;
import comp3350.dishproject.logic.AccessShoppingCart;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.utils.DBHelper;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.annotation.NonNull;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  {
    private static final int SCROLLING_SPEED_FRICTION = 350;//modifies scrolling speed for search suggestion box
    private ListView listSearchSuggestions; //listview used for displaying the search suggestions(AKA autocomplete)
    private ArrayAdapter<String> searchSuggestions;//used for taking a string array of dishes and inserting them into the listview
    private String[] dishes;
    private List<HomeCard> mlist;
    private AccessRecipes ar;
    private AccessIngredients ai;
    private AccessShoppingCart asc;
    private Adapter adapter;

    //for navigation bar
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    //Android Specific Creator
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper.copyDatabaseToDevice(this);//Database

        //Setting up our database singleton classes
        ar = new AccessRecipes();
        ai = new AccessIngredients();
        asc = new AccessShoppingCart();

        //Update the list of recipes at startup
        updateDishList();
        //Setup recycler view with the adapter (shows cards on main screen)
        RecyclerView recyclerView = findViewById(R.id.rv_list);


        //Recipes Cards Init
        mlist = new ArrayList<>();
        turnRecipesIntoCards();
        sortRecipeCards();

        //Adapter for Cards
        adapter = new Adapter(this, mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));

        //Inits
        initializeSearchSuggestionBox();
        initializeNavigationBar();
        setNavigationOnClick();

    }

    /*
    Input: No input
    Output: void function
    Description: Refreshes the page when we use the back button to return to home. Allows us to update home cards
     */
    @Override
    public void onRestart() {
        super.onRestart();
        //When BACK BUTTON is pressed, the activity on the stack is restarted
        //Do what you want on the refresh procedure here
        //Refresh the page if we use the back button to get back to it
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);

    }

    /*
    Input: No input
    Output: void function
    Description: Takes all the recipes in the system and converts them to recipe cards
     */
    public void turnRecipesIntoCards(){
        List<Recipe> recipeList = ar.getAllRecipes();
        for(int i=0;i<recipeList.size();i++) {
            Recipe recipe = recipeList.get(i);
            String dish = recipe.getName().toLowerCase();
            int resID = getResources().getIdentifier(dish, "drawable", getPackageName());//seeing if theres an image
            if(resID != 0) {//meaing we have a picture
                mlist.add(new HomeCard(resID, recipe.getName(),recipe.getFav()));
            } else {//default picture
                mlist.add(new HomeCard(R.drawable.cook, recipe.getName(),recipe.getFav()));
            }
        }
    }

    /*
    Input: No input
    Output: void function
    Description: Sorts the recipe cards based on the favorite status, favorites come first
     */
    public void sortRecipeCards(){
        //Sort with favorites on top
        Collections.sort(mlist, (object1, object2) -> Boolean.compare(object2.getFav(), object1.getFav()));
    }

    /*
    Input: No input
    Output: void function
    Description: initializes the navigation bar
     */
    public void initializeNavigationBar() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.nav_open, R.string.nav_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /*
    Input: No input
    Output: void function
    Description:  This method will act as a listener for the nav bar allowing the user to go to add a recipe
     */
    public void setNavigationOnClick() {
        final NavigationView nv = (NavigationView) findViewById(R.id.nav_view);
        nv.bringToFront();
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.nav_add_recipe) {
                    openDialog();
                }
                if(id == R.id.nav_shopping_cart){
                    Intent intent = new Intent(MainActivity.this, ShoppingCartActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }

    /*
    Input: Menuitem item
    Output: returns true if clicked
    Description: be used in opening the nav bar
     */
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return actionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    /*
    Input: No input
    Output: void function
    Description: This method will be called from OnCreate(). In this method, the listview that is used as a search suggestion box will be initialized.
     */
    public void initializeSearchSuggestionBox() {
        listSearchSuggestions = findViewById(R.id.listview);
        List<String> dishNames = new ArrayList<>(Arrays.asList(dishes));
        searchSuggestions = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishNames);// returns a view
        // for each dish in dishes and used in the listview interface
        listSearchSuggestions.setAdapter(searchSuggestions);
        listSearchSuggestions.setVisibility(View.INVISIBLE);//on startup, we need to disable the visibility for the search suggestions box
        listSearchSuggestions.bringToFront();
        listSearchSuggestions.setFriction(ViewConfiguration.getScrollFriction() * SCROLLING_SPEED_FRICTION);
    }

    /*
    Input: No input
    Output: void function
    Description: updates the local dish array with the latest adds(recipes) and formats it into string array
     */
    public void updateDishList() {
        List<Recipe> rr = ar.getAllRecipes();
        dishes = new String[rr.size()];
        for(int i=0;i<rr.size();i++) {
            Recipe r = rr.get(i);
            dishes[i] = r.getName();
        }
    }

    //Opens the dialog box for "Adding a new recipe"
    public void openDialog(){
        AddDialog addDialog = new AddDialog();
        addDialog.initialize(this); //Send a reference of mainActivity so we can refresh page on close
        addDialog.show(getSupportFragmentManager(), "Add a recipe");


    }
    //Android Specific Creator
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);//instantiate menu XML files into a menu object, this menu will be
        //a search menu as defined in the XML file menu.xml
        MenuItem menuItem = menu.findItem(R.id.action_search);
        
        final SearchView searchView = (SearchView) menuItem.getActionView();//returns currently set action view
        searchView.setQueryHint("Search for Dish");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            /*
            Input: Takes in a string s. This string will be the typed string once the user hits enter.
            Output: returns true if done successfully
            Description: Once user hits enter, go to that dish if it exists
             */
            @Override
            public boolean onQueryTextSubmit(String enteredString) {


                if (!ar.getRecipe(ar.findRecipeID(enteredString.toLowerCase())).getName().equals("Null")) {
                    String dishName = enteredString.toLowerCase();
                    searchView.clearFocus();
                    Intent intent = new Intent(MainActivity.this, ViewRecipe.class);
                    intent.putExtra("search",dishName);
                    startActivity(intent);
                    return true;
                } else {
                    searchView.setQuery("Not Found", false);
                    searchView.clearFocus();
                    return false;
                }

            }

            /*
            Input: Takes in a string s. This is the dynamic string that changes when a new character is entered
            Output: returns true if done successfully
            Description: Once user types/backspaces a character, adjust the search suggestions
             */
            @Override
            public boolean onQueryTextChange(String newCharacterString) {//every change of character
                updateDishList();
                ArrayList<String> filtered = filterSearchSuggestions(newCharacterString,dishes);
                //Clearing search suggestions and adding everything found in user filtering
                searchSuggestions.clear();
                searchSuggestions.addAll(filtered);

                //Dynamically Adjusts the height of the search suggestions box based on the number of suggestions
                if (filtered.size() >= 1 && searchSuggestions.getCount() >= 1) {
                    changeSearchSuggestionBoxSize(filtered);
                }

                if (newCharacterString.length() > 1 && filtered.size() > 0) {
                    listSearchSuggestions.setVisibility(View.VISIBLE);//only show the search suggestions when theres actual suggestions and something has been typed in
                } else {
                    listSearchSuggestions.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        //event listener for when you click a search suggestion
        listSearchSuggestions.setOnItemClickListener((adapterView, view, post, id) -> {
            Object listItem = listSearchSuggestions.getItemAtPosition(post);//clicked Item
            searchView.setQuery(listItem.toString().toLowerCase(), false);//adjusts the query to make it the clicked item
            listSearchSuggestions.setVisibility(View.INVISIBLE);

        });

        //event listener for when the search box is closed
        searchView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {

            /*
            Input: Takes in a view.
            Output: void
            Description: No use since we don't want listview to show when search bar is clicked.
             */
            @Override
            public void onViewAttachedToWindow(View view) {
            }

            /*
            Input: Takes in a view.
            Output: void.
            Description: When search bar is closed, remove visibility for the currently shown search suggestion box
             */
            @Override
            public void onViewDetachedFromWindow(View view) {
                listSearchSuggestions.setVisibility(View.INVISIBLE);
            }
        });
        return true;
    }//end of onCreateMenuOptions function




    /*
    Input: Takes in an array list of type string that contains all relevant search suggestions to be displayed
    Output: void function, but does change some parameters of the listview layout
    Description: Dynamically changes the size of the search suggestion box based on how many items are in the search suggestion box
     */
    public void changeSearchSuggestionBoxSize(ArrayList<String> relevantSearchSuggestions) {
        View item = searchSuggestions.getView(0, null, listSearchSuggestions);
        item.measure(0, 0);//size of one search suggestion box(one search dis)
        ViewGroup.LayoutParams params = listSearchSuggestions.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        int scalingFactor = relevantSearchSuggestions.size();
        if (relevantSearchSuggestions.size() >= 3) {
            scalingFactor = 3; //if more than 3 elements, restrict the listview box to hold only 3 elements and then force user to scroll for more
        }
        params.height = scalingFactor * item.getMeasuredHeight();//height of listview search suggestion box is either 1 element tall, 2 elements tall, or 3 element tall and
        //makes the user scroll down for more suggestions
    }

    /*
    Input: takes in a dish name and a string array of dish names
    Output: returns a filtered list of all dish names that match the searchquery
    Description: Filters our search results based on the searchquery
     */
    public static ArrayList<String> filterSearchSuggestions(String searchQuery, String[] dishes) {
        ArrayList<String> filtered = new ArrayList<>();
        for (String dish : dishes) {
            String[] stringsToCheck = dish.split(" ");//Example: For dish of Chicken Parm, a search query of "Parm" will return Chicken Parm
            for (String s : stringsToCheck) {
                if (s.toLowerCase().contains(searchQuery.toLowerCase())) {//only lowercase cleaning
                    filtered.add(dish);
                }
            }
        }
        return filtered;
    }


}
