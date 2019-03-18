package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient
{
    public static final int PORT = 8000;

    public static void main(String[] args)
    {
        try (Socket server = new Socket(InetAddress.getByName("localhost"), PORT))
        {
            System.out.println("Started client...");

            //get io objects for the server
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    server.getInputStream()));

            //send a message to the server
            System.out.println("Sending message to server...");
            out.println("Live long and prosper!!!");

            //print the response
            System.out.println("Response from server: " + in.readLine());
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
