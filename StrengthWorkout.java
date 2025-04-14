public class StrengthWorkout extends Workout {
    private int sets;
    private int reps;

    public StrengthWorkout(String workoutType, int sets, int reps, int duration, String date) {
        super(workoutType, duration, date);
        this.sets = sets;
        this.reps = reps;
    }

    @Override
    public void displayWorkout() {
        System.out.printf("%-10s %-15s %-6d %-6d %-12s %-10s\n",
                "Strength", workoutType, sets, reps, duration + " mins", date);
    }
    
    

    @Override
    public void logToFile() {
        WorkoutManager.appendToFile("Strength," + workoutType  + "," + sets + "," + reps + "," + duration + "," + date );
    }
}
