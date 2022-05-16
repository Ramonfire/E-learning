package Entities.Threads;

import Entities.users.Student;
import Entities.users.user;
import StreamingService.ScreenShare;

import static Entities.shareClasses.sessionCreated;

public class StreamingThread extends Thread{

    @Override
    public void run(){
        ScreenShare screenShare = new ScreenShare();
        screenShare.interactive("server "+sessionCreated);
    }
}
