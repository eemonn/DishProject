package comp3350.dishproject.persistence.hsqldb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.persistence.ShoppingCartPersistence;

public class ShoppingCartPersistenceHSQLDB implements ShoppingCartPersistence {
    private final String dbPath;
    private final List<Ingredient> shoppingList;

    public ShoppingCartPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
        this.shoppingList = new ArrayList<>();
    }

    private Ingredient fromResultSet(final ResultSet rs) throws SQLException{

        final String ingredientName= rs.getString("NAME");
        final int ingredientQuantity= rs.getInt("QUANTITY");
        final double ingredientWeight= rs.getDouble("WEIGHT");
        final double ingredientCalorie= rs.getDouble("CALORIE");
        final String recipeID= rs.getString("RECIPEID");
        return new Ingredient(ingredientName,ingredientQuantity,ingredientWeight,ingredientCalorie,recipeID);
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }
    @Override
    public boolean addToList(Ingredient ingredientName) {
        boolean added=false;
        try (final Connection c = connection()) {
                final PreparedStatement st = c.prepareStatement("INSERT INTO SHOPPINGLIST VALUES(?,?,?,?,?)");
                st.setString(1, ingredientName.getName());
                st.setInt(2, ingredientName.getQuantity());
                st.setDouble(3, ingredientName.getWeight());
                st.setDouble(4, ingredientName.getCalorie());
                st.setString(5, ingredientName.getRecipeID());

                st.executeUpdate();
                st.close();
                added=true;

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
        return added;
    }


    @Override
    public boolean deleteFromList(String ingredientName) {
        boolean removed=false;
        try (final Connection c = connection()) {
            final PreparedStatement sc = c.prepareStatement("DELETE FROM SHOPPINGLIST WHERE NAME = ?");
            sc.setString(1, ingredientName);
            sc.executeUpdate();
            removed=true;
            sc.close();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
        return removed;
    }

    @Override
    public List<Ingredient> getEntireList() {
        final List<Ingredient> ingredients= new ArrayList<>();
        try(final Connection c=connection()){
            final PreparedStatement st = c.prepareStatement("SELECT * FROM SHOPPINGLIST");
            final ResultSet rs = st.executeQuery();
            while(rs.next()){
                final Ingredient ingredient= fromResultSet(rs);
                ingredients.add(ingredient);
            }
            rs.close();
            st.close();
            return ingredients;
        }catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }
}
