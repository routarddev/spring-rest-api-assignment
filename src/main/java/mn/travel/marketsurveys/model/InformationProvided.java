package mn.travel.marketsurveys.model;

import org.jongo.marshall.jackson.oid.MongoObjectId;

/**
 * Created by hadrien on 23/04/18.
 */
public class InformationProvided {

    @MongoObjectId
    private String _id;
    private InformationActor informationRequester;
    private InformationActor informationProvider;
    private Survey survey;

    public InformationProvided() {}

    public InformationProvided(InformationActor informationRequester, InformationActor informationProvider, Survey survey) {
        this.informationRequester = informationRequester;
        this.informationProvider = informationProvider;
        this.survey = survey;
    }

    public InformationActor getInformationRequester() {
        return informationRequester;
    }

    public void setInformationRequester(InformationActor informationRequester) {
        this.informationRequester = informationRequester;
    }

    public InformationActor getInformationProvider() {
        return informationProvider;
    }

    public void setInformationProvider(InformationActor informationProvider) {
        this.informationProvider = informationProvider;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
}
