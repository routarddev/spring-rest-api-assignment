package mn.travel.marketsurveys.controller;

import mn.travel.marketsurveys.config.MarketSurveysApplication;
import mn.travel.marketsurveys.model.Survey;
import mn.travel.marketsurveys.service.MarketSurveysService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = MarketSurveysApplication.API_V1, produces = MediaType.APPLICATION_JSON_VALUE)
public class MarketSurveysController {
	
	public static final String ENDPOINT = "surveys";
	
	@Autowired
	private MarketSurveysService service;

	@ApiOperation(value = "Register a new survey", nickname = "Register a new survey",
			notes = "Endpoint to register a new survey. If the survey already exists, the info will be updated"
					+ " with the submitted data.")
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpEntity<Survey> registerSurvey(final @Validated @RequestBody Survey survey) {
		return new ResponseEntity<>(service.registerSurvey(survey), HttpStatus.OK);
	}

	@ApiOperation(value = "Find surveys", nickname = "Find surveys",
			notes = "It will retrieve all markets surveys")
	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
	@ResponseBody
	public HttpEntity<List<Survey>> getSurveys() {

		List<Survey> listOfSurveys = service.findSurveys();
		return new ResponseEntity<>(listOfSurveys, listOfSurveys != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@ApiOperation(value = "Get surveys by subject", nickname = "Get surveys by subject",
			notes = "It will retrieve a list of surveys related to a subject")
	@RequestMapping(value = ENDPOINT + "/{subject}", method = RequestMethod.GET)
	@ResponseBody
	public HttpEntity<List<Survey>> getSurveysBySubject(@PathVariable String subject) {
		List<Survey> listOfSurveys = service.findSurveysBySubject(subject);
		return new ResponseEntity<>(listOfSurveys, listOfSurveys != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}


	@ApiOperation(value = "Get survey details", nickname = "Get survey details",
			notes = "It will retrieve the specified survey details")
	@RequestMapping(value = ENDPOINT + "/{subject}/{id}", method = RequestMethod.GET)
	@ResponseBody
	public HttpEntity<Survey> getSurveyDetails(@PathVariable String subject, @PathVariable String id) {
		Survey survey = service.findSurveyBySubject(id);
		return new ResponseEntity<>(survey, survey != null ? HttpStatus.OK: HttpStatus.NOT_FOUND);
	}

	@ApiOperation(value = "Delete the specified survey", nickname = "Delete the specified survey",
			notes = "It will delete the survey specified in the request.")
	@RequestMapping(value = ENDPOINT + "/{subject}", method = RequestMethod.DELETE)
	@ResponseBody
	public HttpEntity<Void> deleteSurvey(@PathVariable String subject) {
		return new ResponseEntity<>(service.deleteSurvey(subject) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
}