/* 
 */
import java.awt.Graphics;
import java.awt.*;

public class Rectangle extends Shape{
	
	
	public Rectangle(boolean fill, int x, int y, int w, int h) {
		super(fill, x, y, w, h);
	}

	public void draw(Graphics g) {
		g.drawRect(getX() - getWidth() / 2, getY() - getHeight() / 2  , getWidth() , getHeight());
	}
	
	public void drawFilled(Graphics g) {
		g.fillRect(getX() - getWidth() / 2, getY() - getHeight() / 2  , getWidth() , getHeight());
	}
}
