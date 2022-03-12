package comp3350.dishproject.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import comp3350.dishproject.persistence.RecipePersistence;

public class RecipePersistenceHSQLDB implements RecipePersistence {
    private final String dbPath;
    public RecipePersistenceHSQLDB(final String dbPath) { this.dbPath = dbPath;}

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }
}
