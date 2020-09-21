package easysurvey.dataModel.controllers;

import easysurvey.dataModel.Question;
import easysurvey.dataModel.Survey;
import easysurvey.persistence.QuestionService;
import easysurvey.persistence.SurveyService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/survey")
public class SurveyRestController {

    @Autowired
    SurveyService surveyService;
    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getSurveys() {
        Collection<Survey> surveys = surveyService.getAllSurveys();
        return new ResponseEntity<Collection<Survey>>(surveys, HttpStatus.OK);
    }

    @RequestMapping(value = "/{surveyid}", method = RequestMethod.GET)
    public ResponseEntity<?> getSurvey(@PathVariable("surveyid") long surveyID) {
        Survey survey = surveyService.getSurvey(surveyID);
        if (survey == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Survey>(survey, HttpStatus.OK);
    }

    @RequestMapping(value = "/{surveyid}/questions", method = RequestMethod.GET)
    public ResponseEntity<?> getQuestions(@PathVariable("surveyid") long surveyID) {
        Collection<Question> questions = questionService.getQuestions(surveyID);
        return new ResponseEntity<Collection<Question>>(questions, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createSurvey(@RequestBody Survey survey) {
        
        surveyService.createNewSurvey(survey);
        
        return new ResponseEntity<Survey>(survey, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/latest", method = RequestMethod.GET)
    public ResponseEntity<?> getLatestSurveys() {
        Collection<Survey> latestSurveys = surveyService.getLatestSurveys();
        return new ResponseEntity<Collection<Survey>>(latestSurveys, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/most_popular", method = RequestMethod.GET)
    public ResponseEntity<?> getMostPopularSurveys() {
        Collection<Survey> mostPopularSurveys = surveyService.getMostPopularSurveys();
        return new ResponseEntity<Collection<Survey>>(mostPopularSurveys, HttpStatus.OK);
    }
}
