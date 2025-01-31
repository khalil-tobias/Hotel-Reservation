import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  // Add back for database operations
public class AddDrivers extends JFrame implements ActionListener {
     JButton addDriver, cancel;
    JTextField carModel1, carCompany1, dname, dage;
    JComboBox<String> availablity, cartype, Gender;

    AddDrivers() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel Drivers = new JLabel("Drivers");
        Drivers.setFont(new Font("Times New Roman", Font.BOLD, 17));
        Drivers.setBounds(60,10,120,30);
        add(Drivers);

        JLabel DriverName = new JLabel("Driver Name");
        DriverName.setFont(new Font("Times New Roman", Font.BOLD, 17));
        DriverName.setBounds(60,70,120,30);
        add(DriverName);
        
        dname = new JTextField();
        dname.setBounds(200,80,150,30);
        add(dname);

        JLabel driverAge = new JLabel("Age");
        driverAge.setFont(new Font("Times New Roman", Font.BOLD, 17));
        driverAge.setBounds(60,130,120,30);
        add(driverAge);

        dage = new JTextField();
        dage.setBounds(200,80,150,30);
        add(dage);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Times New Roman", Font.BOLD, 17));
        gender.setBounds(60,150,120,30);
        add(gender);

        String genderString[] = {"Male", "Female"};
        Gender = new JComboBox<>(genderString);
        Gender.setBounds(200,150,150,30);
        Gender.setBackground(Color.WHITE);
        add(Gender);

        JLabel carCompany = new JLabel("Car Company");
        carCompany.setFont(new Font("Times New Roman", Font.BOLD, 17));
        carCompany.setBounds(60,190,120,30);
        add(carCompany);

        carCompany1 = new JTextField();
        carCompany1.setBounds(200,190,150,30);
        add(carCompany1);

        JLabel carModel = new JLabel("Car Model");
        carModel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        carModel.setBounds(60,230,120,30);
        add(carModel);

        carModel1 = new JTextField();
        carModel1.setBounds(200,230,150,30);
        add(carModel1);

        String carTypes[] = {"BMW", "Mercedes", "Audi", "Toyota"};
        cartype = new JComboBox<>(carTypes);
        cartype.setBounds(200,230,150,30);
        cartype.setBackground(Color.WHITE);
        add(cartype); 

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Times New Roman", Font.BOLD, 17));
        available.setBounds(60,270,120,30);
        add(available); 

        String availableOptions[] = {"Available", "Not Available"};
        availablity = new JComboBox<>(availableOptions);
        availablity.setBounds(200,270,150,30);
        availablity.setBackground(Color.WHITE);
        add(availablity); 

        addDriver = new JButton("Add Driver");
        addDriver.setBackground(Color.BLACK);
        addDriver.setForeground(Color.WHITE);
        addDriver.setBounds(60,370,130,30);
        addDriver.addActionListener(this);
        add(addDriver); 

        cancel = new JButton("Cancel");
        cancel.setBounds(220,350,130,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/sixthImage.jpg"));
        Image image2 = icon.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(image2);
        JLabel image = new JLabel(icon2);
        image.setBounds(400,30,500,300);
        add(image);

        cancel.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addDriver) {
            String name = dname.getText();
            String age = dage.getText();
            String gender = (String)Gender.getSelectedItem();
            String carCompany = carCompany1.getText();
            String carModel = carModel1.getText();
            String carType = (String)cartype.getSelectedItem();
            String available = (String)availablity.getSelectedItem();
            
            try {
                Connection connection = new Connection();
                String query = "INSERT INTO drivers (name, age, gender, car_company, car_model, car_type, available) " +
                              "VALUES ('" + name + "', '" + age + "', '" + gender + "', '" + 
                              carCompany + "', '" + carModel + "', '" + carType + "', '" + available + "')";
                
                connection.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error adding driver: " + e.getMessage());
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AddRooms frame = new AddRooms();
            frame.setVisible(true);
        });
    }
    
}
