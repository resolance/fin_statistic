package ru.solovev.fin.statistic.stock.exchange.poloniex;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author res
 */

public abstract class AbstractPoloniexDaoImpl implements PoloniexDao {

    protected List<JsonPoloniexObject> poloniexObjectsList;

    protected void constructListJsonPoloniex(
            Map<String, LinkedHashMap<String, Object>> stringJsonDetailFromPoloniexMap) {
        Set<Map.Entry<String, LinkedHashMap<String, Object>>> entries = stringJsonDetailFromPoloniexMap.entrySet();

        Iterator<Map.Entry<String, LinkedHashMap<String, Object>>> iterator = entries.iterator();

        this.poloniexObjectsList = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<String, LinkedHashMap<String, Object>> stringLinkedHashMapEntry = iterator.next();
            final JsonPoloniexObject jsonPoloniexObject = this.createJsonPoloniexObject(
                    stringLinkedHashMapEntry.getKey(), stringLinkedHashMapEntry.getValue()
            );
            this.poloniexObjectsList.add(jsonPoloniexObject);
        }
    }

    protected JsonPoloniexObject createJsonPoloniexObject(String key, LinkedHashMap<String, Object> objectLinkedHashMap) {
        JsonPoloniexObject jsonPoloniexObject = new JsonPoloniexObject();
        jsonPoloniexObject.setCurrency(key);
        jsonPoloniexObject.setBaseVolume(new BigDecimal((String) objectLinkedHashMap.get("baseVolume")));
        jsonPoloniexObject.setHigh24hr(new BigDecimal((String) objectLinkedHashMap.get("high24hr")));
        jsonPoloniexObject.setId(Integer.valueOf(String.valueOf(objectLinkedHashMap.get("id"))));
        jsonPoloniexObject.setHighestBid(new BigDecimal((String) objectLinkedHashMap.get("highestBid")));
        jsonPoloniexObject.setIsFrozen(Integer.valueOf(String.valueOf(objectLinkedHashMap.get("isFrozen"))));
        jsonPoloniexObject.setLast(new BigDecimal((String) objectLinkedHashMap.get("last")));
        jsonPoloniexObject.setLow24hr(new BigDecimal((String) objectLinkedHashMap.get("low24hr")));
        jsonPoloniexObject.setLowestAsk(new BigDecimal((String) objectLinkedHashMap.get("lowestAsk")));
        jsonPoloniexObject.setPercentChange(new BigDecimal((String) objectLinkedHashMap.get("percentChange")));
        jsonPoloniexObject.setQuoteVolume(new BigDecimal((String) objectLinkedHashMap.get("quoteVolume")));
        return jsonPoloniexObject;
    }

    @Override
    public List<JsonPoloniexObject> getPoloniexObjectList() {
        return this.poloniexObjectsList;
    }

    @Override
    public JsonPoloniexObject getTokenName(String nameOfToken) {
        for (JsonPoloniexObject jsonPoloniexObject : poloniexObjectsList) {
            if (nameOfToken.equals(jsonPoloniexObject.getCurrency())) {
                return jsonPoloniexObject;
            }
        }
        return null;
    }
}
