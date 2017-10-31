package ru.solovev.fin.statistic.stock.exchange.poloniex;

import java.io.IOException;
import java.util.List;

public interface PoloniexDao {
    void load() throws IOException;

    List<JsonPoloniexObject> getPoloniexObjectList();

    JsonPoloniexObject getTokenName(String namePair);
}
