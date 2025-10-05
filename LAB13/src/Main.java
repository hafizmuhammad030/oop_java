class SmartAppliance {
    String brand;
    boolean isPoweredOn;

    public SmartAppliance(String brand) {
        this.brand = brand;
        this.isPoweredOn = false;
    }

    public void turnOn() {
        isPoweredOn = true;
        System.out.println(brand + " is turned on.");
    }

    public void turnOff() {
        isPoweredOn = false;
        System.out.println(brand + " is turned off.");
    }
}


class SmartLight extends SmartAppliance {
    public SmartLight(String brand) {
        super(brand);
    }

    public void setBrightness(int level) {
        System.out.println("Brightness of " + brand + " is set to " + level + ".");
    }
}


class SmartThermostat extends SmartAppliance {
    public SmartThermostat(String brand) {
        super(brand);
    }

    public void setTemperature(int temp) {
        System.out.println("Temperature of " + brand + " is set to " + temp + " degrees.");
    }
}


public class Main {
    public static void main(String[] args) {
        SmartLight light = new SmartLight("Philips");
        SmartThermostat thermostat = new SmartThermostat("Honeywell");

        light.turnOn();
        light.setBrightness(50);
        light.turnOff();

        thermostat.turnOn();
        thermostat.setTemperature(25);
        thermostat.turnOff();
    }
}
