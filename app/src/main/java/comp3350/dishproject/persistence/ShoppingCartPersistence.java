package comp3350.dishproject.persistence;

import java.util.List;
import comp3350.dishproject.objects.Ingredient;

public interface ShoppingCartPersistence {
     boolean addToList(Ingredient ingredient);
     boolean deleteFromList(String ingredientName);
     List<Ingredient> getEntireList();
}