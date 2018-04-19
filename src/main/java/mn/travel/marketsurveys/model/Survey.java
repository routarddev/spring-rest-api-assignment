package mn.travel.marketsurveys.model;

import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

public class Survey {
	
	public static final String SURVEY_SUBJECT = "subject";
	
	@MongoId
	@MongoObjectId
	private String id;
	private String subject;
	private Target target;
	//private Country country;
	//private String target;
	private String country;

	public Survey() {}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public Survey(String id, String subject, Target target, String country) {
		this.id = id;
		this.subject = subject;
		this.target = target;
		this.country = country;
	}


	public static String getSurveySubject() {
		return SURVEY_SUBJECT;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	/*
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	*/
}
