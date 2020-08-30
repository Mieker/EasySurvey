package easysurvey.persistence;

import easysurvey.dataModel.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component("surveyService")
public class SurveyService {

    Session session;
    Survey survey;
    Question question;
    PotentialQuestionAnswer potentialQuestionAnswer;
    Metric metric;
    PotentialMetricAnswer potentialMetricAnswer;
    Interviewee interviewee;
    QuestionAnswer questionAnswer;
    MetricAnswer metricAnswer;

    public SurveyService() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void close() {
        session.close();
        HibernateUtil.shutdown();
    }


    public void createSurvey(){
        survey = addNewSurvey("badanie kolegow","www.easysurvey.com","www.easysurvey.edit.com",LocalDate.of(2019,8,30),LocalDate.of(2025,8,30),true);

        Question question1 = createQuestion(survey.getId(),"jak lubisz kolor?");
        PotentialQuestionAnswer pqa1 = addPotentialQuestionAnswer(question.getId(),"zielony");
        PotentialQuestionAnswer pqa2 = addPotentialQuestionAnswer(question.getId(),"czarny");
        PotentialQuestionAnswer pqa3 = addPotentialQuestionAnswer(question.getId(),"niebieski");

        Question question2 = createQuestion(survey.getId(),"dokad chcialbys pojechac na wakacje?");
        PotentialQuestionAnswer pqa4 = addPotentialQuestionAnswer(question.getId(),"USA");
        PotentialQuestionAnswer pqa5 = addPotentialQuestionAnswer(question.getId(),"Indonezja");
        PotentialQuestionAnswer pqa6 = addPotentialQuestionAnswer(question.getId(),"Australia");
        PotentialQuestionAnswer pqa7 = addPotentialQuestionAnswer(question.getId(),"Chile");

        Metric metric1 = createMetric(survey.getId(),"podaj przedial wiekowy?");
        PotentialMetricAnswer pma1 = addPotentialMetricAnswer(metric.getId(),"20-30");
        PotentialMetricAnswer pma2 = addPotentialMetricAnswer(metric.getId(),"31-40");
        PotentialMetricAnswer pma3 = addPotentialMetricAnswer(metric.getId(),"41-50");
        PotentialMetricAnswer pma4 = addPotentialMetricAnswer(metric.getId(),"51-100");

        Metric metric2 = createMetric(survey.getId(), "i ilu krajach juz bylem?");
        PotentialMetricAnswer pma5 = addPotentialMetricAnswer(metric.getId(),"1-10");
        PotentialMetricAnswer pma6 = addPotentialMetricAnswer(metric.getId(),"11-20");
        PotentialMetricAnswer pma7 = addPotentialMetricAnswer(metric.getId(),"21-50");
        PotentialMetricAnswer pma8 = addPotentialMetricAnswer(metric.getId(),"50-299");

        Interviewee interviewee1 = addNewInterviewee("MichalJ");
        giveMetricAnswerByIntervieweeId(interviewee1, survey, metric1, pma2);
        giveMetricAnswerByIntervieweeId(interviewee1, survey, metric2, pma8);
        giveQuestionAnswerByIntervieweeId(interviewee1, survey, question1, pqa2);
        giveQuestionAnswerByIntervieweeId(interviewee1, survey, question2, pqa7);

        Interviewee interviewee2 = addNewInterviewee("Marco01");
        giveMetricAnswerByIntervieweeId(interviewee2, survey, metric1, pma1);
        giveMetricAnswerByIntervieweeId(interviewee2, survey, metric2, pma7);
        giveQuestionAnswerByIntervieweeId(interviewee2, survey, question1, pqa2);
        giveQuestionAnswerByIntervieweeId(interviewee2, survey, question2, pqa6);

        Interviewee interviewee3 = addNewInterviewee("Pawel01");
        giveMetricAnswerByIntervieweeId(interviewee3, survey, metric1, pma3);
        giveMetricAnswerByIntervieweeId(interviewee3, survey, metric2, pma6);
        giveQuestionAnswerByIntervieweeId(interviewee3, survey, question1, pqa3);
        giveQuestionAnswerByIntervieweeId(interviewee3, survey, question2, pqa5);
        
    }

    public Interviewee addNewInterviewee(String nickName){
        Transaction txn = session.getTransaction();
        txn.begin();

        interviewee = new Interviewee(nickName);

        session.persist(interviewee);
        txn.commit();
        return interviewee;
    }

