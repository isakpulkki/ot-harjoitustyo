import de.saxsys.javafx.test.JfxRunner;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import pong.data.Config;
import pong.data.ConfigDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static junit.framework.TestCase.assertEquals;

@RunWith(JfxRunner.class)
public class ConfigDaoTest {


    public ConfigDaoTest() {

    }

    @Test
    public void testCreatingDatabase() throws SQLException {
        new ConfigDao("test");
        if ()
    }

    @Test
    public void testUpdateValue() {
        ConfigDao.updateValue("playerHeight", 5);
        assertEquals(Config.playerHeight, 5);
    }

    @Test
    public void closeAndDeleteDao() {
        ConfigDao.closeConnection();
    }

    @AfterClass
}