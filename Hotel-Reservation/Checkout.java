import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Checkout extends JFrame implements ActionListener {
    Choice customerID;
    JButton checkout, back;
    
    Checkout() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(100, 20, 100, 30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        JLabel lblID = new JLabel("Customer ID");
        lblID.setBounds(30, 80, 100, 30);
        add(lblID);
        
        customerID = new Choice();
        customerID.setBounds(150, 80, 150, 25);
        add(customerID);

        // Add tick image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310, 80, 20, 20);
        add(image);

        // Add background image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(550, 50, 400, 400);
        add(image2);
        
        try {
            Connection conn = new Connection();
            ResultSet rs = conn.statement.executeQuery("select * from customers");
            while(rs.next()) {
                customerID.add(rs.getString("customerId"));
            }
            rs.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        // Create table
        String[] columns = {"Room Number", "Name", "Check-in Time", "Amount Paid", "Pending Amount"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 150, 500, 300);  // Adjusted width to accommodate image
        add(sp);
        
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30, 500, 120, 30);
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170, 500, 120, 30);
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkout) {
            String query1 = "delete from customers where customerId = '" + customerID.getSelectedItem() + "'";
            String query2 = "update rooms set availability = 'Available' where roomnumber = '" + customerID.getSelectedItem() + "'";
            try {
                Connection conn = new Connection();
                conn.statement.executeUpdate(query1);
                conn.statement.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Checkout done");
                setVisible(false);
                new Reception();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Checkout();
    }
}
