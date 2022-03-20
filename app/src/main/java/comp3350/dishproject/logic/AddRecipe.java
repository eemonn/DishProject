package comp3350.dishproject.logic;

import java.util.List;
import java.util.Random;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;



public class AddRecipe {

    private static AccessRecipes ar = new AccessRecipes();
    private static AccessIngredients ai = new AccessIngredients();
    private static AccessSteps as = new AccessSteps();

    public static boolean createRecipe(String recipeName, String cookingInstructions, String[] ingredientNames, Double[] ingredientWeights) {
        //Checking dish name
        if(RecipeValidator.checkIfDishInSystem(recipeName,ar.getAllRecipes())) {
            return false;
        }

        //creating and validating Recipe ID
        Random rand = new Random();
        int maxID = 1000;
        int n = rand.nextInt(maxID);
        String recipeID = Integer.toString(n);
        while(RecipeValidator.validateRecipeID(recipeID,ar.getAllRecipes())) { //keep finding random numbers
            n = rand.nextInt(maxID);
            recipeID = Integer.toString(n);
        }
        double randomRating = (double) rand.nextInt(5);
        Recipe r = new Recipe(recipeName,recipeID,randomRating);
        ar.insertRecipe(r);

        //Add ingredients
        for(int i =0;i<ingredientNames.length;i++) {
            int quantity = rand.nextInt(1000);
            double calorie = (double) rand.nextInt(1000);
            Ingredient ingredient = new Ingredient(ingredientNames[i],quantity,ingredientWeights[i],calorie,r);
            ai.addIngredients(ingredient,recipeID,ar.getAllRecipes());
        }
        as.insertSteps(cookingInstructions,r);
        return true;
    }
}
