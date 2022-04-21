package comp3350.dishproject.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.persistence.ShoppingCartPersistence;

public class ShoppingCartPersistenceStub implements ShoppingCartPersistence {
    private final List<Ingredient> shoppingList;

    /*
    Constructor
     */
    public ShoppingCartPersistenceStub(){
        this.shoppingList=new ArrayList<>();
        shoppingList.add(new Ingredient("Bun", 5,23,3, 100));
        shoppingList.add(new Ingredient("Beef",5,23,3,100));
        shoppingList.add(new Ingredient("Cheese",5,23,3, 100));
    }

    /*
    Input: Takes in an ingredient objects
    Output: returns boolean, true if add successful
    Description: Attempts to add an ingredient to the shopping list(no duplicates by name)
    */
    @Override
    public boolean addToList(Ingredient ingredient) {
        shoppingList.add(ingredient);
        return true;
    }

    /*
    Input: Takes in the string of ingredient name
    Output: boolean, returns true if delete successful
    Description: attempts to delete an ingredient from the list - removes first instance it finds
    */
    @Override
    public boolean deleteFromList(String ingredientName) {
        for(int i=0;i<shoppingList.size();i++){
            Ingredient ingredient = shoppingList.get(i);
            if(ingredient.getName().equals(ingredientName)){
                shoppingList.remove(ingredient);
                return true;
            }
        }
        return false;
    }

    /*
    Input: no input
    Output: returns a list of ingredients currently on the shopping list
    Description: returns a list of ingredients in the shopping list
    */
    @Override
    public List<Ingredient> getEntireList() {
        return shoppingList;
    }
}
