package ObjectDB;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoaderProperties {

    private static LoaderProperties loaderProperties;

    private final String pathToJdbcProperties = "C:/Git/fin_statistic/jdbc.properties";
    private final String driverClassName;
    private final String login;
    private final String password;
    private final String jdbcUrl;

    public static LoaderProperties getInstance() throws Exception {
        if (loaderProperties == null) {
            loaderProperties = new LoaderProperties();
        }
        return loaderProperties;
    }

    private LoaderProperties() throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(pathToJdbcProperties);
        properties.load(inputStream);
        inputStream.close();

        this.driverClassName = properties.getProperty("jdbc.driver");
        this.login = properties.getProperty("jdbc.username");
        this.password = properties.getProperty("jdbc.password");
        this.jdbcUrl = properties.getProperty("jdbc.url");
    }

    public String getDriver() {
        return driverClassName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }
}

