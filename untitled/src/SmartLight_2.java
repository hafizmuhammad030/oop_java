public class SmartLight_2 {
    private String room;
    private boolean isOn;
    private int  brightness;

    public SmartLight_2(String room) {
        this.room = room;
        this.isOn = false;
        this.brightness = 0;
    }

    public void turnOn(int brightness) {
        this.isOn = true;
        this.brightness = brightness;
        System.out.println(room + "Light is ON having the brightness level " + brightness);
    }

    public  void turnOff() {
        this.isOn = false;
        System.out.println(room + "Light is OFF having the brightness level " + brightness);
    }

    public void setBrightness(int brightness) {
        if(isOn) {
            this.brightness = brightness;
            System.out.println("Brightness is set to " + brightness + " for " + room + "Light");
        } else {
            System.out.println(room + "Light is OFF cant set brightness! ");
        }
    }

    public void display() {
        if(isOn) {
            System.out.println(room + "Light is ON having brightness level " + brightness);
        } else {
            System.out.println(room + "Light isOFF having a brightness level " + brightness);
        }
    }

    public static void main(String[] args) {
        SmartLight_2 washroom = new SmartLight_2("Living Room");
        SmartLight_2 kitchen = new SmartLight_2("Kitchen");
        SmartLight_2 bedroom = new SmartLight_2("Bed Room");

        washroom.turnOn(75);
        washroom.display();

        washroom.turnOff();
        washroom.display();

        SmartLight_2 defaultLight = new SmartLight_2("Default");
        defaultLight.display();

        kitchen.display();

        bedroom.turnOn(50);
        bedroom.display();

        bedroom.setBrightness(50);
        bedroom.display();

        washroom.turnOn(75);
        washroom.display();
    }
}
