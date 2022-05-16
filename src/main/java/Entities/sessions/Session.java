package Entities.sessions;

import Entities.users.user;
import StreamingService.ScreenShare;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public abstract class Session {

    private Long id;

    private List<file> files;

    private user organisateur;

    private List<user> users;

    private Integer State;

    public void kickuser(){

    }

    public void  Sendchat(String chat){

    }

    public void StartSessiong(){
        ScreenShare screenShare = new ScreenShare();
        Integer sessionCreated=getRandomNumber(1000,2000);
        this.setId(Long.valueOf(sessionCreated));
        //create Jframe here for chat and file share








        screenShare.interactive("server "+sessionCreated);

    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
