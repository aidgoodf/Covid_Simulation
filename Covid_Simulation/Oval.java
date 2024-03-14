////////////////////////////////////////////////////////////////////////////////////
//
//  @Aidan Goodfellow aidgoodf  
//  Explain: This file is the Oval class that extends shapes.
///////////////////////////////////////////////////////////////////////////////////
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Oval extends Shape {
	
	private int height;
	private int width;
	

	public Oval(int x, int y, Color fillColor, Color borderColor, int h, int w) {
		super(fillColor, borderColor, x-w, y-h);
		this.height = h;
		this.width = w;
	}
	
	public Oval(int x, int y, Color fillColor, int h, int w) {
		super(fillColor, x, y);
		this.height = h;
		this.width = w;
	}
	
	public Oval(int x, int y, int h, int w) {
		super(x, y);
		this.height = h;
		this.width = w;
	}
	
	public void setWidth(int w) {
		this.width = w;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setHeight(int h) {
		this.height = h;
	}
	
	public int getHeight() {
		return this.height;
	}

	@Override
	public String toString() {
		return "Oval [height=" + height + ", width=" + width + "]";
	}
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(getBorderColor());
		g2.drawOval(super.getLocation().x, super.getLocation().y, width, height);
		g2.setColor(getFillColor());
		g2.fillOval(super.getLocation().x, super.getLocation().y, width, height);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Oval)) {
			return false;
		}
		Oval other = (Oval) obj;
		if (height != other.height) {
			return false;
		}
		if (width != other.width) {
			return false;
		}
		return true;
	}
	
	// testing
	public static void main(String[] args) {
    	Oval o1 = new Oval(  50, 50 ,Color.BLUE, Color.BLUE, 10, 20);
    	Oval o2 = new Oval(40, 40, Color.BLACK, Color.BLACK, 20, 10);
    	
    	System.out.println(o1.toString());
    	System.out.println(o2.toString());
    }

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void moveLocation(int dx, int dy) {
		Point pt = new Point(this.getX() + this.getXDir(), this.getY() + this.getYDir());
		this.setLocation(pt);
	}
	
	
}
