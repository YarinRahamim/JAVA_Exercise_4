package ex4.geometry;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle2D implements GeoShape{
	private final static double eps = 0.0000001; // eps for tests.
	private Point2D p1, p2, p3;

	// Create triangle with 3 points in geometry package.
	public Triangle2D(Point2D p1, Point2D p2, Point2D p3){
		this.p1 = new Point2D(p1);
		this.p2 = new Point2D(p2);
		this.p3 = new Point2D(p3);
	}

	//	Create string of triangle.
	public Triangle2D(String s) {
		try {
			String[] arr = s.split(",");
			double x = Double.parseDouble(arr[0]);	// Switch x variable to string.
			double y = Double.parseDouble(arr[1]);	// Switch y variable to string.
			Point2D p1 = new Point2D(x,y);			// Create new point1.
			x = Double.parseDouble(arr[2]);			// Switch x variable to string.
			y = Double.parseDouble(arr[3]);			// Switch y variable to string.
			Point2D p2 = new Point2D(x,y);			// Create new point2.
			x = Double.parseDouble(arr[4]);			// Switch x variable to string.
			y = Double.parseDouble(arr[5]);			// Switch y variable to string.
			Point2D p3 = new Point2D(x,y);			// Create new point3.
			this.p1 = new Point2D(p1);
			this.p2 = new Point2D(p2);
			this.p3 = new Point2D(p3);
		}
		catch(IllegalArgumentException e) {			// Print err if its not format string of triangle.
			System.err.println("ERR: got wrong format string for Triangle2D init");
			throw(e);
		}
	}

	// Create other triangle.
	public Triangle2D(Triangle2D other){
		this(other.p1, other.p2, other.p3);
	}
	// Get to point(access to point).
	public Point2D getP1() {
		return p1;
	}
	// Get to point(access to point).
	public Point2D getP2() {
		return p2;
	}
	// Get to point(access to point).
	public Point2D getP3() {
		return p3;
	}
	// Set a new point P1.
	public void setP1(Point2D p1) {
		this.p1 = p1;
	}

	@Override
	// Check if the rectangle contains a new point. Divide the triangle to 3 triangle and calculate the area.
	public boolean contains(Point2D ot) {
		Triangle2D t1 = new Triangle2D(this.p1, this.p2, ot);	// Create triangle with new point and p1+p2.
		Triangle2D t2 = new Triangle2D(this.p1, this.p3, ot);	// Create triangle with new point and p1+p3.
		Triangle2D t3 = new Triangle2D(this.p3, this.p2, ot);	// Create triangle with new point and p2+p3.
		double a = t1.area()+t2.area()+t3.area(); 				// Calculate the area of 3 triangle.
		double b = this.area();
		return Math.abs(a-b)<eps;								// Check if the new point contains in one of triangle.

	}

	@Override
	// Check the center point of the triangle.
	public Point2D centerOfMass() {
		Segment2D s1 = new Segment2D(this.p1, this.p3);
		Segment2D s2 = new Segment2D(this.p2, this.p3);
		Segment2D med1 = new Segment2D(this.p1,s2.centerOfMass());
		Segment2D med2 = new Segment2D(this.p2,s1.centerOfMass());
		return med1.intersec(med2); // Send m1 and m2 segment to intersec function and return the result.
	}

	/**
	 * https://en.wikipedia.org/wiki/Heron%27s_formula
	 * d = peremiter/2;
	 * area = Math.sqrt((d-a)(d-b)(d-c)),  a,b,c are the edges length
	 */

	@Override
	// Calculate the area of triangle. 
	public double area() {
		double a = this.p1.distance(this.p2); // Calculate the distance of p1 and p2. 
		double b = this.p2.distance(this.p3); // Calculate the distance of p2 and p3.
		double c = this.p1.distance(this.p3); // Calculate the distance of p1 and p3.
		double s = (a+b+c)/2;				  // Calculate adding the 3 segment and divide in 2.	
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));// Use in Heron formula.
	}

	@Override
	// Calculate the perimeter of triangle. 
	public double perimeter() {
		double dis1 = this.p1.distance(this.p2);  // Calculate the distance of p1 and p2.
		double dis2 = this.p1.distance(this.p3);  // Calculate the distance of p1 and p3.
		double dis3 = this.p2.distance(this.p3);  // Calculate the distance of p2 and p3.
		return dis1+dis2+dis3;					  // Adding the 3 segments.
	}

	@Override
	// Change the place of the triangle with new point(vec).
	public void move(Point2D vec) {
		this.p1.move(vec);
		this.p2.move(vec);
		this.p3.move(vec);
	}

	@Override
	// Return copy of triangle shape.
	public GeoShape copy() {
		return new Triangle2D(this);
	}

	@Override
	// Array of points in the triangle shape.
	public Point2D[] getPoints() {
		Point2D[] points = new Point2D[3];
		points[0] = new Point2D(this.p1);
		points[1] = new Point2D(this.p2);
		points[2] = new Point2D(this.p3);
		return points;
	}
	@Override
	// String of the triangle(return the point in string). 
	public String toString() {
		return this.p1.toString() + "," + this.p2.toString() + "," + this.p3.toString();
	}

	@Override
	// Check if shape or any object equal(belong) to triangle.
	public boolean equals(Object o) {
		if (this == o){
			return true;
		}
		if (o == null || this.getClass() != o.getClass()){
			return false;
		}

		Triangle2D t = (Triangle2D) o;
		return (this.p1.equals(t.p1) || this.p1.equals(t.p2) || this.p1.equals(t.p3)) &&
				(this.p2.equals(t.p1) || this.p2.equals(t.p2) || this.p2.equals(t.p3)) &&
				(this.p3.equals(t.p1) || this.p3.equals(t.p2) || this.p3.equals(t.p3)) &&
				(t.p1.equals(this.p1) || t.p1.equals(this.p2) || t.p1.equals(this.p3)) &&
				(t.p2.equals(this.p1) || t.p2.equals(this.p2) || t.p2.equals(this.p3)) &&
				(t.p3.equals(this.p1) || t.p3.equals(this.p2) || t.p3.equals(this.p3));

	}

}
