package comp3350.dishproject.persistence.hsqldb;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.RecipePersistence;

public class RecipePersistenceHSQLDB implements RecipePersistence {
    private final String dbPath;
    public RecipePersistenceHSQLDB(final String dbPath) { this.dbPath = dbPath;}

    private Recipe fromResultSet(final ResultSet rs) throws SQLException {
        final String recipeID = rs.getString("RECIPEID");
        final String recipeName = rs.getString("NAME");

        return new Recipe(recipeName, recipeID);
    }


    private Connection connection() throws SQLException {
        Log.d("TAG" , "connection: " + dbPath);
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    @Override
    public List<Recipe> getAllRecipes() {
        final List<Recipe> recipes = new ArrayList<>();
        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM RECIPES");
            while (rs.next()) {
                final Recipe recipe = fromResultSet(rs);
                recipes.add(recipe);
            }
            rs.close();
            st.close();

            return recipes;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }

    @Override
    public Recipe getRecipe(String recipeID){

        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM RECIPES WHERE RECIPES.recipeID=?");
            st.setString(1, recipeID);
            final ResultSet rs = st.executeQuery();
            if(rs.next()){
                return fromResultSet(rs);
            }

            rs.close();
            st.close();


        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
        return null;
    }

    @Override
    public String findRecipeID(final String recipeName){

        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM RECIPES WHERE NAME=?");
            st.setString(1, recipeName);

            final ResultSet rs = st.executeQuery();
            if(rs.next()){
                return fromResultSet(rs).getRecipeID();
            }

            rs.close();
            st.close();

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    return null;
    }

    @Override
    public Recipe insertRecipe(Recipe newRecipe) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO RECIPES VALUES(?, ?)");
            st.setString(1, newRecipe.getRecipeID());
            st.setString(2, newRecipe.getName());
            st.executeUpdate();
            return newRecipe;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }
    @Override
    public Recipe updateRecipe(Recipe newRecipe) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE RECIPES SET  name = ? WHERE RECIPEID = ?");
            st.setString(1, newRecipe.getName());
            st.setString(2, newRecipe.getRecipeID());
            st.executeUpdate();
            return newRecipe;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }


    @Override
    public void deleteRecipe(Recipe newRecipe) {
        try (final Connection c = connection()) {
            final PreparedStatement sc = c.prepareStatement("DELETE FROM RECIPES WHERE RECIPEID = ?");
            sc.setString(1, newRecipe.getRecipeID());
            sc.executeUpdate();
            final PreparedStatement st = c.prepareStatement("DELETE FROM INGREDIENTS WHERE RECIPEID = ?");
            st.setString(1, newRecipe.getRecipeID());
            st.executeUpdate();
            final PreparedStatement sm = c.prepareStatement("DELETE FROM DIRECTIONS WHERE RECIPEID = ?");
            sm.setString(1, newRecipe.getRecipeID());
            sm.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }


    }
}
