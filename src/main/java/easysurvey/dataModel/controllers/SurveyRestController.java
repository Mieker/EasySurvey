package easysurvey.dataModel.controllers;


import easysurvey.persistence.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/survey")
public class SurveyRestController {

    @Autowired
    SurveyService surveyService;


}
