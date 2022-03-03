package comp3350.dishproject.persistence;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.presentation.HomeCard;
import java.util.ArrayList;


public interface DBInterface {
    public void addRecipe(HomeCard name);
    public ArrayList<HomeCard> getRecipe(String name);
    public ArrayList<HomeCard> getAllRecipe();
    public int removeRecipe(String name);
    public int getSizeofRecipe();
    public String[] getDishes();
    public Recipe getRecipe();
}
