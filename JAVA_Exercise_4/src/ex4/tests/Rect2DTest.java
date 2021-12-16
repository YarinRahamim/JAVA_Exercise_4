package ex4.tests;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

public class Rect2DTest {


	@Test
	void contains() { 
		//***1***
		Point2D p1 = new Point2D(0,0);
		Point2D p2 = new Point2D(9,0);
		Rect2D r1 = new Rect2D(p1,p2);
		Point2D ans1 = new Point2D(0,-1); 
		assertFalse(r1.contains(ans1));

		//**2***
		Point2D ans2 = new Point2D(1,0);
		assertTrue(r1.contains(ans2));

		//***3***
		Point2D p3 = new Point2D(0,0);
		Point2D p4 = new Point2D(0,0);
		Rect2D r2 = new Rect2D(p3,p4);
		Point2D ans3 = new Point2D(0,0);
		assertTrue(r2.contains(ans3));
	}

	@Test
	void centerOfMass() {
		//***1***
		Point2D p1 = new Point2D(3,6);
		Point2D p2 = new Point2D(9,0);
		Rect2D r1 = new Rect2D(p1,p2);
		Point2D ans1 = new Point2D(6,3);
		assertEquals(r1.centerOfMass(), ans1);

		//***2***
		Point2D ans2 = new Point2D(0,0);
		assertNotEquals(r1.centerOfMass(),ans2);

		//***3***
		Point2D p3 = new Point2D(0,0);
		Point2D p4 = new Point2D(9,0);
		Rect2D r2 = new Rect2D(p3,p4);
		Point2D ans3 = new Point2D(4.5,0);
		assertEquals(r2.centerOfMass(),ans3);	
	}

	@Test
	void area() {
		//***1***
		Point2D p1 = new Point2D(0,0);
		Point2D p2 = new Point2D(9,0);
		Rect2D r1 = new Rect2D(p1,p2);
		assertEquals(r1.area(),0);	
		assertNotEquals(r1.area(), 10);

		//***2***
		Point2D p3 = new Point2D(-5,-10);
		Point2D p4 = new Point2D(10,5);
		Rect2D r2 = new Rect2D(p3,p4);
		assertEquals(r2.area(),225);

		//***3***
		Point2D p5 = new Point2D(1,1);
		Point2D p6 = new Point2D(2,2);
		Rect2D r3 = new Rect2D(p5,p6);
		assertEquals(r3.area(), 1);
	}

	@Test
	void perimeter() {
		//***1***
		Point2D p1 = new Point2D(0,0); //segment*2
		Point2D p2 = new Point2D(9,0);
		Rect2D r1 = new Rect2D(p1,p2);
		assertEquals(r1.perimeter(),18);

		//***2***
		Point2D p3 = new Point2D(-5,-1);
		Point2D p4 = new Point2D(-10,-1);
		Rect2D r2 = new Rect2D(p3,p4);
		assertEquals(r2.perimeter(),10);

		//***3***
		Point2D p5 = new Point2D(1,1);
		Point2D p6 = new Point2D(1,1);
		Rect2D r3 = new Rect2D(p5,p6);
		assertEquals(r3.perimeter(),0);
	}

	@Test
	void move() {
		//***1***
		Point2D p1 = new Point2D(-5,-10);
		Point2D p2 = new Point2D(10,5);
		Rect2D r1 = new Rect2D(p1,p2);
		Point2D p3 = new Point2D(0,0);
		Point2D p4 = new Point2D(15,15);
		Rect2D r2 = new Rect2D(p3,p4);
		r1.move(new Point2D(5,10));
		assertEquals(r1,r2);

		//***2***
		Point2D p5 = new Point2D(0,0);
		Point2D p6 = new Point2D(0,0);
		Rect2D r3 = new Rect2D(p5,p6);
		Point2D p7 = new Point2D(0,0);
		Point2D p8 = new Point2D(0,0);
		Rect2D r4 = new Rect2D(p7,p8);
		r3.move(new Point2D(1,1));
		assertNotEquals(r3,r4);

		//***3***
		Point2D p9 = new Point2D(100,200);
		Point2D p10 = new Point2D(300,400);
		Rect2D r5 = new Rect2D(p9,p10);
		Point2D p11 = new Point2D(0,0);
		Point2D p12 = new Point2D(200,200);
		Rect2D r6 = new Rect2D(p11,p12);
		r6.move(new Point2D(100,200));
		assertEquals(r5,r6);
	}

	@Test
	void copy() {
		//***1***
		Point2D p1 = new Point2D(-5,-10);
		Point2D p2 = new Point2D(10,5);
		Rect2D r1 = new Rect2D(p1,p2);
		Rect2D copy = (Rect2D)r1.copy();
		assertEquals(copy, r1);
		copy.setHigh(new Point2D (2,2)); 
		assertNotEquals(copy, r1);

		//***2***
		Rect2D r2 = new Rect2D(r1.getHigh(),r1.getLow());
		assertEquals(r1, r2);
	}

	@Test
	void getPoints() {
		//***1***
		Point2D p1 = new Point2D(-5,-10);
		Point2D p2 = new Point2D(10,5);
		Rect2D r1 = new Rect2D(p1,p2);
		Point2D[] points1 = new Point2D[2];
		points1[0] = new Point2D(10,5);
		points1[1] = new Point2D(-5,-10);
		assertArrayEquals(points1,r1.getPoints());

		//***2***
		Point2D p3 = new Point2D(1,3);
		Point2D p4 = new Point2D(2,3);
		Rect2D r2 = new Rect2D(p3,p4);
		Point2D[] points2 = new Point2D[2];
		points2[0] = new Point2D(1,3);
		points2[1] = new Point2D(2,3);
		assertArrayEquals(points2, r2.getPoints());
	}
}
