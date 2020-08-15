package easysurvey.persistence;

import java.util.Collection;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import easysurvey.dataModel.PotentialQuestionAnswer;
import easysurvey.dataModel.Question;
import easysurvey.dataModel.Survey;

@Component("questionService")
public class QuestionService {
	
	Session session;
	@Autowired
    SurveyService surveyService;
	
	public QuestionService() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void close() {
        session.close();
        HibernateUtil.shutdown();
    }
	
	public Collection<Question> getQuestions(Long surveyID) {
		return surveyService.getSurvey(surveyID).getQuestions();
	}
    
    public Collection<Question> getQuestions(Survey survey) {
		return survey.getQuestions();
	}
    
    public Question getQuestion(Long questionID) {
    	return (Question) session.get(Question.class, questionID);
	}
    
    public Collection<PotentialQuestionAnswer> getPotentialQuesionAnswers(Long questionID){
    	return this.getQuestion(questionID).getPotentialQuestionAnswers();
    }
    
    public Collection<PotentialQuestionAnswer> getPotentialQuesionAnswers(Question question){
    	return question.getPotentialQuestionAnswers();
    }
}
