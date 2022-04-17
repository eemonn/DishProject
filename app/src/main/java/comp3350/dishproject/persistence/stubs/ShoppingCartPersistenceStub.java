package comp3350.dishproject.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.persistence.ShoppingCartPersistence;

public class ShoppingCartPersistenceStub implements ShoppingCartPersistence {
    private final List<Ingredient>shoppingList;

    public ShoppingCartPersistenceStub(){
        this.shoppingList=new ArrayList<>();
        shoppingList.add(new Ingredient("Bun", 5,23,3, "100"));
        shoppingList.add(new Ingredient("Beef",5,23,3,"100"));
        shoppingList.add(new Ingredient("Cheese",5,23,3, "100"));
    }

    @Override
    public boolean addToList(Ingredient ingredientName) {
        shoppingList.add(ingredientName);
        return true;
    }

    @Override
    public boolean deleteFromList(String ingredientName) {
        Ingredient temp;
        for(int i=0;i<shoppingList.size();i++){
            temp=shoppingList.get(i);
            if(temp.getName().equals(ingredientName)){
                shoppingList.remove(temp);
                break;
            }
        }
        return false;
    }

    @Override
    public List<Ingredient> getEntireList() {
        return shoppingList;
    }


}
