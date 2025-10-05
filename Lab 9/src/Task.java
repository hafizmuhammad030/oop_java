

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class StylishTicketSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicketGUI(new SeatManager()));
    }
}


class Seat {
    String seatNumber, category, customerName, contactNumber;
    boolean isBooked;

    public Seat(String seatNumber, String category) {
        this.seatNumber = seatNumber;
        this.category = category;
        this.isBooked = false;
    }

    @Override
    public String toString() {
        return seatNumber + " [" + category + "] - " + (isBooked ? "Booked by " + customerName : "Available");
    }
}

class Action {
    String seatNumber, customerName, contactNumber, type, flightTime;

    public Action(String seatNumber, String customerName, String contactNumber, String type, String flightTime) {
        this.seatNumber = seatNumber;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.type = type;
        this.flightTime = flightTime;
    }
}

class CategoryNode {
    String category;
    double price;
    CategoryNode left, right;

    public CategoryNode(String category, double price) {
        this.category = category;
        this.price = price;
    }
}

class CategoryTree {
    CategoryNode root;

    public void insert(String category, double price) {
        root = insertRec(root, category, price);
    }

    private CategoryNode insertRec(CategoryNode root, String category, double price) {
        if (root == null) return new CategoryNode(category, price);
        if (category.compareTo(root.category) < 0)
            root.left = insertRec(root.left, category, price);
        else if (category.compareTo(root.category) > 0)
            root.right = insertRec(root.right, category, price);
        return root;
    }

    public double getPrice(String category) {
        CategoryNode node = root;
        while (node != null) {
            int cmp = category.compareTo(node.category);
            if (cmp == 0) return node.price;
            else if (cmp < 0) node = node.left;
            else node = node.right;
        }
        return -1;
    }
}

class SeatManager {
    HashMap<String, HashMap<String, Seat>> seatsPerFlight = new HashMap<>();
    Stack<Action> bookingStack = new Stack<>();
    Stack<Action> cancelStack = new Stack<>();
    CategoryTree categoryTree = new CategoryTree();

    public SeatManager() {
        categoryTree.insert("VIP", 1000);
        categoryTree.insert("Premium", 750);
        categoryTree.insert("Economy", 500);

        String[] flights = {"10:00 AM", "2:00 PM", "8:00 PM"};
        String[] categories = {"VIP", "Economy", "Premium"};
        String[] rows = {"A", "B", "C"};

        for (String flight : flights) {
            HashMap<String, Seat> seatMap = new HashMap<>();
            for (int i = 1; i <= 30; i++) {
                for (int j = 0; j < categories.length; j++) {
                    String seatId = rows[j] + i;
                    seatMap.put(seatId, new Seat(seatId, categories[j]));
                }
            }
            seatsPerFlight.put(flight, seatMap);
        }
    }

    public boolean bookSeat(String flightTime, String seatNumber, String customerName, String contactNumber) {
        Seat seat = seatsPerFlight.get(flightTime).get(seatNumber.toUpperCase());
        if (seat != null && !seat.isBooked) {
            seat.isBooked = true;
            seat.customerName = customerName;
            seat.contactNumber = contactNumber;
            bookingStack.push(new Action(seatNumber, customerName, contactNumber, "BOOK", flightTime));
            return true;
        }
        return false;
    }

    public boolean cancelSeat(String flightTime, String seatNumber) {
        Seat seat = seatsPerFlight.get(flightTime).get(seatNumber.toUpperCase());
        if (seat != null && seat.isBooked) {
            cancelStack.push(new Action(seatNumber, seat.customerName, seat.contactNumber, "CANCEL", flightTime));
            seat.isBooked = false;
            seat.customerName = null;
            seat.contactNumber = null;
            return true;
        }
        return false;
    }

    public boolean undoBooking() {
        if (!bookingStack.isEmpty()) {
            Action a = bookingStack.pop();
            Seat seat = seatsPerFlight.get(a.flightTime).get(a.seatNumber);
            if (seat != null && seat.isBooked) {
                seat.isBooked = false;
                seat.customerName = null;
                seat.contactNumber = null;
                return true;
            }
        }
        return false;
    }

