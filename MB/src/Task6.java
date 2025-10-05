public class  Task6 {


    public static void A_B(int units) {
        System.out.println("Adjusting brightness by " + units + " units.");
    }


    public static void A_B(double percentage) {
        System.out.println("Adjusting brightness by " + percentage + "%.");
    }

    public static void main(String[] args) {
        A_B(20);
        A_B(15.5);
    }
}