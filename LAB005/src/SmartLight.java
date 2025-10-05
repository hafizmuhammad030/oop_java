class SmartLight {
    private String name;
    private boolean isOn;

    // Constructor
    public SmartLight(String name) {
        this.name = name;
        this.isOn = false;
    }


    public void turnOn() {
        this.isOn = true;
    }


    public void turnOff() {
        this.isOn = false;
    }


    public String getStatus()
    {
        if (isOn)
        {
            return "On";
        } else
        {
            return "Off";
        }
    }


    public String getName() {
        return name;
    }
}


class SmartHomeController
{
    public SmartLight operateLight(SmartLight light) {
        System.out.println("Initial Light status: " + light.getStatus());
        light.turnOn();
        System.out.println("After operation: " + light.getStatus());
        return light;
    }

    public static void main(String[] args) {

        SmartLight livingRoomLight = new SmartLight("Living Room Light");


        SmartHomeController controller = new SmartHomeController();

        controller.operateLight(livingRoomLight);
    }
}