    public boolean undoCancellation() {
        if (!cancelStack.isEmpty()) {
            Action a = cancelStack.pop();
            Seat seat = seatsPerFlight.get(a.flightTime).get(a.seatNumber);
            if (seat != null && !seat.isBooked) {
                seat.isBooked = true;
                seat.customerName = a.customerName;
                seat.contactNumber = a.contactNumber;
                return true;
            }
        }
        return false;
    }

    public Collection<Seat> getAllSeats(String flightTime) {
        return seatsPerFlight.get(flightTime).values();
    }

    public Map<String, Seat> getAllBookedSeatsWithFlight() {
        Map<String, Seat> booked = new LinkedHashMap<>();
        for (String flight : seatsPerFlight.keySet()) {
            for (Seat seat : seatsPerFlight.get(flight).values()) {
                if (seat.isBooked) {
                    booked.put(flight + " – " + seat.seatNumber, seat);
                }
            }
        }
        return booked;
    }

    public double getPrice(String cat) {
        return categoryTree.getPrice(cat);
    }

    public Set<String> getFlightTimes() {
        return seatsPerFlight.keySet();
    }
}

class TicketGUI extends JFrame {
    SeatManager sm;

    public TicketGUI(SeatManager sm) {
        this.sm = sm;
        setTitle("✈ Stylish Ticket Booking System");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(30, 30, 60));
        sidebar.setPreferredSize(new Dimension(250, getHeight()));

        JLabel title = new JLabel("✈ Stylish Menu", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(Box.createRigidArea(new Dimension(0, 20)));
        sidebar.add(title);

        String[] options = {"Book Ticket", "Cancel Booking", "View Booked Tickets", "View Seats by Category", "Search Customer", "Undo Last Booking", "Undo Last Cancellation"};

        for (String option : options) {
            JButton btn = new JButton(option);
            btn.setMaximumSize(new Dimension(220, 45));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setBackground(new Color(85, 110, 170));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
            sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
            sidebar.add(btn);

            btn.addActionListener(e -> {
                String action = btn.getText();
                if (action.equals("Book Ticket")) {
                    bookTicketForm();
                } else if (action.equals("Cancel Booking")) {
                    cancelBookingForm();
                } else if (action.equals("View Booked Tickets")) {
                    showBookedTickets();
                } else if (action.equals("View Seats by Category")) {
                    chooseCategoryToView();
                } else if (action.equals("Search Customer")) {
                    searchByCustomer();
                } else if (action.equals("Undo Last Booking")) {
                    boolean undone = sm.undoBooking();
                    JOptionPane.showMessageDialog(this, undone ? "✅ Booking undone!" : "❌ No booking to undo.");
                } else if (action.equals("Undo Last Cancellation")) {
                    boolean undone = sm.undoCancellation();
                    JOptionPane.showMessageDialog(this, undone ? "✅ Cancellation undone!" : "❌ No cancellation to undo.");
                }
            });
        }

        JLabel welcome = new JLabel("<html><center><h1>Welcome to Stylish Ticket System</h1><p>Select an option from the menu.</p></center></html>", SwingConstants.CENTER);
        welcome.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        add(sidebar, BorderLayout.WEST);
        add(welcome, BorderLayout.CENTER);
        setVisible(true);
    }

    void bookTicketForm() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JComboBox<String> flightCombo = new JComboBox<>(sm.getFlightTimes().toArray(new String[0]));
        JTextField seatField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField contactField = new JTextField();

