package comp3350.dishproject.presentation;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.R;
import comp3350.dishproject.logic.AccessShoppingCart;
import comp3350.dishproject.objects.Ingredient;

public class ShoppingCartActivity extends AppCompatActivity {
    static ListView listView;
    static ArrayList<String> items;
    static ShoppingCartAdapter adapter;
    static Context context;
    static Toast t;
    EditText insert; ImageView imageView; Menu emptyMenu;
    static AccessShoppingCart sc= new AccessShoppingCart();
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        listView = findViewById(R.id.listview);
        context=getApplicationContext();
        insert = findViewById(R.id.input);
        imageView = findViewById(R.id.add);
        items = shoppingList(sc.getEntireList());
        adapter=new ShoppingCartAdapter(this,items);
        listView.setAdapter(adapter);
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
    private ArrayList<String> shoppingList(List<Ingredient> list){
        ArrayList<String> temp=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            temp.add(list.get(i).getName());
        }

        return temp;
    }

    public static void addItem(String item) {
        items.add(item);
        listView.setAdapter(adapter);
    }
    public static void displayIngredientInfo(int i){
        makeToast((String) items.get(i));
        //listView.setAdapter(adapter);

    }


    public static void removeItem(int item){
        String deleteItem=(String)items.get(item);
        makeToast(deleteItem+" has been removed");
        sc.deleteFromList(deleteItem);
        items.remove(item);
        listView.setAdapter(adapter);
    }

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
