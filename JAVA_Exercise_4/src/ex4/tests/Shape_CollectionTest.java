package ex4.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;


import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.GUI_Shape_Collection;
import ex4.Shape_Collection;
import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;

class Shape_CollectionTest {
	ArrayList<GUI_Shape> collection = new ArrayList<GUI_Shape>(3);
	//*Points:
	Point2D p1 = new Point2D (0,0);
	Point2D p2 = new Point2D (7,7);
	Point2D p3 = new Point2D (15,15);
	Point2D p4 = new Point2D (3,3);
	//*Segment:
	Segment2D seg  = new Segment2D (p1,p2);
	//*Triangle:
	Triangle2D t = new Triangle2D (p1,p2,p3);
	//*Circle:
	Circle2D cr = new Circle2D (p1,15);
	//*Rectangles:
	Rect2D r = new Rect2D(p3,p4);
	Rect2D r1 = new Rect2D(p1,p2);
	//*GUI Shapes:
	GUIShape g1 = new GUIShape (p1,true,Color.red,1);
	GUI_Shape g2 = new GUIShape(cr,true,Color.red,1);
	GUI_Shape g3 = new GUIShape(seg,false,Color.blue,0);


	@Test
	void testget() {
		collection.add(g1);
		collection.add(g2);
		collection.add(g3);
		//***1***
		assertTrue(collection.get(0).equals(g1));
		//***2***
		assertTrue(collection.get(1).equals(g2));
		//***3***
		assertTrue(collection.get(2).equals(g3));
		//***4***
		assertFalse(collection.get(0).equals(g3));


	}

	@Test
	void testsize() {
		collection.add(g1);
		collection.add(g2);
		collection.add(g3);
		//***1***
		assertTrue(collection.size()==3);
		//***2***
		assertFalse(collection.size()==5);
	}


	@Test
	void testremove() {
		collection.add(g1);
		collection.add(g2);
		collection.add(g3);
		//***1***
		collection.remove(0);
		assertTrue(collection.size()==2);
		assertFalse(collection.size()==3);
		//***2***
		collection.remove(1);
		assertTrue(collection.size()==1);
		assertFalse(collection.size()==3);
	}

	@Test
	void testremoveElementAt() {
		collection.add(g1);
		collection.add(g2);
		collection.add(g3);
		collection.removeAll(collection);
		//***1***
		assertTrue(collection.size()==0);
		//***2***
		assertFalse(collection.size()==3);
	}

	@Test
	void testaddAt() {
		collection.add(g1);
		collection.add(g2);
		collection.add(g3);
		GUIShape g4 = new GUIShape (r,false,Color.red,1);
		collection.add(3, g4);
		//***1***
		assertTrue(collection.get(3).equals(g4));
		//***2***
		assertFalse(collection.get(2).equals(g4));
	}

	@Test
	void testadd() {
		collection.add(g1);
		collection.add(g2);
		collection.add(g3);
		GUIShape g4 = new GUIShape (r,false,Color.red,1);
		collection.add(g4);
		//***1***
		assertTrue(collection.size()==4);
		//***2***
		assertFalse(collection.size()==3);
	}

	@Test
	void testcopy() {
		collection.add(g1);
		collection.add(g2);
		collection.add(g3);
		collection.get(0).copy();
		//***1***
		assertFalse(collection.get(2).copy()==g1);
		//***2***
		assertTrue(collection.get(1).equals(g2));
	}

	@Test
	void testremoveAll() {
		collection.add(g1);
		collection.add(g2);
		collection.add(g3);
		collection.remove(0);
		//***1***
		assertFalse(g1==collection.get(0));
		//***2***
		assertFalse(g2==collection.get(1));
	}

	@Test
	void testsave() {
		GUI_Shape_Collection s = new Shape_Collection();
		int tag = 0;
		//All GUI Shapes from Ex4Test class. 
		GUI_Shape s1 = new GUIShape(p1,false, Color.blue, tag++);
		GUI_Shape s2 = new GUIShape(cr,true, Color.red, tag++);
		GUI_Shape s3 = new GUIShape(r,true, Color.green, tag++);
		GUI_Shape s4 = new GUIShape(r1,false, Color.cyan, tag++);
		GUI_Shape s5 = new GUIShape(t,false, Color.orange, tag++);
		GUI_Shape s6 = new GUIShape(seg,false, Color.pink, tag++);
		s.add(s1);
		s.add(s2);
		s.add(s3);
		s.add(s4);
		s.add(s5);
		s.add(s6);
		GUI_Shape_Collection sN1 = new Shape_Collection();
		s.save("ShapeCollectionTestSave.txt");
		sN1.load("ShapeCollectionTestSave.txt");
		assertEquals(s.toString(), sN1.toString());
	}

	@Test
	void testload() {
		GUI_Shape_Collection s = new Shape_Collection();
		int tag = 0;
		//All GUI Shapes from Ex4Test class. 
		GUI_Shape s1 = new GUIShape(p1,false, Color.blue, tag++);
		GUI_Shape s2 = new GUIShape(cr,true, Color.red, tag++);
		GUI_Shape s3 = new GUIShape(r,true, Color.green, tag++);
		GUI_Shape s4 = new GUIShape(r1,false, Color.cyan, tag++);
		GUI_Shape s5 = new GUIShape(t,false, Color.orange, tag++);
		GUI_Shape s6 = new GUIShape(seg,false, Color.pink, tag++);
		s.add(s1);
		s.add(s2);
		s.add(s3);
		s.add(s4);
		s.add(s5);
		s.add(s6);
		s.save("ShapeCollectionTestSave2.txt");
		Shape_Collection sN1 = new Shape_Collection();
		sN1.load("ShapeCollectionTestSave2.txt");
		assertEquals(((Shape_Collection)s).toString(), sN1.toString());
	}

	@Test
	void testgetBoundingBox() { 
		double maxX = 15;	
		double maxY = 15;
		double minX = 3;
		double minY = 3;
		Point2D pMax = new Point2D (maxX, maxY);
		Point2D pMin = new Point2D (minX, minY);
		Rect2D bBox = new Rect2D(pMax, pMin);
		assertEquals(bBox, r);
	}

	@Test
	void testtoString() {
		collection.add(g1);
		collection.add(g2);
		collection.add(g3);
		assertNotEquals(collection.get(0).toString(),collection.toString());
	}
}
