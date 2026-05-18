import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm extends JFrame implements ActionListener {

    JLabel lblTitle, lblUsername, lblPassword;
    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton btnLogin;

    public LoginForm() {

        setTitle("Login System");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lblTitle = new JLabel("Student Record System");
        lblTitle.setBounds(80, 20, 300, 30);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTitle);

        lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 80, 100, 30);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(150, 80, 180, 30);
        add(txtUsername);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 130, 100, 30);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 130, 180, 30);
        add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(150, 190, 100, 35);
        btnLogin.addActionListener(this);
        add(btnLogin);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Connection conn = DBConnection.getConnection();

            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Database Connection Failed!");
                return;
            }

            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, txtUsername.getText());
            pst.setString(2, new String(txtPassword.getPassword()));

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful!");

                dispose();

                SwingUtilities.invokeLater(() -> {
                    new Dashboard().setVisible(true);
                });

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}