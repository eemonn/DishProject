package comp3350.dishproject.objects;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Recipe {
    private String name,recipeID;
    private int calories;

    public Recipe(String name, String recipeID,int calories) {
        this.name = name;
        this.recipeID = recipeID;
        this.calories = calories;
    }

    //getters
    public String getName(){ return name;}
    public String getRecipeID(){return recipeID;}
    public int getCalories(){return calories;}

    //setters
    public void setName(String newName) {this.name = newName;}
    public void setRecipeID(String newRecipeID) {this.recipeID = newRecipeID;}
    public void setCalories(int newCalories) {this.calories = calories;}

    public boolean isEquals(Recipe recipeObject) {
        return this.name.equals(recipeObject.name) && this.recipeID.equals(recipeObject.recipeID);
    }

    @NonNull
    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", id='" + recipeID + '\'' +
                ", calorie=" + calories +
                '}';
    }



}