    public QuestionAnswer giveQuestionAnswerByIntervieweeId(Interviewee interviewee ,Survey survey, Question question, PotentialQuestionAnswer potentialQuestionAnswer )
    {
    	Transaction txn = session.getTransaction();
        txn.begin();
        
    	questionAnswer = new QuestionAnswer(survey, question, potentialQuestionAnswer);
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
        
        metricAnswer = new MetricAnswer(survey, metric, potentialMetricAnswer);
        interviewee.getMetricAnswers().add(metricAnswer);

        session.persist(metricAnswer);
        txn.commit();

    	return metricAnswer;
    }
    
    public MetricAnswer giveMetricAnswerByIntervieweeId(Long intervieweeId ,Long surveyId, Long metricId, Long metricAnswerId ){
       
        Interviewee intervewee = (Interviewee) session.get(Interviewee.class,intervieweeId);
        Survey survey = (Survey) session.get(Survey.class,surveyId);
        Metric metric = (Metric) session.get(Metric.class,metricId);
        PotentialMetricAnswer potentialMetricAnswer = (PotentialMetricAnswer) session.get(PotentialMetricAnswer.class,metricAnswerId);
        
        return this.giveMetricAnswerByIntervieweeId(intervewee, survey, metric, potentialMetricAnswer);
    }

    public Survey addNewSurvey(String description, String surveyLink, String editLink, LocalDate startDate, LocalDate endDate, boolean isOpen){
        Transaction txn = session.getTransaction();
        txn.begin();

        survey = new Survey(description, surveyLink, editLink, startDate, endDate, isOpen);

        session.persist(survey);
        txn.commit();
        return survey;
    }

    public Question createQuestion(Long surveyId, String questionText){
        Transaction txn = session.getTransaction();
        txn.begin();

        Survey findSurveyById = (Survey) session.get(Survey.class,surveyId);
        question = new Question(questionText);
        findSurveyById.getQuestions().add(question);

        session.persist(question);
        txn.commit();
        
        return question;
    }

    public PotentialQuestionAnswer addPotentialQuestionAnswer(Long questionId, String potentialQuestionAnswerText){
        Transaction txn = session.getTransaction();
        txn.begin();

        Question findQuestionById = (Question) session.get(Question.class,questionId);
        potentialQuestionAnswer = new PotentialQuestionAnswer(potentialQuestionAnswerText);
        findQuestionById.getPotentialQuestionAnswers().add(potentialQuestionAnswer);

        session.persist(potentialQuestionAnswer);
        txn.commit();
        
        return potentialQuestionAnswer;
    }

    public Metric createMetric(Long surveyId, String metricText){
        Transaction txn = session.getTransaction();
        txn.begin();

        Survey findSurveyById = (Survey) session.get(Survey.class,surveyId);
        metric = new Metric(metricText);
        findSurveyById.getMetrics().add(metric);

        session.persist(metric);
        txn.commit();
        
        return metric;
    }

    public PotentialMetricAnswer addPotentialMetricAnswer(Long metricId, String potentialMetricAnswerText){
        Transaction txn = session.getTransaction();
        txn.begin();

        Metric findMetricById = (Metric) session.get(Metric.class,metricId);
        potentialMetricAnswer = new PotentialMetricAnswer(potentialMetricAnswerText);
        findMetricById.getPotentialMetricAnswers().add(potentialMetricAnswer);

        session.persist(potentialMetricAnswer);
        txn.commit();
        
        return potentialMetricAnswer;
    }
    
    public Collection<Survey> getAllSurveys(){
    	Collection<Survey> surveys = session.createCriteria(Survey.class).list();
        return surveys;
    }
    
    public Survey getSurvey(Long surveyID) {
    	return (Survey) session.get(Survey.class, surveyID);
    }

    public Collection<Interviewee> getAllInterviewees(){
//        String hql = "SELECT Interviewee.nickName FROM Interviewee";
//        Query query = session.createQuery(hql);
//        List results = query.list();
//        return results;
        Collection<Interviewee> interviewees = session.createCriteria(Interviewee.class).list();
        return interviewees;
    }

    public  List<Interviewee> statCalculation(){

        String hql = "FROM Interviewee ";
        Query query = session.createQuery(hql);
        List<Interviewee> results = query.list();
        return results;
    }

    public long statAnswers(long questionId, long questionAnswerId){

        Query query2 = session.createQuery("select count(q) from QuestionAnswer q where q.question='" + questionId + "' and q.questionAnswer='" + questionAnswerId +"'");

        Long interCount2 = (Long) query2.uniqueResult();
        //List<Interviewee> results = query.list();
        //System.out.println("ilosc interwiwes to " + interCount2);
        return interCount2;

    }

    public long countInterviewee() {
        String hql = "select count(s) from Interviewee s";
        Query query = session.createQuery(hql);
        Long interCount = (Long) query.uniqueResult();
        return interCount;
    }


}

