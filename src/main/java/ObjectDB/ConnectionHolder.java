package ObjectDB;

import ObjectDB.DBSystemExaption.DBException;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionHolder {
    private static ConnectionHolder connectionHolder;

    public static ConnectionHolder getInstance() {
        if (connectionHolder == null) {
            connectionHolder = new ConnectionHolder();
        }
        return connectionHolder;
    }

    public Connection getConnection() throws Exception {
        try {
            LoaderProperties loadProperties = LoaderProperties.getInstance();
            return DriverManager.getConnection(
                    loadProperties.getJdbcUrl(),
                    loadProperties.getLogin(),
                    loadProperties.getPassword()
            );


        } catch (Exception e) {
            throw new DBException("Can't create connection", e);
        }
    }
}
