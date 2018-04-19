package mn.travel.marketsurveys.model;

/**
 * Created by hadrien on 13/04/18.
 */
public enum Gender {

    F("F"), M("M"), Other("Other");

    private String value;

    private Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
