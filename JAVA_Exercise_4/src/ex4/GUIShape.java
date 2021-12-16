package ex4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */
import java.awt.Color;
import ex4.geometry.*;

public class GUIShape implements GUI_Shape{

	private GeoShape g;
	private Color c;
	private int t;
	private boolean b;

	// Setting default variables. 
	public GUIShape(){
		this.g = new Point2D(0,0);
		this.c = Color.WHITE;
		this.t = 0;
		this.b = true;
	}
	// String for Shapes in ex4 geometry. The string contains shape, color, if the shape is filled and tag. 
			public  GUIShape(String s) {
				try {
					String[] a = s.split(",",6);
					Color c = new Color (Integer.parseInt(a[1]));
					boolean b = Boolean.parseBoolean(a[2]);
					int t = (Integer.parseInt(a[3]));
					String  sh= a[4];
					this.c = c;	
					this.t = t;
					this.b = b;
					if (sh.equals ("Point2D")) { // Check if Point2D string equals to "sh" string. 
						Point2D p1 = new Point2D (a[5]);
						this.g = p1;
					}
					
					if (sh.equals ("Circle2D")) { // Check if Circle2D string equals to "sh" string.
						Circle2D p1 = new Circle2D(a[5]);
						this.g = p1;
					}
					if (sh.equals ("Triangle2D")) {	// Check if Triangle2D string equals to "sh" string.
						Triangle2D p1 = new Triangle2D(a[5]);
						this.g = p1;
					}
					if (sh.equals ("Rect2D")) {	// Check if Rect2D string equals to "sh" string.
						Rect2D p1 = new Rect2D(a[5]);
						this.g = p1;
					}
					if (sh.equals ("Segment2D")) { // Check if Segment2D string equals to "sh" string.
						Segment2D p1 = new Segment2D(a[5]);
						this.g = p1;
					}	
				}
				catch(IllegalArgumentException e) { // Print ERR if the string not from GUI SHAPE format.  
					System.err.println("ERR: got wrong format string for GUIShape");
					throw(e);
				}
			}

	// Check if geo is from same "family" with each shapes(Point2D,Segment2D,Circle2D,Triangle2D,Rect2D) and do casting to geo.  		
	public GUIShape(GeoShape geo ,boolean filled, Color color, int tag){
		if(geo instanceof Point2D) {
			this.g = new Point2D((Point2D)geo);
		}
		else if(geo instanceof Segment2D){
			this.g = new Segment2D((Segment2D)geo);
		}
		else if(geo instanceof Circle2D){
			this.g = new Circle2D((Circle2D)geo);
		}
		else if(geo instanceof Triangle2D){
			this.g = new Triangle2D((Triangle2D)geo);
		}
		else if(geo instanceof Rect2D){
			this.g = new Rect2D((Rect2D) geo);
		}
		this.c = color;
		this.t = tag;
		this.b = filled;
	}
	// Create other GUIShape.
	public GUIShape(GUIShape other){
		this(other.g, other.b, other.c, other.t);
	}

	@Override
	// Get to the Shape in GeoShape.  
	public GeoShape getShape() {
		return this.g;
	}

	@Override
	// Set Shape in GeoShape.
	public void setShape(GeoShape g) {
		this.g = g;
	}

	@Override
	// Check if the shape is filled. 
	public boolean isFilled() {
		return this.b;
	}

	@Override
	// Set filed. 
	public void setFilled(boolean filled) {
		this.b = filled;
	}

	@Override
	// Get color.
	public Color getColor() {
		return this.c;
	}

	@Override
	// Set color.
	public void setColor(Color cl) {
		this.c = cl;
	}

	@Override
	// Get tag.
	public int getTag() {
		return this.t;
	}

	@Override
	// Set tag.
	public void setTag(int tag) {
		this.t = tag;
	}

	@Override
	// Create copy of GUI Shape. 
	public GUI_Shape copy() {
		return new GUIShape(this.g,this.b,this.c,this.t);
	}
	@Override
	// Create string of GUI Shape, the string include the shape, the number of color, true/false(if shape filled) and tag.  
	public String toString() {
		return ("GUIShape"+","+(c.getRGB()&0xffffff)+","+ b +","+ t +","+ g.getClass().getSimpleName()+","+ g.toString());
	}
	}

