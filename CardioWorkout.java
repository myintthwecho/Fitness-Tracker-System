public class CardioWorkout extends Workout {
    private String activityType;

    public CardioWorkout(String date, int duration, String activityType) {
        super(date, duration);
        this.activityType = activityType;
    }

    @Override
    public void displayWorkout() {
        System.out.println("Cardio Workout - " + activityType + " | Date: " + date + " | Duration: " + duration + " mins");
    }

    @Override
    public void logToFile() {
        WorkoutManager.appendToFile("Cardio," + activityType + "," + date + "," + duration);
    }
}
