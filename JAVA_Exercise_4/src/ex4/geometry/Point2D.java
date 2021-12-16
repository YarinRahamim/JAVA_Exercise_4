package ex4.geometry;

/**
 * This class represents a 2D point in the plane.
 * Do NOT change this class! It would be used as is for testing.
 * Ex4: you should NOT change this class!
 * @author boaz.benmoshe
 */


public class Point2D implements GeoShape{

	public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1,2), EPS=EPS2;
	public static final Point2D ORIGIN = new Point2D(0,0);

	private double _x,_y;

	// Setting constructors variables of point(x double and y double). 
	public Point2D(double x,double y) {
		_x=x; 
		_y=y;
	}

	// Create a point. 
	public Point2D(Point2D p) {
		this(p.x(), p.y());       
	}

	// Create string of the point.
	public Point2D(String s) {
		try {
			String[] a = s.split(",");
			_x = Double.parseDouble(a[0]);	// Switch x variable to string.
			_y = Double.parseDouble(a[1]);	// Switch y variable to string.
		}
		catch(IllegalArgumentException e) {	// Print err if its not format string of point.
			System.err.println("ERR: got wrong format string for Point2D init, got:"+s+"  should be of format: x,y");
			throw(e);
		}
	}

	public double x() {
		return _x;
	}

	public double y() {
		return _y;
	}

	public int ix() {
		return (int)_x;
	}

	public int iy() {
		return (int)_y;
	}
	
	// Add new point with new x and y variables. 
	public Point2D add(Point2D p) {
		Point2D a = new Point2D(p.x()+x(),p.y()+y());
		return a;
	}

	@Override
	// Return string of point.
	public String toString()
	{
		return _x+","+_y;
	}
	// Check distance from Origin(0,0).
	public double distance(){
		return this.distance(ORIGIN);
	}

	// Check new distance between 2 points. 
	public double distance(Point2D p2){
		double dx = this.x() - p2.x();
		double dy = this.y() - p2.y();
		double t = (dx*dx+dy*dy);	// Calculate distance between two points. 
		return Math.sqrt(t);		// Calculate distance between two points. 
	}

	//// Check if shape or any object equal(belong) to point.
	public boolean equals(Object p){
		if(p==null || !(p instanceof Point2D)) {
			return false;
		}

		Point2D p2 = (Point2D)p;
		return ((_x==p2._x) && (_y==p2._y));
	}

	public boolean close2equals(Point2D p2, double eps){
		return (this.distance(p2) < eps );
	}

	public boolean close2equals(Point2D p2){
		return close2equals(p2, EPS);
	}

	/**
	 * This method returns the vector between this point and the target point.
	 *  The vector is represented as a Point2D.
	 * @param target
	 * @return
	 */
	public Point2D vector(Point2D target) {
		double dx = target.x() - this.x();
		double dy = target.y() - this.y();
		return new Point2D(dx,dy);
	}

	@Override
	public boolean contains(Point2D ot) {
		if(ot.x()==this.x() && ot.y() == this.y()){
			return true;
		}
		return false;
	}
	@Override
	public Point2D centerOfMass() {
		// TODO Auto-generated method stub
		return new Point2D(this);
	}
	@Override
	// No area.
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	// No perimeter.
	public double perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	// // Change the place of the point with new point(vec). 
	public void move(Point2D vec) {
		this._x += vec.x();
		this._y += vec.y();
	}

	@Override
	// Copy of point shape.
	public GeoShape copy() {
		return new Point2D(this);
	}

	@Override
	// Array of point.
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[1];
		ans[0] =new Point2D(this);
		return ans;
	}
}
