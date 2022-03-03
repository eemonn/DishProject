package comp3350.dishproject.logic;


import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.view.View;
import android.os.Bundle;

import comp3350.dishproject.objects.Recipe;

public class ShowRecipe {
    //test this
    Recipe recipe;

    /*
    constructor to pass a recipe
     */
    public ShowRecipe(Recipe r) {
        this.recipe = r;
    }

    /*
    return the details of ingredient list
    */
    public String showIngredient() {
        StringBuilder m = new StringBuilder();
        for (int i = 0; i < recipe.getIngredientArrayList().size(); i++) {
            m.append(i + 1).append(". ").append(recipe.getIngredientArrayList().get(i).getName()).append("  Amount: ").append(recipe.getIngredientArrayList().get(i).getQuantity()).append("  Calorie: ").append(recipe.getIngredientArrayList().get(i).getCalorie()).append("cal  Weight: ").append(recipe.getIngredientArrayList().get(i).getWeight()).append("g\n");
        }
        return m.toString();
    }

    /*
    method to update the ingredient
     */
    public String updateIngredients(int num) {
        recipe.updateIngredientList(num);
        return showIngredient();
    }

    /*
    method to return title of recipe
     */
    public String showTitle() {
        return recipe.getName();
    }
    /*
    return the description of recipe
     */

    public String showTitleDescription() {
        String m = "";
        m += "Calorie: " + recipe.getCalorie() + "cal Weight: " + recipe.getWeight() + "g\n";
        return m;
    }

    /*
    method to return direction
     */
    public String showDirection() {
        return recipe.getDirection();
    }

    /*
    method to return the recipe
     */
    public Recipe getRec() {
        return recipe;
    }
}
