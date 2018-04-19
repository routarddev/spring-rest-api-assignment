package mn.travel.marketsurveys.model;

import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

/**
 *
 */
public class InformationActor {

    @MongoId
    @MongoObjectId
    private String id;
    private String informationActorId;
    private String name;

    public InformationActor() {
    }

    public InformationActor(String id, String informationActorId, String name) {
        this.id = id;
        this.informationActorId = informationActorId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getInformationActorId() {
        return informationActorId;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setInformationActorId(String informationActorId) {
        this.informationActorId = informationActorId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
