package comp3350.dishproject.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.objects.Steps;
import comp3350.dishproject.persistence.StepsPersistence;

public class StepsPersistenceHSQLDB implements StepsPersistence {

    private final String dbPath;

    public StepsPersistenceHSQLDB(final String dbPath) { this.dbPath = dbPath;}

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }
    private Steps fromResultSet(final ResultSet rs) throws SQLException {
        final String directions = rs.getString("STEPS");
        final String recipedID = rs.getString("RECIPEID");

        final Recipe r= new Recipe(recipedID);

        return new Steps(directions,r);
    }

    /*
    Input: takes in a string of the recipe ID
    Output: returns a string of that recipes directions
    Description: returns a string of a given recipes directions
     */
    public String getDirections(final String recipeID) {
        final String direction ;
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
    Output: void
    Description: updates a recipes directions
     */
    public void updateDirections(final String recipeID, String newDirections) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE DIRECTIONS SET STEPS = ? WHERE RECIPEID = ?");
            st.setString(1, newDirections);
            st.setString(2, recipeID);

            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }

    /*
    Input: String of directions and recipe object
    Output: void
    Description: adds steps of a given new recipe
     */
    @Override
    public boolean insertSteps(String directions,Recipe recipe) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO DIRECTIONS VALUES(?, ?)");
            st.setString(1, directions);
            st.setString(2, recipe.getRecipeID());
            st.executeUpdate();
            return true;//don't need quantity testing here, since if error we'll get an sql error and it wont return true
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }
}
