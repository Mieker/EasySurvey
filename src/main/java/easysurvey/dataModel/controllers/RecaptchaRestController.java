package easysurvey.dataModel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import easysurvey.persistence.RecaptchaService;

@RestController
@RequestMapping("/api/recaptcha")
public class RecaptchaRestController {

    @Autowired
    RecaptchaService recaptchaService;
    
    @RequestMapping(value = "/{token}", method = RequestMethod.POST)
    public ResponseEntity<?> verifyRecaptcha(@PathVariable("token") String token) {
        
        boolean isSuccess = recaptchaService.verifyRecaptcha(token);
        
        return new ResponseEntity<Boolean>(isSuccess, HttpStatus.OK);
    }
}
