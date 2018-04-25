package mn.travel.marketsurveys.model;

/**
 * Created by routarddev on 13/04/18.
 */
public enum Gender {

    F("F"), M("M"), Other("Other");

    private String genderValue;

    private Gender(String genderValue) {
        this.genderValue = genderValue;
    }

    public String getGenderValue() {
        return genderValue;
    }


}
