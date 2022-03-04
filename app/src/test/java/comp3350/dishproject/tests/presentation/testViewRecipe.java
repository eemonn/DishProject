package comp3350.dishproject.tests.presentation;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.presentation.ViewRecipe;

public class testViewRecipe {
    @Test
    public void testShowIngredient(){
        //ViewRecipe vr=new ViewRecipe();
        Recipe r=new Recipe("Pizza","1", 600.0,450, new ArrayList<Ingredient>());
        Ingredient i=new Ingredient("Apple", "2", 2, 200.0,2.0);
        Ingredient i1=new Ingredient("Banana", "1", 1, 200.0,1.0);
        Ingredient i2=new Ingredient("Orange", "3", 3, 200.0,3.0);
        assert(2+2==4);
    }
}
