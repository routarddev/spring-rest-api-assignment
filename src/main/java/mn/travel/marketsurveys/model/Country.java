package mn.travel.marketsurveys.model;

/**
 * Created by routarddev on 13/04/18.
 */
public class Country {

    private String countryCode;

    public Country() {}

    public Country(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
