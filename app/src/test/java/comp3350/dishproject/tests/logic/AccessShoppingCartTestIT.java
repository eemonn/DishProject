package comp3350.dishproject.tests.logic;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import comp3350.dishproject.application.Services;
import comp3350.dishproject.logic.AccessShoppingCart;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.persistence.ShoppingCartPersistence;
import comp3350.dishproject.tests.utils.TestUtils;

public class AccessShoppingCartTestIT {
    private File tempDB;
    private AccessShoppingCart sc;

    @Before
    public void setUp() throws IOException{
        tempDB=TestUtils.copyDB();
        sc= new AccessShoppingCart();
    }

    @Test
    public void testConstructor(){
        Assert.assertNotNull("Should not be null",sc);
    }

    @Test
    public void testAddtoList(){
        Ingredient ingredient=new Ingredient("Tomato",5,23,3, 100);
        int scSize=sc.getEntireList().size();
        sc.addToList(ingredient);
        Assert.assertEquals(sc.getEntireList().size(),scSize+1); // one more added
    }
    @Test
    public void testDeleteFromList(){
        Ingredient ingredient=new Ingredient("Tomato",5,23,3, 100);
        sc.addToList(ingredient);
        int scSize=sc.getEntireList().size();
        sc.deleteFromList("Tomato");
        Assert.assertEquals(sc.getEntireList().size(),scSize-1); // one removed
    }
    @Test
    public void testGetEntireList(){
        int scSize=sc.getEntireList().size();
        Ingredient ingredient1=new Ingredient("Tomato",5,23,3, 100);
        sc.addToList(ingredient1);
        scSize++;
        Assert.assertEquals(sc.getEntireList().size(),scSize); // one more added

        Ingredient ingredient2=new Ingredient("Lettuce",5,23,3, 100);
        sc.addToList(ingredient2);
        scSize++;
        Assert.assertEquals(sc.getEntireList().size(),scSize); // two more added

        sc.deleteFromList("Tomato");
        scSize--;
        Assert.assertEquals(sc.getEntireList().size(),scSize); // one removed
    }

    @After
    public void tearDown() {
        tempDB.delete();
        Services.clean();
    }
}
