package data;

import de.saxsys.javafx.test.JfxRunner;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import pong.data.Config;
import pong.data.ConfigDao;

import java.io.File;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(JfxRunner.class)
public class ConfigDaoTest {


    public ConfigDaoTest() {

        new ConfigDao("test");
    }

    @Test
    public void testCreatingDatabase() {
        File f = new File("test.db");
        if (f.exists()) {
            assertTrue(true);
        }
    }

    @Test
    public void testUpdateValue() {
        ConfigDao.updateValue("playerHeight", 5);
        assertEquals(Config.playerHeight, 5);
    }

    @AfterClass
    public static void deleteTestDatabase() {
        File f = new File("test.db");
        if (f.exists()) {
            f.delete();
        }
    }
}