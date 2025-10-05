public class SmartHomeSystem {

    public static class SmartLight{
        private String LightName;
        private boolean LightIsOn;
        private int BrightNess;

        public SmartLight (String LightName)
        {
            this.LightName  = LightName;
            this.LightIsOn = false;
            this.BrightNess = 0;
        }
        public void turnOn()
        {
            LightIsOn = true;
            System.out.println(LightName + "Is now On.");
        }
        public void turnOff()
        {
            LightIsOn = false;
            System.out.println(LightName + "Is now Off.");
        }

        public void setBrightNess(int level)
        {
            if (level < 0)
            {
                BrightNess = 0;
            } else if (level > 100)
            {
                BrightNess = 100;
            } else
            {
                BrightNess = level;
            }
            System.out.println(LightName + "Is set to" + BrightNess + "%");
        }
        public void displayStatus()
        {
            String status;
            if (LightIsOn) {
                status = "ON";
            } else {
                status = "OFF";
            }
            System.out.println(LightName + " is " + status + " with brightness at " + BrightNess + "%.");
        }
    }
    public static void main(String[] args)
    {
        SmartLight livingRoomLight = new SmartLight("Living Room Light");

        livingRoomLight.displayStatus();
        livingRoomLight.turnOn();
        livingRoomLight.setBrightNess(60);
        livingRoomLight.displayStatus();
        livingRoomLight.turnOff();
        livingRoomLight.displayStatus();

    }

    }

