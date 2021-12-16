package ex4;
import ex4.geometry.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Shape_Collection implements GUI_Shape_Collection{

	private ArrayList<GUI_Shape> collection; // Use in Array List of GUI Shape. 

	public Shape_Collection(){ // Create shape collection list of GUI Shape. 
		this.collection = new ArrayList<GUI_Shape>();
	}

	// Crate other shape collection. 
	public Shape_Collection(Shape_Collection other){
		this.collection = new ArrayList<GUI_Shape>(other.collection.size());
		for(GUI_Shape gs : other.collection) {
			this.collection.add(new GUIShape((GUIShape) gs));
		}
	}

	@Override
	// Get to GUI Shape in place "i".
	public GUI_Shape get(int i) {
		if(collection.size() <= i || i<0){ // If size collection <= i or i<0, return null.  
			return null;
		}
		return collection.get(i);	// Else return collection in place "i".
	}

	@Override
	// Check size of collection.
	public int size() {
		return collection.size();
	}

	@Override
	// Remove shape in place "i". 
	public GUI_Shape removeElementAt(int i) { 
		if(collection.size() <= i || i<0){	// If size collection <= i or i<0, return null. 
			return null;
		}
		return collection.remove(i); 		//Else return collection without shape in place "i".
	}

	@Override
	// Add shape in place "i".
	public void addAt(GUI_Shape s, int i) {
		if(collection.size() < i || i<0 || s==null){ // If size collection <= i or i<0 or s== null , return null.
			return;
		}
		collection.add(i,s);                         // Else return add shape to collection in place "i".  
	}
	@Override
	// Add shape to collection. 
	public void add(GUI_Shape s) {
		if(s != null) {  // If the shape not null add the shape to collection.
			collection.add(s);
		}
	}
	@Override
	// Create copy to GUI Shape collection. 
	public GUI_Shape_Collection copy() {
		return new Shape_Collection(this);
	}

	@Override
	// Sort the collection.
	public void sort(Comparator <GUI_Shape> comp) {
		this.collection.sort(comp);
	}

	@Override
	// Remove all shape from collection. 
	public void removeAll() {
		this.collection.removeAll(collection);
	}

	@Override
	// Save file with all shapes in the collection. 
	public void save(String file) {
		try {
			FileWriter myWriter = new FileWriter(file);
			for (int i=0; i<this.size();i++) {
				myWriter.write(collection.get(i)+"\n");  
			}
			myWriter.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	// Load from file, the file include the shapes collection. 
	public void load(String file) {
		try {
			this.collection.removeAll(collection);
			File myObj = new File(file);
			Scanner myReader = new Scanner(myObj);
			int i=0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				GUIShape da = new GUIShape(data);
				collection.add(da);
				i=i+1;
			}
			myReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	// Create a bounding box, the box contains the shapes.  
	public Rect2D getBoundingBox() {
		double maxY = this.collection.get(0).getShape().getPoints()[0].y(); // Check the y max in shapes collection.
		double minY = this.collection.get(0).getShape().getPoints()[0].y(); // Check the y min in shapes collection.
		double maxX = this.collection.get(0).getShape().getPoints()[0].x(); // Check the x max in shapes collection.
		double minX = this.collection.get(0).getShape().getPoints()[0].x(); // Check the x min in shapes collection.

		// Default variables.
		double max1 = 0;
		double min1 = 0;
		double max2 = 0;
		double min2 = 0;
		int i = 0;

		// Loop "for", check all the shapes in the collection. Check if "gs" from same "family" and check the min and max x,y. 

		for (; i < this.size(); i++) {
			GeoShape gs = this.collection.get(i).getShape();	
			// Check for the max and min points in Point2D getpoints function. 
			if (this.collection.get(i).getShape() instanceof Point2D) {
				if (((Point2D) gs).x() > maxX) {
					maxX = ((Point2D) gs).x();
				}
				if (((Point2D) gs).y() > maxY) {
					maxY = ((Point2D) gs).y();
				}
				if (((Point2D) gs).x() < minX) {
					minX = ((Point2D) gs).x();
				}
				if (((Point2D) gs).y() < minY) {
					minY = ((Point2D) gs).y();
				}
			}
			// Check for the max and min points in Triangle2D getpoints function.  
			if (this.collection.get(i).getShape() instanceof Triangle2D) {
				max1 = Math.max(((Triangle2D) gs).getPoints()[0].y(), ((Triangle2D) gs).getPoints()[1].y());
				max1 = Math.max(max1, ((Triangle2D) gs).getPoints()[2].y());

				max2 = Math.max(((Triangle2D) gs).getPoints()[0].x(), ((Triangle2D) gs).getPoints()[1].x());
				max2 = Math.max(max2, ((Triangle2D) gs).getPoints()[2].x());

				min1 = Math.min(((Triangle2D) gs).getPoints()[0].y(), ((Triangle2D) gs).getPoints()[1].y());
				min1 = Math.min(min1, ((Triangle2D) gs).getPoints()[2].y());

				min2 = Math.min(((Triangle2D) gs).getPoints()[0].x(), ((Triangle2D) gs).getPoints()[1].x());
				min2 = Math.min(min2, ((Triangle2D) gs).getPoints()[2].x());
				if (max1 > maxY) {
					maxY = max1;
				}
				if (max2 > maxX) {
					maxX = max2;
				}
				if (min1 < minY) {
					minY = min1;
				}
				if (min2 < minX) {
					minX = min2;
				}
			}
			// Check for the max and min points in Segment2D getpoints function.
			if (this.collection.get(i).getShape() instanceof Segment2D) {
				max1 = Math.max(((Segment2D) gs).getPoints()[0].y(), ((Segment2D) gs).getPoints()[1].y());
				max2 = Math.max(((Segment2D) gs).getPoints()[0].x(), ((Segment2D) gs).getPoints()[1].x());

				min1 = Math.min(((Segment2D) gs).getPoints()[0].y(), ((Segment2D) gs).getPoints()[1].y());
				min2 = Math.min(((Segment2D) gs).getPoints()[0].x(), ((Segment2D) gs).getPoints()[1].x());
				if (max1 > maxY) {
					maxY = max1;
				}
				if (max2 > maxX) {
					maxX = max2;
				}
				if (min1 < minY) {
					minY = min1;
				}
				if (min2 < minX) {
					minX = min2;
				}
			}
			// Check for the max and min points in Rect2D use getpoints function. 
			if (this.collection.get(i).getShape() instanceof Rect2D) {
				max1 = Math.max(((Rect2D) gs).getPoints()[0].y(), ((Rect2D) gs).getPoints()[1].y());
				max2 = Math.max(((Rect2D) gs).getPoints()[0].x(), ((Rect2D) gs).getPoints()[1].x());

				min1 = Math.min(((Rect2D) gs).getPoints()[0].y(), ((Rect2D) gs).getPoints()[1].y());
				min2 = Math.min(((Rect2D) gs).getPoints()[0].x(), ((Rect2D) gs).getPoints()[1].x());

				if (max1 > maxY) {
					maxY = max1;
				}
				if (max2 > maxX) {
					maxX = max2;
				}
				if (min1 < minY) {
					minY = min1;
				}
				if (min2 < minX) {
					minX = min2;
				}
			}
			// Check for the max and min points in Circle2D use centrofmass function. 
			if (this.collection.get(i).getShape() instanceof Circle2D) {
				Circle2D check = (Circle2D) this.collection.get(i).getShape();
				max1 = check.centerOfMass().y() + check.getRadius();
				max2 = check.centerOfMass().x() + check.getRadius();

				min1 = check.centerOfMass().y() - check.getRadius();
				min2 = check.centerOfMass().x() - check.getRadius();
				if (max1 > maxY) {
					maxY = max1;
				}
				if (max2 > maxX) {
					maxX = max2;
				}
				if (min1 < minY) {
					minY = min1;
				}
				if (min2 < minX) {
					minX = min2;
				}
			}
		}
		// Check for min and max points between all shapes.
		Rect2D check =new Rect2D(new Point2D(maxX,maxY),new Point2D(minX,minY));
		return check;
	}

	@Override
	// Return string of the collection.
	public String toString() {
		return collection.toString();
	}
}


