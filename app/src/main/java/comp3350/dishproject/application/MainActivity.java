package comp3350.dishproject.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.R;
import comp3350.dishproject.logic.Adapter;
import comp3350.dishproject.presentation.item;

public class MainActivity extends AppCompatActivity {

    private ListView listSearchSuggestions; //listview used for displaying the search suggestions(AKA autocomplete)
    private ArrayAdapter<String> searchSuggestions;//used for taking a string array of dishes and inserting them into the listview
    String[] dishes = {"Burger","Pizza","Tacos","Pancake","Fish","Pickles","Parm","Chicken Parm"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Setup recycler view with the adapter (shows cards on main screen)
        RecyclerView recyclerView = findViewById(R.id.rv_list);
        List<item> mlist = new ArrayList<>();
        //Hard code the data for now
        mlist.add(new item(R.drawable.burger, "Bobby's Burger"));
        mlist.add(new item(R.drawable.pizza, "Paul's Pizza"));
        mlist.add(new item(R.drawable.taco, "Timmy's Taco"));
        mlist.add(new item(R.drawable.pancake, "Patricia's Pancake"));
        mlist.add(new item(R.drawable.fish, "Freddy's Fish"));

        Adapter adapter = new Adapter(this, mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
        Log.d("TAG", "onCreate: ");

        listSearchSuggestions = findViewById(R.id.listview);
        searchSuggestions = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dishes);// returns a view
        // for each dish in dishes and used in the listview interface
        listSearchSuggestions.setAdapter(searchSuggestions);
        listSearchSuggestions.setVisibility(View.INVISIBLE);//on startup, we need to disable the visibility for the search suggestions box
        listSearchSuggestions.bringToFront();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);//instantiate menu XML files into a menu object, this menu will be
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
                /*
                if(dish found in array){
                    Go to dish page
                    return true;
                } else {
                    searchView.setQuery("Not Found",false);
                    searchView.clearFocus();
                    return false;
                }
                 */
                return false;
            }

            /*
            Input: Takes in a string s. This is the dynamic string that changes when a new character is entered
            Output: returns true if done successfully
            Description: Once user types/backspaces a character, adjust the search suggestions
             */
            @Override
            public boolean onQueryTextChange(String newCharacterString) {//every change of character

                searchSuggestions.getFilter().filter(newCharacterString);//Filters the dishes we have based on current input in text field
                //note: does startsWith comparison first on entire s, then does startsWith on s-1,... so on
                //Thus we need this filter to get a baseline filter, which is filtered more using user defined methods

                //User defined filtering - no cleaning besides toLowerCase
                //uses startsWith on entire string s
                ArrayList<String> filtered = new ArrayList<>();
                for (String dish : dishes) {
                    if (dish.toLowerCase().startsWith(newCharacterString.toLowerCase())) {
                        filtered.add(dish);
                    }
                }

                //Dynamically Adjusts the height of the search suggestions box based on the number of suggestions
                if(filtered.size()>=1 && searchSuggestions.getCount()>=1){
                    View item = searchSuggestions.getView(0,null,listSearchSuggestions);
                    item.measure(0,0);//size of one search suggestion box
                    ViewGroup.LayoutParams params = listSearchSuggestions.getLayoutParams();
                    params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    int scalingFactor = filtered.size();
                    if(filtered.size() >= 3){
                        scalingFactor = 3; //if more than 3 elements, restrict the listview box to hold only 3 elements and then force user to scroll for more
                    }
                    params.height = scalingFactor * item.getMeasuredHeight();//height of listview search suggestion box is either 1 element tall, 2 elements tall, or 3 element tall and
                    //makes the user scroll down for more suggestions
                }

                if(newCharacterString.length() > 0 && filtered.size()>0) {
                    listSearchSuggestions.setVisibility(View.VISIBLE);//only show the search suggestions when theres actual suggestions and something has been typed in
                } else{
                    listSearchSuggestions.setVisibility(View.INVISIBLE);
                }

                //event listener for when you click a search suggestion
                listSearchSuggestions.setOnItemClickListener((adapterView, view, post, id) -> {
                    Object listItem = listSearchSuggestions.getItemAtPosition(post);//clicked Item
                    searchView.setQuery(listItem.toString(),false);//adjusts the query to make it the clicked item
                    listSearchSuggestions.setVisibility(View.INVISIBLE);
                });
                return true;
            }
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
}
