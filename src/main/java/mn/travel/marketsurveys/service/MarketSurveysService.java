package mn.travel.marketsurveys.service;

import mn.travel.marketsurveys.database.MongoRepository;
import mn.travel.marketsurveys.database.MongoUtils;
import mn.travel.marketsurveys.model.Survey;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * Created by routarddev on 13/04/18.
 */
@Component
public class MarketSurveysService {

	private static final String COLLECTION = "surveys";
	
	@Autowired
	private MongoRepository repository;
	private MongoCollection surveys;
	
	@PostConstruct
	public void init() { surveys = repository.getCollection(COLLECTION); }

	/**
	 * Create a new survey if it doesn't exist or modify if it does
	 * @param survey to be created and persisted to the database
	 * @return
	 */
	public Survey registerSurvey(Survey survey) {

		if (survey.getId() != null) {
			Survey dbSurvey = findSurveyById(survey.getId());
			if(dbSurvey == null) {
				survey.setId(null);
				surveys.save(survey);
			} else {
				surveys.update(new ObjectId(dbSurvey.getId())).with(survey);
				survey.setId(dbSurvey.getId());
			}
		} else {
			surveys.save(survey);
		}

		return survey;
	}

	/**
	 * Retrieve one random survey
	 * @return one survey
	 */
	public Survey findSurvey() {
		return surveys.findOne().as(Survey.class);
	}

    /***
     * Find all survey documents in database
     * @return list of survey in the database
     */
    public List<Survey> findSurveys() {
        MongoCursor<Survey> mongoCursor = surveys.find().as(Survey.class);
        List<Survey> surveyList = new ArrayList<>();
        for(Survey s: mongoCursor) {
            surveyList.add(s);
        }
        return surveyList;
    }


	/**
	 * Find a survey by its id
	 * @param id unique survey identifier
	 * @return the survey
	 */
	public Survey findSurveyById(String id) {
    	return surveys.findOne(new ObjectId(id)).as(Survey.class);
    }


    /**
     * Retrieves just one random survey by subject
     * @param subject to find for
     * @return one survey related to this subject
     */
	public Survey findOneRandomSurveyBySubject(String subject) {
		return surveys.findOne(MongoUtils.filterToString(eq(Survey.SURVEY_SUBJECT, subject))).as(Survey.class);
	}

    /**
     * Retrieves all survey related to a subject
     * @param subject to find for
     * @return list of surveys that contain or match the incoming subject word
     */
    public List<Survey> findSurveysBySubject(String subject) {
        String query = "{" + Survey.SURVEY_SUBJECT + ": {$regex: '.*" + subject + ".*'}}";
        MongoCursor<Survey> mongoCursor = surveys.find(query).as(Survey.class);
        List<Survey> surveyList = new ArrayList<>();
        for(Survey s: mongoCursor) {
            surveyList.add(s);
        }
        return surveyList;
	}


	/**
	 * Delete survey found by its ID.
	 * This method is only for test purposes. Should not be exposed.
	 * @param surveyId survey unique identifier
	 * @return true if the survey has been found (and deleted), false if it doesn't exist
	 */
	public boolean deleteSurvey(String surveyId) {
		Survey survey = findSurveyById(surveyId);
		if (survey != null) {
			surveys.remove(new ObjectId(survey.getId()));
			return true;
		}
		return false;
	}
}
