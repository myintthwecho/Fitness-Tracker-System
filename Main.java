import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class Main {

    public static String getValidWorkoutType(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            
            if (input.isBlank()) {
                System.out.println("Workout type cannot be empty.");
            } else if (!input.matches("^[a-zA-Z ]+$")) {
                System.out.println("Workout type should only contain letters and spaces.");
            } else {
                return input;
            }
        }
    }
    

    public static boolean isValidDate(String dateStr, String pattern){
        if (dateStr == null || dateStr.isBlank()) {
            return false;
        }    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try{
            LocalDate.parse(dateStr, formatter);
            return true;
        }catch(DateTimeParseException e){
            return false;
        }
    }
    public static int getValidDuration(Scanner sc){
        int duration = -1;
        while(true){
        System.out.print("Enter duration (minutes): ");
        String input = sc.nextLine().trim();
        try{
            duration = Integer.parseInt(input);
            if(duration > 0 && duration <= 300){
                return duration;
            }else{
                System.out.println("Duration must be appropriate number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        
    }
    }
    public static int getValidSets(Scanner sc){
        int sets = -1;
        while(true){
            System.out.print("Enter number of sets: ");
            String input = sc.nextLine().trim();
        try{
            sets = Integer.parseInt(input);
            if(sets > 0 && sets <= 50){
                return sets;
            }else{
                System.out.println("Number of sets must be appropriate number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        
    }
    }
    public static int getValidReps(Scanner sc){
        int reps = -1;
        while(true){
            System.out.print("Enter number of reps per set: ");
            String input = sc.nextLine().trim();
        try{
            reps = Integer.parseInt(input);
            if(reps > 0 && reps <= 100){
                return reps;
            }else{
                System.out.println("Number of reps must be appropriate number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        
    }
    }
    public static void printMenu() {
        System.out.println("\n--- Fitness Tracker Menu ---");
        System.out.println("1. Add Cardio Workout");
        System.out.println("2. Add Strength Workout");
        System.out.println("3. View All Workouts");
        System.out.println("4. Exit");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WorkoutManager.loadFromFile();


        while (true) {
            printMenu();
     

            int choice = -1;
            boolean ValidChoice = false;
            while(!ValidChoice){
                System.out.print("Choose an option: ");
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    if(choice >=1 && choice <=4){
                        ValidChoice = true;
                    }else{
                        System.out.println("Invalid input. Please choose the option from 1 to 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                
                }
            }
            
        
            switch (choice) {
                case 1:
                    try {
                        String type = getValidWorkoutType(sc, "Enter activity type (e.g., Running): ");
                        int duration = getValidDuration(sc);
                        String date;
                        while(true){
                            System.out.print("Enter date (DD-MM-YYYY): ");
                            String input = sc.nextLine().trim();
                            if(isValidDate(input, "dd-MM-yyyy")){
                                LocalDate enteredDate = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                LocalDate today = LocalDate.now();
                                long daysBetween = ChronoUnit.DAYS.between(enteredDate, today);
                        
                                if (enteredDate.isAfter(today)) {
                                    System.out.println("You can't log future workouts.");
                                } else if (daysBetween > 365) {
                                    System.out.println("That date is too far in the past. Please enter a date within the past year.");
                                } else {
                                    date = input;
                                    break;
                                }
                            } else {
                                System.out.println("Invalid date format. Please use DD-MM-YYYY.");
                            }
                        }
                        WorkoutManager.addWorkout(new CardioWorkout(type, duration, date));
                        System.out.println("Cardio workout added!");
                    } catch (Exception e) {
                        System.out.println("Invalid input. Workout not added.");
                    }
                    break;
                case 2:
                    try {
                      
                        String workoutType = getValidWorkoutType(sc, "Enter the type of strength workout (e.g., Back, Biceps, Triceps, Legs): ");
                        int sets = getValidSets(sc);
                        int reps = getValidReps(sc);
                        int duration = getValidDuration(sc);
                        String date;
                        while(true){
                            System.out.print("Enter date (DD-MM-YYYY): ");
                            String input = sc.nextLine().trim();
                            if(isValidDate(input, "dd-MM-yyyy")){
                                LocalDate enteredDate = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                LocalDate today = LocalDate.now();
                                long daysBetween = ChronoUnit.DAYS.between(enteredDate, today);
                        
                                if (enteredDate.isAfter(today)) {
                                    System.out.println("You can't log future workouts.");
                                } else if (daysBetween > 365) {
                                    System.out.println("That date is too far in the past. Please enter a date within the past year.");
                                } else {
                                    date = input;
                                    break;
                                }
                            } else {
                                System.out.println("Invalid date format. Please use DD-MM-YYYY.");
                            }
                        }
                        WorkoutManager.addWorkout(new StrengthWorkout(workoutType, sets, reps, duration, date));
                        System.out.println("Strength workout added!");
                    } catch (Exception e) {
                        System.out.println("Invalid input. Workout not added.");
                    }
                    break;
                    case 3:
                    WorkoutManager.displayWorkouts();
                    
                    while (true) {
                        System.out.print("Press 'C' to continue or 'E' to exit: ");
                        String input = sc.nextLine().trim().toUpperCase();
                        if (input.equals("C")) {
                            break; // Go back to main menu
                        } else if (input.equals("E")) {
                            System.out.println("Exiting... Stay strong!");
                            return;
                        } else {
                            System.out.println("Invalid option. Please enter 'C' or 'E'.");
                        }
                    }
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
