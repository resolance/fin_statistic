package ObjectDB;

import CreatorListObject.JsonPoloniexObject;

import java.math.BigDecimal;

public class PoloniexDaoJdbcImplTest{
    public static final String INSERT_OBJECT = "insert into db_trade.poloniex_api_stat " +
            "(id,last,lowestAsk,highestBid,percentChange,baseVolume,quoteVolume,isFrozen,high24hr,low24hr) " +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static String currency = "USDT_USDT";
    private static int id = 999;
    private static BigDecimal last = BigDecimal.valueOf(56.20325004);
    private static  BigDecimal lowestAsk = BigDecimal.valueOf(56.30600000);
    private static BigDecimal highestBid = BigDecimal.valueOf(56.20000003);
    private static BigDecimal percentChange = BigDecimal.valueOf(0.03125229);
    private static BigDecimal baseVolume = BigDecimal.valueOf(1169569.88288910);
    private static BigDecimal quoteVolume = BigDecimal.valueOf(21123.87222821);
    private static int isFrozen = 1;
    private static BigDecimal high24hr = BigDecimal.valueOf(56.83900000);
    private static BigDecimal low24hr = BigDecimal.valueOf(53.99585400);


    public static void main(String[] args) {
        ConnectionHolder connectionHolder = new ConnectionHolder();

        JsonPoloniexObject jsonPoloniexObject = new JsonPoloniexObject();
        jsonPoloniexObject.setCurrency(currency);
        jsonPoloniexObject.setId(id);
        jsonPoloniexObject.setLast(last);
        jsonPoloniexObject.setLowestAsk(lowestAsk);
        jsonPoloniexObject.setHighestBid(highestBid);
        jsonPoloniexObject.setPercentChange(percentChange);
        jsonPoloniexObject.setBaseVolume(baseVolume);
        jsonPoloniexObject.setQuoteVolume(quoteVolume);
        jsonPoloniexObject.setIsFrozen(isFrozen);
        jsonPoloniexObject.setHigh24hr(high24hr);
        jsonPoloniexObject.setLow24hr(low24hr);
        System.out.println(jsonPoloniexObject);

        try {
            PoloniexDaoJdbcImpl poloniexDaoJdbc = new PoloniexDaoJdbcImpl(connectionHolder.getConnection());


            poloniexDaoJdbc.someSelect();
            poloniexDaoJdbc.insertObject(jsonPoloniexObject);
            poloniexDaoJdbc.someSelect();
            System.out.println(poloniexDaoJdbc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}