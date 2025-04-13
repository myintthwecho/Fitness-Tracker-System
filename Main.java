import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WorkoutManager.loadFromFile();

        while (true) {
            System.out.println("\n--- Fitness Tracker Menu ---");
            System.out.println("1. Add Cardio Workout");
            System.out.println("2. Add Strength Workout");
            System.out.println("3. View All Workouts");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter date (YYYY-MM-DD): ");
                        String date = sc.nextLine();
                        System.out.print("Enter duration (minutes): ");
                        int duration = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter activity type (e.g., Running): ");
                        String type = sc.nextLine();
                        WorkoutManager.addWorkout(new CardioWorkout(date, duration, type));
                        System.out.println("Cardio workout added!");
                    } catch (Exception e) {
                        System.out.println("Invalid input. Workout not added.");
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Enter date (YYYY-MM-DD): ");
                        String date = sc.nextLine();
                        System.out.print("Enter duration (minutes): ");
                        int duration = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter number of sets: ");
                        int sets = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter number of reps per set: ");
                        int reps = Integer.parseInt(sc.nextLine());
                        WorkoutManager.addWorkout(new StrengthWorkout(date, duration, sets, reps));
                        System.out.println("Strength workout added!");
                    } catch (Exception e) {
                        System.out.println("Invalid input. Workout not added.");
                    }
                    break;
                case 3:
                    WorkoutManager.displayWorkouts();
                    break;
                case 4:
                    System.out.println("Exiting... Stay strong!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
