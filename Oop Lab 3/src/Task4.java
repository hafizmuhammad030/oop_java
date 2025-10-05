public class Task4 {
    public static void main(String [] args)
    {
        String mode = "Energy Saving Mode";

        int length = mode.length();
        String upperCase = mode.toUpperCase();
        String lowerCase = mode.toLowerCase();
        char charatIndex5 = mode.charAt(5);
        int indexOfSaving = mode.indexOf("Saving");
        String updatedMode = mode.replace("Saving", "Efficiency");
        String substring = mode.substring(0, 6);

        System.out.println("Length of mode: " + length);
        System.out.println("Mode in uppercase: " + upperCase);
        System.out.println("Mode in lowercase: " + lowerCase);
        System.out.println("Character at index 5: " + charatIndex5);
        System.out.println("Index of 'Saving': " + indexOfSaving);
        System.out.println("Updated Mode: " + updatedMode);
        System.out.println("Substring (first 6 characters): " + substring);
    }

}
