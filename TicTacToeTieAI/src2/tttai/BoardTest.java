package tttai;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board b;
	@Before
	public void setUp() throws Exception {
		String[] array = {"0","X","X","X",
				"","","",
				"","",""};
		b = new Board(array);
		String[] array1 = {"0","","","X",
				"","","X",
				"","","X"};
		//b1 = new Board(array);
	}
	@Test
	public void testBoard(){
		assertTrue(b.isWon());
		assertTrue(b.testWon("X"));
		assertFalse(b.testWon("O"));
	}
}
