package comp3350.dishproject.logic;

import java.util.List;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;

public class ShowRecipe {
    private final Recipe recipe;
    private final String recipeID;
    private List<Ingredient> ingredientsOfRecipe;
    private AccessRecipes Ar;
    private AccessIngredients Ai;

    /*
    Input: a recipe object
    Output: constructor
    Description: Constructor for showRecipe
     */
    public ShowRecipe(Recipe r) {
        this.recipe = r;
        Ar = new AccessRecipes();
        Ai = new AccessIngredients();
        recipeID = Ar.findRecipeID(recipe.getName());
        ingredientsOfRecipe = Ai.getIngredients(recipeID);
    }

    /*
    Input: a recipe object, string recipe ID, ingredient list
    Output: constructor
    Description: Constructor for showRecipe
     */
    public ShowRecipe(Recipe r,String recipeID,List<Ingredient> ingredients) {
        this.recipe =r;
        this.recipeID = recipeID;
        this.ingredientsOfRecipe = ingredients;
    }


    /*
    Input: takes in a integer representing the scaling factor
    Output: void
    Description: updates the record of ingredients to their initial size and then change them accordingly
     */
    public void updateIngredients(int scaleFactor) {
        for(int i=0;i<ingredientsOfRecipe.size();i++){
            Ingredient ingredient = ingredientsOfRecipe.get(i);
            ingredient.setWeight(ingredient.getInitWeight()*scaleFactor);
            ingredient.setCalorie(ingredient.getInitCal()*scaleFactor);
            ingredient.setQuantity(ingredient.getInitQuantity()*scaleFactor);
        }
    }

    /*
    Input: no input
    Output: returns a string representing a title to be displayed
    Description: returns a string with the title description of calories, weight, and rating
     */
    public String showTitleDescription() {
        String ingredientInfo = "";
        double totalCalories = calculateCalories();
        double totalWeight = calculateWeight();
        ingredientInfo += "Calorie: " + totalCalories + "kcal "+ " Weight: " +  totalWeight + "g " + "Rating: " + recipe.getRating() + "\n";
        return ingredientInfo;
    }

    /*
    Input: no input
    Output: returns a double of calories
    Description: returns a double that is sum of all calories for a given dish
     */
    public double calculateCalories() {
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
    public double calculateWeight(){
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
    public String [] getIngredientListName(){
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

}
