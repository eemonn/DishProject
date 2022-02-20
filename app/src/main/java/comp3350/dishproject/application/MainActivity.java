package comp3350.dishproject.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.R;
import comp3350.dishproject.logic.Adapter;
import comp3350.dishproject.logic.ShowRecipe;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.presentation.ViewRecipe;
import comp3350.dishproject.presentation.item;

public class MainActivity extends AppCompatActivity {
    Button viewRec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent= new Intent(MainActivity.this, ViewRecipe.class);
        startActivity(intent);

//        //Setup recycler view with the adapter (shows cards on main screen)
//        RecyclerView recyclerView = findViewById(R.id.rv_list);
//        List<item> mlist = new ArrayList<>();
//        //Hard code the data for now
//        mlist.add(new item(R.drawable.burger, "Bobby's Burger"));
////        mlist.add(new item(R.drawable.pizza, "Paul's Pizza"));
////        mlist.add(new item(R.drawable.taco, "Timmy's Taco"));
////        mlist.add(new item(R.drawable.pancake, "Patricia's Pancake"));
////        mlist.add(new item(R.drawable.fish, "Freddy's Fish"));
//
//        Adapter adapter = new Adapter (this, mlist);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
//
//        viewRec=(Button) findViewById(R.id.btn_view);
//
////        viewRec.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent intent= new Intent(MainActivity.this, ViewRecipe.class);
////                startActivity(intent);
////            }
////        });

    }
}