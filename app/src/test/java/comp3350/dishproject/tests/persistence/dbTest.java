package comp3350.dishproject.tests.persistence;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import java.util.ArrayList;

import comp3350.dishproject.R;
import comp3350.dishproject.persistence.DataAcess;
import comp3350.dishproject.presentation.HomeCard;

public class dbTest {
    @Test
    public void emptyOrnot(){
        DataAcess db=new DataAcess();
        assertNotNull(db); //initially there are 5 recipes.
    }

    @Test
    public void addRecipe(){
        DataAcess db=new DataAcess();
        db.addRecipe(new HomeCard(R.drawable.fish, "newFish"));
        assert(db.getSizeofRecipe()==6); //adding to 1 make 6

    }

    @Test
    public void  removeRecipe(){
        DataAcess db=new DataAcess();
        int removeNumber=db.removeRecipe("Bobby's Burger");
        assert(removeNumber==1);

        int removeNumber2=db.removeRecipe("Freddy's Fish");
        assert(removeNumber2==1);//removed

        //removing two recipes
        assert(db.getSizeofRecipe()==3);


        //then adding one recipe
        db.addRecipe(new HomeCard(R.drawable.fish, "newFish"));
        assert(db.getSizeofRecipe()==4);

    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void ExceptionTest(){
        DataAcess db=new DataAcess();
        ArrayList<HomeCard>x=new ArrayList();
        x=db.getAllRecipe();
        HomeCard s=x.get(5);
    }

}
