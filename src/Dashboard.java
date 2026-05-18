import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard() {

        setTitle("Dashboard");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel lbl = new JLabel("Welcome to Student System!");
        lbl.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbl);

        JButton btnStudents = new JButton("Open Student Management");
        btnStudents.addActionListener(e -> {
            new StudentForm().setVisible(true);
        });
        add(btnStudents);

        JButton btnLogout = new JButton("Logout");

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

        setVisible(true);
    }
}