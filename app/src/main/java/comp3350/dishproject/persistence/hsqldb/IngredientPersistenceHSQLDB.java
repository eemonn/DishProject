package comp3350.dishproject.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.logic.AccessRecipes;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.IngredientPersistence;
import comp3350.dishproject.persistence.RecipePersistence;

public class IngredientPersistenceHSQLDB implements IngredientPersistence {

    private final String dbPath;
    public IngredientPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    //conenction
    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }
    private Ingredient fromResultSet(final ResultSet rs) throws SQLException{
        AccessRecipes ar = new AccessRecipes();
        final String ingredientID= rs.getString("INGREDIENTID");
        final String ingredientName= rs.getString("NAME");
        final int ingredientQuantity= rs.getInt("QUANTITY");
        final double ingredientWeight= rs.getDouble("WEIGHT");
        final double ingredientCalorie= rs.getDouble("CALORIE");
        final String recipeID= rs.getString("RECIPEID");
        return new Ingredient(ingredientName,ingredientID,ingredientQuantity,ingredientWeight,ingredientCalorie,ar.getRecipe(recipeID));
    }

    public List<Ingredient> getIngredients(final String recipeID) {
        final List<Ingredient> ingredients= new ArrayList<>();

        try(final Connection c=connection()){
            final Statement query= c.createStatement();
            final ResultSet results=query.executeQuery("SELECT * FROM INGREDIENTS");
            while(results.next()){
                final Ingredient ingredient= fromResultSet(results);
                ingredients.add(ingredient);
            }
            results.close();
            query.close();
            return ingredients;
        }catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }

    public void addIngredients(Ingredient i, final String recipeID) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO INGREDIENTS VALUES(?, ?,?,?,?,?)");
            st.setString(1, i.getName());
            st.setString(2, i.getID());
            st.setInt(3, i.getQuantity());
            st.setDouble(4, i.getWeight());
            st.setDouble(5, i.getCalorie());
            st.setString(6, i.getRecipeID());

            st.executeUpdate();

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }


    }



}
