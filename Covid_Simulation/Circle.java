////////////////////////////////////////////////////////////////////////////////////
//
//  @Aidan Goodfellow aidgoodf  
//  Explain: This file is the Circle class that extends Oval.
///////////////////////////////////////////////////////////////////////////////////
import java.awt.Color;

public class Circle extends Oval {
	
	private int size;
	
	public Circle(int x, int y, Color fillColor, Color borderColor, int size) {
		super(x, y, fillColor, borderColor, size*2, size*2);
		this.size = size;
	}
	
	public Circle(int x, int y, Color fillColor, int size) {
		super(x, y, fillColor, size, size);
		this.size = size;
	}
	
	public Circle(int x, int y, int size) {
		super(x, y, size, size);
		this.size = size;
	}

	@Override
	public String toString() {
		return "Circle [size=" + size + "]";
	}

	public int getSize() {
		return this.size;
	}
	
	public void setSize(int s) {
		this.size = s;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Circle)) {
			return false;
		}
		Circle other = (Circle) obj;
		if (size != other.size) {
			return false;
		}
		return true;
	}
	
	public double getArea() {
		return (Math.pow((size/2), 2) * Math.PI);
	}
	
	//testing
	public static void main(String[] args) {
    	Circle c1 = new Circle( 50, 50 , Color.BLUE, Color.BLUE, 10);
    	Circle c2 = new Circle( 65, 65,Color.BLACK, Color.BLACK, 20);
    	
    	System.out.println(c1.toString());
    	System.out.println(c2.toString());
    }
	
	
	
	

}
