package ex4.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Segment2D;


public class Segment2DTest {
	// seg 1 
	Segment2D s1;
	// seg 2
	Segment2D s2;
	//	seg 3 
	Segment2D s3;

	public void buildSeg() {

		// seg 1 
		Point2D p1 = new Point2D(0,0);
		Point2D p2 = new Point2D(3,3);
		s1 = new Segment2D(p1,p2);

		// seg 2
		Point2D p3 = new Point2D(5,10);
		Point2D p4 = new Point2D(1,2);
		s2 = new Segment2D(p3,p4);

		//seg 3 
		Point2D p5 = new Point2D(0,0);
		Point2D p6 = new Point2D(0,0);
		s3 = new Segment2D(p5,p6);
	}

	@Test
	void contains() { 
		buildSeg();
		Point2D p = new Point2D(2,2);
		Point2D p1 = new Point2D(1,0);
		Point2D p2 = new Point2D(-1,-1);

		//***1***
		assertTrue(s1.contains(p));
		assertFalse(s1.contains(p2));

		//***2***
		assertFalse(s2.contains(p));
		assertFalse(s2.contains(p1));
		Point2D p3 = new Point2D(2,4);
		assertTrue(s2.contains(p3));

		//***3***
		assertFalse(s3.contains(p));
		assertFalse(s3.contains(p1));
		assertFalse(s3.contains(p2));
	}

	/* @Test- check about area for segment
		void area() {

		}
	 */

	@Test
	void centerOfMass() {
		//***1***
		Point2D p1 = new Point2D(0,0);
		Point2D p2 = new Point2D(3,3);
		double x1 = ( p1.x()+ p2.x())/2;
		double y1 = ( p1.y()+ p2.y())/2;
		Point2D ans1 = new Point2D(x1,y1);
		assertEquals(ans1, new Point2D (1.5,1.5));
		assertNotEquals(ans1, new Point2D (2,3));

		//***2***
		Point2D p3 = new Point2D(5,10);
		Point2D p4 = new Point2D(1,2);
		double x2 = ( p3.x()+ p4.x())/2;
		double y2 = ( p3.y()+ p4.y())/2;
		Point2D ans2 = new Point2D(x2,y2);
		assertEquals(ans2, new Point2D (3,6));
		assertNotEquals(ans2, new Point2D (1.5,1.5));

		//***3***
		Point2D p5 = new Point2D(0,0);
		Point2D p6 = new Point2D(0,0);
		double x3 = ( p5.x()+ p6.x())/2;
		double y3 = ( p5.y()+ p6.y())/2;
		Point2D ans3 = new Point2D(x3,y3);
		assertEquals(ans3, new Point2D (0,0));
		assertNotEquals(ans2, new Point2D (1,1));
	}

	@Test
	void perimeter() {
		//***1***
		Point2D p1 = new Point2D(0,0);
		Point2D p2 = new Point2D(10,0);
		double ans1 = p1.distance(p2)*2;
		assertEquals(ans1, 20);
		assertNotEquals(ans1, 15);

		//***2***
		Point2D p3 = new Point2D(0,0);
		Point2D p4 = new Point2D(0,0);
		double ans2 = p3.distance(p4)*2;
		assertEquals(ans2, 0);
		assertNotEquals(ans2, ans1);

		//***3***
		Point2D p5 = new Point2D(-1,0);
		Point2D p6 = new Point2D(-10,0);
		Point2D p7 = new Point2D(10,0);
		double ans3 = p5.distance(p6)*2;
		double ans4 = p5.distance(p7)*2;
		assertEquals(ans3, 18);
		assertEquals(ans4, 22);
		assertNotEquals(ans3, ans4);

	}

	@Test
	void move() {
		//***1***
		Point2D p1 = new Point2D(5,10);
		Point2D m1 = new Point2D(1,2);
		p1.move(m1);
		Point2D p2 = new Point2D(6,12);
		assertEquals(p1, p2);

		//***2***
		p2.move(m1);
		Point2D p3 = new Point2D(7,14);
		assertEquals(p2, p3);
		assertNotEquals(p3, m1);

		//***3***
		Point2D p4 = new Point2D(4,8);
		p3.move(p4);
		Point2D p5 = new Point2D(11,22);
		assertEquals(p3, p5);
	}

	@Test
	void copy() {	
		Point2D p = new Point2D(0,0);
		Point2D p1 = new Point2D(5,0);
		Segment2D s = new Segment2D(p,p1);
		s.copy();
		String sAns = ("" +s);
		String ans = "0.0,0.0,5.0,0.0"; 
		assertEquals(ans, sAns);
	}

	@Test
	void getPoints() {
		//***1***
		Point2D p = new Point2D(1,3);
		Point2D p1 = new Point2D(2,3);
		Segment2D s  = new Segment2D(p,p1);
		Point2D[] points1 = new Point2D[2];
		points1[0] = new Point2D(1,3);
		points1[1] = new Point2D(2,3);
		assertArrayEquals(s.getPoints(), points1);


		//***2***
		Point2D p3 = new Point2D(0,0);
		Point2D p4 = new Point2D(0,0);
		Segment2D s2  = new Segment2D(p3,p4);
		Point2D[] points2 = new Point2D[2];
		points2[0] = new Point2D(0,0);
		points2[1] = new Point2D(0,0);
		assertArrayEquals(s2.getPoints(), points2);

	}

}
