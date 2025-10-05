
class SmartSpeaker extends SmartAppliance {
    public SmartSpeaker(String brand) {
        super(brand);
    }

    public void playMusic(String song) {
        System.out.println("Playing " + song + " on " + brand + ".");
    }

    public void setVolume(int level) {
        System.out.println("Volume of " + brand + " is set to " + level + ".");
    }
}


class SmartCamera extends SmartAppliance {
    public SmartCamera(String brand) {
        super(brand);
    }

    public void startRecording() {
        System.out.println(brand + " has started recording.");
    }

    public void stopRecording() {

        System.out.println(brand + " has stopped recording.");
    }
}


public class Main1 {
    public static void main(String[] args) {
        SmartSpeaker speaker = new SmartSpeaker("Sony");
        SmartCamera camera = new SmartCamera("Canon");

        speaker.turnOn();
        speaker.playMusic("Happy Birthday");
        speaker.setVolume(75);
        speaker.turnOff();

        camera.turnOn();
        camera.startRecording();
        camera.stopRecording();
        camera.turnOff();
    }
}


