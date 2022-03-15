package comp3350.dishproject.presentation;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import comp3350.dishproject.R;

public class AddDialog extends AppCompatDialogFragment {

    LinearLayout layoutList;
    Button buttonAdd;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_add_dialog, null);

        builder.setView(view)
                .setTitle("Add a new recipe")
                .setMessage("Enter your recipe information")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Pull text and pass to underlying activity
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        //AlertDialog alert = builder.create();
        layoutList = view.findViewById(R.id.layout_list);
        buttonAdd = view.findViewById(R.id.button_add_ingredient);

        //buttonAdd.setOnClickListener((View.OnClickListener) this);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addView();
            }
        });



        return builder.create();
    }


   private void addView()
   {
       View ingredientView = getLayoutInflater().inflate(R.layout.row_add_recipe, null, false);
       EditText ingredientName = ingredientView.findViewById(R.id.edit_ingredient_name);
       EditText ingredientWeight = ingredientView.findViewById(R.id.edit_ingredient_weight);
       ImageView imageClose = ingredientView.findViewById(R.id.image_remove);

       imageClose.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               removeView(ingredientView);
           }
       });

       layoutList.addView(ingredientView);
   }

   private void removeView(View view)
   {
        layoutList.removeView(view);
   }


}
