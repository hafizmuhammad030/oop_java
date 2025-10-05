import java.util.Scanner;
 class Task2 {
    public static void main(String[] args)
    {
       int brightnessLevel;

       Scanner keyboard = new Scanner (System.in);
        System.out.println("Enter how much brighteness you need:");
        brightnessLevel = keyboard.nextInt();



       brightnessLevel += 10;
       System.out.println("Increased Brightness:" + brightnessLevel + "%" );

        brightnessLevel -= 20;
        System.out.println("Deccreased Brightness:" + brightnessLevel + "%");
    }

}
