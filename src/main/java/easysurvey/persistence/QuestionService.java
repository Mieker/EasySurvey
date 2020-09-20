package easysurvey.persistence;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import easysurvey.dataModel.Interviewee;
import easysurvey.dataModel.Metric;
import easysurvey.dataModel.MetricAnswer;
import easysurvey.dataModel.PotentialMetricAnswer;
import easysurvey.dataModel.PotentialQuestionAnswer;
import easysurvey.dataModel.Question;
import easysurvey.dataModel.QuestionAnswer;
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
    
    public QuestionAnswer giveQuestionAnswerByIntervieweeId(Interviewee interviewee ,Survey survey, Question question, PotentialQuestionAnswer potentialQuestionAnswer )
    {
    	Transaction txn = session.getTransaction();
        txn.begin();
        
    	QuestionAnswer questionAnswer = new QuestionAnswer(survey, question, potentialQuestionAnswer);
        interviewee.getQuestionAnswers().add(questionAnswer);

        session.persist(questionAnswer);
        txn.commit();
        
        return questionAnswer;
    }
    
    public QuestionAnswer giveQuestionAnswerByIntervieweeId(Long intervieweeId ,Long surveyId, Long questionId, Long questionAnswerId ){
        
        Interviewee interviewee = (Interviewee) session.get(Interviewee.class,intervieweeId);
        Survey survey = (Survey) session.get(Survey.class,surveyId);
        Question question = (Question) session.get(Question.class,questionId);
        PotentialQuestionAnswer potentialAnswer = (PotentialQuestionAnswer) session.get(PotentialQuestionAnswer.class,questionAnswerId);
        
        return this.giveQuestionAnswerByIntervieweeId(interviewee, survey, question, potentialAnswer);
        
    }

    public MetricAnswer giveMetricAnswerByIntervieweeId(Interviewee interviewee ,Survey survey, Metric metric, PotentialMetricAnswer potentialMetricAnswer ) {
    	Transaction txn = session.getTransaction();
        txn.begin();
        
        MetricAnswer metricAnswer = new MetricAnswer(survey, metric, potentialMetricAnswer);
        interviewee.getMetricAnswers().add(metricAnswer);

        session.persist(metricAnswer);
        txn.commit();

    	return metricAnswer;
    }
    
    public MetricAnswer giveMetricAnswerByIntervieweeId(Long intervieweeId ,Long surveyId, Long metricId, Long metricAnswerId ){
    	System.out.println(intervieweeId + " " + surveyId + " " + metricId + " " + metricAnswerId);
        Interviewee intervewee = (Interviewee) session.get(Interviewee.class,intervieweeId);
        Survey survey = (Survey) session.get(Survey.class,surveyId);
        Metric metric = (Metric) session.get(Metric.class,metricId);
        PotentialMetricAnswer potentialMetricAnswer = (PotentialMetricAnswer) session.get(PotentialMetricAnswer.class,metricAnswerId);
        
        return this.giveMetricAnswerByIntervieweeId(intervewee, survey, metric, potentialMetricAnswer);
    }
}
