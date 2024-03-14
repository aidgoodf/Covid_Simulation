////////////////////////////////////////////////////////////////////////////////////
//
//  @Aidan Goodfellow aidgoodf  
//  Explain: This file is the abstract shape class that will be passed to the 9 forms of shapes.
///////////////////////////////////////////////////////////////////////////////////
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public abstract class Shape {

    private Color fillColor;
    private Color borderColor;
    //private Boolean isFilled; 
    private Point location; 
    private int xDir;
    private int yDir;
    private Random random;
    private int sickAge;
    private boolean isSick;
    private boolean isRecovered;
    
    // the three constructors initialize the instance fields
  
    public Shape(Color fillColor, Color borderColor, int x, int y) {
    	this.fillColor = fillColor;
    	this.borderColor = borderColor;
    	this.location = new Point(x,y);
    	this.random = new Random();
    	this.xDir = random.nextInt(1) + 1;
    	this.yDir = random.nextInt(1) + 1;
    	this.isSick = false;
    	this.isRecovered = false;
    	
    	int neg = random.nextInt(2);
    	int neg2 = random.nextInt(2);
    	
    	if (neg == 0) {
    		
    	} else {
    		this.xDir = this.xDir * -1;
    	}
    	
    	if (neg2 == 0) {
    		
    	} else {
    		this.yDir = this.yDir * -1;
    	}
    	
    } 
 
    // set borderColor to Black since not provided 
    public Shape(Color fillColor, int x, int y) {
    	this.fillColor = fillColor;
    	this.location = new Point(x,y);
    	
    	
    } 
 
    // set fillColor to white and border color to black
    public Shape(int x, int y) { 
    	this.location = new Point(x,y);
    } 
 
    // will fill the shape with some random image. You can select any image for larger shapes
    public void setFillColor(Color c) { 
    	this.fillColor = c;
    }   
    
    public Color getFillColor() {
    	return fillColor;
    }    
    
    public void setBorderColor(Color c) { 
    	this.borderColor = c;
    }  
    
    public Color getBorderColor() { 
    	return borderColor;
    } 

    public void setLocation(Point pt) {
    	this.location = pt;
    }   
    
    public Point getLocation() { 
    	return location;
    } 
    
    public int getSickAge() {
    	return this.sickAge;
    }
    
    public void setSickAge(int t) {
    	this.sickAge = t;
    }
    
    public boolean getIsSick() {
    	return this.isSick;
    }
    
    public void setIsSick(boolean b) {
    	this.isSick = b;
    }
    
    public boolean getIsRecovered() {
    	return this.isRecovered;
    }
    
    public void setIsRecovered(boolean b) {
    	this.isRecovered = b;
    }
 
    // Note:  subclasses of Shape do not inherent private members so we need methods the subclasses 
    
    // can use to get the x and y values from the private Point instance field  
    
    public int getX() { 
    	return (int)this.location.x;
    }     
    
    public void setX(int x) { 
    	this.location.x = x;
    }    
    
    public int getY() { 
    	return(int)this.location.y;
    }    
    
    public void setY(int y) { 
    	this.location.y = y;
    } 
    
    public int getXDir() {
    	return this.xDir;
    }
    
    public void setXDir(int num) {
    	this.xDir = num;
    }
    
    public int getYDir() {
    	return this.yDir;
    }
    
    public void setYDir(int num) {
    	this.yDir = num;
    }
 
    // if fillColor is white returns true, else returns false 
   /*
    public boolean isFilled() { 
    	return this.isFilled;
    } 
 */
    // moves location by dx and dy
    
    abstract void moveLocation(int dx, int dy);
 
    abstract double getArea(); 
    
    abstract double getPerimeter(); 
    
    abstract void draw(Graphics g);
 
    // You have to update other methods as described above } 

	public static void main(String[] args) {

	}
	

}
