package comp3350.dishproject.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import comp3350.dishproject.persistence.IngredientPersistence;

public class IngredientPersistenceHSQLDB implements IngredientPersistence {

    private final String dbPath;
    public IngredientPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

}
