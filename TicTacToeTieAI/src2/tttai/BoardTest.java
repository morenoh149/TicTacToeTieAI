package tttai;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board b,b1,b2;
	@Before
	public void setUp() throws Exception {
		String[] array = {"0","X","X","X",
				"","","",
				"","",""};
		b = new Board(array);
		String[] array1 = {"0","","","X",
				"","","X",
				"","","X"};
		b1 = new Board(array1);
		String[] array2 = {"0","X","X","X",
				"","","O",
				"","","O"};
		b2 = new Board(array2);
	}
	@Test
	public void testBoard(){
		assertTrue(b.isWon());
		assertTrue(b.testWon("X"));
		assertFalse(b.testWon("O"));
		assertTrue(b1.isOver());
		assertTrue(b1.isWon());
	}
}
