package comp3350.dishproject.tests.persistence;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import java.util.ArrayList;

import comp3350.dishproject.R;
import comp3350.dishproject.presentation.HomeCard;

public class dbTest {

    /*
    @Test
    public void emptyOrnot(){
        DataAccess db=new DataAccess();
        assertNotNull(db); //initially there are 5 recipes.
    }

    @Test
    public void addRecipe(){
        DataAccess db=new DataAccess();
        db.addRecipe(new HomeCard(R.drawable.fish, "newFish"));
        assert(db.getSizeofRecipe()==6); //adding to 1 make 6

    }

    @Test
    public void  removeRecipe(){
        DataAccess db=new DataAccess();
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
        DataAccess db=new DataAccess();
        ArrayList<HomeCard>x=new ArrayList();
        x=db.getAllRecipe();
        try {
            HomeCard s = x.get(5);
        }
        catch(Exception e){
            System.out.println("outOfBoundException");
            System.out.println("can't Get more Homecard here.");
        }
    }

     */

}
