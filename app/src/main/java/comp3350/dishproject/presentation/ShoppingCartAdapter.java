package comp3350.dishproject.presentation;

import android.annotation.SuppressLint;
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
import comp3350.dishproject.objects.Ingredient;

public class ShoppingCartAdapter extends ArrayAdapter<String> {
    ArrayList<String> list;
    Context context;
    public ShoppingCartAdapter(@NonNull Context context, ArrayList<String> items) {
        super(context, R.layout.list_row, items);
        this.context=context;
        list=items;
    }
    //@SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
//        if(convertView == null){
//            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//            convertView=layoutInflater.inflate(R.layout.list_row, null);
//
//            TextView number=convertView.findViewById(R.id.number);
//            TextView name=convertView.findViewById(R.id.name);
//            ImageView remove=convertView.findViewById(R.id.remove);
//            ImageView info=convertView.findViewById(R.id.info);
//
//
//            number.setText(position + 1 + ".");
//
//            name.setText(list.get(position));
//

//        }
//        return convertView;
        try {
            if (convertView == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                convertView = inflater.inflate(R.layout.list_row, parent, false);
            }
            TextView number = convertView.findViewById(R.id.number);
            TextView name = convertView.findViewById(R.id.name);
            ImageView remove = convertView.findViewById(R.id.remove);
            ImageView info = convertView.findViewById(R.id.info);
            number.setText(position + 1 + ".");
            name.setText(list.get(position));
            remove.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    ShoppingCartActivity.removeItem(position);
                }
            });
            info.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    ShoppingCartActivity.displayIngredientInfo(position);
                }
            });
            return convertView;

        } catch(Exception e) {
            return null;
        }
    }
}
