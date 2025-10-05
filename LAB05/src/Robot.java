 class Robot {
    private int id;
    private int batteryLevel;


    public Robot(int id, int batteryLevel) {
        this.id = id;
        this.batteryLevel = batteryLevel;
    }


    public void recharge(int chargeAmount)
    {
        this.batteryLevel += chargeAmount;
        if (this.batteryLevel > 100)
        {
            this.batteryLevel = 100;
        }
    }


    public int getId() {
        return id;
    }

    public int getBatteryLevel()
    {
        return batteryLevel;
 }
    public static void main(String[] args)
    {

        Robot[] robots = {
                new Robot(1, 10),
                new Robot(2, 50),
                new Robot(3, 70),
                new Robot(4, 90),
                new Robot(5, 30)
        };

        System.out.println("Initial Battery Levels:");
        for (Robot robot : robots)
        {
            System.out.println("Robot ID: " + robot.getId() + ", Battery Level: " + robot.getBatteryLevel() + "%");
        }


        robots[2].recharge(30);


        System.out.println("After Recharge:");
        System.out.println("Robot ID: " + robots[2].getId() + ", Battery Level: " + robots[2].getBatteryLevel() + "%");
        System.out.println("Done!!!");

    }
}


