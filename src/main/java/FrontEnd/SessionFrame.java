package FrontEnd;

import Entities.sessions.Cours;
import Entities.sessions.Session;
import Entities.shareClasses;
import Entities.users.Student;
import Entities.users.user;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class SessionFrame  extends JFrame {
    private JPanel panel1;
    private JButton joinButton;
    private JButton createButton;
    private JTextField sessionNumberTextField;
    private JComboBox sessionTypeBox1;
    public  Session session ;
    public Entities.users.user user;

    public SessionFrame() {
        this.setContentPane(panel1);
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user=new Student();
                user=user.loging(shareClasses.mail,shareClasses.pass);
                user.JoinSession(Integer.parseInt(sessionNumberTextField.getText()));
            }
        });
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user=new Student();
                    user=user.loging(shareClasses.mail,shareClasses.pass);
                 user.CreateSession();
            }
        });
    }




}
