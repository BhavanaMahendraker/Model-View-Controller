/* 
 * Assignment 3 - CS 151 
 */
import javax.swing.*;
import java.awt.*;

public abstract class Shape implements Cloneable{ 
	//Rectangle, Circle, Ellipse, Square inherit features from
	//this class , need to implement Cloneable interface 
	
	private int x; //coordinates for center of shape
	private int y; 
	private int width; //dimensions of shape
	private int height;
	private boolean isFilled;
	
	public Shape(boolean fill, int x, int y, int w, int h) {
		isFilled = fill;
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		
	}

	public boolean isFilled() {
		return isFilled;
	}
	
	public void setIsFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}


	public int getWidth() {
		return this.width;
	}


	public int getHeight() {
		return this.height;
	}
	
	public void setCenter(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//needs at least 1 abstract method
	public abstract void draw(Graphics g);
	public abstract void drawFilled(Graphics g);
	
	
	public Object clone() {
		try {
			return super.clone();  //when you clone object, this will return the object you clone
		}
		catch(CloneNotSupportedException e) {
			return null; //if not cloned, return null
		}
	}

}
