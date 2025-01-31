import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Room() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/ninethImage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);




        // Create table with column headers
        String[] columns = {"Room Number", "Availability", "Status", "Price", "Bed Type"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        table.setBounds(0, 40, 500, 400);
        add(table);

        try {
            Connection connection = new Connection();
            String query = "select * from rooms";
            ResultSet rs = connection.statement.executeQuery(query);
            
            // Add rows to table
            while(rs.next()) {
                String roomNumber = rs.getString("roomNumber");
                String availability = rs.getString("availability");
                String status = rs.getString("status");
                String price = rs.getString("price");
                String bedType = rs.getString("bed_type");
                
                model.addRow(new Object[]{roomNumber, availability, status, price, bedType});
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 500, 120, 30);
        back.addActionListener(this);
        add(back);

        setBounds(300, 200, 1050, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {
        new Room();
    }
}
