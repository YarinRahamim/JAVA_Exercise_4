package ex4.tests;
import ex4.geometry.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Circle2DTest {

	@Test		
	void Circle2D(){
		Point2D p = new Point2D(1,1);
		double rad = -2 ;		
		Circle2D c = new Circle2D(p,rad);
		double rad2 = 1;
		Circle2D ans = new Circle2D(p,rad2);
		assertEquals(c, ans);
	}
		@Test
		void testcontains() {
			//***1***
			Point2D p = new Point2D(0,0);
			double rad =5;
			Circle2D c = new Circle2D(p,rad);
			Point2D ans1 = new Point2D(7,8);
			assertFalse(c.contains(ans1)); 
			
			//***2***
			Point2D ans2 = new Point2D(3,4);
			assertTrue(c.contains(ans2));
			
			//***3***
			Point2D ans3 = new Point2D(0,0);
			assertTrue(c.contains(ans3));
		}

		@Test
		void testsenterOfMass() {
			//***1***
			Point2D p = new Point2D(0,0);
			double rad =5;
			Circle2D c = new Circle2D(p,rad);
			Point2D t1 = new Point2D(-3,-3);
			assertNotEquals(c.centerOfMass(),t1); 
			Point2D t2 = new Point2D(5,4);
			assertNotEquals(c.centerOfMass(),t2);
			Point2D t3 = new Point2D(0,0);
			assertEquals(c.centerOfMass(), t3);
			
			//***2***
			p = new Point2D(7,6);
			rad =2;
			c = new Circle2D(p,rad);
			t1 = new Point2D(3,2);
			assertNotEquals(c.centerOfMass(),t1); 
			t2 = new Point2D(3,-1);
			assertNotEquals(c.centerOfMass(),t2);
			t3 = new Point2D(7,6);
			assertEquals(c.centerOfMass(), t3);

		}

		@Test
		void testarea() {
			//***1***
			Point2D p = new Point2D(0,0);
			double rad =7;
			Circle2D c = new Circle2D(p,rad);
			double ans1 =80;
			double ans2 = Math.PI*49;
			assertNotEquals(c.area(),ans1); 
			assertEquals(c.area(), ans2);
			
			//***2***
			p = new Point2D(-3,5);
			rad =5;
			c = new Circle2D(p,rad);
			ans1 = 10;
			assertNotEquals(c.area(),ans1); 
			ans2 = Math.PI*25;
			assertEquals(c.area(), ans2);
		}

		@Test
		void testperimeter() {
			//***1***
			Point2D p = new Point2D(0,0);
			double rad =7;
			Circle2D c = new Circle2D(p,rad);
			double ans1 = 40;
			double ans2 = Math.PI*14;
			assertNotEquals(c.perimeter(),ans1); 
			assertEquals(c.perimeter(), ans2);
			
			//***2***
			p = new Point2D(4,3);
			rad =3;
			c = new Circle2D(p,rad);
			ans1 = 10;
			assertNotEquals(c.perimeter(),ans1); 
			ans2 = Math.PI*6;
			assertEquals(c.perimeter(), ans2);
		}

		@Test
		void testmove() {
			//***1***
			Point2D p = new Point2D(0,0);
			double rad =6;
			Circle2D c = new Circle2D(p,rad);
			Point2D vec = new Point2D(3,3);
			c.move(vec);
			assertTrue(vec.equals(c.centerOfMass()));
			
			//***2***
			p = new Point2D(-5,4);
			rad =2;
			vec = new Point2D(0,0);
			c = new Circle2D(p,rad);
			c.move(vec);
			vec=new Point2D(-5,4);
			assertTrue(vec.equals(c.centerOfMass()));
		}

		@Test
		void testcopy() {
			//***1***
			Point2D p = new Point2D(0,0);
			double rad =7;
			Circle2D c = new Circle2D(p,rad);
			c.copy();
			String cAns=(""+c);
			String ans= "0.0,0.0, 7.0";
			assertEquals(ans, cAns);
			
			//***2***
			p = new Point2D(4,3);
			rad =2;
			c = new Circle2D(p,rad);
			c.copy();
			cAns=(""+c);
			ans= "4.0,3.0, 2.0";
			assertEquals(c.toString(), ans);
			
		}

		@Test
		void testtoString() {
			//***1***
			Point2D p = new Point2D(10,0);
			double rad =-5;
			Circle2D c = new Circle2D(p,rad);
			String ans ="10.0,0.0, 1.0";
			assertEquals(c.toString(), ans);
			
			//***2***
			p = new Point2D(-6,3);
			rad =3;
			c = new Circle2D(p,rad);
			ans ="-6.0,3.0, 3.0";
			assertEquals(c.toString(), ans);
			
			//***3***
			p = new Point2D(-8,12);
			rad =-5;
			c = new Circle2D(p,rad);
			ans ="-8.0,12.0, 1.0";
			assertEquals(c.toString(), ans);
		}

		@Test
		void testgetPoints() {
			///***1***
			Point2D p = new Point2D(0,0);
			double rad =5;
			Circle2D c = new Circle2D(p,rad);
			Point2D [] arr= new Point2D [2];
			arr[0]=new Point2D(0.0,0.0);
			arr[1]=new Point2D(0.0,5.0);
			assertArrayEquals(arr,c.getPoints());
			
			//***2***
			p = new Point2D(-2,3);
			rad =2;
			c = new Circle2D(p,rad);
			arr= new Point2D [2];
			arr[0]=new Point2D(-2.0,3.0);
			arr[1]=new Point2D(-2.0,5.0);
			assertArrayEquals(arr,c.getPoints());
		}	
	
	}
	

