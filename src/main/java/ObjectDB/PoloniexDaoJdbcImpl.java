package ObjectDB;

import CreatorListObject.JsonPoloniexObject;
import ObjectDB.DbSystemException.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PoloniexDaoJdbcImpl implements PoloniexDoaJdbc {

    public static final String INSERT_OBJECT = "insert into poloniex_api_stat ("
            + "id,"
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
    public static final String SELECT_SOME_SQL = "select * from db_trade.poloniex_api_stat";

    private Connection connection;

    public PoloniexDaoJdbcImpl(Connection connection) throws Exception {
        this.connection = connection;
    }

    @Override
    public void insertObject(JsonPoloniexObject jsonPoloniexObject) throws DbException, SQLException {
        /*объявляем до try, чтобы видно было в finaly{} */
        //Statement statement = null;
        PreparedStatement ps = null;
        try {
        /*Параметры работы с транзакциями. Лучше все выставлять вручную*/
            this.connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE); // параметры изолированности транзакции
            this.connection.setAutoCommit(false);                                         //
            //statement = connection.createStatement();
            ps = connection.prepareStatement(INSERT_OBJECT);
            ps.setInt(1, jsonPoloniexObject.getId());
            ps.setBigDecimal(2, jsonPoloniexObject.getLast());
            ps.setBigDecimal(3, jsonPoloniexObject.getLowestAsk());
            ps.setBigDecimal(4, jsonPoloniexObject.getHighestBid());
            ps.setBigDecimal(5, jsonPoloniexObject.getPercentChange());
            ps.setBigDecimal(6, jsonPoloniexObject.getBaseVolume());
            ps.setBigDecimal(7, jsonPoloniexObject.getQuoteVolume());
            ps.setInt(8, jsonPoloniexObject.getIsFrozen());
            ps.setBigDecimal(9, jsonPoloniexObject.getHigh24hr());
            ps.setBigDecimal(10, jsonPoloniexObject.getLow24hr());
            ps.execute();
            this.connection.commit();
        } catch (Exception t) {
            this.connection.rollback();
            t.printStackTrace();

        } finally {
            ps.close();
            // statement.close();
        }
    }

    @Override
    public void someSelect() throws DbException, SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            this.connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE); // параметры изолированности транзакции
            this.connection.setAutoCommit(false);
            ps = connection.prepareStatement(SELECT_SOME_SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + " : " + rs.getString(2)
                        + " : " + rs.getString(3)
                        + " : " + rs.getString(4)
                        + " : " + rs.getString(5)
                        + " : " + rs.getString(6)
                        + " : " + rs.getString(7)
                        + " : " + rs.getString(8)
                        + " : " + rs.getString(9)
                        + " : " + rs.getString(10));
            }
            this.connection.commit();
        } catch (SQLException e) {
            this.connection.rollback();
            throw new DbException("Can't execute sql = '" + SELECT_SOME_SQL);
        } finally {
            ps.close();
            rs.close();
        }
    }
}
