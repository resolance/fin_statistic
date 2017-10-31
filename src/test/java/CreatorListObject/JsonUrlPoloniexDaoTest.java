package CreatorListObject;

import org.junit.Test;
import ru.solovev.fin.statistic.stock.exchange.poloniex.JsonPoloniexObject;
import ru.solovev.fin.statistic.stock.exchange.poloniex.JsonUrlPoloniexDaoImpl;

import static org.junit.Assert.*;

public class JsonUrlPoloniexDaoTest {
    private final String nameToken = "USDT_BTC";

    @Test
    public void load() throws Exception {
        JsonUrlPoloniexDaoImpl jsonUrlPoloniexDao =
                new JsonUrlPoloniexDaoImpl("https://poloniex.com/public?command=returnTicker");
        jsonUrlPoloniexDao.load();

        final JsonPoloniexObject jsObj = jsonUrlPoloniexDao.getTokenName(this.nameToken);

        assertEquals(nameToken, jsObj.getCurrency());
    }

}