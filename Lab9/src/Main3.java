import java.io.*;
import java.util.ArrayList;
import java.util.List;


class SmartLight2 {
    private String name;
    private boolean isOn;
    private int brightness;

    public SmartLight2(String name, boolean isOn, int brightness) {
        this.name = name;
        this.isOn = isOn;
        this.brightness = brightness;
    }

    public String getDetails() {
        return name + ", " + (isOn ? "On" : "Off") + ", Brightness: " + brightness;
    }

    public static SmartLight2 fromDetails(String details) {
        String[] parts = details.split(", ");
        String name = parts[0];
        boolean isOn = parts[1].equals("On");
        int brightness = Integer.parseInt(parts[2].replace("Brightness: ", ""));
        return new SmartLight2(name, isOn, brightness);
    }
}


class SmartHome3 {
    private String name;
    private List<SmartLight2> lights;

    public SmartHome3(String name) {
        this.name = name;
        this.lights = new ArrayList<>();
    }

    public void addLight(SmartLight2 light) {
        lights.add(light);
    }

    public void saveToFile(BufferedWriter writer) throws IOException {
        writer.write("Smart Home: " + name);
        writer.newLine();
        writer.write("Lights:");
        writer.newLine();
        for (SmartLight2 light : lights) {
            writer.write(light.getDetails());
            writer.newLine();
        }
    }

    public static SmartHome3 loadFromFile(BufferedReader reader) throws IOException {
        String nameLine = reader.readLine();
        if (nameLine == null || !nameLine.startsWith("Smart Home: ")) {
            return null;
        }
        String name = nameLine.replace("Smart Home: ", "");
        SmartHome3 home = new SmartHome3(name);

        reader.readLine(); // Skip the "Lights:" line

        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            home.addLight(SmartLight2.fromDetails(line));
        }

        return home;
    }

    public String getName() {
        return name;
    }

    public List<SmartLight2> getLights() {
        return lights;
    }
}

// Main class to test the functionality
public class Main3 {

    public static void saveMultipleHomes(List<SmartHome3> homes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("smart_home.txt"))) {
            for (SmartHome3 home : homes) {
                home.saveToFile(writer);
                writer.newLine(); // Separate each home with an empty line
            }
            System.out.println("Multiple smart homes saved to smart_home.txt.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static List<SmartHome3> loadMultipleHomes() {
        List<SmartHome3> homes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("smart_home.txt"))) {
            while (reader.ready()) {
                SmartHome3 home = SmartHome3.loadFromFile(reader);
                if (home != null) {
                    homes.add(home);
                }
                reader.readLine(); // Skip the empty line between homes
            }
            System.out.println("Multiple smart homes loaded from smart_home.txt.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        return homes;
    }

    public static void main(String[] args) {
        // Create multiple SmartHome instances
        SmartHome3 home1 = new SmartHome3("My Home");
        home1.addLight(new SmartLight2("Living Room Light", true, 75));
        home1.addLight(new SmartLight2("Kitchen Light", false, 30));

        SmartHome3 home2 = new SmartHome3("Vacation Home");
        home2.addLight(new SmartLight2("Bedroom Light", true, 60));
        home2.addLight(new SmartLight2("Garden Light", false, 40));

        // Save multiple homes to the file
        List<SmartHome3> homesToSave = List.of(home1, home2);
        saveMultipleHomes(homesToSave);

        // Load multiple homes from the file
        List<SmartHome3> loadedHomes = loadMultipleHomes();

        // Display loaded homes
        for (SmartHome3 home : loadedHomes) {
            System.out.println("Smart Home: " + home.getName());
            System.out.println("Lights:");
            for (SmartLight2 light : home.getLights()) {
                System.out.println(light.getDetails());
            }
            System.out.println();
        }
    }
}