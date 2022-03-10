package comp3350.dishproject.logic;

import comp3350.dishproject.objects.Recipe;

public class ShowRecipe {
    private final Recipe recipe;

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

    public String [] getIngredientListName(){
        String []m=new String[10];
        int x=0;
        for(int i=0;i<recipe.getIngredientArrayList().size();i++){
            m[i]=recipe.getIngredientArrayList().get(i).getName()+" Amount: "+
                    recipe.getIngredientArrayList().get(i).getQuantity()+" Calorie: "+
                    recipe.getIngredientArrayList().get(i).getCalorie()+" Weight: "+
                    recipe.getIngredientArrayList().get(i).getWeight()
            ;
            x++;
        }
        String [] mm=new String[x];
        //System.out.println("m "+m[i]);
        System.arraycopy(m, 0, mm, 0, x);
        return mm;
    }
}
