/////////////////////////////////////////
//Java Server Client Handler           //
//Made by Matt Nielsen and James Hauser//
//CS460/Networks                       //
/////////////////////////////////////////

import java.io.*;
import java.net.*;

//Sends the thread to function run()
public class JavaClient implements Runnable {
    Socket socket;
    Turtle turtle;
    
    public JavaClient(Socket socket, Turtle turtle){
	this.socket = socket;
	this.turtle = turtle;
    }

    @Override
    public void run(){
	//Establish read/write variables
	PrintWriter from_Server = null;
	BufferedReader to_Server = null;
	String to_server_string = null;
	int serverInput = 0;
	int distance2;
	float distance;
	String direction;
	
	
	try{
	    //Populate variables
	    from_Server = new PrintWriter(socket.getOutputStream());
	    to_Server =
		new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    while(serverInput == 0){
		//Check reader stream
		if(to_Server.ready()){
		    serverInput = 1;
		    //Set the string variable
		    to_server_string = to_Server.readLine();
		    //Check for quit command and close
		    if(to_server_string.equalsIgnoreCase("q")){
			System.out.println("Connection closed on user request.\n");
			from_Server.close();
			to_Server.close();
			socket.close();
		    }else{
			direction = StringParser.returnDirection(to_server_string);
			distance2 = StringParser.returnDistanceNum(to_server_string);

			distance = (float) distance2 / 10;

			if(direction.equals("u")){
			    turtle.setPenUp();
			    System.out.println("Up");
			    turtle.show();
			}else if(direction.equals("d")){
			    turtle.setPenDown();
			    System.out.println("Down");
			    turtle.show();
			}else if(direction.equals("n")){
			    turtle.setAngle(90);
			    turtle.goForward(distance);
			    System.out.println("North + "+distance);
			    turtle.show();
			}else if(direction.equals("e")){
			    //right
			    turtle.setAngle(0);
			    turtle.goForward(distance);
			    System.out.println("East +"+distance);
			    turtle.show();
			}else if(direction.equals("w")){
			    //left
			    turtle.setAngle(180);
			    turtle.goForward(distance);
			    System.out.println("West +"+distance);
			    turtle.show();
			}else if(direction.equals("s")){
			    //south
			    turtle.setAngle(270);
			    turtle.goForward(distance);
			    turtle.show();
			    System.out.println("South +"+distance);
			}else{
			    System.out.println("Not a good input\n" + direction + " " + distance);
			}


		       
			System.out.println(StringParser.returnDistanceNum(to_server_string));
			socket.close();
			//Flush buffer stream
			//from_Server.flush();
		    }
		}
	    }
	}catch(IOException e){
	    System.err.println("Stream error\n");
	}
    }
}
