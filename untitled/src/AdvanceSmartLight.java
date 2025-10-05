public class AdvanceSmartLight {

    private String lightName;
    private boolean isOn;
    private int brightness;
    private String color;

    public AdvanceSmartLight(String lightName) {
        this.lightName = lightName;
        this.isOn = false;
        this.brightness = 0;
        this.color = "White";
    }

    public String getLightName() {
        return lightName;
    }

    public void setLightName(String lightName) {
        this.lightName = lightName;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 100) {
            this.brightness = brightness;
        } else {
            System.out.println("Brightness must be between 0 and 100.");
        }
    }

    public void setBrightness(String level) {
        switch (level.toLowerCase()) {
            case "low":
                this.brightness = 25;
                break;
            case "medium":
                this.brightness = 50;
                break;
            case "high":
                this.brightness = 75;
                break;
            default:
                System.out.println("Invalid brightness level. Use 'low', 'medium', or 'high'.");
                return;
        }
        System.out.println("Brightness set to " + level + " (" + this.brightness + "%).");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(lightName + " is now ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(lightName + " is now OFF.");
    }

    public void displayStatus() {
        String status = isOn ? "ON" : "OFF";
        System.out.println(lightName + " - Light is " + status + ", Brightness: " + brightness + "%, Color: " + color);
    }

    public static void main(String[] args) {

        AdvanceSmartLight livingRoomLight = new AdvanceSmartLight("Living Room Light");
        AdvanceSmartLight bedroomLight = new AdvanceSmartLight("Bedroom Light");

        livingRoomLight.displayStatus();
        bedroomLight.displayStatus();

        livingRoomLight.turnOn();
        livingRoomLight.setBrightness(75);
        livingRoomLight.setColor("Warm White");
        livingRoomLight.displayStatus();

        bedroomLight.turnOn();
        bedroomLight.setBrightness("medium");
        bedroomLight.setColor("Blue");
        bedroomLight.displayStatus();
        bedroomLight.turnOff();
        bedroomLight.displayStatus();

        bedroomLight.setBrightness("invalid");
    }
}
