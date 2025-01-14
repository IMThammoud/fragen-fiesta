package fac21.gruppe1.fragen_fiesta.controller;

import fac21.gruppe1.fragen_fiesta.model.Question;
import fac21.gruppe1.fragen_fiesta.model.Questionnaire;
import fac21.gruppe1.fragen_fiesta.repository.QuestionRepository;
import fac21.gruppe1.fragen_fiesta.repository.QuestionnaireRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
            //questionnaire.setQuestions(questionObject);

            // Here Do the Database Saving with the questionObjects value
            questionRepository.save(questionObject);
            //questionnaireRepository.save(questionnaire);

        }



        // Je nach dem was Dennis benötigt für eine Bestätigung
        return "Return bool or string";
    }

    public String loginTeacher(@RequestBody Map<String,String> loginData, HttpSession sessionId) {
        // Add if check to authenticate a user and return true or false to the frontend
        if (loginData == null || loginData.isEmpty()) {
            return "Data is empty";
        } else {

        }
        return null;
    }
}
