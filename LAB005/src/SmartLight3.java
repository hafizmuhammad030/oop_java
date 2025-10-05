class AdvanceSmartLightSystem {

    private String lightName;
    private boolean isOn;
    private int brightness;
    private String color;

    public AdvanceSmartLightSystem(String lightName) {
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

    @Override
    protected void finalize() {
        System.out.println(lightName + " is being garbage collected.");
    }
}

public class SmartLight3 {
    public static void main(String[] args) {

        AdvanceSmartLightSystem livingRoomLight = new AdvanceSmartLightSystem("Living Room Light");
        AdvanceSmartLightSystem bedroomLight = new AdvanceSmartLightSystem("Bedroom Light");

        livingRoomLight.displayStatus();
        bedroomLight.displayStatus();

        livingRoomLight.turnOn();
        livingRoomLight.setBrightness(75);
        livingRoomLight.setColor("Warm White");
        livingRoomLight.displayStatus();

        bedroomLight.turnOff();
        bedroomLight.displayStatus();
        bedroomLight.setBrightness(50);
        bedroomLight.setColor("Blue");
        bedroomLight.turnOn();
        bedroomLight.displayStatus();

        livingRoomLight = null;
        bedroomLight = null;

        System.out.println("Suggesting garbage collection...");
        System.gc();

        System.out.println("Garbage collection process has been suggested.");
    }
}

