package comp3350.dishproject.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.objects.Steps;
import comp3350.dishproject.persistence.StepsPersistence;

public class StepsPersistenceHSQLDB implements StepsPersistence {

    private final String dbPath;
    private final List<String> recipeIDs;

    public StepsPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
        this.recipeIDs = new ArrayList<>();
        loadRecipesIDs();
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }
    private Steps fromResultSet(final ResultSet rs) throws SQLException {
        final String directions = rs.getString("STEPS");
        final String recipedID = rs.getString("RECIPEID");

        return new Steps(directions,recipedID);
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
    Input: takes in a string of the recipe ID
    Output: returns a string of that recipes directions
    Description: returns a string of a given recipes directions
     */
    @Override
    public String getDirections(final String recipeID) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM DIRECTIONS WHERE DIRECTIONS.recipeID=?");
            st.setString(1, recipeID);
            final ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return fromResultSet(rs).getDirections();
            }
            rs.close();
            st.close();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
        return "No Directions";
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
                final PreparedStatement st = c.prepareStatement("UPDATE DIRECTIONS SET STEPS = ? WHERE RECIPEID = ?");
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

    /*
    Input: String of directions and recipe object
    Output: boolean
    Description: adds steps of a given new recipe
     */
    @Override
    public boolean insertSteps(String directions,Recipe recipe) {
        try (final Connection c = connection()) {
            if(getDirections(recipe.getRecipeID()).equals("No Directions")) {
                final PreparedStatement st = c.prepareStatement("INSERT INTO DIRECTIONS VALUES(?, ?)");
                st.setString(1, directions);
                st.setString(2, recipe.getRecipeID());
                st.executeUpdate();
                st.close();
            } else {
                return false;
            }
            return true;//don't need quantity testing here, since if error we'll get an sql error and it wont return true
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }
}
