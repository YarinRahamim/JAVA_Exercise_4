package ex4.geometry;

/**
 * This class represents a 2D circle in the plane. Please make sure you update it 
 * according to the GeoShape interface.
 * Ex4: you can update this class (additional documentation is needed)!
 * @author boaz.benmoshe
 *
 */

// Create circle in geometry package.
public class Circle2D implements GeoShape{
	private Point2D _center;
	private double _radius;

	// Setting constructors variables of circle(point and radius). 
	public  Circle2D(Point2D cen, double rad) {
		this._center = new Point2D(cen); // Point of center.
		this._radius = rad;				 // Radius of circle.
		if(rad < 0 ) { 					 // If radius < 0 print err and the radius = 1.
			System.out.println("Err ***The radius is not illegal***");
			this._radius = 1;
		}
	}

	// Create string of the circle.
	public Circle2D(String s) { 
		try {
			String[] a = s.split(",",2); // Array of strings
			double x = Double.parseDouble(a[0]);	// Switch x variable to string.
			a=a[1].split(",");
			double y = Double.parseDouble(a[0]);	// Switch y variable to string.
			_radius=Double.parseDouble(a[1]);		// Switch radius variable to string.
			_center=new Point2D(x,y);				// Create new point.
		}
		catch(IllegalArgumentException e) {			// Print err if its not format string of circle.
			System.err.println("ERR: got wrong format string for Circle2D init");
			throw(e);
		}
	}

	// Create other circle.
	public Circle2D(Circle2D other) {
		this(other._center,other._radius);	
	}
	// Get radius(access to radius). 
	public double getRadius() {
		return this._radius;
	}

	@Override
	// Return string of the center point and the radius.
	public String toString(){
		return _center.toString()+", "+_radius;
	}

	@Override
	// Check if the circle contains a new point.  
	public boolean contains(Point2D ot) {
		double dist = ot.distance(this._center);
		return dist<=this._radius;
	}
	@Override
	// Check the center of circle.
	public Point2D centerOfMass() {
		return new Point2D(this._center);
	}
	@Override
	// Calculate the area of the circle.
	public double area() {
		double ans = Math.PI * Math.pow(this._radius, 2);
		return ans;
	}

	@Override
	// Calculate the perimeter of the circle.
	public double perimeter() {
		double ans = Math.PI * 2 * this._radius;
		return ans;
	}

	@Override
	// Change the place of the circle with new point(vec).
	public void move(Point2D vec) {
		_center.move(vec);
	}
	@Override
	// Return copy of circle.
	public GeoShape copy() {
		return new Circle2D(_center, _radius);
	}

	@Override
	// Array of point in the circle shape.
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(this._center);
		ans[1] = new Point2D(ans[0].x(), ans[0].y()+this._radius);
		return ans;
	}

	@Override
	// Check if shape or any object equal(belong) to circle.
	public boolean equals(Object o) {
		if (this == o){
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Circle2D c = (Circle2D) o;
		return c._center.equals(this._center)  && c._radius == this._radius;
	}
}
