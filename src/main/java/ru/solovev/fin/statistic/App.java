package ru.solovev.fin.statistic;

import ru.solovev.fin.statistic.stock.exchange.poloniex.JsonPoloniexObject;
import ru.solovev.fin.statistic.stock.exchange.poloniex.JsonUrlPoloniexDaoImpl;
import ru.solovev.fin.statistic.stock.exchange.poloniex.PoloniexDao;
import ru.solovev.fin.statistic.persistence.ConnectionHolder;
import ru.solovev.fin.statistic.persistence.LoaderProperties;
import ru.solovev.fin.statistic.persistence.PoloniexDaoJdbcImpl;
import ru.solovev.fin.statistic.persistence.PoloniexDoaJdbc;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

public class App {
    private static final Logger LOG = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        LOG.info("start app...");

        final PoloniexDao poloniexDao = new JsonUrlPoloniexDaoImpl(
                "https://poloniex.com/public?command=returnTicker");
        try {
            /*Получим список объектов*/
            poloniexDao.load();
            final List<JsonPoloniexObject> jsonPoloniexObjectsList =
                    poloniexDao.getPoloniexObjectList();

            /*Получим коннект и занесем в БД*/
            //Class.forName("com.mysql.jdbc.Driver"); // без этой строки не подключается через jar
            Class.forName(LoaderProperties.getInstance().getDriver());
            final Connection connection = ConnectionHolder.getInstance().getConnection();
            final PoloniexDoaJdbc poloniexDoaJdbc = new PoloniexDaoJdbcImpl(connection);

            // TODO: 29.10.2017 сделать блок с для запуска app с параметрами для инсерта новых токенов и селектов

            for (JsonPoloniexObject jsonObject : jsonPoloniexObjectsList) {
                poloniexDoaJdbc.insertObject(jsonObject);
            }
            connection.close();
            LOG.info("stop app. Done.");

        } catch (Exception e) {
            LOG.info("app error..");
            e.printStackTrace();
        }

    }
}
