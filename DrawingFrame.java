/* 
 * Assignment 3 - CS 151
 * Adeel Javed
 * Alaa Salim
 * Bhavana 
 * Alan Rodriguez 
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DrawingFrame extends JFrame{
	private DrawingCanvas drawingCanvas;
	private JTextField status;
	private Shape currentShape;
	private boolean style;
	private CanvasEditor canvasEditor;
	
	
	public DrawingFrame() {
		this.setTitle("Drawing Application");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		drawingCanvas = new DrawingCanvas();
		JPanel toolStatusPanel = getToolStatusPanel();
		
		this.add(drawingCanvas, BorderLayout.CENTER); //creating the drawingCanvas in the middle
		this.add(toolStatusPanel, BorderLayout.SOUTH); //creating the toolBarPanel at the bottom
		
		
	}
	
	private JPanel getToolStatusPanel() {
		JPanel toolBarPanel = new JPanel(); //creating the ToolBarPanel
		JPanel radioPanel = new JPanel();  //creating radio buttons
		
		JRadioButton empty = new JRadioButton("Empty", true); //create an empty button, when application is ran, this radio button is loaded 
		JRadioButton filled = new JRadioButton("Filled", false);

		
		//to create toggle buttons, need to put the buttons in group
		ButtonGroup bg = new ButtonGroup(); 
		/*
		 * can add radio buttons to this group, adding to group allows for the toggling of
		 * the buttons, if not in a group, both buttons will not know the status of the 
		 * other, need to put in group
		 */
		bg.add(empty);
		bg.add(filled);
		
		//adding the buttons to the panel, cannot add groups to panel, do individually
		radioPanel.add(empty);
		radioPanel.add(filled);
		
		Dimension buttonSize = new Dimension(100,40);  //creating button size
		
		JButton ellipse = new JButton("Ellipse");//creating the buttons
		ellipse.setPreferredSize(buttonSize);
		
		JButton circle = new JButton("Circle");
		circle.setPreferredSize(buttonSize);
		
		JButton rectangle = new JButton("Rectangle");
		rectangle.setPreferredSize(buttonSize);
		
		JButton square = new JButton("Square");
		square.setPreferredSize(buttonSize);
		
		JButton clear = new JButton("Clear");
		clear.setPreferredSize(buttonSize);
		
		toolBarPanel.add(ellipse); //adding the buttons to the toolbar
		toolBarPanel.add(circle);
		toolBarPanel.add(rectangle);
		toolBarPanel.add(square);
		toolBarPanel.add(clear); //need to add actionlistened/perfomed, need to repaint collection after you clear, 
		
		JPanel toolStatusPanel = new JPanel();
		toolStatusPanel.setLayout(new BorderLayout());
		
		status = new JTextField(20); //setting the status bar
		status.setPreferredSize(new Dimension(200,40));
		
		
		toolStatusPanel.add(radioPanel,BorderLayout.NORTH); //adding button to toolBarPanel
		toolStatusPanel.add(toolBarPanel,BorderLayout.CENTER); //adding status bar to toolBarPanel
		toolStatusPanel.add(status,BorderLayout.SOUTH);
		
		

		currentShape = new Ellipse(filled.isSelected(), 0 ,0, 100, 60);
		canvasEditor = new CanvasEditor(currentShape, status);  //0 , 0 is center, 100,60 is width, height
		
		//ANONYMOUS CLASSES
		/*addActionListener the method of the button, call this to listen to button click,
		 *  ellipse is broadcaster, newActionListener() is subscriber
		 *  location collection to access it, locate the class the manipulates
		 *  the collection which is CanvasEditor
		 */
		ellipse.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				currentShape = new Ellipse(filled.isSelected(), 0 ,0, 100, 60);
				canvasEditor.setCurrentShape(currentShape);
				status.setText("Ellipse selected");
			}
		});
		
		circle.addActionListener( e -> {
				currentShape = new Circle(filled.isSelected(),0,0,100,100);
				canvasEditor.setCurrentShape(currentShape);
				status.setText("Circle selected");			
		});
		
		rectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShape = new Rectangle(filled.isSelected(),0,0,100,60);
				canvasEditor.setCurrentShape(currentShape);
				status.setText("Rectangle selected");
			}
		});
		
		square.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShape = new Square(filled.isSelected(),0,0,100,100);
				canvasEditor.setCurrentShape(currentShape);
				status.setText("Square selected");
			}
		});
		
		clear.addActionListener(new ActionListener() { //need to link to collection, collection is located in ShapeModel, from ShapeModel
			public void actionPerformed(ActionEvent e) { 
				drawingCanvas.clearShapes();
				status.setText("Shapes cleared");
			}
		
		});
		
		filled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShape.setIsFilled(filled.isSelected());
				
				//set up listener for the button
				//update the current shape because when you click on filled/empty
				
				//an create listener for this like regular buttons, need to check state of button
				//define listener for radio button
				// if filled flag is true, draw fill ,
				
			}
		});
		
		empty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShape.setIsFilled(!empty.isSelected());
			}
		});
	
		drawingCanvas.addMouseListener(canvasEditor);
		
		return toolStatusPanel;
	}
}