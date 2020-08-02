package easysurvey;

import easysurvey.dataModel.*;
import easysurvey.persistence.HibernateUtil;
import org.apache.tomcat.jni.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasySurveyApplication {

	Session session;

	public static void main(String[] args) {
		//SpringApplication.run(EasySurveyApplication.class, args);
		EasySurveyApplication easySurveyApplication = new EasySurveyApplication();
		//easySurveyApplication.demo();
		easySurveyApplication.demo2();
		easySurveyApplication.close();
	}

	public EasySurveyApplication() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void close() {
		session.close();
		HibernateUtil.shutdown();
	}


//	private void demo(){
//
//		Transaction transaction = session.beginTransaction();
//
//		//dane wymagane przy uzupelnianiu ankiety
//
//		Survey survey1 = new Survey();
//		survey1.setDescription("Badanie 1");
//		survey1.setEditLink("1");
//		survey1.setEndDate(null);
//		survey1.setIsOpen(true);
//		survey1.setStartDate(null);
//		survey1.setSurveyLink("xxx");
//		session.save(survey1);
//
//		Question question1 = new Question();
//		question1.setQuestionText("wybierz swoj ulubiony kolor");
//		survey1.addQuestion(question1);
//		session.save(question1);
//
//		PotentialQuestionAnswer OA1 = new PotentialQuestionAnswer();
//		OA1.setAnswerText("Zielony");
//		question1.addOfferedAnswer(OA1);
//		PotentialQuestionAnswer OA2 = new PotentialQuestionAnswer();
//		OA2.setAnswerText("Niebieski");
//		question1.addOfferedAnswer(OA2);
//		PotentialQuestionAnswer OA3 = new PotentialQuestionAnswer();
//		OA3.setAnswerText("Czarny");
//		question1.addOfferedAnswer(OA3);
//		PotentialQuestionAnswer OA4 = new PotentialQuestionAnswer();
//		OA4.setAnswerText("Czerwony");
//		question1.addOfferedAnswer(OA4);
//
//		Question question2 = new Question();
//		question2.setQuestionText("gdzie wolalbys pojechac na wakacje");
//		survey1.addQuestion(question2);
//		session.save(question2);
//
//		PotentialQuestionAnswer OA21 = new PotentialQuestionAnswer();
//		OA21.setAnswerText("Tajlandia");
//		question2.addOfferedAnswer(OA21);
//		PotentialQuestionAnswer OA22 = new PotentialQuestionAnswer();
//		OA22.setAnswerText("Meksyk");
//		question2.addOfferedAnswer(OA22);
//		PotentialQuestionAnswer OA23 = new PotentialQuestionAnswer();
//		OA23.setAnswerText("USA");
//		question2.addOfferedAnswer(OA23);
//		PotentialQuestionAnswer OA24 = new PotentialQuestionAnswer();
//		OA24.setAnswerText("Australia");
//		question2.addOfferedAnswer(OA24);
//
//		Metric metric1 = new Metric();
//		metric1.setFieldName("miejsce zamieszkania");
//		metric1.setFieldType("String");
//		survey1.addMetrics(metric1);
//		session.save(metric1);
//
//
//		Metric metric2 = new Metric();
//		metric2.setFieldName("wiek");
//		metric2.setFieldType("String");
//		survey1.addMetrics(metric2);
//		session.save(metric2);
//
//
//		//dane uzupelniane przez aknietowanego
//
//		Interviewee interviewee1 = new Interviewee();
//		interviewee1.setNickName("mike86");
//		survey1.addInterwiee(interviewee1);
//		interviewee1.addSurvey(survey1);
//
//		session.save(interviewee1);
//
//		metric1.setFieldValue("krakow");
//		session.update(metric1);
//		metric2.setFieldValue("34");
//		session.update(metric2);
//
//		Answer a1 = new Answer();
//		a1.setSurveyId(1);
//		a1.setQuestionId(1);
//		a1.setOfferedAnswerId(2);
//		session.save(a1);
//		interviewee1.addAnswer(a1);
//
//		Answer a2 = new Answer();
//		a1.setSurveyId(1);
//		a1.setQuestionId(1);
//		a1.setOfferedAnswerId(4);
//		session.save(a2);
//		interviewee1.addAnswer(a2);
//
//		transaction.commit();
//	}


	public static void demo2(){

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();

		try {
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

			Question question2 = new Question("gdzie chcialbys pojechac na wakacje?");
			PotentialQuestionAnswer potentialQuestionAnswer4 = new PotentialQuestionAnswer("USA");
			PotentialQuestionAnswer potentialQuestionAnswer5 = new PotentialQuestionAnswer("Indonezja");
			PotentialQuestionAnswer potentialQuestionAnswer6 = new PotentialQuestionAnswer("Zanzibar");
			question2.getPotentialQuestionAnswers().add(potentialQuestionAnswer4);
			question2.getPotentialQuestionAnswers().add(potentialQuestionAnswer5);
			question2.getPotentialQuestionAnswers().add(potentialQuestionAnswer6);

			Metric metric1 = new Metric("podaj przedzial wiekowy?");
			PotentialMetricAnswer potentialMetricAnswer1 = new PotentialMetricAnswer("18-30");
			PotentialMetricAnswer potentialMetricAnswer2 = new PotentialMetricAnswer("31-45");
			PotentialMetricAnswer potentialMetricAnswer3 = new PotentialMetricAnswer("46-90");
			metric1.getPotentialMetricAnswers().add(potentialMetricAnswer1);
			metric1.getPotentialMetricAnswers().add(potentialMetricAnswer2);
			metric1.getPotentialMetricAnswers().add(potentialMetricAnswer3);

			Metric metric2 = new Metric("gdzie mieszkasz?");
			PotentialMetricAnswer potentialMetricAnswer4 = new PotentialMetricAnswer("Krakow");
			PotentialMetricAnswer potentialMetricAnswer5 = new PotentialMetricAnswer("Szczecin");
			PotentialMetricAnswer potentialMetricAnswer6 = new PotentialMetricAnswer("Poznan");
			metric2.getPotentialMetricAnswers().add(potentialMetricAnswer4);
			metric2.getPotentialMetricAnswers().add(potentialMetricAnswer5);
			metric2.getPotentialMetricAnswers().add(potentialMetricAnswer6);

			survey1.getQuestions().add(question1);
			survey1.getQuestions().add(question2);
			survey1.getMetrics().add(metric1);
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

//			//wypelnianie ankiety user2
//
//			Interviewee interviewee2 = new Interviewee("Rzezimieszek01");
//
//			Answer answer1 = new Answer(survey1,question1,potentialQuestionAnswer1);
//			interviewee1.getAnswers().add(answer1);
//			Answer answer2 = new Answer(survey1,question2,potentialQuestionAnswer5);
//			interviewee1.getAnswers().add(answer2);
//
//			Answer metricAnswer1 = new Answer(survey1, metric1,potentialMetricAnswer2);
//			interviewee1.getAnswers().add(metricAnswer1);
//			Answer metricAnswer2 = new Answer(survey1, metric2,potentialMetricAnswer6);
//			interviewee1.getAnswers().add(metricAnswer2);


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

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
