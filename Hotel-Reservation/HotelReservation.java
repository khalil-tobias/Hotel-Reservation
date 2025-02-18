import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class HotelReservation extends JFrame implements ActionListener {

    HotelReservation() {
       // setSize(1366,430);
       // setLocation(300,300);
        setBounds(0,0,1366,565);
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/HotelImage1.png"));
        JLabel image = new JLabel(icon);
        image.setBounds(0,0,1366,565);
        add(image);

        JLabel text = new JLabel("Hotel Reservation");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1150,450,150,50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        image.add(next);

        setVisible(true);

        while(true) {
            text.setVisible(false);
            try{
                Thread.sleep(500);
            } catch(Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new HotelReservation();
    }
}
