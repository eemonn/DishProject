package comp3350.dishproject.persistence.stubs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.IngredientPersistence;

public class IngredientPersistenceStub implements IngredientPersistence {
    List<List<Ingredient>> ingredients;

    public IngredientPersistenceStub() {
        this.ingredients = new ArrayList<>();


        final Recipe burger = new Recipe("Burger", "100");
        final Recipe pizza = new Recipe("Pizza", "200");
        final Recipe taco = new Recipe("Taco", "300");
        final Recipe pancake = new Recipe("Pancake", "400");
        final Recipe fish = new Recipe("Fish", "500");

        List<Ingredient> burgerIngredients = new ArrayList<>();
        burgerIngredients.add(new Ingredient("Bun", "500",5,23,3, burger));
        burgerIngredients.add(new Ingredient("Beef","500",5,23,3,burger));
        burgerIngredients.add(new Ingredient("Cheese","500",5,23,3, burger));
        ingredients.add(burgerIngredients);

        List<Ingredient> pizzaIngredients = new ArrayList<>();
        pizzaIngredients.add(new Ingredient("Dough","500",5,23,3, pizza));
        pizzaIngredients.add(new Ingredient("Pizza Sauce","500",5,23,3, pizza));
        pizzaIngredients.add(new Ingredient("Cheese","500",5,23,3, pizza));
        ingredients.add(pizzaIngredients);

        List<Ingredient> tacoIngredients = new ArrayList<>();
        tacoIngredients.add(new Ingredient("Shell","500",5,23,3, taco));
        tacoIngredients.add(new Ingredient("Beef","500",5,23,3, taco));
        tacoIngredients.add(new Ingredient("Cheese","500",5,23,3, taco));
        ingredients.add(tacoIngredients);

        List<Ingredient> pancakeIngredients = new ArrayList<>();
        pancakeIngredients.add(new Ingredient("Batter","500",5,23,3, pancake));
        pancakeIngredients.add(new Ingredient("Syrup","500",5,23,3, pancake));
        pancakeIngredients.add(new Ingredient("Butter","500",5,23,3, pancake));
        ingredients.add(pancakeIngredients);

        List<Ingredient> fishIngredients = new ArrayList<>();
        fishIngredients.add(new Ingredient("Salmon","500",5,23,3, fish));
        fishIngredients.add(new Ingredient("Salt","500",5,23,3, fish));
        ingredients.add(fishIngredients);


    }

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

    public void addIngredients(Ingredient ing, final String recipeID) {
        for (int i = 0; i < ingredients.size(); i++) {
            List<Ingredient> in = ingredients.get(i);
            for (int j = 0; j < in.size(); j++) {
                Ingredient ii = in.get(j);
                if (ii.getRecipeID().equals(recipeID)) {
                    in.add(ing);
                }
            }
        }
    }
}
