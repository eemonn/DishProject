package comp3350.dishproject.logic;

import comp3350.dishproject.objects.Recipe;

public class ShowRecipe {
    private Recipe recipe;

    /*
    Input: a recipe object
    Output: constructor
    Description: Constructor for recipe object
     */
    public ShowRecipe(Recipe r) {
        this.recipe = r;
    }

    /*
    Input: no input
    Output: returns string of ingredient information
    Description: Will return the details of ingredient list
    */
    public String showIngredient() {
        StringBuilder ingredientString = new StringBuilder();
        for (int i = 0; i < recipe.getIngredientArrayList().size(); i++) {
            ingredientString.append(i + 1).append(". ").append(recipe.getIngredientArrayList().get(i).
                    getName()).append("  Amount: ").append(recipe.getIngredientArrayList().get(i).
                    getQuantity()).append("  Calorie: ").append(recipe.getIngredientArrayList().get(i).
                    getCalorie()).append("cal  Weight: ").append(recipe.getIngredientArrayList().get(i).
                    getWeight()).append("g\n");
        }
        return ingredientString.toString();
    }

    /*
    Description: Will update the specified ingredients
    */
    public String updateIngredients(int num) {
        recipe.updateIngredientList(num);
        return showIngredient();
    }

    /*
    Description: Will return the title of the recipe
    */
    public String showTitle() {
        return recipe.getName();
    }


    /*
    Description: Will return the calorie and weight of the recipe
    */
    public String showTitleDescription() {
        String ingredientInfo = "";
        ingredientInfo += "Calorie: " + recipe.getCalorie() + "cal Weight: " + recipe.getWeight() + "g\n";
        return ingredientInfo;
    }

    /*
   Description: Will return the recipe directions
   */
    public String showDirection() {
        return recipe.getDirection();
    }

    /*
   Description: Will return the recipe object
   */
    public Recipe getRec() {
        return recipe;
    }
}
