package Entities.Threads;

import FrontEnd.Stream;

import javax.swing.*;

public class ChatThread extends Thread{
    Stream stream= new Stream();

    @Override
    public void run() {
        stream.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        stream.pack();
        stream.setVisible(true);

    }
}
