import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login, cancel;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Username components
        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        user.setFont(new Font("Serif", Font.BOLD, 14));
        add(user);

        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);

        // Password components
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);  // Fixed bounds
        pass.setFont(new Font("Serif", Font.BOLD, 14));
        add(pass);

        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);

        // Login button
        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK);
        login.setFont(new Font("Serif", Font.BOLD, 14));
        login.addActionListener(this);
        add(login);

        // Cancel button
        cancel = new JButton("Cancel");  // Fixed button text
        cancel.setBounds(180, 150, 120, 30);  // Fixed position
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("Serif", Font.BOLD, 14));
        cancel.addActionListener(this);
        add(cancel);

        // Image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/secondImage.png"));
        Image icon2 = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel image = new JLabel(icon3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        // Frame settings
        setBounds(500, 200, 600, 300);
        setTitle("EliteStay Hotel Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String user = username.getText();
            String pass = new String(password.getPassword());

            try {
                Connection conn = new Connection();  // Using your Connection class
                // Using the statement from your Connection class
                String query = "SELECT * FROM login WHERE username='" + user + "' AND password='" + pass + "'";
                ResultSet rs = conn.statement.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    username.setText("");
                    password.setText("");
                }
                
                rs.close();
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == cancel) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
