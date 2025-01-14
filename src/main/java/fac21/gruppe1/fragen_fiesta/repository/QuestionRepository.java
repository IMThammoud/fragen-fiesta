package fac21.gruppe1.fragen_fiesta.repository;

import fac21.gruppe1.fragen_fiesta.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
