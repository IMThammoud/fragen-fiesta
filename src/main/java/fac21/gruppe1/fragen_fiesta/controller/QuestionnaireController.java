package fac21.gruppe1.fragen_fiesta.controller;

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
        return questionnaireRepository.save(questionnaire);
    }

    @GetMapping
    public List<Questionnaire> getAllQuestionnaires() {
        return questionnaireRepository.findAll();
    }
}
