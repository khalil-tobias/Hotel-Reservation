import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class AddCustomers extends JFrame implements ActionListener {
    JComboBox cmbId, cmbCountry, cmbState;
    JTextField tfNumber, tfName, tfAddress, tfZipCode, tfDeposit;
    JRadioButton male, female;
    JLabel lblroomNumber,lblNumber, lblName,gender, lblAddress, lblId, Country, State, ZipCode, checkinTime, checkinDate, deposit,
            lblCheckoutTime, checkoutTime;
    JButton btnAdd, btnBack;
    Choice croom;
    AddCustomers(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Add Customer");
        text.setBounds(100,20,300,20);
        text.setFont(new Font("serif", Font.PLAIN, 20));
        add(text);

        lblId = new JLabel("Id");
        lblId.setBounds(35,80,100,20);
        lblId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblId);

        String[] idTypes = {"Passport","Drivers License"};
        cmbId = new JComboBox(idTypes);
        cmbId.setBounds(200,80,150,25);
        cmbId.setBackground(Color.WHITE);
        add(cmbId);

        lblNumber = new JLabel("Number");
        lblNumber.setBounds(35,120,100,20);
        lblNumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblNumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(200,120,150,25);
        add(tfNumber);

        lblName = new JLabel("Name");
        lblName.setBounds(35,160,100,20);
        lblName.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200,160,150,25);
        add(tfName);

        gender = new JLabel("Gender");
        gender.setBounds(35,200,100,20);
        gender.setFont(new Font("serif", Font.PLAIN, 20));
        add(gender);

        // Create ButtonGroup for gender selection
        ButtonGroup genderGroup = new ButtonGroup();

        male = new JRadioButton("Male");
        male.setBounds(200,200,80,20);  // Increased width to fit text
        male.setBackground(Color.WHITE);
        male.setFont(new Font("serif", Font.PLAIN, 16));
        add(male);
        genderGroup.add(male);

        female = new JRadioButton("Female");
        female.setBounds(290,200,80,20);  // Adjusted x position and width
        female.setBackground(Color.WHITE);
        female.setFont(new Font("serif", Font.PLAIN, 16));
        add(female);
        genderGroup.add(female);

        Country = new JLabel("Country");
        Country.setBounds(35,240,100,20);
        Country.setFont(new Font("serif", Font.PLAIN, 20));
        add(Country);

        String[] CountryOptions = {"India", "USA", "UK", "Canada", "Australia"};
        cmbCountry = new JComboBox(CountryOptions);
        cmbCountry.setBounds(200,240,150,25);
        cmbCountry.setBackground(Color.WHITE);
        add(cmbCountry);

        State = new JLabel("State");
        State.setBounds(35,280,100,20);
        State.setFont(new Font("serif", Font.PLAIN, 20));
        add(State);

        String[] StateOptions = {"Florida", "Georgia", "New York", "Alabama", "Other"};
        cmbState = new JComboBox(StateOptions);
        cmbState.setBounds(200,280,150,25);
        cmbState.setBackground(Color.WHITE);
        add(cmbState);

        ZipCode = new JLabel("Zip Code");
        ZipCode.setBounds(35,320,100,20);
        ZipCode.setFont(new Font("serif", Font.PLAIN, 20));
        add(ZipCode);

        tfZipCode = new JTextField();
        tfZipCode.setBounds(200,320,150,25);
        add(tfZipCode);

        // Address section
        lblAddress = new JLabel("Address");
        lblAddress.setBounds(35, 360, 100, 20);
        lblAddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(200, 360, 150, 25);
        add(tfAddress);

        // Room Number section
        lblroomNumber = new JLabel("Room Number");
        lblroomNumber.setBounds(35, 400, 150, 20);
        lblroomNumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblroomNumber);

        croom = new Choice();
        croom.setBounds(200, 400, 150, 25);  // Add Choice component for room selection
        add(croom);

        // Deposit section - moved after room number
        deposit = new JLabel("Deposit");
        deposit.setBounds(35, 440, 150, 20);
        deposit.setFont(new Font("serif", Font.PLAIN, 20));
        add(deposit);

        tfDeposit = new JTextField();
        tfDeposit.setBounds(200, 440, 150, 25);
        add(tfDeposit);

        // Add Check-in Date
        java.util.Date date = new java.util.Date();  // Specify java.util.Date explicitly
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        checkinDate = new JLabel("" + dateFormat.format(date));
        checkinDate.setBounds(200, 480, 150, 25);
        checkinDate.setFont(new Font("serif", Font.PLAIN, 16));
        add(checkinDate);

        // Add Check-in Time
        JLabel lblCheckinTime = new JLabel("Check-in Time");
        lblCheckinTime.setBounds(35, 520, 150, 20);
        lblCheckinTime.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblCheckinTime);

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        checkinTime = new JLabel("" + timeFormat.format(date));
        checkinTime.setBounds(200, 520, 150, 25);
        checkinTime.setFont(new Font("serif", Font.PLAIN, 16));
        add(checkinTime);

        lblCheckoutTime = new JLabel("Check-out Time");
        lblCheckoutTime.setBounds(35, 560, 150, 20);  // Adjusted y-coordinate
        lblCheckoutTime.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblCheckoutTime);

        checkoutTime = new JLabel("" + timeFormat.format(date));
        checkoutTime.setBounds(200, 560, 150, 25);  // Adjusted y-coordinate
        checkoutTime.setFont(new Font("serif", Font.PLAIN, 16));
        add(checkoutTime);

        // Fix button positions
        btnAdd = new JButton("Add");
        btnAdd.setBackground(Color.WHITE);
        btnAdd.setForeground(Color.BLACK);
        btnAdd.setBounds(50, 600, 120, 30);  // Moved below all fields
        btnAdd.addActionListener(this);  // Add action listener
        add(btnAdd);

        btnBack = new JButton("Back");
        btnBack.setBackground(Color.WHITE);
        btnBack.setForeground(Color.BLACK);
        btnBack.setBounds(200, 600, 120, 30);  // Moved below all fields
        btnBack.addActionListener(this);  // Add action listener
        add(btnBack);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/eigthImage.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);

        // Adjust frame size to fit buttons
        setBounds(350, 200, 800, 700);
        setVisible(true);
    }

    // Add action handling
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnAdd) {
            // Add customer logic here
            String id = cmbId.getSelectedItem().toString();
            String number = tfNumber.getText();
            String name = tfName.getText();
            String gender = (male.isSelected()) ? "Male" : "Female";
            String country = cmbCountry.getSelectedItem().toString();
            String state = cmbState.getSelectedItem().toString();
            String zipCode = tfZipCode.getText();
            String address = tfAddress.getText();

            if(male.isSelected()){
                gender = "Male";
            } else {
                gender = "Female";
            }
            String room = croom.getSelectedItem().toString();
            String deposit = tfDeposit.getText();
            String time = checkinTime.getText();
            String date = checkinDate.getText();

            try {
                Connection connection = new Connection();
                String query = "INSERT INTO customers (id, number, name, gender, country, state, zipCode, address, room, deposit, checkinDate, checkinTime, checkoutTime) " +
                              "VALUES ('" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + state + "', '" + zipCode + "', '" + address + "', '" + room + "', '" + deposit + "', '" + date + "', '" + time + "', '" + time + "')";
                connection.statement.executeUpdate(query);
                String query2 = "update rooms set status = 'Occupied' where roomNumber = '" + room + "'";
                connection.statement.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error adding customer: " + e.getMessage());
            }
        } else if (ae.getSource() == btnBack) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new AddCustomers();
    }
}
