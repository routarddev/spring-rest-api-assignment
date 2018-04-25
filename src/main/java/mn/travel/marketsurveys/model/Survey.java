package mn.travel.marketsurveys.model;

import org.jongo.marshall.jackson.oid.MongoObjectId;

/**
 * Created by routarddev on 13/04/18.
 */
public class Survey {
	
	public static final String SURVEY_SUBJECT = "subject";

    @MongoObjectId
    private String _id;
	private String subject;
	private Target target;
	private Country country;


	public Survey() {}

	public Survey(String subject, Target target, Country country) {
		this.subject = subject;
		this.target = target;
		this.country = country;
	}

	public static String getSurveySubject() {
		return SURVEY_SUBJECT;
	}

	public String getId() {
		return _id;
	}
	public void setId(String id) { this._id = id; }

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}


	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
