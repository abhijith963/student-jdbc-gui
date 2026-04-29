import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentGUI extends JFrame {

    JTextField nameField, ageField, courseField;
    JTextArea outputArea;

    public StudentGUI() {
        setTitle("Student Management System");
        setSize(400, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Name:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField(20);
        add(ageField);

        add(new JLabel("Course:"));
        courseField = new JTextField(20);
        add(courseField);

        JButton addBtn = new JButton("Add Student");
        JButton viewBtn = new JButton("View Students");

        add(addBtn);
        add(viewBtn);

        outputArea = new JTextArea(10, 30);
        add(new JScrollPane(outputArea));

        // Add Student
        addBtn.addActionListener(e -> addStudent());

        // View Students
        viewBtn.addActionListener(e -> viewStudents());

        setVisible(true);
    }

    private void addStudent() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO students(name, age, course) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nameField.getText());
            ps.setInt(2, Integer.parseInt(ageField.getText()));
            ps.setString(3, courseField.getText());

            ps.executeUpdate();
            outputArea.setText("Student added successfully");

        } catch (Exception e) {
            outputArea.setText("Error: " + e.getMessage());
        }
    }

    private void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            StringBuilder result = new StringBuilder();
            while (rs.next()) {
                result.append(rs.getInt("id")).append(" ")
                      .append(rs.getString("name")).append(" ")
                      .append(rs.getInt("age")).append(" ")
                      .append(rs.getString("course")).append("\n");
            }

            outputArea.setText(result.toString());

        } catch (Exception e) {
            outputArea.setText("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new StudentGUI();
    }
}