import java.io.*;
import java.util.ArrayList;
import java.util.List;


class SmartLight {
    private String name;
    private boolean isOn;
    private int brightness;

    public SmartLight(String name, boolean isOn, int brightness) {
        this.name = name;
        this.isOn = isOn;
        this.brightness = brightness;
    }

    public String getDetails() {
        return name + ", " + (isOn ? "On" : "Off") + ", Brightness: " + brightness;
    }
}


class SmartHome {
    private String name;
    private List<smartlight> lights;

    public SmartHome(String name) {
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
}


public class Main1 {
    public static void main(String[] args) {

        smarthome smartHome = new smarthome("My Home");


        smartHome.addLight(new smartlight("Living Room Light", true, 75));
        smartHome.addLight(new smartlight("Kitchen Light", false, 30));


        smartHome.saveToFile();
    }
}
