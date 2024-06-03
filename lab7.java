import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventHandlingDemo extends JFrame implements ActionListener {
    JButton alphaButton, betaButton;

    public ButtonEventHandlingDemo() {
        setTitle("Button Event Handling Demo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        alphaButton = new JButton("Alpha");
        betaButton = new JButton("Beta");
        
        alphaButton.setActionCommand("Alpha");
        betaButton.setActionCommand("Beta");
        
        alphaButton.addActionListener(this);
        betaButton.addActionListener(this);
        
        setLayout(new FlowLayout());
        add(alphaButton);
        add(betaButton);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.equals("Alpha")) {
            JOptionPane.showMessageDialog(this, "Alpha pressed");
        } else if (command.equals("Beta")) {
            JOptionPane.showMessageDialog(this, "Beta pressed");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ButtonEventHandlingDemo demo = new ButtonEventHandlingDemo();
                demo.setVisible(true);
            }
        });
    }
}
