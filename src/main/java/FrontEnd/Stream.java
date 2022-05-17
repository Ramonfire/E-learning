package FrontEnd;

import Entities.Threads.KillThread;
import Entities.sessions.Session;
import Entities.sessions.chat;
import Entities.shareClasses;
import Entities.users.Student;
import Entities.users.professor;
import Entities.users.user;
import Singleton.SingletonJDBC;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;


@Data
public class Stream extends JFrame {

    private Session session;


    private JButton leaveButton;
    private JPanel panel1;
    private JTable fileTable;
    private JTable chatTable;
    private JTextField textField1;
    private JButton button1;
    private user loggedin;

    public Stream(){
        loggedin=new Student();
        loggedin=loggedin.loging(shareClasses.mail,shareClasses.pass);
        this.setContentPane(panel1);
        leaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               UpdateChatTable(shareClasses.sessionCreated);
            }
        });
    }


   public void UpdteFileTable(Long idSession){

       try{
           Connection conn = SingletonJDBC.getConnection();
           String querry = "select * from files where idSession=?";
           PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(querry);
           pstmt.setLong(1,idSession);

           ResultSet r = pstmt.executeQuery();
           if (r.next()){

           }else {System.out.println("failure");}
       }catch (SQLException e){
           e.printStackTrace();
       }
    }


    public void UpdateChatTable(Integer idSession){
        chat fill=new chat();
        try{
            System.out.println("Selecting chat");
            Connection conn = SingletonJDBC.getConnection();
            String querry = "select * from chat where id=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(querry);
            pstmt.setInt(1,idSession);

            ResultSet r = pstmt.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("others");
            model.addColumn("you");

            while (r.next()){
                fill.says=r.getString("content");
                fill.idSession=r.getLong("id");
                fill.source=r.getString("source");
                System.out.println(fill.says+ " " + fill.source);

            if (fill.source.equals(loggedin.getFirstName())){
                model.addRow(new Object[]{ null,fill.source+ ": \n"+fill.says});
            }else {
                model.addRow(new Object[]{ fill.source+ ": \n"+fill.says,null});
            }


            }
            chatTable = new JTable(model);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    }



