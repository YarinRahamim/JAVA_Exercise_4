package ex4;

import ex4.geometry.*;

/**
 * This class is the "main" class which will be constructed and run as in (Test_Ex4).
 * Ex4: you should implement this class!
 * @author boaz.benmoshe
 *
 */
public class Ex4 implements Ex4_GUI{
	private static GUI_Shape_Collection collection;
	public Ex4() {
		collection = new Shape_Collection();
	}
	// The main for jar file.  
	public static void main(String[]args) {
		String file = args[0];
		int sortNum = Integer.parseInt(args[1]);
		Ex4 Ex4 = new Ex4();
		Shape_Collection collection = new Shape_Collection();
		collection.load(file); 
		Shape_Comp comp = new Shape_Comp(sortNum);
		collection.sort(comp);
		Ex4.init(collection);
		Ex4.show();
	}

	@Override
	public void init(GUI_Shape_Collection g) {
		collection=g;
	}

	@Override
	public GUI_Shape_Collection getShape_Collection() {
		return collection;
	}

	@Override
	// Create show function use in StDraw 
	public void show() {
		double isX[] = new double[3];  
		double isY[] = new double[3]; 
		for( int i = 0; i<collection.size(); i++) {
			GeoShape g = Ex4.collection.get(i).getShape();

			// Check if g is same like Point2D, and crate the shape with StDraw. 
			if(g instanceof Point2D) {
				StdDraw.setPenColor(Ex4.collection.get(i).getColor()); // Color.
				Point2D temp = (Point2D)g;							   // Shape.
				StdDraw.getFont();									   // Font.
				StdDraw.getPenRadius();							       // Size of pen.
				StdDraw.point(temp.x(), temp.y());					   // The point.
			}
			// Check if g is same like Rect2D, and crate the shape with StDraw.
			else if(g instanceof Rect2D) {
				StdDraw.setPenColor(Ex4.collection.get(i).getColor()); // Color.
				Rect2D temp = (Rect2D)g; 							   // Shape.
				StdDraw.getFont();									   // Font.
				StdDraw.getPenRadius();								   // Size of pen.
				// The points of Rect2D use in getpoints and center of mass functions.
				StdDraw.rectangle(temp.centerOfMass().x(),temp.centerOfMass().y(),
						Math.abs(temp.getPoints()[0].x()-temp.getPoints()[1].x())/2,
						Math.abs(temp.getPoints()[0].y()-temp.getPoints()[1].y())/2);

				// Check if isFilled boolean function is true or false, and filled the shape.
				if(collection.get(i).isFilled()) {
					StdDraw.filledRectangle(temp.centerOfMass().x(),temp.centerOfMass().y(),
							Math.abs(temp.getPoints()[0].x()-temp.getPoints()[1].x())/2,
							Math.abs(temp.getPoints()[0].y()-temp.getPoints()[1].y())/2);
				}
			}
			// Check if g is same like Segment2D, and create the shape with StDraw.
			else if(g instanceof Segment2D) {
				StdDraw.setPenColor(Ex4.collection.get(i).getColor());	// Color.
				Segment2D temp = (Segment2D)g;							// Shape.
				StdDraw.getFont();										// Font.
				StdDraw.getPenRadius();									// Size of pen.
				// The points of Segment2D use in getpoints function.
				StdDraw.line(temp.getPoints()[0].x(), temp.getPoints()[0].y(),temp.getPoints()[1].x(),temp.getPoints()[1].y());
			}
			// Check if g is same like Circle2D, and crate the shape with StDraw.
			else if(g instanceof Circle2D) {
				Circle2D rad = ((Circle2D)collection.get(i).getShape()); // Check radius of circle.
				StdDraw.setPenColor(Ex4.collection.get(i).getColor()); 	 // Color.
				Circle2D temp = (Circle2D)g;							 // Shape.	
				StdDraw.getFont();										 // Font.
				StdDraw.getPenRadius();								 	 // Size of pen.
				// The points of Circle2D use in getpoints and get radius functions.
				StdDraw.circle(temp.getPoints()[0].x(),temp.getPoints()[0].y(), rad.getRadius());

				// Check if isFilled boolean function is true or false, and filled the shape.
				if(collection.get(i).isFilled()) {
					StdDraw.filledCircle(temp.getPoints()[0].x(),temp.getPoints()[0].y(), rad.getRadius());
				}
			}
			// Check if g is same like Triangle2D, and crate the shape with StDraw.
			else if(g instanceof Triangle2D) {
				StdDraw.setPenColor(Ex4.collection.get(i).getColor());  // Color.
				Triangle2D temp = (Triangle2D)g;						// Shape.
				StdDraw.getFont();										// Font.
				StdDraw.getPenRadius();									// Size of pen.
				// The points of Circle2D use in getpoints function, create 3 arrays for StDraw polygon.
				isX[0] = temp.getPoints()[0].x();
				isX[1] = temp.getPoints()[1].x();
				isX[2] = temp.getPoints()[2].x();
				isY[0] = temp.getPoints()[0].y();
				isY[1] = temp.getPoints()[1].y();
				isY[2] = temp.getPoints()[2].y();
				StdDraw.polygon(isX, isY);
			}
			// Show the shapes.
			StdDraw.show();

		}

	}


	@Override
	// Get string of collection. 
	public String getInfo() {
		return collection.toString();
	}
}
