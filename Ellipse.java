/* 
 * Assignment 3 - CS 151
 * Adeel Javed
 * Alaa Salim
 * Bhavana 
 * Alan Rodriguez 
 */
import java.awt.*;

public class Ellipse extends Shape{
	
	public Ellipse(boolean filled, int x, int y, int w, int h) {
		super(filled, x,y,w,h); //passing all values to super class to initialize the values
	}
	
	public void draw(Graphics g) {
		g.drawOval(getX() - getWidth() / 2, getY() - getHeight() / 2  , getWidth() , getHeight());
	}
	
	public void drawFilled(Graphics g) {
		g.fillOval(getX() - getWidth() / 2, getY() - getHeight() / 2  , getWidth() , getHeight());
	}

}