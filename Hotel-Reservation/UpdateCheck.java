import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class UpdateCheck extends JFrame implements ActionListener {
    Choice ccustomerId;
    JTextField tfname, tcheckInTime, tfpendingAmount, tfroom, tfamountPaid;
    JButton check, update, back;

    UpdateCheck() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(90, 20, 200, 30);
        text.setForeground(Color.BLUE);
        add(text);

        JLabel lblCustomerId = new JLabel("Customer ID");
        lblCustomerId.setBounds(30, 80, 100, 20);
        add(lblCustomerId);

        ccustomerId = new Choice();
        ccustomerId.setBounds(200, 80, 100, 20);
        add(ccustomerId);

        try {
            Connection conn = new Connection();
            String query = "select * from customers";
            ResultSet rs = conn.statement.executeQuery(query);
            while(rs.next()) {
                ccustomerId.add(rs.getString("customerId"));
            }
            rs.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        JLabel room = new JLabel("Room Number");
        room.setBounds(30, 280, 100, 20);
        add(room);

        tfroom = new JTextField();
        tfroom.setBounds(200, 280, 150, 20);
        add(tfroom);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30, 120, 100, 20);
        add(lblName);

        tfname = new JTextField();
        tfname.setBounds(200, 120, 150, 25);
        add(tfname);

        JLabel checkInTime = new JLabel("Check In Time");
        checkInTime.setBounds(30, 160, 100, 20);
        add(checkInTime);

        tcheckInTime = new JTextField();
        tcheckInTime.setBounds(200, 160, 150, 25);
        add(tcheckInTime);

        JLabel amountPaid = new JLabel("Amount Paid");
        amountPaid.setBounds(30, 200, 100, 20);
        add(amountPaid);

        tfamountPaid = new JTextField();
        tfamountPaid.setBounds(200, 200, 150, 25);
        add(tfamountPaid);

        JLabel pendingAmount = new JLabel("Pending Amount");
        pendingAmount.setBounds(30, 240, 100, 20);
        add(pendingAmount);

        tfpendingAmount = new JTextField();
        tfpendingAmount.setBounds(200, 240, 150, 25);
        add(tfpendingAmount);

        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30, 300, 100, 30);
        add(check);

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150, 300, 100, 30);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 300, 100, 30);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/tenthImage.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 500, 300);
        add(image);

        check.addActionListener(this);
        update.addActionListener(this);
        back.addActionListener(this);

        setBounds(300, 200, 980, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == check) {
            String customerId = ccustomerId.getSelectedItem();
            String query = "select * from customers where customerId = '" + customerId + "'";
            try {
                Connection conn = new Connection();
                ResultSet rs = conn.statement.executeQuery(query);
                while(rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfroom.setText(rs.getString("room"));
                    tcheckInTime.setText(rs.getString("checkInTime"));
                    tfamountPaid.setText(rs.getString("deposit"));
                    tfpendingAmount.setText(rs.getString("pendingAmount"));
                }
                rs.close();
                conn.close();

            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == update) {
            String customerId = ccustomerId.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkInTime = tcheckInTime.getText();
            String amountPaid = tfamountPaid.getText();
            String pendingAmount = tfpendingAmount.getText();

            try {
                Connection conn = new Connection();
                String query = "update customers set room = '" + room + "', name = '" + name + "', checkInTime = '" + checkInTime + "', deposit = '" + amountPaid + "', pendingAmount = '" + pendingAmount + "' where customerId = '" + customerId + "'";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
                new Reception();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new UpdateCheck();
    }
}
