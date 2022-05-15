package Entities.users;

import Entities.sessions.file;
import Singleton.SingletonJDBC;
import StreamingService.ScreenShare;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
public abstract class user {

    protected Long idUser;

    protected String firstName;

    protected String lastName;

    protected String email;

    protected String password;

    protected String type;

    protected  Long niveau;


    
    public user loging(String email,String password){
        user logged =null;


        try{
            Connection conn = SingletonJDBC.getConnection();
            String querry = "select * from users where email=? and password=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(querry);
            pstmt.setString(1,email);
            pstmt.setString(2,password );

            ResultSet r = pstmt.executeQuery();
            if (r.next()){
                if ( r.getObject("type").equals("professor")){
                    logged=new professor();
                    System.out.println("success");
                    logged.setEmail((String) r.getObject("email"));
                    logged.setPassword((String) r.getObject("password"));
                    logged.setFirstName((String) r.getObject("name"));
                    logged.setLastName((String) r.getObject("familyname"));
                    logged.setType((String) r.getObject("Type"));
                }
                if ( r.getObject("type").equals("student")){
                    logged=new Student();
                    System.out.println("success");
                    logged.setEmail((String) r.getObject("email"));
                    logged.setPassword((String) r.getObject("password"));
                    logged.setFirstName((String) r.getObject("name"));
                    logged.setLastName((String) r.getObject("familyname"));
                    logged.setType((String) r.getObject("Type"));
                    logged.setNiveau((Long) r.getObject("niveau"));
                }



            }else {System.out.println("failure");}
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  logged;
    }



    public List<user> getAllParticipants(Long idSession){
        LinkedList<user> Utilisateurs=new LinkedList<user>();
        try{
            Connection conn = SingletonJDBC.getConnection();
            String querry = "select * from users";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(querry);


            ResultSet r = pstmt.executeQuery();
            if (r.next()){
                user logged= null;
                if ( r.getObject("type").equals("professor")){
                    logged=new professor();
                }
                if ( r.getObject("type").equals("student")){
                    logged=new Student();
                }
                System.out.println("success");
                logged.setEmail((String) r.getObject("email"));
                logged.setPassword((String) r.getObject("password"));
                logged.setFirstName((String) r.getObject("name"));
                logged.setLastName((String) r.getObject("familyname"));
                logged.setType((String) r.getObject("Type"));
                Utilisateurs.add(logged);

            }else {System.out.println("failure");}
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  Utilisateurs;
    }

    public void sendFile(file file, Long idDestination){

    }


    public void JoinSession(Integer idSession){
        ScreenShare screenShare= new ScreenShare();
        if (idSession==0){
            System.err.println("Session doesnt exist");
        }else {
            screenShare.interactive("client 127.0.0.1 "+idSession);
        }

    }

    public  void LeaveSession(){

    }

    public Integer CreateSession(){
    ScreenShare screenShare = new ScreenShare();
    Integer sessionCreated=getRandomNumber(1000,2000);
    screenShare.interactive("server "+sessionCreated);



    return sessionCreated;
    }

    public void TerminateSession(){
        ScreenShare screenShare = new ScreenShare();
        screenShare.interactive("close");

    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void placeholder(){
        String response= "Error";
        try{
            Connection conn = SingletonJDBC.getConnection();
            String querry = "insert into users values (null,?,?,?,?,?)";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(querry);
            pstmt.setString(1,"");
            pstmt.setString(2,"");
            pstmt.setString(3,"");
            pstmt.setString(4,"");
            pstmt.setString(5,"");


            int r = pstmt.executeUpdate();
            if (r==1){
                response="Done succesfully";

            }else {System.out.println("failure");}
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
