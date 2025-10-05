 class Car extends Vehicle {

    private int noOfWheels;
    private String transmissionType;
    private boolean airConditioning;
    private double fuelEfficiency;
    private int numOfDoors;


    public Car(String brand, int speed, String fuelType, String color, String model, int year, double engineCapacity,
               String transmissionType, boolean airConditioning, double fuelEfficiency, int numOfDoors) {
        super(brand, speed, fuelType, color, model, year, engineCapacity);
        this.noOfWheels = 4;
        this.transmissionType = transmissionType;
        this.airConditioning = airConditioning;
        this.fuelEfficiency = fuelEfficiency;
        this.numOfDoors = numOfDoors;
    }


    @Override
    public void start() {
        super.start();
        if (airConditioning) {
            System.out.println("Air Conditioning turned on.");
        }
    }

    public void playMusic() {
        System.out.println("Playing music in the car.");
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nWheels: " + noOfWheels +
                ", Transmission: " + transmissionType +
                ", Air Conditioning: " + airConditioning +
                ", Fuel Efficiency: " + fuelEfficiency + " km/l" +
                ", Doors: " + numOfDoors;
    }


    public static void main(String[] args) {
        Car car = new Car("Toyota", 0, "Petrol", "Blue", "Corolla", 2020, 1.8,
                "Automatic", true, 15.0, 4);
        System.out.println(car);
        car.start();
        car.playMusic();
        car.accelerate(50);
        car.brake(20);
        car.fuelLevel();
        car.stop();
    }
}
