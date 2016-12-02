/////////////////////////////////////////
//Java Server connector.               //
//Made by Matt Nielsen and James Hauser//
//CS 460/Networks                      //
/////////////////////////////////////////


import java.io.*;
import java.net.*;


//Opens the server and waits for connections
//When connection happens, it threads to the client handler.
public class JavaServer{
    public static void main(String[] args) throws IOException{
	int portnumber = 27772;//Pre-defined portnumber.
	ServerSocket serverSocket = new ServerSocket(portnumber);
	StdDraw.enableDoubleBuffering();
	double x0 = 0.5;
	double y0 = 0.5;
	double a0 = 60.0;
	Turtle turtle = new Turtle(x0, y0, a0);
	turtle.show();
	while(true){
	    System.err.println("Waiting for connection\n");
	    Socket client = serverSocket.accept();
	    //Send thread to JavaClient
	    (new Thread (new JavaClient(client, turtle))).start();
	    
	    System.err.println("Accepted connection from client\n");
	}
    }
}





