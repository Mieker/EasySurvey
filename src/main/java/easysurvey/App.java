package easysurvey;

import easysurvey.persistence.SurveyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SurveyService surveyService = new SurveyService();
		surveyService.close();
		SpringApplication.run(App.class, args);
	}
}


