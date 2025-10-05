public class SmartHomeSystem2 {


    public static class SmartLight {
        private String LightName;
        private boolean LightIsOn;
        private int BrightNess;

        public SmartLight()
        {
            this.LightName = "Default Light";
            this.LightIsOn  = false;
            this.BrightNess = 0;
        }
        public SmartLight(String lightName)
        {
            this.LightName  = LightName;
            this.LightIsOn = false;
            this.BrightNess = 0;
        }
        public SmartLight(String lightName, boolean isOn, int brightness)
        {
            this.LightName = LightName;
            this.LightIsOn = LightIsOn;

            if (BrightNess < 0)
            {
                this.BrightNess = 0;
            }
            else if (BrightNess > 100)
            {
                this.BrightNess = 100;
            } else
            {
                this.BrightNess = BrightNess;
            }
        }

        public void turnOn()
        {
            LightIsOn = true;
            System.out.println(LightName + " is now ON.");
        }

        public void turnOff()
        {
            LightIsOn = false;
            System.out.println(LightName + " is now OFF.");
        }
        public void setBrightness(int level)
        {
            if (level < 0)
            {
                BrightNess = 0;
            }
            else if (level > 100)
            {
                BrightNess = 100;
            } else
            {
                BrightNess = level;
            }
            System.out.println(LightName + " brightness set to " + BrightNess + "%.");
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
            SmartLight defaultLight = new SmartLight();
            defaultLight.displayStatus();


            SmartLight bedroomLight = new SmartLight("Bedroom Light");
            bedroomLight.displayStatus();


            SmartLight kitchenLight = new SmartLight("Kitchen Light", true, 50);
            kitchenLight.displayStatus();
        }
}


