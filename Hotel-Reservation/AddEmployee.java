import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.*;

public class AddEmployee extends JFrame  implements ActionListener {
    JTextField age, txtName, sal, ph, tfemail;
    JRadioButton rdbtnMale, rdbtfemale;
    JComboBox<String> jobpos;
    JButton submit;
    ButtonGroup genderGroup;

    AddEmployee()
    {
        setLayout(null);
        
        // Set frame properties first, but make visible at the end
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Add this to make frame closeable
        
        // Name components
        JLabel lblName = new JLabel("NAME");
        lblName.setBounds(60,30,120,30);
        lblName.setFont(new Font("Times New Roman", Font.BOLD, 17));
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(200,30,150,30);
        txtName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(txtName);

        // Age components
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Times New Roman", Font.BOLD, 17));
        add(lblage);

         age = new JTextField();
        age.setBounds(200,80,150,30);
        age.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(age);

        // Gender components
        JLabel lblGender = new JLabel("GENDER");
        lblGender.setBounds(60,130,120,30);
        lblGender.setFont(new Font("Times New Roman", Font.BOLD, 17));
        add(lblGender);

        genderGroup = new ButtonGroup();
        
         rdbtnMale = new JRadioButton("Male");
        rdbtnMale.setBounds(200,130,70,30);
        rdbtnMale.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        rdbtnMale.setBackground(Color.WHITE);
        add(rdbtnMale);
        genderGroup.add(rdbtnMale);

         rdbtfemale = new JRadioButton("Female");
        rdbtfemale.setBounds(280,130,90,30);
        rdbtfemale.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        rdbtfemale.setBackground(Color.WHITE);
        add(rdbtfemale);
        genderGroup.add(rdbtfemale);

        // Job components
        JLabel lblJob = new JLabel("JOB");
        lblJob.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblJob.setBounds(60,180,150,30);
        add(lblJob);

        String job_positions[] = {"Front desk Clerks","Porters","Kitchen Staff", "Room Services",
                "Waiter/Waitress", "Chefs", "Manager", "Accountant"};
         jobpos = new JComboBox<>(job_positions);
        jobpos.setBounds(200,180,150,30);
        jobpos.setBackground(Color.WHITE);
        jobpos.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(jobpos);

        // Salary components
        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60,230,150,30);
        salary.setFont(new Font("Times New Roman", Font.BOLD, 17));
        add(salary);

         sal = new JTextField();
        sal.setBounds(200,230,150,30);
        sal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(sal);

        // Phone components
        JLabel Phone = new JLabel("PHONE");
        Phone.setBounds(60,280,120,30);
        Phone.setFont(new Font("Times New Roman", Font.BOLD, 17));
        add(Phone);

         ph = new JTextField();
        ph.setBounds(200,280,150,30);
        ph.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(ph);

        // Email components
        JLabel Email = new JLabel("EMAIL");
        Email.setBounds(60,330,120,30);
        Email.setFont(new Font("Times New Roman", Font.BOLD, 17));
        add(Email);

         tfemail = new JTextField();
        tfemail.setBounds(200,330,150,30);
        tfemail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(tfemail);

        // Add submit button
        submit = new JButton("SUBMIT");
        submit.setBounds(200,400,150,30);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);

        ImageIcon imagIcon1 = new ImageIcon(ClassLoader.getSystemResource("images/fourthImage.png"));
        Image imageIcone2 = imagIcon1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcone2);
        JLabel image = new JLabel(imageIcon3);
        image.setBounds(380,60,450,370);
        add(image);

        // Make frame visible after adding all components
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = txtName.getText();
            String ages = age.getText();
            String salary = sal.getText();
            String phone = ph.getText();
            String email = tfemail.getText();
            String gender = "";  // Initialize empty string instead of null
            
            // Basic validation
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter name");
                return;
            }
            
            // Gender validation using loop through button group
            Enumeration<AbstractButton> genderButtons = genderGroup.getElements();
            boolean genderSelected = false;
            
            while(genderButtons.hasMoreElements()) {
                AbstractButton button = genderButtons.nextElement();
                if(button.isSelected()) {
                    gender = button.getText();
                    genderSelected = true;
                    break;
                }
            }
            
            if (!genderSelected) {
                JOptionPane.showMessageDialog(null, "Please select gender");
                return;
            }
            
            String job = (String) jobpos.getSelectedItem();
            
            try {
                Connection connection = new Connection();
                
                String query = "INSERT INTO employee (name, age, gender, job, salary, phone, email) " +
                              "VALUES ('" + name + "', '" + ages + "', '" + gender + "', '" + 
                              job + "', '" + salary + "', '" + phone + "', '" + email + "')";
                
                connection.statement.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error adding employee: " + e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        new AddEmployee();
    }
}