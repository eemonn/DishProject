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
        final double rating = rs.getDouble("RATING");

        return new Recipe(recipeName, recipeID,rating);
    }


    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    /*
    Input: no input
    Output: returns a list of recipes
    Description: returns a list of all recipes in the system
    */
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

    /*
    Input: takes in a string of the recipe ID
    Output: returns a recipe object
    Description: returns a recipe object with that given recipe ID
     */
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
        return new Recipe("Null","1",1);
    }

    /*
    Input: takes in a string of the recipe name
    Output: returns a string of recipe id
    Description: returns a string of a recipe ID for a given recipe dish name
     */
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
        return "No ID";
    }

    /*
    Input: Recipe object
    Output: returns a recipe object
    Description: adds a recipe into the system and returns it
     */
    @Override
    public boolean insertRecipe(Recipe newRecipe) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO RECIPES VALUES(?, ?, ?)");
            st.setString(1, newRecipe.getRecipeID());
            st.setString(2, newRecipe.getName());
            st.setDouble(3,5);
            st.executeUpdate();
            st.close();
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }


    /*
     Input: takes in a recipe object
     Output: void
     Description: deletes a given recipe object by id
      */
    @Override
    public void deleteRecipe(String recipeID) {
        try (final Connection c = connection()) {
            final PreparedStatement sc = c.prepareStatement("DELETE FROM RECIPES WHERE RECIPEID = ?");
            sc.setString(1, recipeID);
            sc.executeUpdate();
            final PreparedStatement st = c.prepareStatement("DELETE FROM INGREDIENTS WHERE RECIPEID = ?");
            st.setString(1, recipeID);
            st.executeUpdate();
            final PreparedStatement sm = c.prepareStatement("DELETE FROM DIRECTIONS WHERE RECIPEID = ?");
            sm.setString(1, recipeID);
            sm.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    /*
    Input: takes in double rating
    Output: void
    Description: changes a recipes rating
     */
    public void changeRating(double rating,String recipeID){
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE RECIPES SET RATING = ? WHERE RECIPEID = ?");
            st.setDouble(1, rating);
            st.setString(2, recipeID);

            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
}
