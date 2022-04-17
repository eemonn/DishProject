package comp3350.dishproject.tests.logic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.ArrayList;

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
        shoppingCart= mock(ShoppingCartPersistence.class);
        sc= new AccessShoppingCart(shoppingCart);
    }

    @Test
    public void testConstructor(){
        Assert.assertNotNull("Should not be null",sc);
    }

    @Test
    public void testAddtoList(){
        Ingredient ingredient=new Ingredient("Tomato",5,23,3, "100");
        final ArrayList<Ingredient> ingredients=new ArrayList<>();
        ingredients.add(ingredient); // one more added
        when(shoppingCart.getEntireList()).thenReturn(ingredients);

        int scSize=shoppingCart.getEntireList().size();
        Assert.assertEquals(scSize,1); // There is only one element in the list
        verify(shoppingCart).getEntireList();
    }

    @Test
    public void testDeleteFromList(){
        Ingredient ingredient=new Ingredient("Tomato",5,23,3, "100");
        Ingredient ingredient2=new Ingredient("Lettuce",5,23,3, "100");
        final ArrayList<Ingredient> ingredients=new ArrayList<>();
        ingredients.add(ingredient); // one more added
        ingredients.add(ingredient2);
        ingredients.remove(0); //remove the first one
        when(shoppingCart.getEntireList()).thenReturn(ingredients);

        int scSize=shoppingCart.getEntireList().size();
        Assert.assertEquals(scSize,1); // There is only one element in the list
        verify(shoppingCart).getEntireList();

    }

    @Test
    public void testGetEntireList(){
        Ingredient ingredient=new Ingredient("Tomato",5,23,3, "100");
        Ingredient ingredient2=new Ingredient("Lettuce",5,23,3, "100");
        final ArrayList<Ingredient> ingredients=new ArrayList<>();
        ingredients.add(ingredient); // one more added
        ingredients.add(ingredient2);
        when(shoppingCart.getEntireList()).thenReturn(ingredients);

        int scSize=shoppingCart.getEntireList().size();
        Assert.assertEquals(scSize,2); // There are total two  elements in the list
        verify(shoppingCart).getEntireList();
    }
}
