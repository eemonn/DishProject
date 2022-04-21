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
    private final List<String> recipeIDs;

    public RecipePersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
        this.recipeIDs = new ArrayList<>();
        loadRecipesIDs();
    }

    private Recipe fromResultSet(final ResultSet rs) throws SQLException {
        final String recipeID = rs.getString("RECIPEID");
        final String recipeName = rs.getString("NAME");
        final double rating = rs.getDouble("RATING");
        final boolean fav = rs.getBoolean("FAV");
        final String steps = rs.getString("STEPS");

        return new Recipe(recipeName, recipeID,rating,fav,steps);
    }


    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private void loadRecipesIDs(){
        try(final Connection c=connection()){
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM RECIPES");
            while (rs.next()) {
                String recipeID = rs.getString("RECIPEID");
                recipeIDs.add(recipeID);
            }
            rs.close();
            st.close();
        }catch (final SQLException e){
            throw new PersistenceException(e);
        }
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
        return new Recipe("Null","1",1,false,"");
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
            loadRecipesIDs();
            if(!recipeIDs.contains(newRecipe.getRecipeID())) {
                final PreparedStatement st = c.prepareStatement("INSERT INTO RECIPES VALUES(?, ?, ?, ?,?)");
                st.setString(1, newRecipe.getRecipeID());
                st.setString(2, newRecipe.getName());
                st.setDouble(3, 5);//rating default 5
                st.setBoolean(4,false);//default is false
                st.setString(5,newRecipe.getSteps());
                st.executeUpdate();
                st.close();
            } else {
                return false;
            }
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }

    /*
     Input: takes in a recipe id and a boolean indicating if it is a favourite
     Output: boolean
     Description: updates the favourite status of the recipe
     */
    @Override
    public boolean changeFav(boolean fav,String recipeID){
        try (final Connection c = connection()) {
            loadRecipesIDs();
            if(recipeIDs.contains(recipeID)) {
                final PreparedStatement st = c.prepareStatement("UPDATE RECIPES SET FAV = ? WHERE RECIPEID = ?");
                st.setBoolean(1, fav);
                st.setString(2, recipeID);
                st.executeUpdate();
            } else {
                return false;
            }
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    /*
     Input: takes in a recipe object
     Output: boolean
     Description: deletes a given recipe object by id
      */
    @Override
    public boolean deleteRecipe(String recipeID) {
        try (final Connection c = connection()) {
            loadRecipesIDs();
            if(recipeIDs.contains(recipeID)) {
                final PreparedStatement sc = c.prepareStatement("DELETE FROM RECIPES WHERE RECIPEID = ?");
                sc.setString(1, recipeID);
                sc.executeUpdate();
                final PreparedStatement st = c.prepareStatement("DELETE FROM INGREDIENTS WHERE RECIPEID = ?");
                st.setString(1, recipeID);
                st.executeUpdate();
            } else {
                return  false;
            }
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    /*
    Input: takes in double rating
    Output: boolean
    Description: changes a recipes rating
     */
    public boolean changeRating(double rating,String recipeID){
        try (final Connection c = connection()) {
            loadRecipesIDs();
            if(recipeIDs.contains(recipeID)) {
                final PreparedStatement st = c.prepareStatement("UPDATE RECIPES SET RATING = ? WHERE RECIPEID = ?");
                st.setDouble(1, rating);
                st.setString(2, recipeID);
                st.executeUpdate();
            } else {
                return false;
            }
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    /*
    Input: takes in a string of the recipe ID and a string of new directions
    Output: boolean
    Description: updates a recipes directions
     */
    @Override
    public boolean updateDirections(final String recipeID, String newDirections) {
        try (final Connection c = connection()) {
            loadRecipesIDs();
            if(recipeIDs.contains(recipeID)) {
                final PreparedStatement st = c.prepareStatement("UPDATE RECIPES SET STEPS = ? WHERE RECIPEID = ?");
                st.setString(1, newDirections);
                st.setString(2, recipeID);
                st.executeUpdate();
            } else {
                return false;
            }
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
        return true;
    }

    @Override
    public String getDirections(final String recipeID) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM RECIPES WHERE RECIPES.recipeID=?");
            st.setString(1, recipeID);
            final ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return fromResultSet(rs).getSteps();
            }
            rs.close();
            st.close();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
        return "No Directions";
    }
}
