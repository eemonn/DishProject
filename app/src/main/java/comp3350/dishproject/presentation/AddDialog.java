package comp3350.dishproject.presentation;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import comp3350.dishproject.R;
import comp3350.dishproject.logic.AddRecipe;

public class AddDialog extends AppCompatDialogFragment {

    private LinearLayout layoutList;
    private Button buttonAdd;
    private MainActivity mainActivityCopy;

    /*
    Input: instance State
    Output: Outputs the dialog box after it is created
    Description: This will instantiate a dialog box and send it back to mainActivity
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_add_dialog, null);

        //Setup the options for the dialog box, including Add and Cancel buttons
        builder.setView(view)
                .setTitle("Add a new recipe")
                .setMessage("Enter your recipe information")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Pull text and pass to underlying activity
                        readData(view);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        //Variables used for the dynamic ingredient list
        layoutList = view.findViewById(R.id.layout_list);  //Contains the added ingredients
        buttonAdd = view.findViewById(R.id.button_add_ingredient);  //Adds a new ingredient

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addView();
            }
        });
        return builder.create();
    }

    /*
    Input: Takes in a view
    Output: void
    Description: Reads the data from the add recipe dialog boxes and sends it to logic layer
     */
    private void readData(View view)
    {
        //Initialize Variables to hold data
        String recipeName = "";
        String cookingInstructions = "";
        String ingredientNames[] = new String[layoutList.getChildCount()];
        Double ingredientWeights[] = new Double[layoutList.getChildCount()];
        boolean hasFailed = false;

        EditText recipeNameEdit = view.findViewById(R.id.add_recipe_name);
        EditText cookingInstructionsEdit = view.findViewById(R.id.add_recipe_directions);

        //Store the recipe name and cooking instructions in a variable
        recipeName = recipeNameEdit.getText().toString();
        cookingInstructions = cookingInstructionsEdit.getText().toString();



        for(int i = 0; i < layoutList.getChildCount(); i++)
        {
            //Need a new view here since we are looking at the layoutList not the parent page
            View ingredientView = layoutList.getChildAt(i);
            EditText ingredientName = ingredientView.findViewById(R.id.edit_ingredient_name);
            EditText ingredientWeight = ingredientView.findViewById(R.id.edit_ingredient_weight);

            //Store the ingredient name and weight in variables
            ingredientNames[i] = ingredientName.getText().toString();
            try {
                ingredientWeights[i] = Double.parseDouble(ingredientWeight.getText().toString());
            } catch(NumberFormatException nfe ) {
                hasFailed = true;
                Messages.warning(view.getContext(),"Bad input to weight field, make it a number");
            }
        }
        if(!hasFailed) {
            try {
                AddRecipe.createRecipe(recipeName.toLowerCase(), cookingInstructions, ingredientNames, ingredientWeights);

                //Reload the main activity showing the new card
                mainActivityCopy.finish();
                mainActivityCopy.overridePendingTransition(0, 0);
                mainActivityCopy.startActivity(mainActivityCopy.getIntent());
                mainActivityCopy.overridePendingTransition(0, 0);

            } catch(Exception e) {
                Messages.warning(view.getContext(),e.getMessage());
            }
        }
    }

    //Called to add a new row for ingredients
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

    //Remove a specified row of ingredients
    private void removeView(View view)
    {
        layoutList.removeView(view);
    }

    /*
    Input: Reference to main activity
    Output: void function
    Description: Gives us a reference to main activity so we can refresh the cards when we finish adding
     */
    public void initialize(MainActivity mainActivity) {
        mainActivityCopy = mainActivity;
    }
}
