package comp3350.dishproject.persistence;

import java.util.List;
import comp3350.dishproject.objects.Ingredient;

public interface ShoppingCartPersistence {
    public boolean addToList(Ingredient ingredient);
    public boolean deleteFromList(Ingredient ingredientName);
    public List<Ingredient> getEntireList();
}