/* 
 * Assignment 3 - CS 151
 * Adeel Javed
 * Alaa Salim
 * Bhavana 
 * Alan Rodriguez 
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;


public class DrawingCanvas extends JPanel{
	private ShapeModel shapeModel;
	
	public DrawingCanvas() {
		this.setPreferredSize(new Dimension(800,600));
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.YELLOW);
		shapeModel = new ShapeModel();  //creates object of ShapeModel, which is an empty ArrayList, can add shapes to it
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		repaint(); //this is method of super class
		Iterator it = shapeModel.iterator();
		while(it.hasNext()) { //while there is another object in the collection, we keep getting the shape
			Shape shape = (Shape)it.next(); //when you get an item from the collection, convert it to the Shape type, now we have the shape we want to draw
			if(shape.isFilled())
				shape.drawFilled(g);
			else
				shape.draw(g); //the compiler will look for the draw method in the other classes, for example in the Ellipse/Rectangle classes, they have their own draw methods. 
						   //From the shape, can call the draw method
			
		}
		//repaint();
	}	

	
	public void addShape(Shape newShape) {
		shapeModel.addShape(newShape);   //shapeModel is an object of the ShapeModel class
		repaint(); //this is from Component class, 
	}
	
	public void clearShapes() {
		Iterator it = shapeModel.iterator(); //returns the iterator of the current collection
		//traverse through and remove one at a time
		//check the end of the collection
		while(it.hasNext()){
			//will keep going and remove until the end of the collection
			it.next();  //call this first to get the pointer 
			it.remove(); //removes the objects in the collection
		}
		repaint(); //redraw the empty collection, if you dont repaint, the collection is empty but the shapes will still be on the screen
	}
	
	
}



//erase: need to erase all shapes from collection, when you repaint the collection there should be nothing on the screen


//1. locate the class the manipulates the collection
//2. check the objects currently in the drawingFrame
//3. can call any method to do whatever you want ellipse,square,clear, etc


// can use iteratorPattern to remove shapes from collection one at a time
//need to get the iterator of that collection that you are accessing, identify the collection you are trying to process


