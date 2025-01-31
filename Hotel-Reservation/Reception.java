import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Reception extends JFrame implements ActionListener {
    JButton newCustomer, room, department, Employees, ManagerInfo, customer, searchRoom, updateStatus, roomStatus, pickup, checkOut, logout;
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

         newCustomer = new JButton("New Customer");
        newCustomer.setBounds(10,70,200,30);
        newCustomer.setBackground(Color.WHITE);
        newCustomer.setForeground(Color.BLACK);
        add(newCustomer);

        room = new JButton("Rooms");
        room.setBounds(10,30,200,30);
        room.setBackground(Color.WHITE);
        room.setForeground(Color.BLACK);
        add(room);

        department = new JButton("Departments");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.WHITE);
        department.setForeground(Color.BLACK);
        department.addActionListener(this);
        add(department);

        Employees = new JButton("Employees");
        Employees.setBounds(10,190,200,30);
        Employees.setBackground(Color.WHITE);
        Employees.setForeground(Color.BLACK);
        Employees.addActionListener(this);
        add(Employees);

        customer = new JButton("Customer Information");
        customer.setBounds(10,190,200,30);
        customer.setBackground(Color.WHITE);
        customer.setForeground(Color.BLACK);
        customer.addActionListener(this);
        add(customer);


         ManagerInfo = new JButton("Manager Information");
        ManagerInfo.setBounds(10,230,200,30);
        ManagerInfo.setBackground(Color.WHITE);
        ManagerInfo.setForeground(Color.BLACK);
        ManagerInfo.addActionListener(this);
        add(ManagerInfo);

        JButton checkIn = new JButton("Check In");
        checkIn.setBounds(10,270,200,30);
        checkIn.setBackground(Color.WHITE);
        checkIn.setForeground(Color.BLACK);
        checkIn.addActionListener(this);
        add(checkIn);

        checkOut = new JButton("Check Out");
        checkOut.setBounds(10,270,200,30);
        checkOut.setBackground(Color.WHITE);
        checkOut.setForeground(Color.BLACK);
        checkOut.addActionListener(this);
        add(checkOut);

        updateStatus = new JButton("Update Status");
        updateStatus.setBounds(10,310,200,30);
        updateStatus.setBackground(Color.WHITE);
        updateStatus.setForeground(Color.BLACK);
        updateStatus.addActionListener(this);
        add(updateStatus);

        roomStatus = new JButton("Room Status");
        roomStatus.setBounds(10,350,200,30);
        roomStatus.setBackground(Color.WHITE);
        roomStatus.setForeground(Color.BLACK);
        roomStatus.addActionListener(this);
        add(roomStatus);
        
        pickup = new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.WHITE);
        pickup.setForeground(Color.BLACK);
        add(pickup);

        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setBackground(Color.WHITE);
        searchRoom.setForeground(Color.BLACK);
        add(searchRoom);

         logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.WHITE);
        logout.setForeground(Color.BLACK);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/seventhImage.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);


        setBounds(350,200,800,570);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newCustomer) {
            setVisible(false);
            new AddCustomers();
        }
        else if (ae.getSource() == room) {
            setVisible(false);
            new Room();
        }
        else if (ae.getSource() == department) {
            setVisible(false);
            new Department();
        }
        else if (ae.getSource() == Employees) {
            setVisible(false);
            new EmployeeInfo();
        }
        else if (ae.getSource() == ManagerInfo) {
            setVisible(false);
            new ManagerInfo();
        }
        else if (ae.getSource() == customer) {
            setVisible(false);
            new CustomerInfo();
        }
        else if (ae.getSource() == searchRoom) {
            setVisible(false);
            new SearchRoom();
        }
        else if(ae.getSource()== updateStatus)
        {
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource()== roomStatus)
        {
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource()== pickup)
        {
            setVisible(false);
            new PickUp();
        }
        else if(ae.getSource()== checkOut)
        {
            setVisible(false);
            new Checkout();
        }
        else if(ae.getSource()== logout)
        {
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Reception();
    }
}
