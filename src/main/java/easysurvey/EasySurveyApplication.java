package easysurvey;

import easysurvey.dataModel.*;
import easysurvey.persistence.HibernateUtil;
import easysurvey.persistence.SurveyService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasySurveyApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EasySurveyApplication.class, args);
		SurveyService surveyService = new SurveyService();
		surveyService.run();
		surveyService.close();
	}
}


