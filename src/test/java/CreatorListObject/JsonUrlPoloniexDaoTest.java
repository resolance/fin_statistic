package CreatorListObject;

import org.junit.Test;

public class JsonUrlPoloniexDaoTest {
    private final String nameToken = "USDT_BTC";

    @Test
    public void load() throws Exception {
       JsonUrlPoloniexDaoImpl jsonUrlPoloniexDao = new JsonUrlPoloniexDaoImpl("https://poloniex.com/public?command=returnTicker");
        jsonUrlPoloniexDao.load();


        final JsonPoloniexObject jsObj = jsonUrlPoloniexDao.getTokenName(this.nameToken);

        if (this.nameToken.equals(jsObj.getCurrency())) {
            System.out.println("JsonPars - DONE");
        } else {
            System.out.println("Can't reconstruct JSON.");
        }
        //System.out.println("\n" + jsonUrlPoloniexDao.poloniexObjectsList);

    }

}