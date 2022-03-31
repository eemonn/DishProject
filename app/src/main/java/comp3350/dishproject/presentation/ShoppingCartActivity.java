package comp3350.dishproject.presentation;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
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

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import comp3350.dishproject.R;
import comp3350.dishproject.objects.Ingredient;

public class ShoppingCartActivity extends AppCompatActivity {
    static ListView listView;
    static ArrayList<String> items;
    static ShoppingCartAdapter adapter;
    static Context context;
    static Toast t;
    EditText insert; ImageView imageView;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        listView = findViewById(R.id.listview);
        context=getApplicationContext();
        insert = findViewById(R.id.input);
        imageView = findViewById(R.id.add);
// for noman
        items = new ArrayList<>();

        items.add("a");
        items.add("b");
        items.add("c");items.add("d");
        items.add("a");
        items.add("b");
        items.add("c");items.add("d");items.add("a");
        items.add("b");
        items.add("c");items.add("d");
        items.add("a");
        items.add("b");
        items.add("c");items.add("d");items.add("a");
        items.add("b");
        items.add("c");items.add("d");
        //items.add("e");items.add("f");items.add("g");





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
                    adapter=new ShoppingCartAdapter(context,items);
                    listView.setAdapter(adapter);
                }
            }
        });
        //listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //makeToast(items.get(i).getName()+"");
                System.out.println(items);
            }
        });
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
        makeToast((String)items.get(item)+" has been removed");
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
        listView.setAdapter(adapter);
    }
}
