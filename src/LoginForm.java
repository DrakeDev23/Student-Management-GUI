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
        lblTitle.setBounds(90, 20, 250, 30);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, txtUsername.getText());
            pst.setString(2, txtPassword.getText());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                JOptionPane.showMessageDialog(this, "Login Successful");

                new Dashboard().setVisible(true);
                dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}