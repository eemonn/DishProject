package comp3350.dishproject.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import comp3350.dishproject.R;
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
        final String recipeName = rs.getString("name");
        final String recipedID = rs.getString("RECIPEID");

        final Recipe r= new Recipe(recipeName,recipedID);

        return new Steps(directions,r);
    }

    public String getDirections(final String recipeID) {
        final String direction ;
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM STEPS JOIN RECIPES ON STEPS.RECIPEID=RECIPES.RECIPEID WHERE RECIPEID = ?");
            st.setString(1, recipeID);

            final ResultSet rs = st.executeQuery();

            final Steps step = fromResultSet(rs);
            direction=step.getDirections();


            rs.close();
            st.close();

            return direction;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }

    public void updateDirections(final String recipeID, String newDirections) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE STEPS SET STEPS = ? WHERE RECIPEID = ?");
            st.setString(1, newDirections);
            st.setString(2, recipeID);

            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }
}
