package comp3350.dishproject.presentation;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.R;
import comp3350.dishproject.logic.AccessShoppingCart;
import comp3350.dishproject.objects.Ingredient;

public class ShoppingCartActivity extends AppCompatActivity {
    private static ListView listView;
    private static ArrayList<String> items;
    private static List<Ingredient> ingredientList;
    private static ShoppingCartAdapter adapter;
    private static Context context;
    private static Toast t;
    private EditText insert;
    private ImageView imageView;
    private static AccessShoppingCart sc;



    //Android studio onCreate
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        //Finding our variables
        listView = findViewById(R.id.listview);
        context = getApplicationContext();
        insert = findViewById(R.id.input);
        imageView = findViewById(R.id.add);

        //Persistent shopping cart
        sc= new AccessShoppingCart();
        ingredientList = sc.getEntireList();
        items = shoppingList(ingredientList);

        //Adapter for our shopping cart
        adapter=new ShoppingCartAdapter(this,items);
        listView.setAdapter(adapter);

        //This onClick is for when you add ingredients via the shopping list page
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = insert.getText().toString();
                if (text.length() == 0) {
                    makeToast("Enter an ingredient.");
                } else {
                    addItem(text);
                    insert.setText("");
                    makeToast("Added " + text);
                }
            }
        });
    }

    /*
    Input: Takes in an list of ingredient objects
    Output: returns an array list of strings
    Description: converts the list of ingredient objects into list of ingredient names
    */
    private ArrayList<String> shoppingList(List<Ingredient> list){
        ArrayList<String> temp=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            temp.add(list.get(i).getName());
        }
        return temp;
    }

    /*
    Input: Takes in string of the name of ingredient to add to the shopping list
    Output: void function
    Description: adds the name of the ingredient to the shoppinglist, duplication checking is done at persistence layer
    */
    public static void addItem(String item) {
        sc.addToList(new Ingredient(item,5,6.6,7.0,"1001"));//These ingredients arnt tied to a recipe ID
        items.add(item);
        listView.setAdapter(adapter);
    }

    /*
    Input: Takes in the position of the item relative to the shopping list
    Output: void function
    Description: Displays the name of the ingredient
    */
    public static void displayIngredientInfo(int i){
        ingredientList = sc.getEntireList();
        Ingredient ingredient = ingredientList.get(i);
        String displayString = "" + ingredient.getName() + " Weight: " + ingredient.getWeight();
        makeToast(displayString);
    }


    /*
    Input: Takes in the position of the item relative to the shopping list
    Output: void function
    Description: Deletes the ingredient from the shopping list at the given position
    */
    public static void removeItem(int item){
        String deleteItem= (String) items.get(item);
        makeToast(deleteItem+" has been removed");
        sc.deleteFromList(deleteItem);
        items.remove(item);
        listView.setAdapter(adapter);
    }

    /*
    Input: Takes in a string to display
    Output: void function
    Description: Helper for displaying string message about ingredients in the shopping cart
    */
    public static void makeToast(String s){
        if(t!=null) t.cancel();
        t=Toast.makeText(context,s,Toast.LENGTH_LONG);
        TextView tv=new TextView(context);
        tv.setBackgroundColor(Color.WHITE);
        tv.setPadding(10,10,10,10);
        tv.setTextSize(25);
        tv.setText(s);
        t.setView(tv);
        t.show();
    }
}
