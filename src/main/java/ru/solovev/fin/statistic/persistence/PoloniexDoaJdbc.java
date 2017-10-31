package ru.solovev.fin.statistic.persistence;

import ru.solovev.fin.statistic.stock.exchange.poloniex.JsonPoloniexObject;

import java.sql.SQLException;

public interface PoloniexDoaJdbc {
    void insertObject(JsonPoloniexObject jsonPoloniexObject) throws SQLException;

    void someSelect() throws SQLException;
}
