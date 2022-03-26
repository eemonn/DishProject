package comp3350.dishproject.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.IngredientPersistence;

public class IngredientPersistenceStub implements IngredientPersistence {
    List<List<Ingredient>> ingredients;
    List<Recipe> recipes;

    /*
    Description: Constructor
    */
    public IngredientPersistenceStub() {
        this.ingredients = new ArrayList<>();
        this.recipes = new ArrayList<>();

        final Recipe burger = new Recipe("Burger", "100",5);
        final Recipe pizza = new Recipe("Pizza", "200",4);
        final Recipe taco = new Recipe("Taco", "300",3);
        final Recipe pancake = new Recipe("Pancake", "400",1);
        final Recipe fish = new Recipe("Fish", "500",1.5);
        recipes.add(burger);
        recipes.add(pizza);
        recipes.add(taco);
        recipes.add(pancake);
        recipes.add(fish);

        List<Ingredient> burgerIngredients = new ArrayList<>();
        burgerIngredients.add(new Ingredient("Bun", 5,23,3, burger.getRecipeID()));
        burgerIngredients.add(new Ingredient("Beef",5,23,3,burger.getRecipeID()));
        burgerIngredients.add(new Ingredient("Cheese",5,23,3, burger.getRecipeID()));
        ingredients.add(burgerIngredients);

        List<Ingredient> pizzaIngredients = new ArrayList<>();
        pizzaIngredients.add(new Ingredient("Dough",5,23,3, pizza.getRecipeID()));
        pizzaIngredients.add(new Ingredient("Pizza Sauce",5,23,3, pizza.getRecipeID()));
        pizzaIngredients.add(new Ingredient("Cheese",5,23,3, pizza.getRecipeID()));
        ingredients.add(pizzaIngredients);

        List<Ingredient> tacoIngredients = new ArrayList<>();
        tacoIngredients.add(new Ingredient("Shell",5,23,3, taco.getRecipeID()));
        tacoIngredients.add(new Ingredient("Beef",5,23,3, taco.getRecipeID()));
        tacoIngredients.add(new Ingredient("Cheese",5,23,3, taco.getRecipeID()));
        ingredients.add(tacoIngredients);

        List<Ingredient> pancakeIngredients = new ArrayList<>();
        pancakeIngredients.add(new Ingredient("Batter",5,23,3, pancake.getRecipeID()));
        pancakeIngredients.add(new Ingredient("Syrup",5,23,3, pancake.getRecipeID()));
        pancakeIngredients.add(new Ingredient("Butter",5,23,3, pancake.getRecipeID()));
        ingredients.add(pancakeIngredients);

        List<Ingredient> fishIngredients = new ArrayList<>();
        fishIngredients.add(new Ingredient("Salmon",5,23,3, fish.getRecipeID()));
        fishIngredients.add(new Ingredient("Salt",5,23,3, fish.getRecipeID()));
        ingredients.add(fishIngredients);
    }

    /*
    Input: String of recipe ID
    Output: returns a list of ingredients
    Description: returns a list of ingredients for a given recipe
    */
    public List<Ingredient> getIngredients(final String recipeID) {
        List<Ingredient> specifiedIngredients = new ArrayList<>();
        for (int i = 0; i < ingredients.size(); i++) {
            List<Ingredient> in = ingredients.get(i);
            for (int j = 0; j < in.size(); j++) {
                Ingredient ii = in.get(j);
                if (ii.getRecipeID().equals(recipeID)) {
                    specifiedIngredients.add(ii);
                }
            }
        }
        return specifiedIngredients;
    }

    /*
    Input: takes in a ingredient object and string recipe ID
    Output: void
    Description: Adds ingredients for a given recipeID
    */
    public void addIngredients(Ingredient ing, final String recipeID) {
        boolean previousIngredient = false;
        for (int i = 0; i < ingredients.size(); i++) {
            List<Ingredient> in = ingredients.get(i);
            if (in.get(0).getRecipeID().equals(recipeID)) {
                in.add(ing);
                previousIngredient = true;

            }
        }
        if (!previousIngredient) {
            List<Ingredient> newIngredients = new ArrayList<>();
            newIngredients.add(ing);
            ingredients.add(newIngredients);
        }
    }

}
