package easysurvey.dataModel.controllers;


import easysurvey.dataModel.Survey;
import easysurvey.persistence.SurveyService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/survey")
public class SurveyRestController {

    @Autowired
    SurveyService surveyService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getSurveys() {

        Collection<Survey> surveys = surveyService.getAllSurveys();
        return new ResponseEntity<Collection<Survey>>(surveys, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getSurvey(@PathVariable("id") long surveyID) {
	    Survey survey = surveyService.getSurvey(surveyID);
		if (survey == null) { 
		return new ResponseEntity(HttpStatus.NOT_FOUND);
		} 	
		return new ResponseEntity<Survey>(survey, HttpStatus.OK); 
	}

}
