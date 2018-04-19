package mn.travel.marketsurveys.service;

import static com.mongodb.client.model.Filters.eq;

import com.mongodb.DBCursor;
import com.mongodb.client.model.Filters;
import mn.travel.marketsurveys.database.MongoRepository;
import mn.travel.marketsurveys.model.Survey;

import mn.travel.marketsurveys.database.MongoUtils;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class MarketSurveysService {

	private static final String COLLECTION = "surveys";
	
	@Autowired
	private MongoRepository repository;
	private MongoCollection surveys;
	
	@PostConstruct
	public void init() { surveys = repository.getCollection(COLLECTION); }
	
	public Survey registerSurvey(Survey survey) {
		survey.setId(null);
		Survey dbSurvey = findSurveyBySubject(survey.getSubject());
		
		if(dbSurvey == null) {
			surveys.save(survey);
		} else {
			surveys.update(new ObjectId(dbSurvey.getId())).with(survey);
			survey.setId(dbSurvey.getId());
		}
		return survey;
	}

	public Survey findSurvey() {
		return surveys.findOne().as(Survey.class);
	}

    /***
     * Find all survey documents in database
     * @return
     */
    public List<Survey> findSurveys() {
        MongoCursor<Survey> mongoCursor = surveys.find().as(Survey.class);
        List<Survey> surveyList = new ArrayList<>();
        for(Survey s: mongoCursor) {
            surveyList.add(s);
        }
        return surveyList;
    }
	
	public Survey findSurveyById(String id) { return surveys.findOne(new ObjectId(id)).as(Survey.class); }

    /**
     * Retrieves just one random survey
     * @param subject
     * @return
     */
	public Survey findSurveyBySubject(String subject) {
		return surveys.findOne(MongoUtils.filterToString(eq(Survey.SURVEY_SUBJECT, subject))).as(Survey.class);
	}

    /**
     * Retrieves all survey related to a subject
     * @param subject
     * @return
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

	public boolean deleteSurvey(String subject) {
		Survey survey = findSurveyBySubject(subject);
		if (survey != null) {
			surveys.remove(new ObjectId(survey.getId()));
			return true;
		}
		return false;
	}
}
