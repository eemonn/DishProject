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

        final Recipe burger = new Recipe("Burger", "100",450);
        final Recipe pizza = new Recipe("Pizza", "200",460);
        final Recipe taco = new Recipe("Taco", "300",700);
        final Recipe pancake = new Recipe("Pancake", "400",800);
        final Recipe fish = new Recipe("Fish", "500",900);

        List<Ingredient> burgerIngredients = new ArrayList<>();
        burgerIngredients.add(new Ingredient("Bun", 500, burger));
        burgerIngredients.add(new Ingredient("Beef",500, burger));
        burgerIngredients.add(new Ingredient("Cheese",500, burger));
        ingredients.add(burgerIngredients);

        List<Ingredient> pizzaIngredients = new ArrayList<>();
        pizzaIngredients.add(new Ingredient("Dough",500, pizza));
        pizzaIngredients.add(new Ingredient("Pizza Sauce",500, pizza));
        pizzaIngredients.add(new Ingredient("Cheese",500, pizza));
        ingredients.add(pizzaIngredients);

        List<Ingredient> tacoIngredients = new ArrayList<>();
        tacoIngredients.add(new Ingredient("Shell",500, taco));
        tacoIngredients.add(new Ingredient("Beef",500, taco));
        tacoIngredients.add(new Ingredient("Cheese",500, taco));
        ingredients.add(tacoIngredients);

        List<Ingredient> pancakeIngredients = new ArrayList<>();
        pancakeIngredients.add(new Ingredient("Batter",500, pancake));
        pancakeIngredients.add(new Ingredient("Syrup",500, pancake));
        pancakeIngredients.add(new Ingredient("Butter",500, pancake));
        ingredients.add(pancakeIngredients);

        List<Ingredient> fishIngredients = new ArrayList<>();
        fishIngredients.add(new Ingredient("Salmon",500, fish));
        fishIngredients.add(new Ingredient("Salt",500, fish));
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

    public void modifyIngredients(Ingredient ing, final String recipeID) {
        for (int i = 0; i < ingredients.size(); i++) {
            List<Ingredient> in = ingredients.get(i);
            for (int j = 0; j < in.size(); j++) {
                Ingredient ii = in.get(j);
                if (ii.isEqual(ing) && ii.getRecipeID().equals(recipeID)) {
                    //modifify something tbd
                }
            }
        }
    }
}
