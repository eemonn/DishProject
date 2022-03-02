package comp3350.dishproject.persistence;
import comp3350.dishproject.presentation.item;
import java.util.ArrayList;


public interface fakeDB {
    public void addRecipe(item name);
    public ArrayList<item> getRecipe(String name);
    public ArrayList<item> getAllRecipe();
    public int removeRecipe(String name);
}
