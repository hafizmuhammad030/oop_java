import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Basic Device class
class Device {
    private String name;
    private boolean isOn;

    public Device(String name) {
        this.name = name;
        this.isOn = false;  // Default state is off
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return isOn;
    }

    public void toggle() {
        this.isOn = !this.isOn;
    }

    public String getStatus() {
        return isOn ? "On" : "Off";
    }
}


 class SmartHomeController {

    private JFrame frame;
    private JPanel panel;
    private DefaultListModel<String> deviceListModel;
    private JList<String> deviceList;
    private ArrayList<Device> devices;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SmartHomeController controller = new SmartHomeController();
            controller.createAndShowGUI();
        });
    }

    public SmartHomeController() {
        devices = new ArrayList<>();
    }

    public void createAndShowGUI() {
        frame = new JFrame("Smart Home Controller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Device list setup
        deviceListModel = new DefaultListModel<>();
        deviceList = new JList<>(deviceListModel);
        JScrollPane scrollPane = new JScrollPane(deviceList);

        panel.add(scrollPane, BorderLayout.CENTER);

        // Control panel (buttons, sliders, etc.)
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        // Add device button
        JButton addDeviceButton = new JButton("Add Device");
        addDeviceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deviceName = JOptionPane.showInputDialog("Enter device name:");
                if (deviceName != null && !deviceName.isEmpty()) {
                    addDevice(deviceName);
                }
            }
        });

        // Remove device button
        JButton removeDeviceButton = new JButton("Remove Device");
        removeDeviceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = deviceList.getSelectedIndex();
                if (selectedIndex != -1) {
                    removeDevice(selectedIndex);
                }
            }
        });

        // Toggle device on/off
        JButton toggleDeviceButton = new JButton("Toggle Device");
        toggleDeviceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = deviceList.getSelectedIndex();
                if (selectedIndex != -1) {
                    toggleDevice(selectedIndex);
                }
            }
        });

        controlPanel.add(addDeviceButton);
        controlPanel.add(removeDeviceButton);
        controlPanel.add(toggleDeviceButton);

        panel.add(controlPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }


    private void addDevice(String name) {
        Device newDevice = new Device(name);
        devices.add(newDevice);
        deviceListModel.addElement(name + " - Off");
    }


    private void removeDevice(int index) {
        devices.remove(index);
        deviceListModel.remove(index);
    }


    private void toggleDevice(int index) {
        Device device = devices.get(index);
        device.toggle();
        deviceListModel.set(index, device.getName() + " - " + device.getStatus());
    }
}
