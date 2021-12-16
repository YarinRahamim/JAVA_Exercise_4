package ex4.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;

public class Point2DTest {

	@Test
	void add() { 
		//***1***
		Point2D p = new Point2D(3,1);
		Point2D p1 = new Point2D(2,2);
		Point2D a = new Point2D(p.x()+p1.x(),p.y()+p1.y());
		assertEquals(p.add(p1), a);
		assertNotEquals(p1.add(a), p);

		//***2***
		Point2D p2 = new Point2D(-5,-5);
		Point2D p3 = new Point2D(5,5);
		Point2D a1 = new Point2D(0,0);
		assertEquals(p2.add(p3), a1);
		assertNotEquals(a1.add(a), p2);
	}

	@Test
	void distance() {
		//***1***
		Point2D p = new Point2D(3,1);
		Point2D p1 = new Point2D(2,2);
		double a = 1.414;
		assertEquals(p.distance(p1), a , 0.0003);

		//***2***
		Point2D p2 = new Point2D(-3,0);
		Point2D p3 = new Point2D(-2,0);
		double a2 = 1;
		assertEquals(p2.distance(p3), a2);
		assertNotEquals(p.distance(p3), a);

		//***3***
		Point2D p4 = new Point2D(0,0);
		Point2D p5 = new Point2D(0,0);
		double a3 = 0;
		assertEquals(p4.distance(p5), a3);
		assertNotEquals(p.distance(p3), a3);
	}

	@Test
	void vector() {
		//***1***
		Point2D p = new Point2D(3,1);
		Point2D p1 = new Point2D(2,2);
		Point2D a = new Point2D(-1,1);
		assertEquals(p.vector(p1), a);

		//***2***
		Point2D p2 = new Point2D(-5,-5);
		Point2D p3 = new Point2D(-3,-4);
		Point2D a1 = new Point2D(2,1);
		assertEquals(p2.vector(p3), a1);
		assertNotEquals(p.vector(p3), a);

		//***3***
		Point2D p4 = new Point2D(0,0);
		Point2D p5 = new Point2D(0,0);
		Point2D a2 = new Point2D(0,0);
		assertEquals(p4.vector(p5), a2);
	}

	@Test
	void contains() {
		//***1***
		Point2D p = new Point2D(0,0);
		Point2D p1 = new Point2D(0,0);
		assertTrue(p.contains(p1));

		//***2***
		Point2D p2 = new Point2D(-1,10);
		Point2D p3 = new Point2D(-1,10);
		assertTrue(p2.contains(p3));

		//***3***
		Point2D p4 = new Point2D(55,100);
		Point2D p5 = new Point2D(55,100);
		assertTrue(p4.contains(p5));
		assertFalse(p2.contains(p4));

		//***4***
		Point2D p6 = new Point2D(10,-5);
		Point2D p7 = new Point2D(-5,10);
		assertFalse(p6.contains(p7));
	}

	@Test
	void move() { 
		Point2D p = new Point2D(0,0);
		Point2D vec = new Point2D(3,3);
		p.move(vec);
		Point2D ans = new Point2D(3,3);
		assertTrue(vec.equals(ans));
	}



	@Test
	void getPoints() {

		Point2D[] points1 = new Point2D[3];
		points1[0] = new Point2D(2,3);
		points1[1] = new Point2D(1,3);
		points1[2] = new Point2D(5,3);

		Point2D[] points2 = new Point2D[3];
		points2[0] = new Point2D(2,3);
		points2[1] = new Point2D(1,3);
		points2[2] = new Point2D(5,3);
		assertArrayEquals(points1, points2);

	}

}