        panel.add(new JLabel("Select Flight Time:"));
        panel.add(flightCombo);
        panel.add(new JLabel("Seat Number (e.g., A1):"));
        panel.add(seatField);
        panel.add(new JLabel("Customer Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Contact Number:"));
        panel.add(contactField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Book Ticket", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String flight = (String) flightCombo.getSelectedItem();
            String seat = seatField.getText().toUpperCase();
            String name = nameField.getText();
            String contact = contactField.getText();

            if (sm.bookSeat(flight, seat, name, contact)) {
                Seat bookedSeat = sm.getAllSeats(flight).stream().filter(s -> s.seatNumber.equalsIgnoreCase(seat)).findFirst().orElse(null);
                String info = "🎫 Ticket Booked!\nFlight: " + flight + "\nSeat: " + seat +
                        "\nCategory: " + bookedSeat.category + "\nPrice: $" + sm.getPrice(bookedSeat.category) +
                        "\nCustomer: " + name + "\nContact: " + contact;
                JOptionPane.showMessageDialog(this, info, "Booking Confirmed", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "❌ Seat is already booked or invalid!", "Booking Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    void cancelBookingForm() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JComboBox<String> flightCombo = new JComboBox<>(sm.getFlightTimes().toArray(new String[0]));
        JTextField seatField = new JTextField();

        panel.add(new JLabel("Select Flight Time:"));
        panel.add(flightCombo);
        panel.add(new JLabel("Seat Number:"));
        panel.add(seatField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Cancel Booking", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String flight = (String) flightCombo.getSelectedItem();
            String seat = seatField.getText().toUpperCase();

            if (sm.cancelSeat(flight, seat)) {
                JOptionPane.showMessageDialog(this, "✅ Booking canceled successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "❌ Seat is not booked or invalid!", "Cancel Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    void showBookedTickets() {
        Map<String, Seat> booked = sm.getAllBookedSeatsWithFlight();
        if (booked.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No booked tickets available.");
            return;
        }

        JTextArea area = new JTextArea();
        area.setFont(new Font("Monospaced", Font.PLAIN, 14));
        area.setEditable(false);
        for (Map.Entry<String, Seat> entry : booked.entrySet()) {
            Seat s = entry.getValue();
            area.append("Flight: " + entry.getKey().split(" – ")[0] +
                    ", Seat: " + s.seatNumber +
                    ", Category: " + s.category +
                    ", Name: " + s.customerName +
                    ", Contact: " + s.contactNumber + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        JOptionPane.showMessageDialog(this, scrollPane, "Booked Tickets", JOptionPane.INFORMATION_MESSAGE);
    }

    void chooseCategoryToView() {
        String[] cats = {"VIP", "Premium", "Economy"};
        String cat = (String) JOptionPane.showInputDialog(this, "Choose category to view:", "Seat Category", JOptionPane.QUESTION_MESSAGE, null, cats, cats[0]);
        if (cat != null) showSeatGrid(cat);
    }

    void showSeatGrid(String category) {
        JPanel panel = new JPanel(new GridLayout(0, 5, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Seats - " + category));

        for (String flight : sm.getFlightTimes()) {
            for (Seat s : sm.getAllSeats(flight)) {
                if (s.category.equalsIgnoreCase(category)) {
                    JLabel label = new JLabel(s.seatNumber + (s.isBooked ? " ❌" : " ✅"));
                    label.setForeground(s.isBooked ? Color.RED : new Color(0, 128, 0));
                    panel.add(label);
                }
            }
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(500, 400));
        JOptionPane.showMessageDialog(this, scrollPane, "Seat Status", JOptionPane.PLAIN_MESSAGE);
    }

    void searchByCustomer() {
        String name = JOptionPane.showInputDialog(this, "Enter Customer Name:");
        if (name == null || name.isEmpty()) return;

        JTextArea result = new JTextArea();
        result.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        result.setEditable(false);

        for (String flight : sm.getFlightTimes()) {
            for (Seat seat : sm.getAllSeats(flight)) {
                if (seat.isBooked && seat.customerName.equalsIgnoreCase(name.trim())) {
                    result.append("Flight: " + flight + ", Seat: " + seat.seatNumber +
                            ", Category: " + seat.category + ", Contact: " + seat.contactNumber + "\n");
                }
            }
        }

        if (result.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No booking found for " + name);
        } else {
            JScrollPane scrollPane = new JScrollPane(result);
            scrollPane.setPreferredSize(new Dimension(500, 300));
            JOptionPane.showMessageDialog(this, scrollPane, "Customer Booking Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
