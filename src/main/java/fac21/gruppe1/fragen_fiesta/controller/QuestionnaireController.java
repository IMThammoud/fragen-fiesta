package fac21.gruppe1.fragen_fiesta.controller;

import fac21.gruppe1.fragen_fiesta.model.Option;
import fac21.gruppe1.fragen_fiesta.model.Question;
import fac21.gruppe1.fragen_fiesta.model.Questionnaire;
import fac21.gruppe1.fragen_fiesta.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/questionnaires")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @PostMapping
    public Questionnaire createQuestionnaire(@RequestBody Questionnaire questionnaire) {
        // Logging für Debugging
        System.out.println("Received questionnaire: " + questionnaire);

        // Verknüpfen der Fragen mit dem Fragebogen
        for (Question question : questionnaire.getQuestions()) {
            question.setQuestionnaire(questionnaire); // Verknüpfe jede Frage mit dem Fragebogen
            for (Option option : question.getOptions()) {
                option.setQuestion(question); // Verknüpfe jede Option mit der Frage
            }
        }

        return questionnaireRepository.save(questionnaire);
    }

    @GetMapping
    public List<Questionnaire> getAllQuestionnaires() {
        return questionnaireRepository.findAll();
    }
}
