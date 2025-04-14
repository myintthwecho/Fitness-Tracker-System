public class CardioWorkout extends Workout {

    public CardioWorkout(String workoutType, int duration,  String date) {
        super(workoutType, duration, date);
    }
    @Override
    public void displayWorkout() {
        System.out.printf("%-10s %-15s %-6s %-6s %-12s %-10s\n",
                "Cardio", workoutType, "-", "-", duration + " mins", date);
    }
    

    @Override
    public void logToFile() {
        WorkoutManager.appendToFile("Cardio," + workoutType + "," + duration + "," + date);
    }
}
