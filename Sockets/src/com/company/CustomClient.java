package com.company;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class CustomClient {

    private Object locker = new Object(); // chroni dostępu do obiektów wykorzystywanych na poziomie wielu wątków
    private static final int PING_FRAME = 1;
    private static final int HELLO_FRAME = 2;
    private static final int LOGIN_FRAME = 3;
    private static final int LOGOUT_FRAME = 4;

    private boolean connected = false;
    private boolean looped = false;
    private boolean isLogged = false;

    private Socket clientSocket;
    //private Scanner input;
    //private PrintWriter output;
    private Thread thread;

    private DataInputStream input;
    private DataOutputStream output;

    public void connect(String host, int port) throws IOException {

        if ( this.connected )
            return;

        try {
            this.clientSocket = new Socket(host, port);
            System.out.println("client connected to : "+ host);
            this.input = new DataInputStream( this.clientSocket.getInputStream() );
            this.output = new DataOutputStream( this.clientSocket.getOutputStream() );

            this.connected = true;
            this.looped = true;
            this.runThread();
        }
        catch (Exception x)
        {
            System.out.println("błąd połączenia");
            this.closeObjects();
        }

    }
    private void runThread()
    {
        this.thread = new Thread(() ->
        {
            try
            {
                while ( this.looped )
                    this.getTask();
            }
            catch ( IOException e )
            {
               return;
            }
            finally
            {
                this.closeObjects();

                this.looped = false;
                this.connected = false;
            }
        });

        this.thread.start();
    }




    private void getTask() throws IOException
    {
        int frameType = this.input.readByte();
        switch ( frameType )
        {

            case PING_FRAME: {
                break;
            }

            case HELLO_FRAME: {
                System.out.println(this.input.readUTF());
                //this.echo("hello!");
                break;
            }

            case LOGIN_FRAME:{
                break;
            }

            case LOGOUT_FRAME: {
                isLogged = false;
                System.out.println("Użytkownik wylogowany!");
                break;
            }


            default:
                break;
        }
    }

    public boolean echo(String text) throws IOException {

        if ( this.connected == false )
            return false;
        if(isLogged)
        {
            try {
                this.output.writeByte(HELLO_FRAME);
                this.output.writeUTF(text);
            } catch (IOException e) {
                return false;
            }

            return true;
        }
        else {
            System.out.println("nie jesteś zalogowany!");
            return false;
        }
    }

    public boolean ping() throws IOException{
        if ( this.connected == false )
            return false;
        if(isLogged) {
            this.output.writeByte(PING_FRAME);
            if(this.input.readBoolean()==true)
            {
                System.out.println("jest polaczenie!");
                return true;
            }
        }
        else {
            System.out.println("nie jesteś zalogowany!");
            return false;
        }
        return false;
    }


    public boolean login(String username, String password) throws IOException
    {
        if ( this.connected == false )
            return false;
        try
        {
            this.output.writeByte( LOGIN_FRAME);
            this.output.writeUTF(username);
            this.output.writeUTF(password);
            System.out.println("użytkownik zalogowany!");
            isLogged = true;
            return true;
        }
        catch ( IOException e )
        {
            return false;
        }
    }


    public boolean logout() throws IOException{

        if ( this.connected == false )
            return false;

        if(this.isLogged == false) {
            System.out.println("użytkownik nie jest zalogowany!");
            return false;
        }
        try {
            //System.out.println("jest?");
            this.output.writeByte(LOGOUT_FRAME);
        }
        catch (IOException x)
        {
            return false;
        }

        return true;
    }





    private void closeObjects() {
        this.closeObject( this.output );
        this.closeObject( this.input );
        this.closeObject( this.clientSocket);
    }



    private boolean closeObject(Closeable object){
        if ( object == null )
            return false;

        try
        {
            object.close();

            return true;
        }
        catch ( IOException e )
        {
            return false;
        }
    }

    public void disconnect() throws IOException{
        if ( this.connected == false )
            return;

        this.looped = false;

        this.closeObjects();
        this.joinThread();
        System.out.println("użytkownik rozłączony!");

        this.connected = false;
    }

    private boolean joinThread()
    {
        try
        {
            this.thread.join();
            return true;
        }
        catch ( InterruptedException e )
        {
            return false;
        }
    }
}
