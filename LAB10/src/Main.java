import java.util.Random;

 class Vehicle {

    private String brand;
    private int speed;
    private String fuelType;
    private String color;
    private String model;
    private int year;
    private double engineCapacity;


    public Vehicle(String brand, int speed, String fuelType, String color, String model, int year, double engineCapacity) {
        this.brand = brand;
        this.speed = speed;
        this.fuelType = fuelType;
        this.color = color;
        this.model = model;
        this.year = year;
        this.engineCapacity = engineCapacity;
    }


    public void start() {
        System.out.println("The vehicle has started.");
    }

    public void stop() {
        System.out.println("The vehicle has stopped.");
    }

    public void accelerate(int increment) {
        speed += increment;
        System.out.println("The vehicle accelerated. Current speed: " + speed + " km/h");
    }

    public void brake(int decrement) {
        speed -= decrement;
        if (speed < 0) speed = 0;
        System.out.println("The vehicle slowed down. Current speed: " + speed + " km/h");
    }

    public int fuelLevel() {
        Random random = new Random();
        int fuelLevel = random.nextInt(101);
        System.out.println("Fuel level: " + fuelLevel + "%");
        return fuelLevel;
    }

    @Override
    public String toString() {
        return "Vehicle Details: " +
                "\nBrand: " + brand +
                ", Model: " + model +
                ", Color: " + color +
                ", Year: " + year +
                ", Speed: " + speed + " km/h" +
                ", Engine Capacity: " + engineCapacity + " L";
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Honda", 0, "Petrol", "Red", "Civic", 2021, 2.0);
        System.out.println(vehicle);
        vehicle.start();
        vehicle.accelerate(30);
        vehicle.brake(10);
        vehicle.fuelLevel();
        vehicle.stop();
        System.out.println(vehicle);
    }
}
