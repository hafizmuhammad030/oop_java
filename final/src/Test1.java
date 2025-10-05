interface RentalOperations{
    void rentVehicle(int days);
    void returnVehicle();
    double calculateRentalCost();
    void generateInvoice();


}
abstract class Vehicle implements RentalOperations {
    protected String model;
    protected boolean isRented;
    protected double dailyRate;
    protected int rentalDays;

    public Vehicle(String model, boolean isRented, double dailyRate, int rentalDays) {
        this.model = model;
        this.isRented = isRented;
        this.dailyRate = dailyRate;
        this.rentalDays = rentalDays;
    }

    @Override
    public void rentVehicle(int days) {
        if (!isRented) {
            this.isRented = true ;
            this.rentalDays = days;

            System.out.println("Model:" + model + "days:" + days);

        } else {
            System.out.println("Already rented..");
        }

    }

    @Override
    public void returnVehicle() {
        if (isRented)
        {
            isRented = false;
            System.out.println("Model"+model);
        }
        else {
            System.out.println(model + "model was not rented..");
        }

    }

    @Override
    public double calculateRentalCost() {
        return rentalDays * dailyRate;
    }

    @Override
    public void generateInvoice() {
        System.out.println(model);
        System.out.println(rentalDays);
        System.out.println(dailyRate );
        System.out.println(calculateRentalCost());
    }
}
class Car extends Vehicle {
    protected String fuelType;

    public Car(String model, boolean isRented, double dailyRate, int rentalDays, String fuelType) {
        super(model, isRented, dailyRate, rentalDays);
        this.fuelType = fuelType;
    }


    @Override
    public void rentVehicle(int days) {
        if (!isRented) {
            super.rentVehicle(days);
        } else {
            System.out.println("Not available");
        }
    }

    @Override
    public double calculateRentalCost() {
        double cost = super.calculateRentalCost();
        if (fuelType.equalsIgnoreCase("Electric")) {
            cost *= 0.9;

        }
        return cost;
    }

    @Override
    public void generateInvoice() {
        System.out.println(model);
        System.out.println(rentalDays);
        System.out.println(dailyRate );
        System.out.println(fuelType);
        System.out.println(calculateRentalCost());

    }
}
public class Test1{
    public static void main(String [] args)
    {
        Car car = new Car("CIVIC",false,2000.0,12,"ss");


        car.rentVehicle(5);
        car.returnVehicle();
        car.generateInvoice();
    }
}

class A{
    private int fuel;

    public A(int fuel) {
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;

    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
