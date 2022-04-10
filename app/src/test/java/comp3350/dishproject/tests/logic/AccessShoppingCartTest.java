package comp3350.dishproject.tests.logic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import comp3350.dishproject.logic.AccessShoppingCart;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.persistence.ShoppingCartPersistence;
import comp3350.dishproject.persistence.stubs.ShoppingCartPersistenceStub;

public class AccessShoppingCartTest {
    private ShoppingCartPersistence shoppingCart;
    private AccessShoppingCart sc;
    String ingredientName;

    @Before
    public void setUp(){
        shoppingCart= new ShoppingCartPersistenceStub();
        sc= new AccessShoppingCart();
    }

    @Test
    public void testConstructor(){
        Assert.assertNotNull("Should not be null",sc);
    }

    @Test
    public void testAddtoList(){
        Ingredient ingredient=new Ingredient("Tomato",5,23,3, "100");
        int scSize=shoppingCart.getEntireList().size();
        shoppingCart.addToList(ingredient);
        Assert.assertEquals(shoppingCart.getEntireList().size(),scSize+1); // one more added
    }

    @Test
    public void testDeleteFromList(){
        int scSize=shoppingCart.getEntireList().size();
        shoppingCart.deleteFromList("Bun");
        Assert.assertEquals(shoppingCart.getEntireList().size(),scSize-1); // one removed
    }

    @Test
    public void testGetEntireList(){
        int scSize=shoppingCart.getEntireList().size();
        Ingredient ingredient1=new Ingredient("Tomato",5,23,3, "100");
        shoppingCart.addToList(ingredient1);
        scSize++;
        Assert.assertEquals(shoppingCart.getEntireList().size(),scSize); // one more added

        Ingredient ingredient2=new Ingredient("Lettuce",5,23,3, "100");
        shoppingCart.addToList(ingredient2);
        scSize++;
        Assert.assertEquals(shoppingCart.getEntireList().size(),scSize); // two more added

        shoppingCart.deleteFromList("Tomato");
        scSize--;
        Assert.assertEquals(shoppingCart.getEntireList().size(),scSize); // one removed
    }
}
