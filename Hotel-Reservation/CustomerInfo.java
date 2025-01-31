import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    CustomerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("First Name");
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        l1.setBounds(40, 10, 120, 30);
        add(l1);

        JLabel l2 = new JLabel("Last Name");
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        l2.setBounds(180, 10, 120, 30);
        add(l2);

        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tahoma", Font.BOLD, 20));
        age.setBounds(320, 10, 100, 30);
        add(age);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma", Font.BOLD, 20));
        gender.setBounds(440, 10, 100, 30);
        add(gender); 

        JLabel job = new JLabel("Country");
        job.setFont(new Font("Tahoma", Font.BOLD, 20));
        job.setBounds(560, 10, 100, 30);
        add(job);

        JLabel salary = new JLabel("Room Number");
        salary.setFont(new Font("Tahoma", Font.BOLD, 20));
        salary.setBounds(680, 10, 100, 30);
        add(salary);

        JLabel phone = new JLabel("Check In Time");
        phone.setFont(new Font("Tahoma", Font.BOLD, 20));
        phone.setBounds(800, 10, 100, 30);
        add(phone);

        JLabel email = new JLabel("Deposit");
        email.setFont(new Font("Tahoma", Font.BOLD, 20));
        email.setBounds(920, 10, 100, 30);
        add(email);

        // Create table with column headers
        String[] columns = {"First Name", "Last Name", "Age", "Gender", "Job", "Salary", "Phone", "Email"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 50, 1000, 400);
        add(sp);

        try {
            Connection conn = new Connection();
            Statement stmt = conn.statement;
            ResultSet rs = stmt.executeQuery("select * from customers");
            
            while(rs.next()) {
                String empFirstName = rs.getString("firstName");
                String empLastName = rs.getString("lastName");
                String empAge = rs.getString("age");
                String empGender = rs.getString("gender");
                String empJob = rs.getString("job");
                String empSalary = rs.getString("salary");
                String empPhone = rs.getString("phone");
                String empEmail = rs.getString("email");
                
                model.addRow(new Object[]{empFirstName, empLastName, empAge, empGender, 
                                        empJob, empSalary, empPhone, empEmail});
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading employee data: " + e.getMessage());
        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(420, 500, 120, 30);
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
        new CustomerInfo();
    }
}


