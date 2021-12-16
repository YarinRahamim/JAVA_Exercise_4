package ex4.tests;

import ex4.geometry.Point2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Triangle2DTest {

	Triangle2D t;
	Triangle2D dt;


	@BeforeEach
	void createParallelAxisTriangle(){
		Point2D p1 = new Point2D(1,1);
		Point2D p2 = new Point2D(6,1);
		Point2D p3 = new Point2D(4,4);
		t = new Triangle2D(p1,p2,p3);
	}

	void createDegenerateTriangle(){
		Point2D p1 = new Point2D(1,1);
		Point2D p2 = new Point2D(3,1);
		Point2D p3 = new Point2D(5,1);
		dt = new Triangle2D(p1,p2,p3);
	}

	@Test
	void contains() { 
		//***1***
		Point2D p1 = new Point2D(0,0);
		Point2D p2 = new Point2D(9,0);
		Point2D p3 = new Point2D(0,6);
		Triangle2D t1 = new Triangle2D(p1,p2,p3);
		Point2D ans1 = new Point2D(0,0);
		assertTrue(t1.contains(ans1));
		Point2D ans2 = new Point2D(1,5);
		assertTrue(t1.contains(ans2));
		
		///***2***
		createDegenerateTriangle();
		Point2D ans3 = new Point2D(4,1);
		assertTrue(dt.contains(ans3));
		Point2D ans4 = new Point2D(0,0);
		assertFalse(dt.contains(ans4));
		
		//***3***
		Point2D p4 = new Point2D(5,5);
		Point2D p5 = new Point2D(3,0);
		Point2D p6 = new Point2D(7,8);
		Triangle2D t2 = new Triangle2D(p4,p5,p6);
		Point2D ans5 = new Point2D(5,4);
		assertTrue(t2.contains(ans5));
		Point2D ans6 = new Point2D(9,0);
		assertFalse(t2.contains(ans6));
		
		//***4***
		Point2D p7 = new Point2D(10,0);
		Point2D p8 = new Point2D(-5,0);
		Point2D p9 = new Point2D(0,-7);
		Triangle2D t3 = new Triangle2D(p7,p8,p9);
		Point2D ans7 = new Point2D(0,0);
		assertTrue(t3.contains(ans7));
	}

	@Test
	void centerOfMass() {
		//***1***
		Point2D p1 = new Point2D(1,1);
		Point2D p2 = new Point2D(1,1);
		Point2D p3 = new Point2D(1,1);
		Triangle2D t1 = new Triangle2D(p1,p2,p3);
		Point2D ans1 = new Point2D(1,1);
		assertEquals(t1.centerOfMass(), ans1);
		
		//***2***
		createDegenerateTriangle();
		Point2D ans2 = new Point2D(0,0);
		assertNotEquals(dt.centerOfMass(), ans2);
		
		//***3***
		createParallelAxisTriangle();
		Point2D ans3 = new Point2D(1,1);
		assertNotEquals(t.centerOfMass(), ans3);
		
		//***4***
		Point2D p4 = new Point2D(7,0);
		Point2D p5 = new Point2D(-10,0);
		Point2D p6 = new Point2D(0,-3);
		Triangle2D t2 = new Triangle2D(p4,p5,p6);
		Point2D ans4 = new Point2D(0,0);
		assertNotEquals(t2.centerOfMass(), ans4);
		
		//***5***
		Point2D p7 = new Point2D(0,0);
		Point2D p8 = new Point2D(9,0);
		Point2D p9 = new Point2D(0,6);
		Triangle2D t3 = new Triangle2D(p7,p8,p9);
		Point2D ans5 = new Point2D(3,2);
		assertEquals(t3.centerOfMass(), ans5);
		Point2D ans6 = new Point2D(0,0);
		assertNotEquals(t3.centerOfMass(), ans6);
	}

	@Test
	void area() {
		createDegenerateTriangle();
		//***1***
		assertEquals(dt.area(),0);
		
		//***2***
		assertEquals(t.area(), 7.5,0.0001);
		
		//***3***
		Point2D p1 = new Point2D(0,0);
		Point2D p2 = new Point2D(9,0);
		Point2D p3 = new Point2D(0,6);
		Triangle2D t1 = new Triangle2D(p1,p2,p3);
		assertEquals(t1.area(),27, 0.0001 );
		
		//***4***
		Point2D p4 = new Point2D(0,0);
		Point2D p5 = new Point2D(0,0);
		Point2D p6 = new Point2D(0,0);
		Triangle2D t2 = new Triangle2D(p4,p5,p6);
		assertEquals(t2.area(),0);
		
		//***5***
		Point2D p7 = new Point2D(0,0);
		Point2D p8 = new Point2D(0,0);
		Point2D p9 = new Point2D(0,0);
		Triangle2D t3 = new Triangle2D(p7,p8,p9);
		assertEquals(t3.area(),0);
	}

	@Test
	void perimeter() {
		//***1***
		createDegenerateTriangle();
		Segment2D s = new Segment2D(new Point2D(1,1), new Point2D(1,5));
		assertEquals(s.perimeter(), dt.perimeter());
		
		//***2***
		assertEquals(t.perimeter(), 12.85,0.01);
		
		//***3***
		Point2D p1 = new Point2D(0,0);
		Point2D p2 = new Point2D(0,0);
		Point2D p3 = new Point2D(0,0);
		Triangle2D t1 = new Triangle2D(p1,p2,p3);
		assertEquals(t1.perimeter(),0);
		assertNotEquals(t1.perimeter(), 15);
		
		//***4***
		Point2D p4 = new Point2D(5,0);
		Point2D p5 = new Point2D(0,-5);
		Point2D p6 = new Point2D(10,0);
		Triangle2D t2 = new Triangle2D(p4,p5,p6);
		assertEquals(t2.perimeter(), 23, 0.26);
	}

	@Test
	void move() {
		//***1***
		Triangle2D t1 = new Triangle2D(new Point2D(2,3), new Point2D(7,3),new Point2D(5,6));
		t.move(new Point2D(1,2));
		assertEquals(t,t1);
		
		//***2***
		Triangle2D t2 = new Triangle2D(new Point2D(5,5), new Point2D(10,5),new Point2D(8,8));
		t1.move(new Point2D(3,2));
		assertEquals(t1,t2);
		
		//***3***
		Triangle2D t3 = new Triangle2D(new Point2D(7,2), new Point2D(12,2),new Point2D(10,5));
		t2.move(new Point2D(2,-3));
		assertEquals(t3,t2);
	}

	@Test
	void copy() {
		Triangle2D copy = (Triangle2D)t.copy();
		assertEquals(copy,t);
		copy.setP1(new Point2D(2,2));
		assertNotEquals(copy,t);
		Triangle2D t2 = new Triangle2D(t.getP2(),t.getP3(),t.getP1());
		assertEquals(t2,t);

	}

	@Test
	void getPoints() {
		//***1***
		Point2D[] points1 = new Point2D[3];
		points1[0] = new Point2D(2,3);
		points1[1] = new Point2D(1,3);
		points1[2] = new Point2D(5,3);
		
		Point2D[] points2 = new Point2D[3];
		points2[0] = new Point2D(2,3);
		points2[1] = new Point2D(1,3);
		points2[2] = new Point2D(5,3);
		assertArrayEquals(points1, points2);
		//***2***
		Point2D[] points3 = new Point2D[3];
		points2[0] = new Point2D(5,3);
		points2[1] = new Point2D(-2,3);
		points2[2] = new Point2D(-7,3);
		
		Point2D[] points4 = new Point2D[3];
		points1[0] = new Point2D(5,3);
		points1[1] = new Point2D(-2,3);
		points1[2] = new Point2D(-7,3);
		assertArrayEquals(points3, points4);
	}

}
