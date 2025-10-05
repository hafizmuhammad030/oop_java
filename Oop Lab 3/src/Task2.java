import java.util.*;

public class Task2 {
    public static void main(String [] args)
    {
        ArrayList<Integer> lightBrightness = new ArrayList<>();
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter the number of lights: ");
        int num = kb.nextInt();

        System.out.println("Enter the brightness levels for each light:");
        for (int i = 0; i < num; i++) {
            System.out.print("Light " + (i + 1) + ": ");
            lightBrightness.add(kb.nextInt());
        }

        System.out.println("Initial Brightness Levels:");
        displayBrightness(lightBrightness);

        while (true)
        {
            System.out.println(" Press 1 to levelup or down brightness.");
            System.out.println(" Press 2 to remove light.");
            System.out.println("Press 3 to exit.");
            int choice = kb.nextInt();

            if (choice == 1)
            {
                System.out.print("Enter the light number to update (1-" + lightBrightness.size() + "): ");
                int lightNumber = kb.nextInt();
                if (lightNumber < 1 || lightNumber > lightBrightness.size()) {
                    System.out.println("Invalid light number.");
                    continue;
                }

                System.out.print("Enter new brightness level for Light " + lightNumber + ": ");
                int newBrightness = kb.nextInt();
                lightBrightness.set(lightNumber - 1, newBrightness);

                System.out.println("Updated Brightness Levels:");
                displayBrightness(lightBrightness);

            }
            else if (choice == 2)
            {
                System.out.print("Enter the light number to remove (1-" + lightBrightness.size() + "): ");
                int lightNumber = kb.nextInt();
                if (lightNumber < 1 || lightNumber > lightBrightness.size()) {
                    System.out.println("Invalid light number.");
                    continue;
                }

                lightBrightness.remove(lightNumber - 1);
                System.out.println("Updated Brightness Levels after removal:");
                displayBrightness(lightBrightness);

            } else if (choice == 3) {
                System.out.println("Exit");
                break;
            }
            else
            {
                System.out.println("Invalid option.");
            }
        }

        kb.close();
    }

    private static void displayBrightness(ArrayList<Integer> lightBrightness) {
        for (int i = 0; i < lightBrightness.size(); i++) {
            System.out.println("Light " + (i + 1) + ": " + lightBrightness.get(i) + "%");
        }
    }
}




