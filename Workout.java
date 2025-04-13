public abstract class Workout implements Loggable {
    protected String date;
    protected int duration; // in minutes

    public Workout(String date, int duration) {
        this.date = date;
        this.duration = duration;
    }

    public abstract void displayWorkout();

    public String getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }
}
