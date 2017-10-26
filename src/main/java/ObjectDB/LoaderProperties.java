package ObjectDB;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoaderProperties {

    private static LoaderProperties loaderProperties;

    private final String pathToJdbcProperties = "C:/Git/fin_statistic/src/main/resources/jdbc.properties";
    public final String driverClassName;
    public final String login;
    public final String password;
    public final String jdbcUrl;

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

        driverClassName = properties.getProperty("jdbc.driver");
        login = properties.getProperty("jdbc.username");
        password = properties.getProperty("jdbc.password");
        jdbcUrl = properties.getProperty("jdbc.url");
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

