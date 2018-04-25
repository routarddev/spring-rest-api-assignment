package mn.travel.marketsurveys.model;


/**
 * Created by routarddev on 13/04/18.
 */
public class Income {

    private String currency;
    private Range range;

    public Income() {
    }

    public Income(String currency, Range range) {
        this.currency = currency;
        this.range = range;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }
}
