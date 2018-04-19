package mn.travel.marketsurveys.model;

import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

import java.util.Currency;

/**
 * Created by hadrien on 13/04/18.
 */
public class Income {

    @MongoId
    @MongoObjectId
    private String id;
    private Currency currency;
    private Range range;

    public Income() {
    }

    public Income(String id, Currency currency, Range range) {
        this.id = id;
        this.currency = currency;
        this.range = range;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }
}
