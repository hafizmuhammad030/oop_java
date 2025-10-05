import java.io.File;
import java.io.IOException;

public class Main {


    public static void createSmartHomeFile() {
        try {

            File file = new File("smart_home.txt");


            if (file.exists()) {
                System.out.println("The file smart_home.txt already exists.");
            } else {

                if (file.createNewFile()) {
                    System.out.println("The file smart_home.txt has been created successfully.");
                } else {
                    System.out.println("Failed to create the file smart_home.txt.");
                }
            }
        } catch (IOException e) {

            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        createSmartHomeFile();
    }
}
