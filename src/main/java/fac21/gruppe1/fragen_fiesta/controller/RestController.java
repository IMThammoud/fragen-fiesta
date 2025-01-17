package fac21.gruppe1.fragen_fiesta.controller;

import fac21.gruppe1.fragen_fiesta.model.Question;
import fac21.gruppe1.fragen_fiesta.model.Questionnaire;
import fac21.gruppe1.fragen_fiesta.model.Teacher;
import fac21.gruppe1.fragen_fiesta.repository.QuestionRepository;
import fac21.gruppe1.fragen_fiesta.repository.QuestionnaireRepository;
import fac21.gruppe1.fragen_fiesta.repository.TeacherRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    Question questionObject = new Question();
    Questionnaire questionnaire = new Questionnaire();

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuestionnaireRepository questionnaireRepository;

    @Autowired
    TeacherRepository teacherRepository;

    RestController(){}

    /*
    Endpoint got replaced by endpoint in Questionnaire
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
 */

    @PostMapping("/api/login")
    public String loginTeacher(@RequestBody Map<String,String> loginData, HttpSession sessionId) {
        // Add if check to authenticate a user and return true or false to the frontend
        // Once a HTTPsession object is created the a JSESSIONID is created and sent to the client
        if (loginData == null || loginData.isEmpty()) {
            return "Data is empty";
        } else {
            Teacher teacher = new Teacher();
            teacher.setEmail(loginData.get("teacher-email"));
            teacher.setPassword(loginData.get("teacher-password"));



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
            Teacher teacher = new Teacher();
            teacher.setEmail(registerData.get("teacher-email"));
            teacher.setPassword(registerData.get("teacher-password"));
            teacherRepository.save(teacher);
            // Check Credentials of Teacher with data from the DB

            // Encrypt the password on receiving here
            // Should return a HTTP Status code
            return ResponseEntity.status(HttpStatus.OK).toString();
        }

    }

    @GetMapping("/api/questionnaire-dashboard")
    public String getQuestionnaireDashboard(@CookieValue(name = "JSESSIONID") String cookieSession) {
        return null;
    }

    @PostMapping("/api/retrieve-answers-to-questions")
    public String getSpecificAnswersToQuestions(@CookieValue(name = "JSESSIONID") String cookieValue) {
        return null;
    }
}
