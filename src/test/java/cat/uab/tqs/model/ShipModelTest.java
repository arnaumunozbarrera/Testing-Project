package test.java.cat.uab.tqs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.cat.uab.tqs.model.ShipModel;

class ShipModelTest {

	@Test
	void testGetRowParticionsEquivalentsAndValorsLimitAndFrontera() {
				
		// En aquest test considerem una matriu 4x4, on els valors a provar són:
		// Particions equivalents: -4, -1, 1, 2, 4 i 5
		// Valors límit: 0 i 3
		// Valors frontera: dins dels límits (0 i 3) i fora (-1 i 4)
		  
		ShipModel s1 = new ShipModel(-4, -4); 
	    assertEquals(s1.getRow(), -4);
		
	    ShipModel s2 = new ShipModel(-1, -1); 
	    assertEquals(s2.getRow(), -1);
	    
	    ShipModel s3 = new ShipModel(1, 1); 
	    assertEquals(s3.getRow(), 1);
	
	    ShipModel s4 = new ShipModel(2, 2);
	    assertEquals(s4.getRow(), 2);
	    
	    ShipModel s5 = new ShipModel(4, 4); 
	    assertEquals(s5.getRow(), 4);
	    
	    ShipModel s6 = new ShipModel(5, 5); 
	    assertEquals(s6.getRow(), 5);

	    ShipModel s7 = new ShipModel(0, 0); 
	    assertEquals(s7.getRow(), 0);

	    ShipModel s8 = new ShipModel(3, 3); 
	    assertEquals(s8.getRow(), 3);   
	}

	@Test
	void testGetColParticionsEquivalentsAndValorsLimitAndFrontera() {
		
		// En aquest test considerem una matriu 4x4, on els valors a provar són:
		// Particions equivalents: -4, -1, 1, 2, 4 i 5
		// Valors límit: 0 i 3
		// Valors frontera: dins dels límits (0 i 3) i fora (-1 i 4)
		  
		ShipModel s1 = new ShipModel(-4, -4); 
	    assertEquals(s1.getCol(), -4);
		
	    ShipModel s2 = new ShipModel(-1, -1); 
	    assertEquals(s2.getCol(), -1);
	    
	    ShipModel s3 = new ShipModel(1, 1); 
	    assertEquals(s3.getCol(), 1);
	
	    ShipModel s4 = new ShipModel(2, 2);
	    assertEquals(s4.getCol(), 2);
	    
	    ShipModel s5 = new ShipModel(4, 4); 
	    assertEquals(s5.getCol(), 4);
	    
	    ShipModel s6 = new ShipModel(5, 5); 
	    assertEquals(s6.getCol(), 5);

	    ShipModel s7 = new ShipModel(0, 0); 
	    assertEquals(s7.getCol(), 0);

	    ShipModel s8 = new ShipModel(3, 3); 
	    assertEquals(s8.getCol(), 3); 
   
	}
}