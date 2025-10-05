import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UniversityCourseFeedback {
    public static void main(String args[]) {
        JFrame frame = new JFrame("University Course Feedback");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.getContentPane().setBackground(new Color(245, 245, 245));

        JLabel titleLabel = new JLabel("University Course Feedback", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(0, 51, 102));

        JLabel studentIdLabel = new JLabel("Student ID: ");
        JLabel feedbackLabel = new JLabel("Feedback: ");
        JLabel courseLabel = new JLabel("Course: ");

        JTextField studentIdField = new JTextField(20);
        JTextField feedbackField = new JTextField(20);

        String[] courses = { "Introduction to Programming", "Data Structure", "Database", "Operating System" };
        JComboBox<String> courseComboBox = new JComboBox<>(courses);

        JButton submitButton = new JButton("Submit");
        submitButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        submitButton.setBackground(new Color(60, 179, 113));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setFocusPainted(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBackground(new Color(245, 245, 245));

        panel.add(studentIdLabel);
        panel.add(studentIdField);
        panel.add(feedbackLabel);
        panel.add(feedbackField);
        panel.add(courseLabel);
        panel.add(courseComboBox);
        panel.add(new JLabel());
        panel.add(submitButton);

        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = studentIdField.getText();
                String feedbackMessage = feedbackField.getText();
                String selectedCourse = (String) courseComboBox.getSelectedItem();

                if (studentId.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid Student ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                System.out.println("Student ID: " + studentId);
                System.out.println("Course: " + selectedCourse);
                System.out.println("Feedback: " + feedbackMessage);

                JOptionPane.showMessageDialog(frame, feedbackMessage, "Feedback Submitted", JOptionPane.INFORMATION_MESSAGE);

                studentIdField.setText("");
                feedbackField.setText("");
                courseComboBox.setSelectedIndex(0);
            }
        });

        frame.setVisible(true);
}
}
