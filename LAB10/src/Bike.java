
 class Bike extends Vehicle {

    private int noOfWheels;
    private String handlebarType;
    private boolean hasGearSystem;
    private String engineType;


    public Bike(String brand, int speed, String fuelType, String color, String model, int year, double engineCapacity,
                String handlebarType, boolean hasGearSystem, String engineType) {
        super(brand, speed, fuelType, color, model, year, engineCapacity);
        this.noOfWheels = 2;
        this.handlebarType = handlebarType;
        this.hasGearSystem = hasGearSystem;
        this.engineType = engineType;
    }


    @Override
    public void start() {
        super.start();
        System.out.println("Adjusting the seat height for a comfortable ride.");
    }


    public void adjustSeat() {
        System.out.println("Adjusting the seat height for a comfortable ride.");
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nWheels: " + noOfWheels +
                ", Handlebar Type: " + handlebarType +
                ", Gear System: " + hasGearSystem +
                ", Engine Type: " + engineType;
    }


    public static void main(String[] args) {
        Bike bike = new Bike("Yamaha", 0, "Petrol", "Black", "MT-15", 2023, 0.155,
                "Straight", true, "Four-Stroke");
        System.out.println(bike);
        bike.start();
        bike.adjustSeat();
        bike.accelerate(60);
        bike.brake(30);
        bike.fuelLevel();
        bike.stop();
    }
}
