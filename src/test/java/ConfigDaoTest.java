import de.saxsys.javafx.test.JfxRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import pong.data.Config;
import pong.data.ConfigDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(JfxRunner.class)
public class ConfigDaoTest {

    Connection connection;

    public ConfigDaoTest() {
        new ConfigDao("test");
        connection = ConfigDao.getConnection();
    }

    @Test
    public void testCreatingDatabase() throws SQLException {
        ConfigDao.createDatabase();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from config");
        int playerHeightDao = 0;
        while (rs.next()) {
            // Read the result set
            playerHeightDao = rs.getInt("playerHeight");
        }
        assertEquals(Config.playerHeight, playerHeightDao);
    }

    @Test
    public void testUpdateValue() {
        ConfigDao.updateValue("playerHeight", 5);
        assertEquals(Config.playerHeight, 5);
    }

    @Test
    public void closeAndDeleteDao() {
        ConfigDao.closeConnection();
        assertNull(ConfigDao.getConnection());
    }
}