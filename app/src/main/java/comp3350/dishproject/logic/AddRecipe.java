package comp3350.dishproject.logic;

import java.util.Random;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;



public class AddRecipe {

    private static AccessRecipes ar;
    private static AccessIngredients ai;
    
    /*
    Input: takes in string recipe name, string of cooking instructions, arrays of ingredients names and their weights
    Output: true if add successful and false otherwise
    Description: attempts to add a dish to the system
     */
    public static boolean createRecipe(String recipeName, String cookingInstructions, String[] ingredientNames, Double[] ingredientWeights, Double [] ingredientCals) throws Exception {
        ar = new AccessRecipes();
        //Checking dish name
        if(!ar.findRecipeID(recipeName).equals("No ID")) {
            throw new Exception("Name Already in System");
        }

        //creating and validating Recipe ID
        Random rand = new Random();
        int maxID = 1000;
        int n = rand.nextInt(maxID);
        String recipeID = Integer.toString(n);

        while(!ar.getRecipe(recipeID).getName().equals("Null")) { //keep finding random numbers
            n = rand.nextInt(maxID);
            recipeID = Integer.toString(n);
        }

        //Creates recipe object
        Recipe r = new Recipe(recipeName,recipeID,5,false,"");
        boolean isAdded = ar.insertRecipe(r);//already validated the id and name, so now exception needed here

        //Add ingredients
        if(isAdded) {
            ai = new AccessIngredients();
            for (int i = 0; i < ingredientNames.length; i++) {
                Ingredient ingredient = new Ingredient(ingredientNames[i], 1, ingredientWeights[i], ingredientCals[i], r.getRecipeID());
                ai.addIngredients(ingredient, recipeID);
            }
            ar.updateDirections(r.getRecipeID(),cookingInstructions);////already validated the id and name, so now exception needed here
            return true;
        } else {
            return false;
        }
    }
}
