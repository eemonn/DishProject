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

    public String showIngredient(){
        StringBuilder m= new StringBuilder();
        for(int i=0;i<rec.getIngredientArrayList().size();i++){
            m.append(i+1).append(". ").append(rec.getIngredientArrayList().get(i).getName()).append("  Amount: ").append(rec.getIngredientArrayList().get(i).getQuantity()).append("  Calorie: ").append(rec.getIngredientArrayList().get(i).getCalorie()).append("cal  Weight: ").append(rec.getIngredientArrayList().get(i).getWeight()).append("g\n");

        }
        String s=m.toString();
        return s;
    }
    public String updateIngredients(int num){
        rec.updateIngredientList(num);
        return showIngredient();
    }

    public String showTitle(){
        return rec.getName();
    }


    public String showTitleDescription(){
        String m="";
        m+="Calorie: "+rec.getCalorie()+"cal Weight: "+rec.getWeight()+"g\nRating: ";
        return m;
    }
    public void showRatingTitle(TextView r){
        //r.setText();
    }

    public String showDirection(){
        return rec.getDirection();
    }

}
