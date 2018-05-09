package com.company;

import java.io.IOException;

public class ServerProgram {

    public static void main(String[] args) throws Exception
    {
        final int PORT = 444;
        CustomServer server_1 = new CustomServer();
        server_1.run(PORT);

    }

}
