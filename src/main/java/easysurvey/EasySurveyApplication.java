package easysurvey;

import easysurvey.dataModel.*;
import easysurvey.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasySurveyApplication {

	Session session;

	public static void main(String[] args) {
		//SpringApplication.run(EasySurveyApplication.class, args);
		EasySurveyApplication easySurveyApplication = new EasySurveyApplication();
		easySurveyApplication.demo();
		easySurveyApplication.close();
	}

	public EasySurveyApplication() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void close() {
		session.close();
		HibernateUtil.shutdown();
	}


	private void demo(){

		Transaction transaction = session.beginTransaction();

		//dane wymagane przy uzupelnianiu ankiety

		Survey survey1 = new Survey();
		survey1.setDescription("Badanie 1");
		survey1.setEditLink("1");
		survey1.setEndDate(null);
		survey1.setIsOpen(true);
		survey1.setStartDate(null);
		survey1.setSurveyLink("xxx");
		session.save(survey1);

		Question question1 = new Question();
		question1.setQuestionText("wybierz swoj ulubiony kolor");
		survey1.addQuestion(question1);
		session.save(question1);

		OfferedAnswer OA1 = new OfferedAnswer();
		OA1.setAnswerText("Zielony");
		question1.addOfferedAnswer(OA1);
		OfferedAnswer OA2 = new OfferedAnswer();
		OA2.setAnswerText("Niebieski");
		question1.addOfferedAnswer(OA2);
		OfferedAnswer OA3 = new OfferedAnswer();
		OA3.setAnswerText("Czarny");
		question1.addOfferedAnswer(OA3);
		OfferedAnswer OA4 = new OfferedAnswer();
		OA4.setAnswerText("Czerwony");
		question1.addOfferedAnswer(OA4);

		Question question2 = new Question();
		question2.setQuestionText("gdzie wolalbys pojechac na wakacje");
		survey1.addQuestion(question2);
		session.save(question2);

		OfferedAnswer OA21 = new OfferedAnswer();
		OA21.setAnswerText("Tajlandia");
		question2.addOfferedAnswer(OA21);
		OfferedAnswer OA22 = new OfferedAnswer();
		OA22.setAnswerText("Meksyk");
		question2.addOfferedAnswer(OA22);
		OfferedAnswer OA23 = new OfferedAnswer();
		OA23.setAnswerText("USA");
		question2.addOfferedAnswer(OA23);
		OfferedAnswer OA24 = new OfferedAnswer();
		OA24.setAnswerText("Australia");
		question2.addOfferedAnswer(OA24);

		Metric metric1 = new Metric();
		metric1.setFieldName("miejsce zamieszkania");
		metric1.setFieldType("String");
		survey1.addMetrics(metric1);
		session.save(metric1);


		Metric metric2 = new Metric();
		metric2.setFieldName("wiek");
		metric2.setFieldType("String");
		survey1.addMetrics(metric2);
		session.save(metric2);


		//dane uzupelniane przez aknietowanego

		Interviewee interviewee1 = new Interviewee();
		interviewee1.setNickName("mike86");
		survey1.addInterwiee(interviewee1);
		interviewee1.addSurvey(survey1);

		session.save(interviewee1);

		metric1.setFieldValue("krakow");
		session.update(metric1);
		metric2.setFieldValue("34");
		session.update(metric2);

		Answer a1 = new Answer();
		a1.setSurveyId(1);
		a1.setQuestionId(1);
		a1.setOfferedAnswerId(2);
		session.save(a1);
		interviewee1.addAnswer(a1);

		Answer a2 = new Answer();
		a1.setSurveyId(1);
		a1.setQuestionId(1);
		a1.setOfferedAnswerId(4);
		session.save(a2);
		interviewee1.addAnswer(a2);
		
		transaction.commit();
	}









//
//		System.out.println(survey1.getDescription());
//		survey1.printQuestions();




}
