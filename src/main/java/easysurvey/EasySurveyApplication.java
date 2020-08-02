package easysurvey;

import easysurvey.dataModel.*;
import easysurvey.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasySurveyApplication {

	Session session;
	Survey survey;
	Question question;
	PotentialQuestionAnswer potentialQuestionAnswer;
	Metric metric;
	PotentialMetricAnswer potentialMetricAnswer;
	Interviewee interviewee;
	Answer answer;

	public static void main(String[] args) {
		//SpringApplication.run(EasySurveyApplication.class, args);
		EasySurveyApplication easySurveyApplication = new EasySurveyApplication();
		easySurveyApplication.run();
		easySurveyApplication.close();
	}

	public EasySurveyApplication() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void close() {
		session.close();
		HibernateUtil.shutdown();
	}

	public void run(){
		createSurvey();
		fillUpSurvey();
	}

	public void createSurvey(){
		addNewSurvey("badanie kolegow");

		createQuestion(1L,"jak lubisz kolor?");
		addPotentialQuestionAnswer(1L,"zielony");
		addPotentialQuestionAnswer(1L,"czarny");
		addPotentialQuestionAnswer(1L,"niebieski");

		createMetric(1L,"podaj przedial wiekowy?");
		addPotentialMetricAnswer(1L,"20-30");
		addPotentialMetricAnswer(1L,"31-40");
		addPotentialMetricAnswer(1L,"41-50");
		addPotentialMetricAnswer(1L,"51-100");

		createQuestion(1L,"dokad chcialbys pojechac na wakacje?");
		addPotentialQuestionAnswer(2L,"USA");
		addPotentialQuestionAnswer(2L,"Indonezja");
		addPotentialQuestionAnswer(2L,"Australia");
		addPotentialQuestionAnswer(2L,"Chile");

		createMetric(1L, "i ilu krajach juz bylem?");
		addPotentialMetricAnswer(2L,"1-10");
		addPotentialMetricAnswer(2L,"11-20");
		addPotentialMetricAnswer(2L,"21-50");
		addPotentialMetricAnswer(2L,"50-299");
	}

	public void fillUpSurvey(){
		addNewInterviewee("Marco01");
		giveQuestionAnswerByIntervieweeId(1L,1L,1L,1L);
		giveMetricAnswerByIntervieweeId(1L,1L,2L,7L);


	}


	public void addNewInterviewee(String nickName){
		Transaction txn = session.getTransaction();
		txn.begin();

		interviewee = new Interviewee(nickName);

		session.persist(interviewee);
		txn.commit();
	}

	public void giveQuestionAnswerByIntervieweeId(Long intervieweeId ,Long surveyId, Long questionId, Long potentialQuestionAnswerId ){
		Transaction txn = session.getTransaction();
		txn.begin();

		Interviewee findIntervieweeById = (Interviewee) session.get(Interviewee.class,intervieweeId);
		Survey findSurveyById = (Survey) session.get(Survey.class,surveyId);
		Question findQuestionById = (Question) session.get(Question.class,questionId);
		PotentialQuestionAnswer findPotentialQuestionAnswerById = (PotentialQuestionAnswer) session.get(PotentialQuestionAnswer.class,potentialQuestionAnswerId);

		answer = new Answer(findSurveyById,findQuestionById,findPotentialQuestionAnswerById);
		findIntervieweeById.getAnswers().add(answer);

		session.persist(answer);
		txn.commit();
	}

	public void giveMetricAnswerByIntervieweeId(Long intervieweeId ,Long surveyId, Long metricId, Long potentialMetricAnswerId ){
		Transaction txn = session.getTransaction();
		txn.begin();

		Interviewee findIntervieweeById = (Interviewee) session.get(Interviewee.class,intervieweeId);
		Survey findSurveyById = (Survey) session.get(Survey.class,surveyId);
		Metric findMetricById = (Metric) session.get(Metric.class,metricId);
		PotentialMetricAnswer findPotentialMetricAnswerById = (PotentialMetricAnswer) session.get(PotentialMetricAnswer.class,potentialMetricAnswerId);

		answer = new Answer(findSurveyById,findMetricById,findPotentialMetricAnswerById);
		findIntervieweeById.getAnswers().add(answer);

		session.persist(answer);
		txn.commit();
	}

	public void addNewSurvey(String surveyName){
		Transaction txn = session.getTransaction();
		txn.begin();

		survey = new Survey(surveyName);

		session.persist(survey);
		txn.commit();
	}


	public void createQuestion(Long surveyId, String questionText){
		Transaction txn = session.getTransaction();
		txn.begin();

		Survey findSurveyById = (Survey) session.get(Survey.class,surveyId);
		question = new Question(questionText);
		findSurveyById.getQuestions().add(question);

		session.persist(question);
		txn.commit();
	}

	public void addPotentialQuestionAnswer(Long questionId, String potentialQuestionAnswerText){
		Transaction txn = session.getTransaction();
		txn.begin();

		Question findQuestionById = (Question) session.get(Question.class,questionId);
		potentialQuestionAnswer = new PotentialQuestionAnswer(potentialQuestionAnswerText);
		findQuestionById.getPotentialQuestionAnswers().add(potentialQuestionAnswer);

		session.persist(potentialQuestionAnswer);
		txn.commit();
	}

	public void createMetric(Long surveyId, String metricText){
		Transaction txn = session.getTransaction();
		txn.begin();

		Survey findSurveyById = (Survey) session.get(Survey.class,surveyId);
		metric = new Metric(metricText);
		findSurveyById.getMetrics().add(metric);

		session.persist(metric);
		txn.commit();
	}

	public void addPotentialMetricAnswer(Long metricId, String potentialMetricAnswerText){
		Transaction txn = session.getTransaction();
		txn.begin();

		Metric findMetricById = (Metric) session.get(Metric.class,metricId);
		potentialMetricAnswer = new PotentialMetricAnswer(potentialMetricAnswerText);
		findMetricById.getPotentialMetricAnswers().add(potentialMetricAnswer);

		session.persist(potentialMetricAnswer);
		txn.commit();
	}






	public void runDEMO(){

		Transaction txn = session.getTransaction();

		txn.begin();

			//tworzenie ankiety

			Survey survey1 = new Survey("Badanie gustu kolegów");

			Question question1 = new Question("Jaki lubisz kolor?");
			PotentialQuestionAnswer potentialQuestionAnswer1 = new PotentialQuestionAnswer("Czarny");
			PotentialQuestionAnswer potentialQuestionAnswer2 = new PotentialQuestionAnswer("Czerwony");
			PotentialQuestionAnswer potentialQuestionAnswer3 = new PotentialQuestionAnswer("Niebieski");
			question1.getPotentialQuestionAnswers().add(potentialQuestionAnswer1);
			question1.getPotentialQuestionAnswers().add(potentialQuestionAnswer2);
			question1.getPotentialQuestionAnswers().add(potentialQuestionAnswer3);
			survey1.getQuestions().add(question1);

			Question question2 = new Question("gdzie chcialbys pojechac na wakacje?");
			PotentialQuestionAnswer potentialQuestionAnswer4 = new PotentialQuestionAnswer("USA");
			PotentialQuestionAnswer potentialQuestionAnswer5 = new PotentialQuestionAnswer("Indonezja");
			PotentialQuestionAnswer potentialQuestionAnswer6 = new PotentialQuestionAnswer("Zanzibar");
			question2.getPotentialQuestionAnswers().add(potentialQuestionAnswer4);
			question2.getPotentialQuestionAnswers().add(potentialQuestionAnswer5);
			question2.getPotentialQuestionAnswers().add(potentialQuestionAnswer6);
			survey1.getQuestions().add(question2);

			Metric metric1 = new Metric("podaj przedzial wiekowy?");
			PotentialMetricAnswer potentialMetricAnswer1 = new PotentialMetricAnswer("18-30");
			PotentialMetricAnswer potentialMetricAnswer2 = new PotentialMetricAnswer("31-45");
			PotentialMetricAnswer potentialMetricAnswer3 = new PotentialMetricAnswer("46-90");
			metric1.getPotentialMetricAnswers().add(potentialMetricAnswer1);
			metric1.getPotentialMetricAnswers().add(potentialMetricAnswer2);
			metric1.getPotentialMetricAnswers().add(potentialMetricAnswer3);
			survey1.getMetrics().add(metric1);

			Metric metric2 = new Metric("gdzie mieszkasz?");
			PotentialMetricAnswer potentialMetricAnswer4 = new PotentialMetricAnswer("Krakow");
			PotentialMetricAnswer potentialMetricAnswer5 = new PotentialMetricAnswer("Szczecin");
			PotentialMetricAnswer potentialMetricAnswer6 = new PotentialMetricAnswer("Poznan");
			metric2.getPotentialMetricAnswers().add(potentialMetricAnswer4);
			metric2.getPotentialMetricAnswers().add(potentialMetricAnswer5);
			metric2.getPotentialMetricAnswers().add(potentialMetricAnswer6);
			survey1.getMetrics().add(metric2);



			//wypelnianie ankiety user1
			Interviewee interviewee1 = new Interviewee("Marco01");

			Answer answer1 = new Answer(survey1,question1,potentialQuestionAnswer1);
			interviewee1.getAnswers().add(answer1);
			Answer answer2 = new Answer(survey1,question2,potentialQuestionAnswer5);
			interviewee1.getAnswers().add(answer2);

			Answer metricAnswer1 = new Answer(survey1, metric1,potentialMetricAnswer2);
			interviewee1.getAnswers().add(metricAnswer1);
			Answer metricAnswer2 = new Answer(survey1, metric2,potentialMetricAnswer6);
			interviewee1.getAnswers().add(metricAnswer2);

			//wypelnianie ankiety user2

			Interviewee interviewee2 = new Interviewee("Rzezimieszek01");

			Answer answer3 = new Answer(survey1,question1,potentialQuestionAnswer2);
			interviewee2.getAnswers().add(answer3);
			Answer answer4 = new Answer(survey1,question2,potentialQuestionAnswer4);
			interviewee2.getAnswers().add(answer4);

			Answer metricAnswer3 = new Answer(survey1, metric1,potentialMetricAnswer3);
			interviewee2.getAnswers().add(metricAnswer3);
			Answer metricAnswer4 = new Answer(survey1, metric2,potentialMetricAnswer5);
			interviewee2.getAnswers().add(metricAnswer4);


			session.persist(survey1);
			session.persist(question1);
			session.persist(question2);
			session.persist(metric1);
			session.persist(metric2);

			session.persist(interviewee1);
			session.persist(answer1);
			session.persist(answer2);
			session.persist(metricAnswer1);
			session.persist(metricAnswer2);

			session.persist(interviewee2);
			session.persist(answer3);
			session.persist(answer4);
			session.persist(metricAnswer3);
			session.persist(metricAnswer4);

			txn.commit();

	}
}
