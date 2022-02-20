package comp3350.dishproject.logic;


import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.os.Bundle;

import comp3350.dishproject.objects.Recipe;

public class ShowRecipe {
    Recipe rec;
    public ShowRecipe(Recipe r){
        this.rec= r;
    }

    public void showIngredient(TextView t){
        t.setText(rec.getIngredientArrayList().toString());
    }

    public void showDescription(TextView t, String s){
        t.setText(s);
    }
}
