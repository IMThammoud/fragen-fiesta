package fac21.gruppe1.fragen_fiesta.controller;

import fac21.gruppe1.fragen_fiesta.model.Question;
import fac21.gruppe1.fragen_fiesta.model.Questionnaire;
import fac21.gruppe1.fragen_fiesta.repository.QuestionRepository;
import fac21.gruppe1.fragen_fiesta.repository.QuestionnaireRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    Question questionObject = new Question();
    Questionnaire questionnaire = new Questionnaire();

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuestionnaireRepository questionnaireRepository;

    RestController(){


    }

    @PostMapping("/api/receiveQuestion")
    public String receiveQuestion(@RequestBody Map<String,String> receivedQuestion) {
        if (receivedQuestion.isEmpty()) {
            return "Empty";
        }else {
            // Filling an objects with the receivedQuestion consumed by the frontend
            // setting questionnaire name of questionnaire Object through the setter in the questionObject
            questionObject.setText(receivedQuestion.get("question"));
            questionObject.setType(receivedQuestion.get("question-type"));
            questionnaire.setQuestions(questionObject);
            questionnaire.setTeacherId(100L);
            questionnaire.setName("ORM");

            // Here Do the Database Saving with the questionObjects value
            questionRepository.save(questionObject);
            questionnaireRepository.save(questionnaire);

        }



        // Je nach dem was Dennis benötigt für eine Bestätigung
        return "Return bool or string";
    }

    @PostMapping("/api/login")
    public String loginTeacher(@RequestBody Map<String,String> loginData, HttpSession sessionId) {
        // Add if check to authenticate a user and return true or false to the frontend
        if (loginData == null || loginData.isEmpty()) {
            return "Data is empty";
        } else {
            String TeacherEmail = loginData.get("teacher-email");
            String TeacherPassword = loginData.get("teacher-password");

            // Check Credentials of Teacher with data from the DB

            // Encrypt the password on receiving here
            return "logged in";
        }

    }

    @PostMapping("/api/user-registration")
    public String registrateTeacher(@RequestBody Map<String, String> registerData) {
        if (registerData == null || registerData.isEmpty()) {
            return "Data is empty";
        } else {
            String TeacherEmail = registerData.get("teacher-email");
            String TeacherPassword = registerData.get("teacher-password");

            // Check Credentials of Teacher with data from the DB

            // Encrypt the password on receiving here
            // Should return a HTTP Status code
            return ResponseEntity.status(HttpStatus.OK).toString();
        }

    }
}
