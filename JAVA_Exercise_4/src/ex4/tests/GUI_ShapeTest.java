package ex4.tests;

	import static org.junit.jupiter.api.Assertions.*;

	import java.awt.Color;
	import org.junit.jupiter.api.Test;
	import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.geometry.Circle2D;
	import ex4.geometry.Point2D;
	public class GUI_ShapeTest {

		GUIShape s1 = new GUIShape();

		@Test
		void GUIShape () {
			Point2D p = new Point2D (1.1,1.1);
			Circle2D c= new Circle2D (p,0.14);
			GUIShape g = new GUIShape ();
			assertFalse(g.toString().equals("GUIShape,255,false,0,Point2D,1.0,1.0"));
			GUIShape g1 = new GUIShape (c,true,Color.blue,1);
			assertTrue(g1.toString().equals("GUIShape,255,true,1,Circle2D,1.1,1.1, 0.14"));
		}

		@Test
		void GUIShape_other () {
			Point2D p = new Point2D (0.2,1.1);
			Circle2D c= new Circle2D (p,5);
			GUIShape g1 = new GUIShape (c,true,Color.blue,1);
			GUI_Shape g = g1.copy();
			assertTrue(g.toString().equals("GUIShape,255,true,1,Circle2D,0.2,1.1, 5.0"));
		}

		@Test
		void getShape() {
			Point2D p = new Point2D (0.2,1.1);
			Circle2D c= new Circle2D (p,5);
			GUIShape g = new GUIShape (c,true,Color.blue,1);
			assertTrue(g.getShape().toString().equals("0.2,1.1, 5.0"));

		}

		@Test
		void setShape() {
			Point2D p1 = new Point2D(0.1,0.2);
			Circle2D c1 = new Circle2D(p1,0.14);
			GUI_Shape s1 = new GUIShape();
			s1.setShape(c1);
			assertFalse(s1.toString().equals("GUIShape,255,true,0,Circle2D,0.1,0.2, 0.14"));
		}

		@Test
		void isFilled() {
			GUI_Shape s1 = new GUIShape();
			s1.isFilled();
			assertTrue(s1.isFilled()==true);
		}

		@Test
		void setFilled() {
			s1.setFilled(true);
			assertFalse(s1.isFilled()==false);
			assertTrue(s1.isFilled()==true);
		}

		@Test
		void getColor() {
			Point2D p = new Point2D (1.1,1.1);
			GUIShape g = new GUIShape (p,true,Color.blue,1);
			assertTrue(g.toString().equals("GUIShape,255,true,1,Point2D,1.1,1.1"));
		}

		@Test
		void setColor() {
			s1.setColor(Color.GREEN);
			assertFalse(s1.toString().equals("GUIShape,65280,false,0,Point2D,0.0,0.0"));

		}

		@Test
		void getTag() {
			assertFalse (s1.getTag()==1);
		}

		@Test
		void setTag() {
			int tag=0;
			s1.setTag(++tag);
			assertTrue(s1.getTag()==1);

		}

		@Test
		void copy() {
			GUI_Shape g = s1.copy();
			assertFalse(g.toString().equals("GUIShape,255,true,0,Point2D,0.0,0.0"));

	}
}
