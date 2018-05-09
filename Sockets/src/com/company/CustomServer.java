package com.company;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class CustomServer{

    //ServerSocket SERVER;
    public static ArrayList<Socket> ConnectionArray = new ArrayList<Socket>();

    private Object synchronizer = new Object();

    private static final int PING_FRAME = 1;
    private static final int HELLO_FRAME = 2;
    private static final int LOGIN_FRAME = 3;
    private static final int LOGOUT_FRAME = 4;

    private boolean connected = false;
    private boolean looped = false;

    private ServerSocket serverSocket = null;
    private Socket clientSocket = null;

    private DataInputStream input = null;
    private DataOutputStream output = null;
    private Thread thread;

    private ArrayList<User> clientsList = new ArrayList<User>();

    private User clientUser = null;

    public void run(int port) throws IOException {

        if (this.connected)
            return;

        try
        {
            this.serverSocket = new ServerSocket(port,5); //specifies how many incoming clients to store in a wait queue
        }
        catch ( IOException e )
        {
            return;
        }
        this.thread = new Thread(()->
        {
            while ( this.looped )
            {
                try
                {
                    System.out.println("oczekuje na klienta...");
                    this.clientSocket = this.serverSocket.accept();
                    this.input = new DataInputStream( this.clientSocket.getInputStream() );
                    this.output = new DataOutputStream( this.clientSocket.getOutputStream() );

                    while (this.looped){
                        doClientLogic(this.clientSocket);
                    };
                }
                catch ( IOException ex )
                {
                    System.out.println("zerwanie połączenia!");

                }
                finally
                {
                    this.closeClient();
                }
            }
        } );

        this.looped = true;
        this.thread.setName("Client thread");
        this.thread.start();
        this.connected = true;

    }

    public void stop() {
        this.looped = false;

        this.closeObjects();
        this.joinThread();
        this.connected = false;
    }


    private void closeObjects()
    {
        this.closeClient();
        this.closeObject( this.serverSocket );
    }




    public void closeObject(Closeable object){
        if ( object == null )
            return;
        try
        {
            object.close();
            return;
        }
        catch ( IOException e )
        {
            System.out.println("błąd przy zamykaniu obiektu");
            return;
        }
    }



    public void closeClient(){

        this.closeObject(this.output);
        this.closeObject(this.input);
        this.closeObject( this.clientSocket );

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


    private void doClientLogic(Socket socket) throws IOException
    {
        int frameType = this.input.readByte();
        switch (frameType)
        {
            case PING_FRAME:
                this.doPingFrame();
                break;

            case HELLO_FRAME:
                this.doHelloFrame();
                break;

            case LOGIN_FRAME:
                this.doLoginFrame();
                break;

            case LOGOUT_FRAME:
                this.doLogoutFrame();
                break;
            default:
                return;
        }
    }

    private void doPingFrame() throws IOException{
        try {
            synchronized (this.synchronizer) {
                this.output.writeBoolean(this.connected);
            }
        }
        catch (IOException x)
        {
            return;
        }
    }


    private void doHelloFrame() throws IOException{
        String userMessage = this.input.readUTF();
        System.out.println("otrzymana wiadomość to : "+userMessage);
        if ( this.connected == false )
            return;

        try
        {
            synchronized (this.synchronizer)
            {
                if( this.output != null )
                {
                    this.output.writeByte(HELLO_FRAME);

                    this.output.writeUTF(userMessage);
                }
            }
        }
        catch ( IOException e )
        {
            return;
        }
    }

    private void doLoginFrame() throws IOException{
        try {
            synchronized (this.synchronizer) {
                String login = this.input.readUTF();
                String password = this.input.readUTF();
                //System.out.println(login);
                //System.out.println(password);

                this.output.writeByte(LOGIN_FRAME);
                this.output.writeBoolean(false);

                this.clientUser = new User(login, password);
                this.clientsList.add(this.clientUser);
                this.output.writeBoolean(true);
                //this.output.writeInt( this.clientUser.getId() );
            }
        }
        catch (IOException x)
        {
            return;
        }
    }

    private void doLogoutFrame() throws IOException {
        try {
            synchronized (this.synchronizer) {
                this.output.writeByte(LOGOUT_FRAME);
            }
        }
        catch (IOException x)
        {
            return;
        }

    }
}
