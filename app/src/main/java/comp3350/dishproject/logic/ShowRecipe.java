package comp3350.dishproject.logic;


import android.widget.EditText;
import android.widget.RatingBar;
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
        StringBuilder m= new StringBuilder();
        for(int i=0;i<rec.getIngredientArrayList().size();i++){
            m.append(i+1).append(". ").append(rec.getIngredientArrayList().get(i).getName()).append("  Amount: ").append(rec.getIngredientArrayList().get(i).getQuantity()).append("  Calorie: +").append(rec.getIngredientArrayList().get(i).getCalorie()).append("cal  Weight: ").append(rec.getIngredientArrayList().get(i).getWeight()).append("g\n");

        }
        t.setText(m);
    }
    public void showTitle(TextView t){
        t.setText("\n"+rec.getName());
    }

    public void showDescription(TextView t, String s){
        t.setText("\n"+s+"\n");
    }
    public void showTitleDescription(TextView t, RatingBar r){
        String m="";
        m+="Calorie: "+rec.getCalorie()+"cal Weight: "+rec.getWeight()+"g\nRating: "+r.getOnRatingBarChangeListener();
        t.setText(m);
    }
    public void showRatingTitle(TextView r){
        //r.setText();
    }

    public void showDirection(TextView t){ t.setText(rec.getDirection());}
}
