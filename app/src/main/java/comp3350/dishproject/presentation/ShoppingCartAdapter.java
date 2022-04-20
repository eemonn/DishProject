package comp3350.dishproject.presentation;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import comp3350.dishproject.R;
import comp3350.dishproject.logic.AccessShoppingCart;

public class ShoppingCartAdapter extends ArrayAdapter<String> {
    private final ArrayList<String> list;
    private final Context context;

    //Constructor
    public ShoppingCartAdapter(@NonNull Context context, ArrayList<String> items) {
        super(context, R.layout.list_row, items);
        this.context = context;
        this.list = items;
    }


    /*
    Description: View method for the shopping cart
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        try {
            if (convertView == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                convertView = inflater.inflate(R.layout.list_row, parent, false);
            }

            //Creating the list elements
            TextView number = convertView.findViewById(R.id.number);
            TextView name = convertView.findViewById(R.id.name);
            ImageView remove = convertView.findViewById(R.id.remove);
            ImageView info = convertView.findViewById(R.id.info);
            number.setText(position + 1 + ".");
            name.setText(list.get(position));

            //Setting on click for deleting an ingredient from the shopping list
            remove.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    ShoppingCartActivity.removeItem(position);
                }
            });

            //Setting an on click for displaying info about the ingredient
            info.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    ShoppingCartActivity.displayIngredientInfo(position);
                }
            });
            return convertView;

        } catch(Exception e) {
            Messages.warning(convertView.getContext(),e.getMessage());
            return null;
        }
    }
}
