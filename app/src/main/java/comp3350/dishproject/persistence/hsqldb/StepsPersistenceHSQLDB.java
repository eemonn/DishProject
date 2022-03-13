package comp3350.dishproject.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import comp3350.dishproject.persistence.StepsPersistence;

public class StepsPersistenceHSQLDB implements StepsPersistence {

    private final String dbPath;

    public StepsPersistenceHSQLDB(final String dbPath) { this.dbPath = dbPath;}

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }
    public String getDirections(final String recipeID) {
        return null;
    }

    public void updateDirections(final String recipeID, String newDirections) {
    }
}
