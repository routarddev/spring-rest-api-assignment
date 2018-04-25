package mn.travel.marketsurveys.model;

/**
 * Created by routarddev on 13/04/18.
 */
public class Target {

    private Gender gender;
    private int age;
    private Income income;

    public Target() {
    }

    public Target(Gender gender, int age, Income income) {
        this.gender = gender;
        this.age = age;
        this.income = income;
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
