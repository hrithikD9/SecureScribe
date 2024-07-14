import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Encode extends JFrame {
    private Container c;
    private JLabel encodeLabel, inputTextLabel, inputKeyLabel;
    private Font font;
    private JTextArea inputTextArea;
    private JTextField inputKeyField;
    private JButton goBackButton, encodeButton;

    Encode() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 500, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("ENCODE");

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GRAY);

        font = new Font("Poppins", Font.BOLD, 18);

        encodeLabel = new JLabel("Encode", JLabel.CENTER);
        encodeLabel.setBounds(0, 0, 500, 30);
        encodeLabel.setFont(font);
        encodeLabel.setForeground(Color.WHITE);
        encodeLabel.setOpaque(true);
        encodeLabel.setBackground(Color.DARK_GRAY);
        c.add(encodeLabel);

        inputTextLabel = new JLabel("Input Text:");
        inputTextLabel.setBounds(30, 50, 100, 30);
        inputTextLabel.setForeground(Color.WHITE);
        c.add(inputTextLabel);

        inputTextArea = new JTextArea();
        inputTextArea.setBounds(30, 80, 440, 120);
        inputTextArea.setFont(font);
        c.add(inputTextArea);

        inputKeyLabel = new JLabel("Input Key:");
        inputKeyLabel.setBounds(30, 210, 100, 30);
        inputKeyLabel.setForeground(Color.WHITE);
        c.add(inputKeyLabel);

        inputKeyField = new JTextField();
        inputKeyField.setBounds(30, 240, 440, 30);
        inputKeyField.setFont(font);
        inputKeyField.setHorizontalAlignment(JTextField.CENTER);
        c.add(inputKeyField);

        goBackButton = new JButton("Go back");
        goBackButton.setBounds(30, 300, 210, 30);
        goBackButton.setFocusable(false);
        goBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
            }
        });
        c.add(goBackButton);

        encodeButton = new JButton("Encode");
        encodeButton.setBounds(260, 300, 210, 30);
        encodeButton.setFocusable(false);
        encodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String text = inputTextArea.getText();
                String keyText = inputKeyField.getText();
                int key;
                try {
                    key = Integer.parseInt(keyText);
                    String encodedText = encodeText(text, key);
                    JOptionPane.showMessageDialog(null, "Encoded Text: \n" + encodedText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for the key.");
                }
            }
        });
        c.add(encodeButton);
    }

        private String encodeText(String text, int key) {
        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + key) % 26 + base);
            }
            encoded.append(c);
        }
        return encoded.toString();
    }

    public static void main(String[] args) {
        Encode frame = new Encode();
        frame.setVisible(true);
    }
}