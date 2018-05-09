package com.company;

public class ClientProgram {
    public static void main(String[] args) throws Exception
    {
        final int PORT = 444;
        final String HOST = "localhost";
        CustomClient client_1 = new CustomClient();

        client_1.connect(HOST,PORT);

        client_1.login("jan","1234");

        client_1.echo("Witam!");
        client_1.echo("pyr pyr pyr");

        client_1.logout();
        Thread.sleep(5000);
        client_1.disconnect();
    }
}
