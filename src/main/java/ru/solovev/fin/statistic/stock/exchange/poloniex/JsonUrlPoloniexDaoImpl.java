package ru.solovev.fin.statistic.stock.exchange.poloniex;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class JsonUrlPoloniexDaoImpl extends AbstractPoloniexDaoImpl {

    private String url;

    public JsonUrlPoloniexDaoImpl(String url) {
        this.url = url;
    }

    @Override
    public void load() throws IOException {
        ObjectMapper mapperRoot = new ObjectMapper();
        Map<String, LinkedHashMap<String, Object>> stringJsonDetailFromPoloniexMap = null;
        stringJsonDetailFromPoloniexMap = mapperRoot.readValue(new URL(url), TreeMap.class);

        constructListJsonPoloniex(stringJsonDetailFromPoloniexMap);
    }
}
