package ObjectDB;

import ru.solovev.fin.statistic.persistence.ConnectionHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionHolderTest {

    public static void main(String[] args) {
        ConnectionHolder connectionHolder = new ConnectionHolder();

        String sql = "select * from poloniex_api_stat";
        String insert = "insert into poloniex_api_stat (id,"
                + "last,"
                + "lowestAsk,"
                + "highestBid,"
                + "percentChange,"
                + "baseVolume,"
                + "quoteVolume,"
                + "isFrozen,"
                + "high24hr,"
                + "low24hr) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connectionHolder.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("id")
                        + " : " + rs.getString("last")
                        + " : " + rs.getString("date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}