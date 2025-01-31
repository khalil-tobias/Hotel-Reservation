import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {
    
    Dashboard() {
        // Set frame properties
        setBounds(0, 0, 1550, 1000);
        setLayout(null);
        
        // Load and scale background image properly
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/thirdImage.png"));
        Image imageIcon = icon.getImage().getScaledInstance(1550, 1000, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imageIcon);
        JLabel image = new JLabel(scaledIcon);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        // Welcome text
        JLabel text = new JLabel("Welcome to the EliteStay Hotel");
        text.setBounds(400, 80, 1000, 50);
        text.setFont(new Font("Serif", Font.PLAIN, 46));
        text.setForeground(Color.WHITE);
        image.add(text);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1550, 30);
        
        // Hotel Management Menu
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.BLUE);
        hotel.setFont(new Font("Serif", Font.BOLD, 14));
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.setFont(new Font("Serif", Font.PLAIN, 14));
        reception.addActionListener(this);
        hotel.add(reception);
        
        // Admin Menu
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.RED);
        admin.setFont(new Font("Serif", Font.BOLD, 14));
        
        JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
        addEmployee.setFont(new Font("Serif", Font.PLAIN, 14));
        addEmployee.addActionListener(this);
        admin.add(addEmployee);
        
        JMenuItem addRooms = new JMenuItem("ADD ROOMS");
        addRooms.setFont(new Font("Serif", Font.PLAIN, 14));
        addRooms.addActionListener(this);
        admin.add(addRooms);
        
        JMenuItem addDrivers = new JMenuItem("ADD DRIVERS");
        addDrivers.setFont(new Font("Serif", Font.PLAIN, 14));
        addDrivers.addActionListener(this);
        admin.add(addDrivers);
        
        // Add menus to menu bar
        menuBar.add(hotel);
        menuBar.add(admin);
        
        image.add(menuBar);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee();
        } else if (ae.getActionCommand().equals("ADD ROOMS")) {
            // Add room handling code here
            new AddRooms();
        } else if (ae.getActionCommand().equals("ADD DRIVERS")) {
            new AddDrivers(); 
        } else if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
            // Add reception handling code here
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
