interface PowerControl{
     void turnOn();
     void turnOff();
}
abstract class SmartDevice{
    abstract void connect();

}
class SmartLight extends SmartDevice implements PowerControl {


    private boolean isConnected = false;
    private boolean isOn = false;


    @Override
    void connect(){
        isConnected = true;
        System.out.println("SmartLight is connected to the network!");
    }
    @Override
    public void turnOn()
    {
        if(isConnected){
            isOn = true;
            System.out.println("SmartLight is turned on.");
        }
        else {
            System.out.println("Cannot turn on the SmartLight.");
        }
    }

    @Override
    public void turnOff()
    {
        if(isConnected)
        {
            isOn = false;
            System.out.println("SmartLight is turned off.");
        }
        else {
            System.out.println("Cannot turned on SmartLight.");
        }
    }

}
public class Main{
    public static void main(String [] args){
        SmartLight smartLight = new SmartLight();
        
        smartLight.turnOn();
        smartLight.connect();
        smartLight.turnOn();
        smartLight.turnOff();



    }
}