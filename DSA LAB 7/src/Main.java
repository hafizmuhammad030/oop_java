import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Ticket {
    private int id;
    private String employeeName;
    private String issueDescription;
    private String timestamp;

    public Ticket(int id, String employeeName, String issueDescription, String timestamp) {
        this.id = id;
        this.employeeName = employeeName;
        this.issueDescription = issueDescription;
        this.timestamp = timestamp;
    }

    public String toString() {
        return "Ticket ID: " + id +
                ", Employee: " + employeeName +
                ", Issue: " + issueDescription +
                ", Timestamp: " + timestamp;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Ticket> ticketQueue = new LinkedList<>();
        int ticketCounter = 1;

        while (true) {
            System.out.println("\nHelp Desk Ticketing System");
            System.out.println("1. Add a new ticket");
            System.out.println("2. Resolve and remove the next ticket");
            System.out.println("3. Peek at the next ticket");
            System.out.println("4. Check if the queue is empty");
            System.out.println("5. Display all tickets");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter employee name: ");
                String name = scanner.nextLine();
                System.out.print("Enter issue description: ");
                String issue = scanner.nextLine();
                System.out.print("Enter submission timestamp: ");
                String timestamp = scanner.nextLine();

                Ticket newTicket = new Ticket(ticketCounter++, name, issue, timestamp);
                ticketQueue.add(newTicket);
                System.out.println("Ticket added successfully.");

            } else if (choice == 2) {
                if (ticketQueue.isEmpty()) {
                    System.out.println("No tickets to resolve.");
                } else {
                    Ticket resolvedTicket = ticketQueue.poll();
                    System.out.println("Resolved ticket: " + resolvedTicket);
                }

            } else if (choice == 3) {
                if (ticketQueue.isEmpty()) {
                    System.out.println("No tickets available.");
                } else {
                    Ticket nextTicket = ticketQueue.peek();
                    System.out.println("Next ticket to be served: " + nextTicket);
                }

            } else if (choice == 4) {
                if (ticketQueue.isEmpty()) {
                    System.out.println("The queue is empty.");
                } else {
                    System.out.println("There are tickets in the queue.");
                }

            } else if (choice == 5) {
                if (ticketQueue.isEmpty()) {
                    System.out.println("No tickets in the queue.");
                } else {
                    System.out.println("Current tickets in queue order:");
                    for (Ticket ticket : ticketQueue) {
                        System.out.println(ticket);
                    }
                }

            } else if (choice == 6) {
                System.out.println("Exiting the system. Goodbye!");
                scanner.close();
                break;

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
