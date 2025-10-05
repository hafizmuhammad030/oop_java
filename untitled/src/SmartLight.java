public class SmartLight{

    private String lightName;
    private boolean isOn;
    private int brightness;
    private String color;



    public SmartLight(String lightName, boolean isOn, int brightness, String color) {
        this.lightName = lightName;
        this.isOn = isOn;
        setBrightness(brightness);
        this.color = color;
    }


    public String getLightName() {
        return lightName;
    }

    public void setLightName(String lightName) {
        this.lightName = lightName;
    }


    public boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public int getBrightness()
    {
        return brightness;
    }

    public void setBrightness(int brightness) {
        if (brightness < 0) {
            this.brightness = 0;
        } else if (brightness > 100) {
            this.brightness = 100;
        } else {
            this.brightness = brightness;
        }
    }

    public String getColor()
    {
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


    public void displayStatus()
    {
        String status;
        if (isOn) {
            status = "ON";
        } else {
            status = "OFF";
        }


        System.out.println(lightName + " is " + status + " with brightness at " + brightness + "% and color " + color + ".");
    }
    public static void main(String [] args)
    {
        SmartLight livingRoomLight = new SmartLight("Bedroom Light", false, 50, "Warm White");
        livingRoomLight.turnOn();
        livingRoomLight.setBrightness(75);
        livingRoomLight.setColor("Blue");
        livingRoomLight.displayStatus();

        SmartLight bedroomLight = new SmartLight("Bedroom Light", false, 50, "Warm White");
        bedroomLight.displayStatus();
    }
}
