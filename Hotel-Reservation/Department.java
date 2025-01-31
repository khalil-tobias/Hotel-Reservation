import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    
    Department() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Department Details");
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        l1.setBounds(150, 10, 200, 30);
        add(l1);

        // Create table with column headers
        String[] columns = {"Department", "Budget"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 50, 500, 400);
        add(sp);

        try {
            Connection connection = new Connection();
            String query = "select * from department";
            ResultSet rs = connection.statement.executeQuery(query);
            
            while(rs.next()) {
                String department = rs.getString("department");
                String budget = rs.getString("budget");
                
                model.addRow(new Object[]{department, budget});
            }

            rs.close();
            connection.statement.close();
            
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
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
        new Department();
    }
}
