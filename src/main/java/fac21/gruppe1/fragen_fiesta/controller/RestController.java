package fac21.gruppe1.fragen_fiesta.controller;

import fac21.gruppe1.fragen_fiesta.model.Question;
import fac21.gruppe1.fragen_fiesta.model.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    Question questionObject;

    RestController(){


    }

    public String receiveQuestion(@RequestBody Map<String,String> receivedQuestion) {
        if (receivedQuestion.isEmpty()) {
            return "Empty";
        }else {
            // Filling an objects with the receivedQuestion consumed by the frontend
            // setting questionnaire name of questionnaire Object through the setter in the questionObject
            questionObject.setText(receivedQuestion.get("question"));
            questionObject.getQuestionnaire().setName(receivedQuestion.get("questionnaire-name"));

            // Here Do the Database Saving

        }



        // Je nach dem was Dennis benötigt für eine Bestätigung
        return "Return bool or string";
    }

    public String loginTeacher() {

        // Add if check to authenticate a user and return true or false to the frontend

        return null;
    }
}
