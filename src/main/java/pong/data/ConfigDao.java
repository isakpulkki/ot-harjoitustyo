package pong.data;

import java.sql.*;
import java.util.Objects;

/**
 * This class loads the database from SQLite
 */
public class ConfigDao extends Config {

    static Connection connection;

    /**
     * Just makes connection to the database
     */
    public ConfigDao(String name) {
        try {
            // Create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:" + name + ".db");
            createDatabase();
            getConfigurations();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    /**
     * Gets different attributes from the database to the application's configuration
     */

    public static void createDatabase() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(createTable());
        try {
            statement.execute(createConfig());
        } catch (SQLException e) {
            System.out.println("Config -column was not created, it already exists");
        }
    }

    public static void getConfigurations() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from config");
        while (rs.next()) {
            // Read the result set
            Config.playerHeight = rs.getInt("playerHeight");
            Config.difficulty = rs.getInt("difficulty");
            Config.ballRadius = rs.getInt("ballRadius");
        }
    }

    /**
     * Updates value modified in SettingsScene
     */
    public static void updateValue(String row, int value) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE config SET " + row + " = " + value + " where id=1");
            if (row.equals("playerHeight")){
                Config.playerHeight = value;
            }
            else if (row.equals("difficulty")){
                Config.difficulty = value;
            }
            if (row.equals("ballRadius")){
                Config.ballRadius = value;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Creates table if it does not exist
     */
    public static String createTable() {
        return "CREATE TABLE IF NOT EXISTS config(" +
                "id INTEGER PRIMARY KEY, " +
                "playerHeight INTEGER NOT NULL, " +
                "difficulty INTEGER NOT NULL," +
                "ballRadius INTEGER NOT NULL);";
    }

    /**
     * Creates the config column
     */
    public static String createConfig() {
        return "INSERT INTO config(" +
                "id, " +
                "playerHeight, " +
                "difficulty," +
                "ballRadius) values(1, 100, 10, 20)";
    }

    /**
     * Just close's databases connection before shutting down the application
     */
    public static void closeConnection() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
