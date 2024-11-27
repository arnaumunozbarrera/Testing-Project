package test.java.cat.uab.tqs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.cat.uab.tqs.model.ShipModel;

class ShipModelTest {

	@Test
	void testGetRow() {
		
		// Primera versió de prova
	    ShipModel s1 = new ShipModel(0, 0); // valor límit inferior
	    assertEquals(s1.getRow(), 0);
	    
	    ShipModel s2 = new ShipModel(7, 7); // valor límit superior
	    assertEquals(s2.getRow(), 7);

	    ShipModel s3 = new ShipModel(4, 4); // valor mitjà
	    assertEquals(s3.getRow(), 4);

	    ShipModel s4 = new ShipModel(3, 5); // partició dins dels límits
	    assertEquals(s4.getRow(), 3);
	    
	    ShipModel s5 = new ShipModel(1, 7); // partició dins dels límits
	    assertEquals(s5.getRow(), 1);

	    
	 // Segona versió de prova
	}

	@Test
	void testGetCol() {
		ShipModel s1 = new ShipModel(0, 0); // valor límit inferior
	    assertEquals(s1.getCol(), 0);
	    
	    ShipModel s2 = new ShipModel(7, 7); // valor límit superior
	    assertEquals(s2.getCol(), 7);

	    ShipModel s3 = new ShipModel(4, 4); // valor mitjà
	    assertEquals(s3.getCol(), 4);

	    ShipModel s4 = new ShipModel(3, 5); // partició dins dels límits
	    assertEquals(s4.getCol(), 3);
	    
	    ShipModel s5 = new ShipModel(1, 7); // partició dins dels límits
	    assertEquals(s5.getCol(), 1);

	    
	 // Segona versió de prova

	}

}
