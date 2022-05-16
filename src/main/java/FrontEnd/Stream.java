package FrontEnd;

import Entities.Threads.KillThread;
import Entities.sessions.Session;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@Data
public class Stream extends JFrame {

    private Session session;


    private JButton leaveButton;
    private JPanel panel1;

    public Stream(){
        this.setContentPane(panel1);
        leaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Thread.currentThread().stop();
            }
        });
    }
}
