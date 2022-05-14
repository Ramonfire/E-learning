package Entities.users;

import Entities.sessions.file;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class user {

    private Long idUser;

    private String firstName;

    private String lastName;

    private String email;

    private String password;


    public void sendFile(file file, Long idDestination){

    }


    public void JoinSession(Long idSession){
        if (idSession==Long.valueOf(0)){
            System.err.println("Session doesnt exist");
        }

    }

    public  void LeaveSession(){

    }

    public Long CreateSession(){
    Long sessionCreated=Long.valueOf(0);



    return sessionCreated;
    }

    public void TerminateSession(){

    }
}
