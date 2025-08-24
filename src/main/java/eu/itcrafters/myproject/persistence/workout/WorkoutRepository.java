package eu.itcrafters.myproject.persistence.workout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    @Query("SELECT w FROM Workout w JOIN FETCH w.customer JOIN FETCH w.exercise WHERE w.id = :id")
    Optional<Workout> findByIdWithRelations(@Param("id") Long id);

}