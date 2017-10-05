/**
 * The CopyData class displays images
 * to represent a user copying some data using threads
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

/**
 * Declaring appropriate fields which will be used
 * Implement the Runnable Class
 */
public class CopyData implements Runnable  {
	
	private ImageIcon image1, image2, image3, image4, image5;
	
	private JFrame copyFrame;
	
	private JLabel imageLabel;
	
	private ImageIcon [] imageArray;
	
	private Thread copyThread;
	
	public CopyData () {
		
		//calling the createCopyFrame from below
		createCopyFrame();
		
		// create a new thread
        copyThread = new Thread(this); //"this" object contains the run method
        
        // start the thread
        copyThread.start(); //looks for run method
				
}
	
	/*
	 * Create the frame for the CopyDate class GUI
	 */
	public void createCopyFrame () {
		
		copyFrame = new JFrame("Copying Data - EDP CA");
		
		copyFrame.setLayout (new GridLayout(1,0));
		copyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		copyFrame.setSize(300,300);
		copyFrame.setLocation(400,200);
		copyFrame.getContentPane().setBackground(Color.white);
		copyFrame.setResizable(false);
		copyFrame.setVisible(true);
		
		//calling the createPanel method below
		createPanel ();
		
		// create a new thread
        copyThread = new Thread(this); //"this" object contains the run method
        // start the thread
        copyThread.start();//looks for run method
	}
	
	/*
	 * Create the panel where the images will display
	 */
	public void createPanel () {
		
		imageLabel = new JLabel();
		
		//setting the label blank so image does not appear 
		//before program starts
		imageLabel.setText("");
		copyFrame.add(imageLabel);

	}
	
	/*
	 * Run method which will display each image
	 * While delaying the time between each image
	 * Using the Thread.sleep
	 */
	public void run() {
		
		//import the images from source folder
		image1 = new ImageIcon("progress1.gif");
		image2 = new ImageIcon("progress2.gif");
		image3 = new ImageIcon("progress3.gif");
		image4 = new ImageIcon("progress4.gif");
		image5 = new ImageIcon("progress5.gif");
		
		//Array will store five images
		imageArray = new ImageIcon[20];
		
		//Populate the array
		//Should of repeated the loop through the initial array [5]
		//It would not work so re populated the array [20]
		imageArray[0] = (image1);
		imageArray[1] = (image2);
		imageArray[2] = (image3);
		imageArray[3] = (image4);
		imageArray[4] = (image5);
		imageArray[5] = (image1);
		imageArray[6] = (image2);
		imageArray[7] = (image3);
		imageArray[8] = (image4);
		imageArray[9] = (image5);
		imageArray[10] = (image1);
		imageArray[11] = (image2);
		imageArray[12] = (image3);
		imageArray[13] = (image4);
		imageArray[14] = (image5);
		imageArray[15] = (image1);
		imageArray[16] = (image2);
		imageArray[17] = (image3);
		imageArray[18] = (image4);
		imageArray[19] = (image5);
		
		int i = 0;
		
		//For loop to search through the ArrayList above
		while( i < imageArray.length)
			
		{
			//Set each image to appear on the JLabel imageLabel
			imageLabel.setIcon(imageArray[i]);
			imageLabel.setBounds(70, 80, 150, 150);
			
			//add the next image
			i++;

			try
			{
				Thread.sleep(1000); //represents the millisecond between images
			}
			catch (InterruptedException e)
			{
				//If something is to go wrong the user will be notified
				imageLabel.setText("*** Something went wrong - Download interupted ***");
				e.printStackTrace();
			}
			
		}// while loop closing tag
		
		  
	} // run method closing tag
	
	
	
	
	
public static void main(String[] args) {
		CopyData cd = new CopyData();
		DOSBox DB = new DOSBox();
		
	
		
			
	} // main closing tag
	
} // last closing tag
