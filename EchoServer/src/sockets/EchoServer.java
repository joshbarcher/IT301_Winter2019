package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoServer
{
    public static final int PORT = 8000;

    public static void main(String[] args)
    {
        try (ServerSocket server = new ServerSocket(PORT, 0,
                InetAddress.getByName("localhost")))
        {
            System.out.println("Server has started...");
            System.out.println("Wait for a client connection");

            Socket client = server.accept(); //block until a remote connection is made
            System.out.println("Found a client...");

            //create objects to converse with the client
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));

            //try to read a message from the client
            System.out.println("Reading message from client...");

            String message = in.readLine();

            //send it back (echo)
            System.out.println("Sending message back to client (" + message + ")");
            out.println(message);
        }
        catch (UnknownHostException ex)
        {
            System.out.println("Unknown host: " + ex.getMessage());
        }
        catch (IOException ex)
        {
            System.out.println("IO Exception: " + ex.getMessage());
        }
    }
}
