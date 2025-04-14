import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkoutManager {
    private static List<Workout> workoutList = new ArrayList<>();

    public static void addWorkout(Workout workout) {
        workoutList.add(workout);
        workout.logToFile();
    }

    public static void displayWorkouts() {
        if (workoutList.isEmpty()) {
            System.out.println("No workouts logged yet.");
            return;
        }
        System.out.println("\n================ Logged Workouts ================\n");
        System.out.printf("%-10s %-15s %-6s %-6s %-12s %-10s\n",
                "Type", "Workout", "Sets", "Reps", "Duration", "Date");
        System.out.println("--------------------------------------------------------------");
    
        for (Workout w : workoutList) {
            w.displayWorkout();
        }
    }

    public static void appendToFile(String data) {
        try (FileWriter fw = new FileWriter("workouts.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("workouts.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals("Cardio")) {
                    workoutList.add(new CardioWorkout(parts[1], Integer.parseInt(parts[2]), parts[3]));
                } else if (parts[0].equals("Strength")) {
                    workoutList.add(new StrengthWorkout(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),Integer.parseInt(parts[4]), parts[5]));
                }
            }
        } catch (IOException e) {
            System.out.println("No existing file found or file is corrupted.");
        }
    }
}
