public class Task8 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Main 'isLightOn', 'brightnessLevel'");
            return;
        }

        boolean isLightOn = Boolean.parseBoolean(args[0]);
        int brightnessLevel = Integer.parseInt(args[1]);

        if (isLightOn) {
            System.out.println("Light is On!");
        } else {
            System.out.println("Light is Off!");
        }

        System.out.println("Brightness level: " + brightnessLevel + " units.");
    }
}

