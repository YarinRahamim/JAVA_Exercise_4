package ex4.geometry;

/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Segment2D implements GeoShape{

	private Point2D _p1,_p2;

	// Create segment with 2 points in geometry package.
	public Segment2D(Point2D o1, Point2D o2) {
		_p1 = new Point2D(o1);
		_p2 = new Point2D(o2);
	}


	public Segment2D(Segment2D segment) {
		this(segment._p1, segment._p2);
	}

	// Create string of segment.	
	public Segment2D(String s) {
		try {
			String[] arr = s.split(",");
			double x = Double.parseDouble(arr[0]);	// Switch x variable to string.
			double y = Double.parseDouble(arr[1]);	// Switch y variable to string.
			Point2D p1 = new Point2D(x,y);			// Create new point1.
			x = Double.parseDouble(arr[2]);			// Switch x variable to string.
			y = Double.parseDouble(arr[3]);			// Switch y variable to string.
			Point2D p2 = new Point2D(x,y);			// Create new point2
			_p1 = new Point2D(p1);					
			_p2 = new Point2D(p2);
		}
		catch(IllegalArgumentException e) {			// Print err if its not format string of segment.
			System.err.println("ERR: got wrong format string for Segment2D init");
			throw(e);
		}
	}

	@Override
	// Check if the segment contains a new point. 
	public boolean contains(Point2D ot) {
		double m = (_p1.y() - _p2.y())/(_p1.x() - _p2.x());
		return (ot.y() - _p1.y() == m*(ot.x() - _p1.x())) &&
				(ot.x()>=Math.min(_p1.x(), _p2.x())) &&
				(ot.x()<=Math.max(_p1.x(), _p2.x())) &&
				(ot.y()>=Math.min(_p1.y(), _p2.y())) &&
				(ot.y()<=Math.max(_p1.y(), _p2.y()));	
	}
	// Get to point(access to point).
	public Point2D get_p1() {
		return _p1;
	}

	// Get to point(access to point).
	public Point2D get_p2() {
		return _p2;
	}

	@Override
	// Check the center of segment.
	public Point2D centerOfMass() {
		double x = (_p1.x()+_p2.x())/2; // Calculate (x1+x2)/2.
		double y = (_p1.y()+_p2.y())/2;	// Calculate (y1+y2)/2.
		return new Point2D(x,y);
	}

	@Override
	// No area for segment, return 0.
	public double area() {
		return 0;
	}

	@Override
	// Perimeter of segment is a distance. 
	public double perimeter() {
		return (_p1.distance(_p2))*2;
	}

	@Override
	// Change the place of the segment with new point(vec).
	public void move(Point2D vec) {
		_p1.move(vec);
		_p2.move(vec);
	}

	@Override
	// Return copy of segment shape.
	public GeoShape copy() {
		return new Segment2D(this);
	}
	@Override
	// Array of points in the segment shape.
	public Point2D[] getPoints() {
		Point2D[] points = new Point2D[2];
		points[0] = _p1;
		points[1] = _p2;
		return points;
	}
	// Check intersection with to segments.
	public Point2D intersec(Segment2D seg){
		if(this.equals(seg)){	// If the segments are equals return 1 segment.
			return _p1;
		}
		double m1 = (_p1.y() - _p2.y())/(_p1.x() - _p2.x()); 				 // Check for incline in seg1.                     
		double m2 = (seg._p1.y() - seg._p2.y())/(seg._p1.x() - seg._p2.x()); // Check for incline in seg2.		  
		if(m1 == m2){	// If the incline are equals return null.
			return null;
		}
		// Check if the point contains in the segments. if the point contains return the point, if no return null.
		double x = ((m1*_p1.x())-(m2*seg._p1.x())+seg._p1.y()-_p1.y())/(m1-m2);
		double y = (m1*x)-(m1*_p1.x())+_p1.y();
		Point2D p = new Point2D(x,y);
		if(this.contains(p) && seg.contains(p)) {
			return p;
		}
		else{
			return null;
		}
	}

	@Override
	// String of the segment(return the point in string).
	public String toString() {
		return _p1.toString()+","+_p2.toString();
	}

	@Override
	// Check if shape or any object equal(belong) to segment.
	public boolean equals(Object o) {
		if (this == o){
			return true;
		}
		if (o == null || this.getClass() != o.getClass()){
			return false;
		}
		Segment2D seg = (Segment2D) o;
		return _p1.equals(seg._p1) && _p2.equals(seg._p2);
	}
}
