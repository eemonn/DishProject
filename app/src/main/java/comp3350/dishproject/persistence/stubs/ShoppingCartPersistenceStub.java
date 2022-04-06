package comp3350.dishproject.persistence.stubs;

import java.util.List;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.persistence.ShoppingCartPersistence;

public class ShoppingCartPersistenceStub implements ShoppingCartPersistence {


    @Override
    public boolean addToList(Ingredient ingredientName) {
        return false;
    }

    @Override
    public boolean deleteFromList(String ingredientName) {
        return false;
    }

    @Override
    public List<Ingredient> getEntireList() {
        return null;
    }


}
