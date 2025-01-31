import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back, submit;
    JComboBox<String> bedTypeCombo;
    JCheckBox available;
    JTextField priceField;
    
    SearchRoom() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Search Room");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);
        
        JLabel lblBedType = new JLabel("Bed Type");
        lblBedType.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblBedType.setBounds(50, 100, 100, 20);
        add(lblBedType);

        bedTypeCombo = new JComboBox<>(new String[]{"Single", "Double"});
        bedTypeCombo.setBounds(150, 100, 150, 25);
        bedTypeCombo.setBackground(Color.WHITE);
        add(bedTypeCombo);

        available = new JCheckBox("Onlu display available rooms");
        available.setBounds(650, 100, 150, 25);
        add(available);

        // Create table with column headers
        String[] columns = {"Room Number", "Availability", "Status", "Price", "Bed Type"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        
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
            String bedType = bedTypeCombo.getSelectedItem().toString();
            try {
                Connection conn = new Connection();
                String query = "select * from rooms where bed_type = '" + bedType + "'";
                ResultSet rs = conn.statement.executeQuery(query);
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); // Clear existing rows
                
                while(rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("roomNumber"),
                        rs.getString("availability"),
                        rs.getString("status"),
                        rs.getString("price"),
                        rs.getString("bed_type")
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
        new SearchRoom();
    }
}
