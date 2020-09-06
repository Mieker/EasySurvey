package easysurvey;

import easysurvey.persistence.SurveyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SurveyService surveyService = new SurveyService();
		surveyService.createSurvey();
//		System.out.println(surveyService.statCalculation());
//		System.out.println(surveyService.statAnswers(1,1));
//		System.out.println(surveyService.statAnswers(1,2));
//		System.out.println(surveyService.statAnswers(1,3));
		surveyService.close();
		SpringApplication.run(App.class, args);
	}
}


