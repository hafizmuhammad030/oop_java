import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        int[] brightnessLevels = new int[5];
        Random random = new Random();

        for (int i = 0; i < brightnessLevels.length; i++) {
            brightnessLevels[i] = random.nextInt(100);
        }

        System.out.println("Static Array - Initial Brightness Levels:");
        for (int i = 0; i < brightnessLevels.length; i++) {
            System.out.println("Light " + (i + 1) + ": " + brightnessLevels[i] + "%");
        }

        ArrayList<Integer> brightnessList = new ArrayList<>();
        for (int level : brightnessLevels) {
            brightnessList.add(level);
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("\nModify brightness levels (Enter new values):");
        for (int i = 0; i < brightnessList.size(); i++) {
            System.out.print("Enter new brightness for Light " + (i + 1) + ": ");
            int newBrightness = sc.nextInt();
            if (newBrightness > 100) {
                System.out.println("Warning: Brightness set to 100% (maximum allowed).");
                brightnessList.set(i, 100);
            } else {
                brightnessList.set(i, newBrightness);
            }
        }

        System.out.print("\nDo you want to remove any light's brightness level? (yes/no): ");
        String removeChoice = sc.next();
        if (removeChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter the light number to remove: ");

            if (sc.hasNextInt()) {
                int lightToRemove = sc.nextInt();

                if (lightToRemove >= 1 && lightToRemove <= brightnessList.size()) {
                    brightnessList.remove(lightToRemove);
                    System.out.println("Light " + lightToRemove + " brightness level removed.");
                } else {
                    System.out.println("Invalid light number.");
                }
            } else {
                System.out.println("Please enter a valid integer.");
                sc.next();
            }
        }

        System.out.println("\nDynamic Array - Updated Brightness Levels:");
        for (int i = 0; i < brightnessList.size(); i++) {
            System.out.println("Light " + (i + 1) + ": " + brightnessList.get(i) + "%");
        }

        String mode = "Energy Saving Mode";
        System.out.println("\nSmart Light Mode: " + mode);
        System.out.println("Length of mode: " + mode.length());
        System.out.println("Mode in uppercase: " + mode.toUpperCase());
        System.out.println("Mode in lowercase: " + mode.toLowerCase());
        String firstWord = mode.split(" ")[0];
        System.out.println("First word of mode: " + firstWord);
        String updatedMode = mode.replace("Energy", "Efficiency");
        System.out.println("Updated Mode: " + updatedMode);

        System.out.println("\nFinal Configuration of Smart Light Controller:");
        System.out.println("Brightness Levels (Final):");
        for (int i = 0; i < brightnessList.size(); i++) {
            System.out.println("Light " + (i + 1) + ": " + brightnessList.get(i) + "%");
        }
        System.out.println("Current Mode: " + updatedMode);
        System.out.println("Smart Light Controller successfully configured!");

        sc.close();
    }
}

