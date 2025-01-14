package fac21.gruppe1.fragen_fiesta.repository;

import fac21.gruppe1.fragen_fiesta.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
}