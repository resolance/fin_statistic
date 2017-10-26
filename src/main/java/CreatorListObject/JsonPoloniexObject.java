package CreatorListObject;

import java.math.BigDecimal;

public class JsonPoloniexObject {
    private String currency;
    public int id;
    private BigDecimal last;
    private BigDecimal lowestAsk;
    private BigDecimal highestBid;
    private BigDecimal percentChange;
    private BigDecimal baseVolume;
    private BigDecimal quoteVolume;
    private int isFrozen;
    private BigDecimal high24hr;
    private BigDecimal low24hr;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(BigDecimal lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public BigDecimal getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(BigDecimal highestBid) {
        this.highestBid = highestBid;
    }

    public BigDecimal getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(BigDecimal percentChange) {
        this.percentChange = percentChange;
    }

    public BigDecimal getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(BigDecimal baseVolume) {
        this.baseVolume = baseVolume;
    }

    public BigDecimal getQuoteVolume() {
        return quoteVolume;
    }

    public void setQuoteVolume(BigDecimal quoteVolume) {
        this.quoteVolume = quoteVolume;
    }

    public int getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(int isFrozen) {
        this.isFrozen = isFrozen;
    }

    public BigDecimal getHigh24hr() {
        return high24hr;
    }

    public void setHigh24hr(BigDecimal high24hr) {
        this.high24hr = high24hr;
    }

    public BigDecimal getLow24hr() {
        return low24hr;
    }

    public void setLow24hr(BigDecimal low24hr) {
        this.low24hr = low24hr;
    }

    @Override
    public String toString() {
        return
                "\ncurrency: " + currency +
                        "\n\tid: " + id +
                        "\n\tlast: " + last.toPlainString() +
                        "\n\tlowestAsk: " + lowestAsk.toPlainString() +
                        "\n\thighestBid: " + highestBid.toPlainString() +
                        "\n\tpercentChange " + percentChange +
                        "\n\tbaseVolume: " + baseVolume +
                        "\n\tquoteVolume: " + quoteVolume +
                        "\n\tisFrozen: " + isFrozen +
                        "\n\thigh24hr: " + high24hr.toPlainString() +
                        "\n\tlow24hr: " + low24hr.toPlainString();
    }

}
