package eu.itcrafters.myproject.infrastructure.mapper;
import eu.itcrafters.myproject.infrastructure.dto.WorkoutDTO;
import eu.itcrafters.myproject.persistence.customer.Customer;
import eu.itcrafters.myproject.persistence.exercise.Exercise;
import eu.itcrafters.myproject.persistence.workout.Workout;

public class WorkoutMapper {

    public static WorkoutDTO toDTO(Workout workout) {
        WorkoutDTO dto = new WorkoutDTO();
        dto.setId(workout.getId());
        dto.setDate(workout.getDate());
        dto.setSets(workout.getSets());
        dto.setReps(workout.getReps());
        dto.setWeight(workout.getWeight());

        if (workout.getCustomer() != null) {
            dto.setCustomerId(workout.getCustomer().getId());
            dto.setCustomerName(
                    workout.getCustomer().getFirstName() + " " + workout.getCustomer().getLastName()
            );
        }

        if (workout.getExercise() != null) {
            dto.setExerciseId(workout.getExercise().getId());
            dto.setExerciseName(workout.getExercise().getExerciseName());
        }

        return dto;
    }

    public static Workout toEntity(WorkoutDTO dto, Customer customer, Exercise exercise) {
        Workout workout = new Workout();
        workout.setId(dto.getId());
        workout.setDate(dto.getDate());
        workout.setSets(dto.getSets());
        workout.setReps(dto.getReps());
        workout.setWeight(dto.getWeight());

        workout.setCustomer(customer);
        workout.setExercise(exercise);

        return workout;
    }
}