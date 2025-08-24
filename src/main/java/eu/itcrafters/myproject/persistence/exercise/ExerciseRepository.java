package eu.itcrafters.myproject.persistence.exercise;

import eu.itcrafters.myproject.persistence.exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}