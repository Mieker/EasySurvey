package easysurvey;

import easysurvey.dataModel.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasySurveyApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EasySurveyApplication.class, args);
		demo();
	}

	public static void demo(){
		createSurvey();
	}

	public static void createSurvey(){

		Survey survey1 = new Survey(){};
		survey1.setDescription("Badanie 1");

		Question question1 = new Question(){};
		question1.setQuestionId(1);
		question1.setQuestionText("wybierz swoj ulubiony kolor");
		survey1.addQuestion(question1);

		OfferedAnswer OA1 = new OfferedAnswer(){};
		OA1.setAnswerText("Zielony");
		question1.addOfferedAnswer(OA1);
		OfferedAnswer OA2 = new OfferedAnswer(){};
		OA2.setAnswerText("Niebieski");
		question1.addOfferedAnswer(OA2);
		OfferedAnswer OA3 = new OfferedAnswer(){};
		OA3.setAnswerText("Czarny");
		question1.addOfferedAnswer(OA3);
		OfferedAnswer OA4 = new OfferedAnswer(){};
		OA4.setAnswerText("Czerwony");
		question1.addOfferedAnswer(OA4);

		Question question2 = new Question(){};
		question2.setQuestionId(2);
		question2.setQuestionText("gdzie wolalbys pojechac na wakacje");
		survey1.addQuestion(question2);

		OfferedAnswer OA21 = new OfferedAnswer(){};
		OA21.setAnswerText("Tajlandia");
		question2.addOfferedAnswer(OA21);
		OfferedAnswer OA22 = new OfferedAnswer(){};
		OA22.setAnswerText("Meksyk");
		question2.addOfferedAnswer(OA22);
		OfferedAnswer OA23 = new OfferedAnswer(){};
		OA23.setAnswerText("USA");
		question2.addOfferedAnswer(OA23);
		OfferedAnswer OA24 = new OfferedAnswer(){};
		OA24.setAnswerText("Australia");
		question2.addOfferedAnswer(OA24);

		System.out.println(survey1.getDescription());
		survey1.printQuestions();




	}

	public static void interviewee(long id){
		Interviewee interviewee = new Interviewee();
		interviewee.setIntervieweeId(id);


	}

}
