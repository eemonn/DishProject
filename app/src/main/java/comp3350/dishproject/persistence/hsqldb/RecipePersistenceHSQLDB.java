package comp3350.dishproject.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.RecipePersistence;

public class RecipePersistenceHSQLDB implements RecipePersistence {
    private final String dbPath;
    public RecipePersistenceHSQLDB(final String dbPath) { this.dbPath = dbPath;}

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return null;
    }

    @Override
    public Recipe getRecipe(String recipeID){
        return null;
    }

    @Override
    public String findRecipeID(final String recipeName){return "";}

    @Override
    public Recipe insertRecipe(Recipe newRecipe) {
        return null;
    }
    @Override
    public Recipe updateRecipe(Recipe newRecipe) {
        return null;
    }
    @Override
    public void deleteRecipe(Recipe newRecipe) {

    }
}
