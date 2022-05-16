package FrontEnd;

import Entities.shareClasses;
import Entities.users.Student;
import Entities.users.user;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class LogIn extends  JFrame{

    private JTextField labelTextField;
    private JLabel label1;
    private JPanel panel1;
    private JTextField mail;
    private JButton logInButton;
    private JPasswordField pass;
    public  static user loggedIn=new Student();
    Boolean logged = false;

    public LogIn() {

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

              logged= loggedIn.loging2(mail.getText(),pass.getText());
              if (logged){
                  shareClasses.mail=mail.getText();
                  shareClasses.pass=pass.getText();
                OnLoggingSuccess();
              }
              else {
                  JOptionPane.showMessageDialog(null,"Wrong email or password",
                                            "invalid Credentials",JOptionPane.ERROR_MESSAGE);
              }


            }
        });
        this.setContentPane(panel1);
    }


    public void OnLoggingSuccess(){
        SessionFrame sessionFrame = new SessionFrame();
        sessionFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        sessionFrame.pack();
        sessionFrame.setVisible(true);
        this.setVisible(false);

    }
}
