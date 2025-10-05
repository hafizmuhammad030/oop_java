import java.util.Scanner;

class Task4 {
    public static void main(String[] args)
    {
        int LighteningMode;

        Scanner keyboard = new Scanner (System.in);
        System.out.println("Press 1 for Normal, 2 for Reading, 3 for Night:");
        LighteningMode = keyboard.nextInt();

        switch (LighteningMode) {
            case 1:
                System.out.println("Normal mode");
                break;
            case 2:
                System.out.println("Reading mode");
                break;
            case 3:
                System.out.println("Night mode");
                break;
            default:
                System.out.println("Invalid mode");
        }
    }
}
