


interface Controllable {
    void turnOn();
    void turnOff();
}

interface Configurable {
    void configure(String setting, String value);
}

class SmartAppliance1 implements Controllable {
    String brand;
    boolean isPoweredOn;

    public SmartAppliance1 (String brand) {
        this.brand = brand;
        this.isPoweredOn = false;
    }

    @Override
    public void turnOn() {
        isPoweredOn = true;
        System.out.println(brand + " is turned on.");
    }

    @Override
    public void turnOff() {
        isPoweredOn = false;
        System.out.println(brand + " is turned off.");
    }
}

class SmartLight1 extends SmartAppliance {
    public SmartLight1(String brand) {
        super(brand);
    }
}

class SmartThermostat1 extends SmartAppliance implements Configurable {
    public SmartThermostat1(String brand) {
        super(brand);
    }

    @Override
    public void configure(String setting, String value) {
        System.out.println("Configuring " + brand + ": " + setting + " = " + value);
    }
}

public class Main2 {
    public static void main(String[] args) {
        Controllable[] appliances = new Controllable[2];
        appliances[0] = new SmartLight1("Philips");
        appliances[1] = new SmartThermostat1("Honeywell");

        for (Controllable appliance : appliances) {
            appliance.turnOn();
        }

        SmartThermostat thermostat = (SmartThermostat) appliances[1];
        thermostat.configure("temperature", "25");
    }
}