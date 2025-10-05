import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

        public class Main1 {
        public static void main(String[] args) {

        String fileName = "example.txt";

        try {

        FileWriter fileWriter = new FileWriter(fileName);


        PrintWriter printWriter = new PrintWriter(fileWriter);


        printWriter.println("Hello, World!");
        printWriter.println("This is an example of writing to a file in Java.");

        
        printWriter.close();
        fileWriter.close();

        System.out.println("Data has been written to the file.");
        } catch (IOException e) {
        System.out.println("An error occurred while writing to the file.");
        e.printStackTrace();
        }
        }
        }


