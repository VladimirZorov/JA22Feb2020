package workout;

import java.util.ArrayList;;
import java.util.List;

public class Workout {

    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        return exercises.stream().filter(exercise -> exercise.getName().equals(name))
                .filter(exercise -> exercise.getMuscle().equals(muscle))
                .findFirst().orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        if (exercises.size() == 0) {
            return null;
        }
            Exercise maxExercise = null;
            int maxBC = 0;
            for (Exercise exercise : exercises) {
                if (exercise.getBurnedCalories() > maxBC) {
                    maxBC = exercise.getBurnedCalories();
                    maxExercise = exercise;
                }
            }

        return maxExercise;
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s", type)).append(System.lineSeparator());
        for (Exercise exercise : exercises) {
            sb.append(String.format("Exercise: %s", exercise.toString())).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
