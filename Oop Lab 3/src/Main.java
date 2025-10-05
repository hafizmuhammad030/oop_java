import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Static variable to count total number of appointments
        int appointmentCount = 0;

        // Input patient details
        System.out.print("Enter patient name: ");
        String patientName = scanner.nextLine();

        System.out.print("Enter patient age: ");
        int patientAge = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        System.out.print("Enter patient's ailment: ");
        String ailment = scanner.nextLine();

        // Input doctor details
        System.out.print("Enter doctor's name: ");
        String doctorName = scanner.nextLine();

        System.out.print("Enter doctor's specialty: ");
        String specialty = scanner.nextLine();

        // Increment appointment count
        appointmentCount++;

        // Display the interaction between patient and doctor
        System.out.println("Patient " + patientName + " (age " + patientAge + ") is consulting Dr. " + doctorName
                + ", a specialist in " + specialty + ", for " + ailment + ".");

        // Display patient details (method 1)
        System.out.println("Patient Details: Name - " + patientName + ", Age - " + patientAge);

        


        // Print the total number of appointments
        System.out.println("Total number of appointments: " + appointmentCount);

        scanner.close();
    }
}
