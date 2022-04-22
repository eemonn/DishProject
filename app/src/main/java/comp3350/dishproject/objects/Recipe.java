package comp3350.dishproject.objects;

import java.util.List;
import java.util.Objects;

public class Recipe {
    private String name;
    private int recipeID;
    private double rating;
    private boolean isFav;
    private String steps;

    /*
    Description: Constructor if we have all three parameters
    */
    public Recipe(String name, int recipeID,double rating, boolean isFav, String steps) {
        this.name = name;
        this.recipeID = recipeID;
        this.rating = rating;
        this.isFav = isFav;
        this.steps = steps;
    }

    //Getters
    public double getRating(){
        return this.rating;
    }
    public String getName(){ return name;}
    public int getRecipeID(){return recipeID;}
    public boolean getFav(){return this.isFav;}
    public String getSteps(){return this.steps;}

    //Setters
    public void setName(String newName) {this.name = newName;}
    public void setRecipeID(int newRecipeID) {this.recipeID = newRecipeID;}
    public void setRating(double rating){this.rating =rating;}
    public void setFav(boolean fav){this.isFav = fav;}
    public void setSteps(String newSteps){this.steps = newSteps;}

    /*
    Input: no input
    Output: returns a string representing a title to be displayed
    Description: returns a string with the title description of calories, weight, and rating
     */
    public String showTitleDescription(List<Ingredient> ingredientsOfRecipe) {
        String ingredientInfo = "";
        double totalCalories = calculateCalories(ingredientsOfRecipe);
        double totalWeight = calculateWeight(ingredientsOfRecipe);
        ingredientInfo += "Calorie: " + totalCalories + "kcal "+ " Weight: " +  totalWeight + "g " + "Rating: " + rating + "\n";
        return ingredientInfo;
    }

    /*
    Input: no input
    Output: returns a double of calories
    Description: returns a double that is sum of all calories for a given dish
     */
    public double calculateCalories(List<Ingredient> ingredientsOfRecipe) {
        double runningSum = 0;
        for(int i=0;i<ingredientsOfRecipe.size();i++) {
            Ingredient ing = ingredientsOfRecipe.get(i);
            runningSum += ing.getCalorie();
        }
        return runningSum;
    }

    /*
    Input: no input
    Output: returns a double of weight
    Description: returns a double that is sum of all weight for a given dish
     */
    public double calculateWeight(List<Ingredient> ingredientsOfRecipe){
        double runningSum = 0;
        for(int i=0;i<ingredientsOfRecipe.size();i++) {
            Ingredient ing = ingredientsOfRecipe.get(i);
            runningSum += ing.getWeight();
        }
        return runningSum;
    }

    /*
  Input: no input
  Output: returns an array of strings
  Description: Method use to return the list of ingredients in a specified format
   */
    public String [] getIngredientListName(List<Ingredient> ingredientsOfRecipe){
        String []m = new String[10];
        int size=0;

        for(int i=0;i<ingredientsOfRecipe.size();i++){
            Ingredient ingredient = ingredientsOfRecipe.get(i);
            m[i]= ingredient.getName()+" Amount: "+
                    ingredient.getQuantity()+" Calorie: "+
                    ingredient.getCalorie()+" Weight: "+
                    ingredient.getWeight()
            ;
            size++;
        }
        String [] mm=new String[size];
        System.arraycopy(m, 0, mm, 0, size);
        return mm;
    }

    /*
    Input: takes in a integer representing the scaling factor
    Output: void
    Description: updates the record of ingredients to their initial size and then change them accordingly
     */
    public void updateIngredients(int scaleFactor,List<Ingredient> ingredientsOfRecipe ) {
        for(int i=0;i<ingredientsOfRecipe.size();i++){
            Ingredient ingredient = ingredientsOfRecipe.get(i);
            ingredient.setWeight(ingredient.getInitWeight()*scaleFactor);
            ingredient.setCalorie(ingredient.getInitCal()*scaleFactor);
            ingredient.setQuantity(ingredient.getInitQuantity()*scaleFactor);
        }
    }

    /*
   Input: no input
   Output: returns string
   Description: toString of recipe class
    */
    @Override
    public String toString() {
        return "Steps for "+ this.name+": " + steps;
    }

    /*
   Input: takes in object
   Output: boolean, returns true if objects are the same
   Description: equals method for recipe class
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name) && Objects.equals(recipeID, recipe.recipeID);
    }

}