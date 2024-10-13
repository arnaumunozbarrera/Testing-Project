package test.java.cat.uab.tqs.coordinate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.cat.uab.tqs.coordinate.Coordinate;

class CoordinateTest {

	@Test
	void testCoordinate() {
		//Valors positius i enters
		Coordinate coord = new Coordinate(3,5);
		assertEquals(3,coord.getX());
		assertEquals(5,coord.getY());
		
		//Valors negatius i enters
		Coordinate coord1 = new Coordinate(-1,5);
		assertEquals(-1,coord1.getX());
		assertEquals(5,coord1.getY());
		
		
	}

	@Test
	void testEqualsCoordinate() {
		
		Coordinate coord1 = new Coordinate(2,3);
		Coordinate coord2 = new Coordinate(2,3);
		Coordinate coord3 = new Coordinate(3,5);
		
		assertTrue(coord1.equals(coord2));
		assertFalse(coord1.equals(coord3));
	}

}
