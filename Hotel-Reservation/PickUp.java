import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PickUp extends JFrame implements ActionListener {
    JTable table;
    JButton back, submit;
    JComboBox<String> bedTypeCombo;
    JCheckBox available;
    JTextField priceField;
    Choice carType;
    PickUp() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Pick Up Service");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);
        
        JLabel lblcartype = new JLabel("Type of Car");
        lblcartype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblcartype.setBounds(50, 100, 100, 20);
        add(lblcartype);

        carType = new Choice();
        carType.setBounds(150, 100, 200, 25);
        add(carType);

        try{
            Connection conn = new Connection();
            String query = "select * from car";
            ResultSet rs = conn.statement.executeQuery(query);
            while(rs.next()){
                carType.add(rs.getString("carType"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel name = new JLabel("Name");
        name.setBounds(30,160,100,20);
        add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(30,200,100,20);
        add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,240,100,20);
        add(gender);

        JLabel company = new JLabel("Company");
        company.setBounds(460,160,100,20);
        add(company);

        JLabel brand = new JLabel("Brand");
        brand.setBounds(630,160,100,20);
        add(brand);
        
        JLabel availability = new JLabel("Availability");
        availability.setBounds(740,160,100,20);
        add(availability);

        JLabel location = new JLabel("Location");
        location.setBounds(890,160,100,20);
        add(location);


        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 200, 1000, 300);
        add(sp);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300, 150, 120, 30);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500, 150, 120, 30);
        back.addActionListener(this);
        add(back);

        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String carTypeCombo = carType.getSelectedItem().toString();
            try {
                Connection conn = new Connection();
                String query = "select * from driver where brand = '" + carTypeCombo + "'";
                ResultSet rs = conn.statement.executeQuery(query);
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); // Clear existing rows
                
                while(rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("name"),
                        rs.getString("age"),
                        rs.getString("gender"),
                        rs.getString("company"),
                        rs.getString("brand"),
                        rs.getString("available"),
                        rs.getString("location")
                    });
                }
                
                rs.close();
                conn.close();
                
            } catch(Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new PickUp();
    }
}
