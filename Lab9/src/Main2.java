import java.io.*;
import java.util.ArrayList;
import java.util.List;


class smartlight {
    private String name;
    private boolean isOn;
    private int brightness;

    public smartlight(String name, boolean isOn, int brightness) {
        this.name = name;
        this.isOn = isOn;
        this.brightness = brightness;
    }

    public String getDetails() {
        return name + ", " + (isOn ? "On" : "Off") + ", Brightness: " + brightness;
    }

    public static smartlight fromDetails(String details) {
        String[] parts = details.split(", ");
        String name = parts[0];
        boolean isOn = parts[1].equals("On");
        int brightness = Integer.parseInt(parts[2].replace("Brightness: ", ""));
        return new smartlight(name, isOn, brightness);
    }
}


class smarthome {
    private String name;
    private List<smartlight> lights;

    public smarthome(String name) {
        this.name = name;
        this.lights = new ArrayList<>();
    }

    public void addLight(smartlight light) {
        lights.add(light);
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("smart_home.txt"))) {
            writer.write("Smart Home: " + name);
            writer.newLine();
            writer.write("Lights:");
            writer.newLine();
            for (smartlight light : lights) {
                writer.write(light.getDetails());
                writer.newLine();
            }
            System.out.println("Smart home details saved to smart_home.txt.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("smart_home.txt"))) {
            String line = reader.readLine();
            if (line != null && line.startsWith("Smart Home: ")) {
                name = line.replace("Smart Home: ", "");
            }

            reader.readLine();
            lights.clear();

            while ((line = reader.readLine()) != null) {
                lights.add(smartlight.fromDetails(line));
            }

            System.out.println("Smart home details loaded from smart_home.txt.");
            System.out.println("Smart Home: " + name);
            System.out.println("Lights:");
            for (smartlight light : lights) {
                System.out.println(light.getDetails());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}


public class Main2 {
    public static void main(String[] args) {

        smarthome smartHome = new smarthome("My Home");


        smartHome.addLight(new smartlight("Living Room Light", true, 75));
        smartHome.addLight(new smartlight("Kitchen Light", false, 30));


        smartHome.saveToFile();

        smartHome.loadFromFile();
    }
}
