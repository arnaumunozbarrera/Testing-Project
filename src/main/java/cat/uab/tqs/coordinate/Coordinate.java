package main.java.cat.uab.tqs.coordinate;

public class Coordinate {
		private int x, y;
		
		public Coordinate(int x, int y) {
			assert x > 0;
			assert y > 0;
			
			this.x=x;
			this.y=y;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public boolean equals(Coordinate coord) {
			return this.x == coord.getX() && this.y == coord.getY();
		}
}
