import java.util.Scanner;

class SmartL {
    private String lightName;
    private boolean isOn;
    private int brightness;

    public SmartL(String lightName) {
        this.lightName = lightName;
        this.isOn = false;
        this.brightness = 0;
    }

    public void turnOn() {
        isOn = true;
        brightness = 100;
        System.out.println(lightName + " is turned on.");
    }

    public void turnOff() {
        isOn = false;
        brightness = 0;
        System.out.println(lightName + " is turned off.");
    }

    public void setBrightness(int level) {
        if (isOn) {
            if (level >= 0 && level <= 100) {
                brightness = level;
                System.out.println("Brightness of " + lightName + " set to " + brightness + "%.");
            } else {
                System.out.println("Brightness level must be between 0 and 100.");
            }
        } else {
            System.out.println("Cannot set brightness. The light is off.");
        }
    }

    public void displayStatus() {
        String status = isOn ? "On" : "Off";
        System.out.println("Light Name: " + lightName);
        System.out.println("Status: " + status);
        System.out.println("Brightness: " + brightness + "%");
    }

    public SmartL shallowCopy() {
        return this;
    }

    public SmartL deepCopy() {
        SmartL copiedLight = new SmartL(this.lightName);
        copiedLight.isOn = this.isOn;
        copiedLight.brightness = this.brightness;
        return copiedLight;
    }
}

public class SmartLight2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SmartLight livingRoomLight = new SmartLight("Living Room Light");

        int choice;
        do {
            System.out.println("\nSmart Light Control Menu:");
            System.out.println("1. Turn On Light");
            System.out.println("2. Turn Off Light");
            System.out.println("3. Set Brightness");
            System.out.println("4. Display Status");
            System.out.println("5. Create Shallow Copy");
            System.out.println("6. Create Deep Copy");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    livingRoomLight.turnOn();
                    break;
                case 2:
                    livingRoomLight.turnOff();
                    break;
                case 3:
                    System.out.print("Enter brightness level (0-100): ");
                    int brightness = sc.nextInt();
                    livingRoomLight.setBrightness(brightness);
                    break;
                case 4:
                    livingRoomLight.displayStatus();
                    break;
                case 5:
                    SmartLight shallowCopy = livingRoomLight.shallowCopy();
                    System.out.println("Created shallow copy of the light.");
                    shallowCopy.displayStatus();
                    break;
                case 6:
                    SmartLight deepCopy = livingRoomLight.deepCopy();
                    System.out.println("Created deep copy of the light.");
                    deepCopy.displayStatus();
                    break;
                case 7:
                    System.out.println("Exiting Smart Light Control.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        sc.close();
    }
}
