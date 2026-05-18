import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton btnStudents, btnLogout;

    public Dashboard() {

        setTitle("Dashboard");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTitle = new JLabel("Dashboard");
        lblTitle.setBounds(180, 30, 200, 30);
        add(lblTitle);

        btnStudents = new JButton("Manage Students");
        btnStudents.setBounds(150, 100, 180, 40);
        btnStudents.addActionListener(this);
        add(btnStudents);

        btnLogout = new JButton("Logout");
        btnLogout.setBounds(150, 170, 180, 40);
        btnLogout.addActionListener(this);
        add(btnLogout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnStudents) {
            new StudentForm().setVisible(true);
        }

        if (e.getSource() == btnLogout) {
            dispose();
            new LoginForm().setVisible(true);
        }
    }
}