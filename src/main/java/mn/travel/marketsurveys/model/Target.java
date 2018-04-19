package mn.travel.marketsurveys.model;

import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

/**
 * Created by hadrien on 13/04/18.
 */
public class Target {

    @MongoId
    @MongoObjectId
    private String id;
    private Gender gender;
    private int age;
    private Income income;

    public Target() {
    }

    public Target(String id, Gender gender, int age, Income income) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.income = income;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

}
