/* 
 * Assignment 3 - CS 151
 * Adeel Javed
 * Alaa Salim
 * Bhavana 
 * Alan Rodriguez 
 */
import java.util.*;

public class ShapeModel implements Iterable<Shape>{
	private ArrayList<Shape> shapes;
	
	public ShapeModel() {
		shapes = new ArrayList<Shape>();
	}
	
	public void addShape(Shape newShape) {
		shapes.add(newShape); //shapes is a collection, adding newShape to the collection
	}
	
	public Iterator<Shape> iterator(){  //can traverse all shapes in the collection 
		return shapes.iterator();
	}
}
