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
import comp3350.dishproject.persistence.DataAcess;
import comp3350.dishproject.presentation.item;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Setup recycler view with the adapter (shows cards on main screen)
        RecyclerView recyclerView = findViewById(R.id.rv_list);
        DataAcess db=new DataAcess();
        List<item> mlist = db.getAllRecipe();
        //Hard code the data for now


        Adapter adapter = new Adapter(this, mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));



    }
}
