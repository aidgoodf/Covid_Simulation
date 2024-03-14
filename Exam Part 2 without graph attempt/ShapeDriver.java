////////////////////////////////////////////////////////////////////////////////////
//
//  C212
//
//  Midterm exam part 2
//  @Aidan Goodfellow aidgoodf  
//  Explain: This file is the shapeDriver that will generate all of the people in the "town",
//  constructs a timer and every tick moves the people, checks if they have become sick and handles that accordingly,
//  in addition to setting the people to recovered after they have been sick for 12 seconds.
//  this file also creates the string that is displayed as the live count of sick, healthy, and recovered people.
//  this file also controls collision detection.
///////////////////////////////////////////////////////////////////////////////////
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ShapeDriver extends JPanel implements ActionListener {

	 private Timer timer;
	    public final int FRAME_WIDTH = 800;
	    public final int FRAME_HEIGHT = 800;
	    private ArrayList<Circle> people;
	    private Random random;
	    int sickCount = 0;
	    int recoveredCount = 0;
	    int healthyCount = 0;
	    int firstSick;
	    
	    
	    
	    public ShapeDriver(int pop) {
	    	
	    	 super(); 
	         JPanel panel = new JPanel();
	         panel.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	         
	         random = new Random();
	         people = new ArrayList<Circle>();
	         for (int i=0; i<pop; i++) {
	        	 people.add(new Circle(random.nextInt(761) + 20, random.nextInt(761) + 20, Color.BLUE, Color.BLUE, 7));
	         }
	         int sick = random.nextInt(pop);
	         people.get(sick).setFillColor(new Color(139,69,19));
	         people.get(sick).setBorderColor(new Color(139,69,19));
	         people.get(sick).setIsSick(true);
	         firstSick = sick;
	         
	         timer = new Timer(1000/100, (ActionListener) this);
	         timer.start();   
	    }
	    
	    public void actionPerformed(ActionEvent e) {
	    	healthyCount = 0;
	    	sickCount = 0;
	    	recoveredCount = 0;
	    	// check if a person is sick, if they are set color to black and increase sick age
	    	for (int g = 0; g<people.size(); g++) {
	    		people.get(g).moveLocation(people.get(g).getXDir(), people.get(g).getYDir());
	    		if (people.get(g).getIsSick()) {
	    			people.get(g).setSickAge(people.get(g).getSickAge() + (1000/100));
	    			people.get(g).setFillColor(new Color(139,69,19));
	   	         	people.get(g).setBorderColor(new Color(139,69,19));
	   	         	sickCount++;
	   	         	
	    		// check if a person has been sick for longer than 12 seconds, if they are, change them to recovered.
	   	         	if (people.get(g).getSickAge() >= 12000 ) {
	    			people.get(g).setIsSick(false);
	    			people.get(g).setBorderColor(Color.PINK);
	    			people.get(g).setFillColor(Color.PINK);
	    			people.get(g).setIsRecovered(true);
	   	         	}
	    		}
	    		else if (people.get(g).getIsRecovered()) {
	    			recoveredCount++;
	    		} else {
	    			healthyCount++;
	    		}
	    		
	    		// checking if shapes are touching the edge, if they are, this will make them bounce
	    		for (int x = 0; x<800; x++) {
	    			if ( (dist(people.get(g).getLocation(), new Point(x, 0)) <= 7) || (dist(people.get(g).getLocation(), new Point(x, 800)) <= 7) ){
	    				people.get(g).setYDir(people.get(g).getYDir() * -1);
	    				people.get(g).setY(people.get(g).getY() + (1 * people.get(g).getYDir()));
	    			} 
	    			
	    			if ( (dist(people.get(g).getLocation(), new Point(0, x)) <= 7) || (dist(people.get(g).getLocation(), new Point(800, x)) <= 7) ) {
	    				people.get(g).setXDir(people.get(g).getXDir() * -1);
	    				people.get(g).setX(people.get(g).getX() + (1 * people.get(g).getXDir()));
	    			}
	    		}
	    		
	    		// collision detection + spreading sickness
	    		
	    		for (int y = 0; y<people.size(); y++) {
	    			if (!(people.get(g) == (people.get(y)))) {
	    				if (dist(people.get(g).getLocation(), people.get(y).getLocation()) <= 14) {
	    					if (people.get(g).getIsSick()) {
	    						if(!(people.get(y).getIsRecovered())) {
	    							people.get(y).setIsSick(true);
	    						}
	    					}
	    					if (people.get(y).getIsSick()) {
	    						if(!(people.get(g).getIsRecovered())) {
	    							people.get(g).setIsSick(true);
	    						}
	    					}
	    					if (people.get(g).getXDir() > 0) {
	    						if ((people.get(y).getXDir() == 1) && (!(people.get(y).getYDir() == people.get(g).getYDir()))) {
	    							people.get(y).setYDir(people.get(y).getYDir() * -1);
	    							people.get(g).setYDir(people.get(g).getYDir() * -1);
	    							people.get(g).setY(people.get(g).getY() + (1 * people.get(g).getYDir()));
	    							people.get(y).setY(people.get(y).getY() + (1 * people.get(y).getYDir()));
	    						} else if ((people.get(y).getXDir() == -1) && (people.get(y).getYDir() == people.get(g).getYDir())) {
	    							people.get(y).setXDir(people.get(y).getXDir() * -1);
	    							people.get(g).setXDir(people.get(g).getXDir() * -1);
	    							people.get(g).setX(people.get(g).getX() + (1 * people.get(g).getXDir()));
	    							people.get(y).setX(people.get(y).getX() + (1 * people.get(y).getXDir()));
	    						} else if ((people.get(y).getXDir() == -1) && (!(people.get(y).getYDir() == people.get(g).getYDir()))) {
	    							people.get(y).setYDir(people.get(y).getYDir() * -1);
	    							people.get(y).setXDir(people.get(y).getXDir() * -1);
	    							people.get(g).setYDir(people.get(g).getYDir() * -1);
	    							people.get(g).setXDir(people.get(g).getXDir() * -1);	
	    							people.get(g).setY(people.get(g).getY() + (1 * people.get(g).getYDir()));
	    							people.get(y).setY(people.get(y).getY() + (1 * people.get(y).getYDir()));
	    							people.get(g).setX(people.get(g).getX() + (1 * people.get(g).getXDir()));
	    							people.get(y).setX(people.get(y).getX() + (1 * people.get(y).getXDir()));
	    						}
	    					} else if (people.get(g).getXDir() == -1) {
	    						if ((people.get(y).getXDir() == -1) && (!(people.get(y).getYDir() == people.get(g).getYDir()))) {
	    							people.get(y).setYDir(people.get(y).getYDir() * -1);
	    							people.get(g).setYDir(people.get(g).getYDir() * -1);
	    						} else if ((people.get(y).getXDir() == 1) && (people.get(y).getYDir() == people.get(g).getYDir())) {
	    							people.get(y).setXDir(people.get(y).getXDir() * -1);
	    							people.get(g).setXDir(people.get(g).getXDir() * -1);
	    						} else if ((people.get(y).getXDir() == 1) && (!(people.get(y).getYDir() == people.get(g).getYDir()))) {
	    							people.get(y).setYDir(people.get(y).getYDir() * -1);
	    							people.get(y).setXDir(people.get(y).getXDir() * -1);
	    							people.get(g).setYDir(people.get(g).getYDir() * -1);
	    							people.get(g).setXDir(people.get(g).getXDir() * -1);	
	    						}
	    					}
	    				}
	    			}
	    		}
	    	
	    	}
	    	
	    	
	    	
	    	this.repaint();
	    }
	    
	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawString("healthy: " + this.healthyCount + " Sick: " + this.sickCount + " recovered: " + this.recoveredCount, 600, 40);

	        for (int z=0; z< people.size(); z++) {
	        	people.get(z).draw(g);
	        }
	        
	        
	                
	    }
	    
	    
	    
	    public double dist(Point p1, Point p2) {
	    	return Math.sqrt( (Math.pow( (p2.getX() - p1.getX()), 2) + Math.pow( (p2.getY() - p1.getY()), 2) ) );
	    }
	    
}
