import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentForm extends JFrame implements ActionListener {

    JTextField txtName, txtCourse, txtYear, txtId;
    JButton btnAdd, btnUpdate, btnDelete, btnClear, btnLogout;
    JTable table;
    DefaultTableModel model;

    Connection conn;

    public StudentForm() {

        conn = DBConnection.getConnection();

        setTitle("Student CRUD System");
        setSize(700, 450);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(20, 20, 80, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(100, 20, 150, 25);
        txtId.setEditable(false);
        add(txtId);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(20, 60, 80, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(100, 60, 150, 25);
        add(txtName);

        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setBounds(20, 100, 80, 25);
        add(lblCourse);

        txtCourse = new JTextField();
        txtCourse.setBounds(100, 100, 150, 25);
        add(txtCourse);

        JLabel lblYear = new JLabel("Year:");
        lblYear.setBounds(20, 140, 80, 25);
        add(lblYear);

        txtYear = new JTextField();
        txtYear.setBounds(100, 140, 150, 25);
        add(txtYear);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(280, 20, 100, 30);
        btnAdd.addActionListener(this);
        add(btnAdd);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(280, 60, 100, 30);
        btnUpdate.addActionListener(this);
        add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(280, 100, 100, 30);
        btnDelete.addActionListener(this);
        add(btnDelete);

        btnClear = new JButton("Clear");
        btnClear.setBounds(280, 140, 100, 30);
        btnClear.addActionListener(this);
        add(btnClear);

        btnLogout = new JButton("Logout");
        btnLogout.setBounds(400, 20, 100, 30);

        btnLogout.addActionListener(e -> {

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                dispose();

                SwingUtilities.invokeLater(() -> {
                    LoginForm login = new LoginForm();
                    login.setVisible(true);
                    login.setLocationRelativeTo(null);
                });
            }
        });

        add(btnLogout);

        model = new DefaultTableModel();
        table = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Course");
        model.addColumn("Year");

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 200, 640, 200);
        add(sp);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();

                txtId.setText(model.getValueAt(row, 0).toString());
                txtName.setText(model.getValueAt(row, 1).toString());
                txtCourse.setText(model.getValueAt(row, 2).toString());
                txtYear.setText(model.getValueAt(row, 3).toString());
            }
        });

        loadData();

        setVisible(true);
    }

    public void loadData() {
        try {
            model.setRowCount(0);

            String sql = "SELECT * FROM students";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[] {
                        rs.getInt("id"),
                        rs.getString("fullname"),
                        rs.getString("course"),
                        rs.getString("year_level")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAdd)
            addStudent();
        else if (e.getSource() == btnUpdate)
            updateStudent();
        else if (e.getSource() == btnDelete)
            deleteStudent();
        else if (e.getSource() == btnClear)
            clearFields();
    }

    public void addStudent() {
    }

    public void updateStudent() {
    }

    public void deleteStudent() {
    }

    public void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtCourse.setText("");
        txtYear.setText("");
    }
}