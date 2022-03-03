package comp3350.dishproject.persistence;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.presentation.HomeCard;
import java.util.ArrayList;

public interface DBInterface {
    void addRecipe(HomeCard name);
    ArrayList<HomeCard> getRecipe(String name);
    ArrayList<HomeCard> getAllRecipe();
    int removeRecipe(String name);
    int getSizeofRecipe();
    String[] getDishes();
    Recipe getRecipe();
}
