import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class StudentForm extends JFrame implements ActionListener {

    JLabel lblName;
    JTextField txtName;
    JButton btnAdd;

    public StudentForm() {

        setTitle("Student Management");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lblName = new JLabel("Full Name:");
        lblName.setBounds(30, 50, 100, 30);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(120, 50, 200, 30);
        add(txtName);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(120, 120, 100, 35);
        btnAdd.addActionListener(this);
        add(btnAdd);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAdd) {
            JOptionPane.showMessageDialog(this,
                    "Student: " + txtName.getText());
        }
    }
}