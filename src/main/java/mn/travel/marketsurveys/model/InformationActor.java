package mn.travel.marketsurveys.model;

/**
 * Created by routarddev on 13/04/18.
 */
public class InformationActor {

    private String informationActorId;
    private String name;

    public InformationActor() {
    }

    public InformationActor(String informationActorId, String name) {
        this.informationActorId = informationActorId;
        this.name = name;
    }

    public String getInformationActorId() {
        return informationActorId;
    }

    public String getName() {
        return name;
    }

    public void setInformationActorId(String informationActorId) {
        this.informationActorId = informationActorId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
