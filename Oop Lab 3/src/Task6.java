public class Task6 {
    // Attributes
    private String location;
    private boolean isOn;
    private int brightness;

    // Constructor
    public Task6(String location) {
        this.location = location;
        this.isOn = false; // Default is off
        this.brightness = 0; // Default brightness level
    }

    // Method to turn the light on
    public void turnOn() {
        isOn = true;
        System.out.println(location + " Light is now ON.");
    }

    // Method to turn the light off
    public void turnOff() {
        isOn = false;
        System.out.println(location + " Light is now OFF.");
    }

    // Method to set brightness
    public void setBrightness(int level) {
        brightness = level;
        System.out.println("Brightness set to " + brightness);
    }

    // Method to get the status of the light
    public String getStatus() {
        String status = isOn ? "ON" : "OFF";
        return location + " Light is " + status + " with brightness level " + brightness;
    }

    // Main method for testing
    public static void main(String[] args) {
        SmartLight livingRoomLight = new SmartLight("Living Room");
        livingRoomLight.turnOn();
        livingRoomLight.setBrightness(75);
        System.out.println(livingRoomLight.getStatus());

        livingRoomLight.turnOff();
        System.out.println(livingRoomLight.getStatus());

        SmartLight kitchenLight = new SmartLight("Kitchen");
        System.out.println(kitchenLight.getStatus());
    }
}
