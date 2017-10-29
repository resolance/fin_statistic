import CreatorListObject.JsonPoloniexObject;
import CreatorListObject.JsonUrlPoloniexDaoImpl;
import CreatorListObject.PoloniexDao;
import ObjectDB.ConnectionHolder;
import ObjectDB.LoaderProperties;
import ObjectDB.PoloniexDaoJdbcImpl;
import ObjectDB.PoloniexDoaJdbc;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

/**
 * Входная точка приложения
 */
public class App_start {
    private static final Logger LOG = Logger.getLogger(App_start.class.getName());

    public static void main(String[] args) {
        LOG.info("start app...");
        PoloniexDao poloniexDao = new JsonUrlPoloniexDaoImpl("https://poloniex.com/public?command=returnTicker");

        try {
            //Получим список объектов
            poloniexDao.load();
            List<JsonPoloniexObject> jsonPoloniexObjectsList = poloniexDao.getPoloniexObjectList();

            //Получим коннект и занесем в БД
            //Class.forName("com.mysql.jdbc.Driver"); // без этой строки не подключается через jar
            Class.forName(LoaderProperties.getInstance().driverClassName);
            Connection connection = ConnectionHolder.getInstance().getConnection();
            PoloniexDoaJdbc poloniexDoaJdbc = new PoloniexDaoJdbcImpl(connection);
            for (JsonPoloniexObject jsonObj : jsonPoloniexObjectsList) {
                poloniexDoaJdbc.insertObject(jsonObj);
            }
            connection.close();
            LOG.info("stop app. Done.");

        } catch (Exception e) {
            LOG.info("app error..");
            e.printStackTrace();
        }

    }
}
