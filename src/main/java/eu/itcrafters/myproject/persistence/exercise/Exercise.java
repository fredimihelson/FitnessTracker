package eu.itcrafters.myproject.persistence.exercise;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EXERCISE")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 20)
    @NotNull
    @Column(name = "EXERCISE_NAME", nullable = false, length = 20)
    private String exerciseName;

    @Size(max = 20)
    @NotNull
    @Column(name = "MUSCLE_GROUP", nullable = false, length = 20)
    private String muscleGroup;

}