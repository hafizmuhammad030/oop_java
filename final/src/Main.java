import java.util.HashMap;
import java.util.Scanner;

  class RoomBooked{
     public static void main(String [] args) {
         Scanner input = new Scanner(System.in);
         HashMap<Integer, String> rooms = new HashMap<>();
         for (int i = 0; i <= 30; i++) {
             rooms.put(i, "Available");
         }
         System.out.println("1.Book a flight/n 2.Cancel a flight /n  3.Check Availability /n 4.View Guest List /n 5.Search Guest List");
         System.out.println("Enter your choice:");
         int type = input.nextInt();
         if (type == 1) {
             System.out.println("Enter the number you want to book of room:");
             int room = input.nextInt();
             input.nextLine();

             if (!rooms.containsKey(room)) {
                 System.out.println("Invalid room number.");
             } else if (!rooms.get(room).equals("Available")) {
                 System.out.println("Room is already booked by:" + rooms.get(room));
             } else {
                 System.out.println("Enter guest name:");
                 String guest = input.nextLine();
                 rooms.put(room, guest);
                 System.out.println("Rooms:" + room + "are successfully booked by:" + guest);
             }
         }
         if (type == 2){



     }
}}