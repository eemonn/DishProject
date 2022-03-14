package comp3350.dishproject.logic;

import java.util.List;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.objects.Steps;

public class ShowRecipe {
    private final Recipe recipe;
    private final Steps step;
    private final String recipeID;
    List<Ingredient> ingredientsOfRecipe;
    /*
    Input: a recipe object
    Output: constructor
    Description: Constructor for recipe object
     */
    public ShowRecipe(Recipe r,Steps step) {
        this.recipe = r;
        this.step = step;
        AccessRecipes Ar = new AccessRecipes();
        recipeID = Ar.findRecipeID(recipe.getName());
        AccessIngredients Ai = new AccessIngredients();
        ingredientsOfRecipe = Ai.getIngredients(recipeID);
    }


    public String showIngredient(int scaleFactor) {
        StringBuilder ingredientString = new StringBuilder();

        for (int i = 0; i < ingredientsOfRecipe.size(); i++) {
            String name = ingredientsOfRecipe.get(i).getName();
            int quantity = ingredientsOfRecipe.get(i).getQuantity() * scaleFactor;
            double weight = ingredientsOfRecipe.get(i).getWeight() * scaleFactor;
            double calorie = ingredientsOfRecipe.get(i).getCalorie() * scaleFactor;

            ingredientString.append(i + 1).append(". ").append(name).append("  Amount: ").
                    append(quantity).
                    append("  Calorie: ").append(calorie).append("cal  Weight: ").
                    append(weight).append("g\n");
        }
        return ingredientString.toString();
    }



    public String updateIngredients(int scaleFactor) {
       return showIngredient(scaleFactor);
    }

    public String showTitle() {
        return recipe.getName();
    }


    public String showTitleDescription() {
        String ingredientInfo = "";
        double totalCalories = calculateQuantity("Calories");
        double totalWeight = calculateQuantity("Weight");
        ingredientInfo += "Calorie: " + totalCalories + " Weight: " + totalWeight + "g\n";
        return ingredientInfo;
    }


    public double calculateQuantity(String whatToCount) {
        double runningSum = 0;
        for(int i=0;i<ingredientsOfRecipe.size();i++) {
            Ingredient ing = ingredientsOfRecipe.get(i);
           if(whatToCount.equals("Calories")) runningSum += ing.getCalorie();
           if(whatToCount.equals("Weight")) runningSum += ing.getWeight();
        }
        return runningSum;
    }

    public String showDirection() {
        return step.toString();
    }

}
