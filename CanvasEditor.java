/* 
 * Assignment 3 - CS 151
 * Adeel Javed
 * Alaa Salim
 * Bhavana 
 * Alan Rodriguez 
 */

import java.awt.event.*;
import javax.swing.*;

public class CanvasEditor implements MouseListener{;
	private Shape currentShape;
	private boolean isFilled = false;
	private JTextField status;

	
	public CanvasEditor(Shape initialShape, JTextField status) {
		this.currentShape = initialShape;
		this.status = status;
	}
	
	public void setCurrentShape(Shape currentShape) {
		this.currentShape = currentShape;
	}
	
	public void mouseClicked(MouseEvent e) {
		
		Object o = currentShape.clone();
		if(o instanceof Shape) 
		{
			Shape newShape = (Shape)o;
		}
		
		Shape newShape = (Shape)currentShape.clone(); //clone returns object type, need to cast as Shape
		newShape.setCenter(e.getX(), e.getY());
		DrawingCanvas drawingCanvas = (DrawingCanvas)e.getSource();
		drawingCanvas.addShape(newShape);
		
		if(currentShape instanceof Circle) 
		{
			status.setText("Circle drawn");
		}
		else if(currentShape instanceof Square) 
		{
			status.setText("Square drawn");
		}
		else if(currentShape instanceof Rectangle) 
		{
			status.setText("Rectangle drawn");
		}
		else if(currentShape instanceof Ellipse) 
		{
			status.setText("Ellipse drawn");
		}
		
		}

	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {	
	}
	
	public void mouseExited(MouseEvent e) {	
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
}

