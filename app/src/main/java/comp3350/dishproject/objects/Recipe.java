package comp3350.dishproject.objects;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.logic.AccessIngredients;
import comp3350.dishproject.logic.AccessRecipes;

public class Recipe {
    private String name,recipeID;
    private double rating;

    /*
    Description: Constructor if we have all three parameters
    */
    public Recipe(String name, String recipeID,double rating) {
        this.name = name;
        this.recipeID = recipeID;
        this.rating = rating;
    }

    /*
    Description: Constructor if we only have recipe ID
    */
    public Recipe(String recipeID){
        AccessRecipes Ar = new AccessRecipes();
        this.name = Ar.getRecipe(recipeID).getName();
        this.recipeID = recipeID;
    }

    //Getters
    public double getRating(){
        return this.rating;
    }
    public String getName(){ return name;}
    public String getRecipeID(){return recipeID;}


    //setters
    public void setName(String newName) {this.name = newName;}
    public void setRecipeID(String newRecipeID) {this.recipeID = newRecipeID;}
    public void setRating(double rating){this.rating =rating;}

}