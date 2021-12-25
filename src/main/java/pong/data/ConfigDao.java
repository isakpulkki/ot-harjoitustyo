package pong.data;

import java.sql.*;

public class ConfigDao extends Config {
    static Connection connection;

    public static void makeConnection(){

    try {
        // create a database connection
        connection = DriverManager.getConnection("jdbc:sqlite:settings.db");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from settings");
        while (rs.next()) {
            // read the result set
            Config.playerHeight = rs.getInt("playerheight");
            Config.difficulty = rs.getInt("difficulty");
            Config.ballRadius = rs.getInt("ballradius");
            Config.sounds = rs.getBoolean("sounds");
        }

    } catch (
    SQLException e) {
        e.printStackTrace();
    }

}

    public static void updateValue(String row, int value) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE settings SET " + row + "=" + value + " where id=1");
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
