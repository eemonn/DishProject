package comp3350.dishproject.objects;

import androidx.annotation.NonNull;

import comp3350.dishproject.logic.AccessRecipes;

public class Recipe {
    private String name,recipeID;
    private int calories;

    public Recipe(String name, String recipeID) {
        this.name = name;
        this.recipeID = recipeID;
    }

    public Recipe(String recipeID){
        AccessRecipes Ar = new AccessRecipes();
        this.name = Ar.getRecipe(recipeID).getName();
        this.recipeID = recipeID;
    }

    //getters
    public String getName(){ return name;}
    public String getRecipeID(){return recipeID;}


    //setters
    public void setName(String newName) {this.name = newName;}
    public void setRecipeID(String newRecipeID) {this.recipeID = newRecipeID;}


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