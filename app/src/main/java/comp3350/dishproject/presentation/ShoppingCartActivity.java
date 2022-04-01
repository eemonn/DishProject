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

import comp3350.dishproject.R;
import comp3350.dishproject.objects.Ingredient;

public class ShoppingCartActivity extends AppCompatActivity {
    static ListView listView;
    static ArrayList<String> items;
    static ShoppingCartAdapter adapter;
    static Context context;
    static Toast t;
    EditText insert; ImageView imageView; Menu emptyMenu;
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
        items.add("a1");
        items.add("b1");
        items.add("c1");items.add("d1");
        items.add("a2");
        items.add("b2");
        items.add("c2");items.add("d2");
        items.add("a3");
        items.add("b3");
        items.add("c3");items.add("d3");
        items.add("a4");
        items.add("b4");
        items.add("c4");items.add("d4");
        //items.add("e");items.add("f");items.add("g");

        //adapter.notifyDataSetChanged();




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
                    //adapter=new ShoppingCartAdapter(context,items);
                    //listView.setAdapter(adapter);
                }
            }
        });
        //listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                //makeToast(items.get(i).getName()+"");
//                System.out.println(items);
//            }
//        });
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.shopping_cart_menu,menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item){
//        int id=item.getItemId();
//        if(id==R.id.empty){
//            int i=0;
//            while(items.size()>0){
//                removeItem(i);
//                i++;
//            }
////            adapter=new ShoppingCartAdapter(context,items);
////            listView.setAdapter(adapter);
//            makeToast("");
//        }
//        return super.onOptionsItemSelected(item);
//    }
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
        //listView.setAdapter(adapter);
    }
}
