package comp3350.dishproject.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.persistence.ShoppingCartPersistence;

public class ShoppingCartPersistenceHSQLDB implements ShoppingCartPersistence {
    private final String dbPath;

    public ShoppingCartPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Ingredient fromResultSet(final ResultSet rs) throws SQLException{

        final String ingredientName= rs.getString("NAME");
        final int ingredientQuantity= rs.getInt("QUANTITY");
        final double ingredientWeight= rs.getDouble("WEIGHT");
        final double ingredientCalorie= rs.getDouble("CALORIE");
        final String recipeID= rs.getString("RECIPEID");
        return new Ingredient(ingredientName,ingredientQuantity,ingredientWeight,ingredientCalorie,recipeID);
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }


    /*
    Input: Takes in an ingredient objects
    Output: returns boolean, true if add successful
    Description: Attempts to add an ingredient to the shopping list(no duplicates by name)
    */
    @Override
    public boolean addToList(Ingredient ingredient) {
            try (final Connection c = connection()) {
                final PreparedStatement st = c.prepareStatement("INSERT INTO SHOPPINGLIST VALUES(?,?,?,?,?)");
                st.setString(1, ingredient.getName());
                st.setInt(2, ingredient.getQuantity());
                st.setDouble(3, ingredient.getWeight());
                st.setDouble(4, ingredient.getCalorie());
                st.setString(5, ingredient.getRecipeID());
                st.executeUpdate();
                st.close();
                return true;
            } catch (final SQLException e) {
                throw new PersistenceException(e);
            }
    }

    /*
    Input: Takes in the string of ingredient name
    Output: boolean, returns true if delete successful
    Description: attempts to delete an ingredient from the list
    */
    @Override
    public boolean deleteFromList(String ingredientName) {
            try (final Connection c = connection()) {
                final PreparedStatement sc = c.prepareStatement("DELETE FROM SHOPPINGLIST WHERE NAME = ?");
                sc.setString(1, ingredientName);
                sc.executeUpdate();
                sc.close();
                return true;
            } catch (final SQLException e) {
                throw new PersistenceException(e);
            }
    }

    /*
   Input: no input
   Output: returns a list of ingredients currently on the shopping list
   Description: returns a list of ingredients in the shopping list
   */
    @Override
    public List<Ingredient> getEntireList() {
        final List<Ingredient> ingredients= new ArrayList<>();
        try(final Connection c=connection()){
            final PreparedStatement st = c.prepareStatement("SELECT * FROM SHOPPINGLIST");
            final ResultSet rs = st.executeQuery();
            while(rs.next()){
                final Ingredient ingredient = fromResultSet(rs);
                ingredients.add(ingredient);
            }
            rs.close();
            st.close();
            return ingredients;
        }catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }
}
