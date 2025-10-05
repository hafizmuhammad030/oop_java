import java.util.Scanner;

public class Calculator {
    public static void main(String [] args)
    {
       Scanner kb = new Scanner(System.in);

        System.out.println("Enter the distance (in meters):");
        double distance = kb.nextDouble();


        System.out.println("Enter the time (in hours):");
        double time = kb.nextDouble();


        System.out.println("Enter the time (in minutes):");
        double minutes = kb.nextDouble();


        System.out.println("Enter the time (in seconds):");
        double seconds= kb.nextDouble();

        double timeInSeconds = (time * 3600) + (minutes * 60) + seconds;

        double speedInMeters = distance / timeInSeconds;
        double speedInKilometers= (distance / 1000) / (timeInSeconds / 3600);
        double speedInMiles= (distance / 1609) / (timeInSeconds / 3600);

        System.out.println("Speed in meters:" + speedInMeters);
        System.out.println("Speed in kilometers:" + speedInKilometers);
        System.out.println("Speed in miles:" + speedInMiles);














    }
}
