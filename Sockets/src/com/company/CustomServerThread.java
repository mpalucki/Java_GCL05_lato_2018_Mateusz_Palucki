package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CustomServerThread implements Runnable {

    CustomServer tmp;
    Socket tmpSocket;
    private Scanner input;
    private PrintWriter output;

    public CustomServerThread(Socket SOCK)
    {
        this.tmpSocket = SOCK;
    }

    @Override
    public void run(){
        try
        {
            input = new Scanner(tmpSocket.getInputStream());
            output = new PrintWriter(tmpSocket.getOutputStream());


        }
        catch (IOException x)
        {
            x.printStackTrace();
        }
    }
}
