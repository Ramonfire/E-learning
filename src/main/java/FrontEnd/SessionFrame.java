package FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SessionFrame  extends JFrame {
    private JPanel panel1;
    private JButton joinButton;
    private JButton createButton;
    private JTextField sessionNumberTextField;
    private JComboBox sessionTypeBox1;

    public SessionFrame() {
        this.setContentPane(panel1);
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
