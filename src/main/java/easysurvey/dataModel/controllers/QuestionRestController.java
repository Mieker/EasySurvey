package easysurvey.dataModel.controllers;

import easysurvey.dataModel.AnsweredSurvey;
import easysurvey.dataModel.PotentialQuestionAnswer;
import easysurvey.dataModel.Question;
import easysurvey.dataModel.Survey;
import easysurvey.persistence.QuestionService;
import easysurvey.persistence.SurveyService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/question")
public class QuestionRestController {

	@Autowired
    QuestionService questionService;
	Survey survey;
	@RequestMapping(value = "/{questionid}", method = RequestMethod.GET)
	public ResponseEntity<?> getQuestion(@PathVariable("questionid") long questionID) {
	    Question question = questionService.getQuestion(questionID);
		if (question == null) { 
		return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Question>(question, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/{questionid}/potentialquestionanswer", method = RequestMethod.GET)
	public ResponseEntity<?> getPotentialQuestionAnswers(@PathVariable("questionid") long questionID) {
	    Collection<PotentialQuestionAnswer> potentialQuestionAnswers = questionService.getPotentialQuesionAnswers(questionID);
		return new ResponseEntity<Collection<PotentialQuestionAnswer>>(potentialQuestionAnswers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{surveyid}/{intervieweeid}", method = RequestMethod.POST)
	public ResponseEntity<?> submitAnswers(@PathVariable("surveyid") long surveyId, @PathVariable("intervieweeid") long intervieweeId, @RequestBody AnsweredSurvey answeredSurvey) {
	
		try {
			for(int index = 0; index < answeredSurvey.getQuestionIds().size(); index++) {
				questionService.giveQuestionAnswerByIntervieweeId(intervieweeId, surveyId, answeredSurvey.getQuestionIds().get(index), answeredSurvey.getAnswerIds().get(index));
			}
		}
		catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Survey>(survey, HttpStatus.OK); 
	}
}
