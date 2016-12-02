/////////////////////////////////////////
//GUI in Java                          //
//Made by Matt Nielsen and James Hauser//
//CS460/Networks                       //
/////////////////////////////////////////

import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.lang.*;
import java.beans.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class JavaGuiClient extends Frame
      implements ActionListener, WindowListener {
    //Declare GUI Variables
   private TextField response, serverField, portField, drawDistance;
   private Button btn1, btn2, btn3, btn4, btn5, btn6;


   public JavaGuiClient() {
      setLayout(new FlowLayout());

       btn1 = new Button("North");
       add(btn1);
       btn2 = new Button("South");
       add(btn2);
       btn3 = new Button("East");
       add(btn3);
       btn4 = new Button("West");
       add(btn4);
       btn5 = new Button("Down");
       add(btn5);
       btn6 = new Button("Up");
       add(btn6);

       add(new Label("Draw Distance: "));
       drawDistance = new TextField(3);
       drawDistance.setColumns(3);
       add(drawDistance);

       add(new Label("Server: "));
       serverField = new TextField(15);
       serverField.setColumns(15);
       add(serverField);

       add(new Label("Port: "));
       portField = new TextField(5);
       add(portField);
       //Sets window title, size, and visibility
       setTitle("Server Client GUI");
       setSize(500, 200);
       setVisible(true);


      btn1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {

	     try{
		 drawDistance.setText(serverConnect("n"));
	     }
	     
	     catch(UnknownHostException e){
		 
	     }catch(IOException e){
		 
		 }
	 }
	  });
      btn2.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent evt) {
		  try{
		      drawDistance.setText(serverConnect("s"));
		  }
		  
		  catch(UnknownHostException e){
		      
		  }catch(IOException e){
		      
		  }
	      }
	  });
      btn3.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent evt) {
		  try{
		      drawDistance.setText(serverConnect("e"));
		  }
		  
		  catch(UnknownHostException e){
		      
		  }catch(IOException e){
		      
		  }
	      }
	  });
      btn4.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent evt) {
		  try{
		      drawDistance.setText(serverConnect("w"));
		  }
		  
		  catch(UnknownHostException e){
		      
		  }catch(IOException e){
		      
		  }
	      }
	  });
      btn5.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent evt) {
		  try{
		      drawDistance.setText(serverConnect("d"));
		  }
		  
		  catch(UnknownHostException e){
		      
		  }catch(IOException e){
		      
		  }
	      }
	  });
      btn6.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent evt) {
		  try{
		      drawDistance.setText(serverConnect("u"));
		  }
		  
		  catch(UnknownHostException e){
		      
		  }catch(IOException e){
		      
		  }
	      }
	  });
      
      /*
	add(new Label("\nResponse: "));   // contruct the label "Response"
	response = new TextField(" "); // Construct the TextField
	response.setColumns(60);
	add(response);
      */
      
      //listen to window events
      addWindowListener(this);
	  
	  


   }

   // The entry main() method
   public static void main(String[] args) {
      new JavaGuiClient();
   }

   /* ActionEvent handler */
   @Override
   public void actionPerformed(ActionEvent evt) {

   }

   //Close the window if the close button is activated
   @Override
   public void windowClosing(WindowEvent evt) {
     JOptionPane.showMessageDialog(null, "Bye!");
      System.exit(0);  // Terminate the program
   }

   public String serverConnect(String c) throws IOException{

     //Store server information from args
     String hostName = serverField.getText();
     int portNumber = Integer.parseInt(portField.getText());
     String not_a_valid_return = "messed up";
     String command = c + drawDistance.getText();

     System.out.println(command);



    try{
      Socket daySocket = new Socket(hostName, portNumber);//Create socket, readers and writer.
      PrintWriter out = new PrintWriter(daySocket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(daySocket.getInputStream()));
      BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

      out.println(command);
      String outputString = in.readLine();
      not_a_valid_return = outputString;
      return outputString;
    }
    catch(UnknownHostException e){}
    catch(IOException e){}

    
    return not_a_valid_return;
    }

   // Surpassing Compilation Errors
   @Override public void windowOpened(WindowEvent evt) { }
   @Override public void windowClosed(WindowEvent evt) { }
   @Override public void windowIconified(WindowEvent evt) { }
   @Override public void windowDeiconified(WindowEvent evt) { }
   @Override public void windowActivated(WindowEvent evt) { }
   @Override public void windowDeactivated(WindowEvent evt) { }
}
