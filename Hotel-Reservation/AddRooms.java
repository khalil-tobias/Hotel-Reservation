import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  // Add back for database operations
public class AddRooms extends JFrame implements ActionListener {
     JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox<String> available, cleaning, bed;

    AddRooms() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel lblRoom = new JLabel("Add Rooms");
        lblRoom.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblRoom.setBounds(60,80,120,30);
        add(lblRoom);

        JLabel lblRoomNumber = new JLabel("Room Number");
        lblRoomNumber.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblRoomNumber.setBounds(150,60,200,20);
        add(lblRoomNumber);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);

        JLabel roomAvailable = new JLabel("Rooms Available");
        roomAvailable.setFont(new Font("Times New Roman", Font.BOLD, 17));
        roomAvailable.setBounds(60,130,120,30);
        add(roomAvailable);

        String availableOptions[] = {"Available", "Not Available"};
        available = new JComboBox<>(availableOptions);
        available.setBounds(200,130,150,30);
        available.setBackground(Color.WHITE);
        add(available);

        JLabel cleaning_status = new JLabel("Cleaning Status");
        cleaning_status.setFont(new Font("Times New Roman", Font.BOLD, 17));
        cleaning_status.setBounds(60,180,120,30);
        add(cleaning_status);

        String cleaningOptions[] = {"Cleaned", "Dirty"};
        cleaning = new JComboBox<>(cleaningOptions);
        cleaning.setBounds(200,180,150,30);
        cleaning.setBackground(Color.WHITE);
        add(cleaning);

        JLabel price = new JLabel("Price");
        price.setFont(new Font("Times New Roman", Font.BOLD, 17));
        price.setBounds(60,230,120,30);
        add(price);

        tfprice = new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);

        JLabel bedType = new JLabel("Bed Type");
        bedType.setFont(new Font("Times New Roman", Font.BOLD, 17));
        bedType.setBounds(60,280,120,30);
        add(bedType);

        String bedOptions[] = {"Single", "Double", "King", "Queen"};
        bed = new JComboBox<>(bedOptions);
        bed.setBounds(200,280,150,30);
        bed.setBackground(Color.WHITE);
        add(bed); 

        add = new JButton("Add Room");
        add.setBounds(60,350,130,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add); 

        cancel = new JButton("Cancel");
        cancel.setBounds(220,350,130,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/fifthImage1.png"));
        JLabel image = new JLabel(icon);
        image.setBounds(400,30,500,300);
        add(image);

        cancel.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String roomNumber = tfroom.getText();
            String price = tfprice.getText();
            String availableStatus = (String)available.getSelectedItem();
            String cleaningStatus = (String)cleaning.getSelectedItem();
            String bedType = (String)bed.getSelectedItem();
            
            try
            {
                Connection connection = new Connection();
                String query = "INSERT INTO room (roomnumber, availability, cleaning_status, price, bed_type) " +
                              "VALUES ('" + roomNumber + "', '" + availableStatus + "', '" + 
                              cleaningStatus + "', '" + price + "', '" + bedType + "')";
                connection.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Room Added Successfully");
                setVisible(false);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        } 
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AddRooms frame = new AddRooms();
            frame.setVisible(true);
        });
    }
    
}

