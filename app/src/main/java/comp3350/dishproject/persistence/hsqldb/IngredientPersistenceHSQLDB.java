package comp3350.dishproject.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.IngredientPersistence;

public class IngredientPersistenceHSQLDB implements IngredientPersistence {

    private final String dbPath;
    private final List<Integer> recipeIDs;

    public IngredientPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
        this.recipeIDs = new ArrayList<>();
        loadRecipesIDs();
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }
    private Ingredient fromResultSet(final ResultSet rs) throws SQLException{

        final String ingredientName= rs.getString("NAME");
        final int ingredientQuantity= rs.getInt("QUANTITY");
        final double ingredientWeight= rs.getDouble("WEIGHT");
        final double ingredientCalorie= rs.getDouble("CALORIE");
        final int recipeID= rs.getInt("RECIPEID");
        return new Ingredient(ingredientName,ingredientQuantity,ingredientWeight,ingredientCalorie,recipeID);
    }

    private void loadRecipesIDs(){
        try(final Connection c=connection()){
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM RECIPES");
            while (rs.next()) {
                int recipeID = rs.getInt("RECIPEID");
                recipeIDs.add(recipeID);
            }
            rs.close();
            st.close();
        }catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }

    /*
    Input: String of recipe ID
    Output: returns a list of ingredients
    Description: returns a list of ingredients for a given recipe
    */
    @Override
    public List<Ingredient> getIngredients(final int recipeID) {
        final List<Ingredient> ingredients= new ArrayList<>();

        try(final Connection c=connection()){
            final PreparedStatement st = c.prepareStatement("SELECT * FROM INGREDIENTS WHERE INGREDIENTS.recipeID=?");
            st.setInt(1, recipeID);

            final ResultSet rs = st.executeQuery();
            while(rs.next()){
                final Ingredient ingredient= fromResultSet(rs);
                ingredients.add(ingredient);
            }
            rs.close();
            st.close();
            return ingredients;
        }catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }

    /*
    Input: takes in a ingredient object and string recipe ID
    Output: boolean
    Description: Adds ingredients for a given recipeID
    */
    @Override
    public boolean addIngredients(Ingredient i, final int recipeID) {
        try (final Connection c = connection()) {
            loadRecipesIDs();
            if(recipeIDs.contains(recipeID)) {
                final PreparedStatement st = c.prepareStatement("INSERT INTO INGREDIENTS VALUES(?,?,?,?,?)");
                st.setString(1, i.getName());
                st.setInt(2, i.getQuantity());
                st.setDouble(3, i.getWeight());
                st.setDouble(4, i.getCalorie());
                st.setInt(5, i.getRecipeID());

                st.executeUpdate();
                st.close();
                return true;
            }
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
        return false;
    }
}
