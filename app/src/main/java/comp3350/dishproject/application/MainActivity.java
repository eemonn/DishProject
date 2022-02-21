package comp3350.dishproject.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.R;
import comp3350.dishproject.logic.Adapter;
import comp3350.dishproject.presentation.item;

public class MainActivity extends AppCompatActivity {

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



    }
}
