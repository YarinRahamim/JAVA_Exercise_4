package ex4.geometry;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShape{


	private Point2D high, low;

	// Create rectangle with 2 points in geometry package.
	public Rect2D(Point2D p1, Point2D p2){
		if(p2.y()>p1.y()){				// Check who is the high point and low point.  
			this.high = new Point2D(p2); 
			this.low = new Point2D(p1);
		}
		else{
			this.high = new Point2D(p1);
			this.low = new Point2D(p2);
		}
	}
	// Create string of rectangle.
	public Rect2D(String s) {
		try {
			String[] arr = s.split(",");
			double x = Double.parseDouble(arr[0]); 	// Switch x variable to string.
			double y = Double.parseDouble(arr[1]);	// Switch y variable to string.
			Point2D p1 = new Point2D(x,y);			// Create new point1.
			x = Double.parseDouble(arr[2]);			// Switch x variable to string.
			y = Double.parseDouble(arr[3]);			// Switch y variable to string.
			Point2D p2 = new Point2D(x,y);			// Create new point2.
			this.high = new Point2D(p1);
			this.low = new Point2D(p2);
		}
		catch(IllegalArgumentException e) {			// Print err if its not format string of rectangle.
			System.err.println("ERR: got wrong format string for Rect2D init");
			throw(e);
		}
	}

	// Create other rectangle.
	public Rect2D(Rect2D other){
		this(other.high,other.low);
	}
	// Get high point(access to high point). 
	public Point2D getHigh(){
		return this.high;
	}
	// Get low point(access to low point).
	public Point2D getLow(){
		return this.low;
	}
	// Set new high point(access to create new high point).
	public void setHigh(Point2D high) {
		this.high = high;
	}

	@Override
	// Check if the rectangle contains a new point.  
	public boolean contains(Point2D ot) {
		return (ot.x()>=Math.min(this.high.x(), this.low.x())) &&
				(ot.x()<=Math.max(this.high.x(), this.low.x())) &&
				(ot.y()<=this.high.y()) && (ot.y()>=this.low.y());
	}
	@Override
	// Check the center point of the rectangle. 
	public Point2D centerOfMass() {
		Segment2D mainTrace = new Segment2D(this.high, this.low);
		return mainTrace.centerOfMass();
	}
	@Override
	// Calculate the area of the rectangle.
	public double area() {
		Point2D low2 = new Point2D(this.high.x(),this.low.y());  // Check for low point.
		Point2D high2 = new Point2D(this.low.x(),this.high.y()); // Check for high point.		
		double edge1 = this.high.distance(high2);				 // Calculate the distance between the 2 high points.
		double edge2 = this.high.distance(low2);				 // Calculate the distance between the 2 low points.
		return edge1*edge2;										 // Multiple distance of the segments.
	}

	@Override
	// Calculate the perimeter of the rectangle.
	public double perimeter() {
		Point2D low2 = new Point2D(this.high.x(),this.low.y());  // Check for low point.
		Point2D high2 = new Point2D(this.low.x(),this.high.y()); // Check for high point.
		double edge1 = this.high.distance(high2);				 // Calculate the distance between the 2 high points.
		double edge2 = this.high.distance(low2);				 // Calculate the distance between the 2 low points.
		return (edge1+edge2)*2;									 // Adding between distance of the segments.
	}

	@Override
	// Change the place of the rectangle with new point(vec).
	public void move(Point2D vec) {
		this.high.move(vec);
		this.low.move(vec);

	}
	@Override	
	// Return copy of rectangle shape.
	public GeoShape copy() {
		return new Rect2D(this);
	}

	@Override
	// Array of points in the rectangle shape.
	public Point2D[] getPoints() {
		Point2D[] points = new Point2D[2];
		points[0] = new Point2D(this.high);
		points[1] = new Point2D(this.low);
		return points;
	}
	@Override
	// String of the rectangle(return the point in string).
	public String toString() {
		return this.high.toString() + "," + this.low.toString();
	}

	@Override
	// Check if shape or any object equal(belong) to rectangle.
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()){
			return false;
		}
		Rect2D r = (Rect2D) o;
		return this.high.equals(r.high) && this.low.equals(r.low);
	}


}


