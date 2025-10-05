import java.util.Scanner;

 class Task3 {
    public static void main(String[] args)
    {
        boolean isLighton = false;

        int input;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Do you want to On or off the Light?");
        System.out.println("Press 1 to ON OR Press 0 to OFF the Light");
        input = keyboard.nextInt();

        if (input == 1)
        {
            isLighton = true;
            System.out.println("Light is now ON");
        }
        else if (input == 0)
        {
            isLighton = false;
            System.out.println("Light is now OFF");
        }
        else
        {
            System.out.println("Invalid input!!!");
        }



    }


}
