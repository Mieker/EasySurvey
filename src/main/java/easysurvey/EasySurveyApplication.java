package easysurvey;

import easysurvey.dataModel.Survey;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasySurveyApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EasySurveyApplication.class, args);
		demo();
	}

	public static void demo(){

		Survey survey = new Survey(){};
		

	}

}
