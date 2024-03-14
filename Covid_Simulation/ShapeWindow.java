////////////////////////////////////////////////////////////////////////////////////
//
//  @Aidan Goodfellow aidgoodf  
//  Explain: This file creates the frame that the shapeDriver component is displayed on. 
//  It also takes the user input for how many people should be in the "town".
///////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapeWindow extends JFrame {
	
	JPanel shapeDriver;
	
	public ShapeWindow(int pop) {
        super();
        JFrame frame = new JFrame();
        shapeDriver = new ShapeDriver(pop);
        frame.getContentPane().add(shapeDriver);
        // size 800,800 wasn't creating a frame of that size for some reason so this was for cosmetic adjustment
        frame.setSize(820, 835);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
       
        
    }

	public static void main(String[] args) {
		System.out.println("Please enter a number for the population of the town");
		Scanner in = new Scanner(System.in);
		int pop = in.nextInt();
		JFrame shapeWindow = new ShapeWindow(pop);
		
	}

}
