import java.util.Scanner;

public class Task1 {
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int brightnessLevel[] = new int[5];

        System.out.println("Enter the Number of Brighteness Level:");
        for (int i = 0; i < brightnessLevel.length; i++)
        {
            System.out.println("Light " + (i + 1) + ": ");
            brightnessLevel[i] = keyboard.nextInt();
        }
        System.out.println("Enter the Initial Brigteness level:");
        for (int i = 0; i < brightnessLevel.length; i++)
        {
            System.out.println("Light " + (i + 1) + ": " + brightnessLevel[i] + "%");
        }
        System.out.print("Enter the light number that has to changed:");
        int lightNumber = keyboard.nextInt();
        System.out.print("Enter the new brightness level:");
        int newBrightness = keyboard.nextInt();
        brightnessLevel[lightNumber - 1] = newBrightness;


        System.out.println("Updated Brightness Levels:");
        for (int i = 0; i < brightnessLevel.length; i++) {
            System.out.println("Light " + (i + 1) + ": " + brightnessLevel[i] + "%");
        }

        keyboard.close();






    }
}



