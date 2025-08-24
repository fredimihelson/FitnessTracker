package eu.itcrafters.myproject.service;

import eu.itcrafters.myproject.infrastructure.dto.WorkoutDTO;
import eu.itcrafters.myproject.infrastructure.mapper.WorkoutMapper;
import eu.itcrafters.myproject.persistence.customer.Customer;
import eu.itcrafters.myproject.persistence.exercise.Exercise;
import eu.itcrafters.myproject.persistence.workout.Workout;
import eu.itcrafters.myproject.persistence.workout.WorkoutRepository;
import eu.itcrafters.myproject.persistence.customer.CustomerRepository;
import eu.itcrafters.myproject.persistence.exercise.ExerciseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final CustomerRepository customerRepository;
    private final ExerciseRepository exerciseRepository;

    public WorkoutService(WorkoutRepository workoutRepository,
                          CustomerRepository customerRepository,
                          ExerciseRepository exerciseRepository) {
        this.workoutRepository = workoutRepository;
        this.customerRepository = customerRepository;
        this.exerciseRepository = exerciseRepository;
    }

    public List<WorkoutDTO> getAllWorkouts() {
        return workoutRepository.findAll()
                .stream()
                .map(WorkoutMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<WorkoutDTO> getWorkoutById(Long id) {
        return workoutRepository.findByIdWithRelations(id)
                .map(WorkoutMapper::toDTO);
    }

    public WorkoutDTO createWorkout(WorkoutDTO dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Exercise exercise = exerciseRepository.findById(dto.getExerciseId())
                .orElseThrow(() -> new RuntimeException("Exercise not found"));

        Workout workout = WorkoutMapper.toEntity(dto, customer, exercise);
        Workout savedWorkout = workoutRepository.save(workout);

        return WorkoutMapper.toDTO(savedWorkout);
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }

    public Optional<WorkoutDTO> updateWorkout(Long id, WorkoutDTO dto) {
        return workoutRepository.findById(id).map(existingWorkout -> {
            Customer customer = customerRepository.findById(dto.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + dto.getCustomerId()));
            Exercise exercise = exerciseRepository.findById(dto.getExerciseId())
                    .orElseThrow(() -> new RuntimeException("Exercise not found with ID: " + dto.getExerciseId()));

            existingWorkout.setDate(dto.getDate());
            existingWorkout.setSets(dto.getSets());
            existingWorkout.setReps(dto.getReps());
            existingWorkout.setWeight(dto.getWeight());
            existingWorkout.setCustomer(customer);
            existingWorkout.setExercise(exercise);

            Workout updated = workoutRepository.save(existingWorkout);
            return WorkoutMapper.toDTO(updated);
        });
    }
}
