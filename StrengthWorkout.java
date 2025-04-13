public class StrengthWorkout extends Workout {
    private int sets;
    private int reps;

    public StrengthWorkout(String date, int duration, int sets, int reps) {
        super(date, duration);
        this.sets = sets;
        this.reps = reps;
    }

    @Override
    public void displayWorkout() {
        System.out.println("Strength Workout | Date: " + date + " | Duration: " + duration + " mins | Sets: " + sets + " | Reps: " + reps);
    }

    @Override
    public void logToFile() {
        WorkoutManager.appendToFile("Strength," + date + "," + duration + "," + sets + "," + reps);
    }
}
