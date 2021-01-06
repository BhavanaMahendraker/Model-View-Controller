/* 
 * Assignment 3 - CS 151
 */
import java.awt.Graphics;

public class Circle extends Ellipse{
	//do all shapes same as Ellipse, or similar
	
	public Circle(boolean filled,int x, int y, int w, int h) {
		super(filled, x,y,w,h);
	}
	
	public void draw(Graphics g) {
		g.drawOval(getX() - getWidth() / 2, getY() - getHeight() / 2  , getWidth() , getHeight());
	}
	
	public void drawFilled(Graphics g) {
		g.fillOval(getX() - getWidth() / 2, getY() - getHeight() / 2  , getWidth() , getHeight());
	}
	
	
}
