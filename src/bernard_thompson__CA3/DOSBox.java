/**
 * The DOSBox class represents a visual Dos Box
 * which runs with the Copy Class to enable the user to
 * see the progress and ensure it has copied
 * 
 * @author (Bernard Thompson) 
 * @version (CA 3)
 */

package bernard_thompson__CA3;

/**
 * Import both swing and awt packages to construct the GUI
 */

import java.awt.*;

import javax.swing.*;

public class DOSBox implements Runnable {
	
/**
 * Declaring appropriate fields which will be used
 * Implement the Runnable Class
 */
	
	private JFrame dosFrame;
	
	private JLabel dosLabel, dosLabel2, dosLabel3, dosLabelCopy;
	
	private Thread dosThread;
	
	private String [] dosMessage;
	
	
	
	public DOSBox () {
		
		//Call createFrame method
		createFrame();
		// create a new thread
        dosThread = new Thread(this); //"this" object contains i run method
        // start the thread
        dosThread.start();//looks for run method
	}
	
	/*
	 * Create the JLables 
	 * I tried to create a string in order to display text on separate lines
	 * but it would not work so I opted for multiple JLabels as \n will not work using JLabels
	 * I also tried using the HTML tag "<HTML>Some text<br><br>More text</HTML>, for some reason I could not get this to work
	 */
	
	public void createLabels() {
		
		dosLabel = new JLabel();
		dosLabel.setText("C:/programfiles_");
		dosLabel.setHorizontalTextPosition(JLabel.LEFT);
		dosLabel.setForeground(Color.white);
		dosLabel.setSize(20,300);
		
		dosFrame.add(dosLabel);
		
		dosLabel2 = new JLabel();
		dosLabel2.setText("Activity Log ");
		dosLabel2.setHorizontalTextPosition(JLabel.LEFT);
		dosLabel2.setForeground(Color.white);
		
		dosFrame.add(dosLabel2);
		
		dosLabel3 = new JLabel();
		dosLabel3.setText("*********");
		dosLabel3.setHorizontalTextPosition(JLabel.LEFT);
		dosLabel3.setForeground(Color.white);
		
		dosFrame.add(dosLabel3);
		
		dosLabelCopy = new JLabel();
		dosLabelCopy.setHorizontalTextPosition(JLabel.LEFT);
		dosLabelCopy.setForeground(Color.white);
		
		dosFrame.add(dosLabelCopy);
		
		
	}
	
	/*
	 * Create the frame for the GUI
	 */
	
	public void createFrame() {
		
		dosFrame = new JFrame("Log File for Animation on Left");
		dosFrame.setLayout(new GridLayout(10,1));
		dosFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dosFrame.setSize(600,300);
		dosFrame.setLocation(695,200);
		dosFrame.getContentPane().setBackground(Color.black);
		dosFrame.setVisible(true);
		dosFrame.setResizable(false);
	    //call the createLabels method
	    createLabels();
	}
	
	/*
	 * Run method which will display each image
	 * While delaying the time between each image
	 * Using the Thread.sleep
	 */
		
	public void run () {
		
		//create array
		dosMessage = new String[5];
		
		//Populate array for messages
		dosMessage[0] = "";
		dosMessage[1] = "Data Set 1 Successfully copied";
        dosMessage[2] = "Data Set 2 Successfully copied";
        dosMessage[3] = "Data Set 3 Successfully copied";
        dosMessage[4] = "Data Set 4 Successfully copied";
		
		int i = 0;
		
		//while loop to search through array
		while(i <= dosMessage.length)
			
		{
			//display message and go to the next message and display
			dosLabelCopy.setText(dosMessage[i]);
			//add next message
			i++;
			
			try
			{
				Thread.sleep(5000);//milliseconds between each message to display after a group of img's
				dosLabelCopy.setText("Data Successfully Copied");
			}
			catch (InterruptedException e)
			{
				//alert the user that something has gone wrong if so
				dosLabelCopy.setText("Download interupted");
				e.printStackTrace();
			}
			
			
		}
		
	}// Run method closing tag
	
} // last closing Tag
	
