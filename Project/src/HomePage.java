import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame{
    private Container c;
    private JLabel label;
    private Font font;
    private JButton button1 , button2;
    
    HomePage(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setTitle("HOMEPAGE");

        font = new Font("Poppins", Font.BOLD, 18);
       

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GRAY);

        label = new JLabel("Welcome People",JLabel.CENTER);
        label.setBounds(0, 0, 500, 30);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        label.setOpaque(true);
        label.setBackground(Color.DARK_GRAY);
        c.add(label);

        button1 = new JButton();
        button1.setText("ENCODE");
        button1.setBounds(100, 100, 300, 60);
        button1.setFont(font);
        button1.setFocusable(false);
        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                Encode encode = new Encode();
                encode.setVisible(true);
            }
        });
        c.add(button1);

        button2 = new JButton();
        button2.setText("DECODE");
        button2.setBounds(100, 170, 300, 60);
        button2.setFont(font);
        button2.setFocusable(false);
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                Decode decode = new Decode();
                decode.setVisible(true);
            }
        });
        c.add(button2);

    }
    public static void main(String[] args) {
        HomePage Frame = new HomePage();
        Frame.setVisible(true);
    }
}
