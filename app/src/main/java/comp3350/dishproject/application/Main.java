package comp3350.dishproject.application;

public class Main {
    private static String dbName = "dishdb";//database name

    /*
   Input: Takes in the name of the database(not dynamically defined)
   Output: void
   Description: Sets the database path name to the hsqldb script
    */
    public static void setDBPathName(final String name) {
        try {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dbName = name;
    }

    /*
    Description: Returns db path name
     */
    public static String getDBPathName() {
        return dbName;
    }

}





