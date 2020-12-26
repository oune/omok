package test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import main.Board;

public class BoardTest {
	@Test
	public void add() {
		Board board = new Board();
		
		board.add(0, 0);
		String cmp = 
				"¡Ü++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n";
		assertEquals(cmp, board.toString());
		
		board.add(0, 1);
		cmp = 
				"¡Ü¡Û+++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n";
		
		assertEquals(cmp, board.toString());
		
		board.add(14, 14);
		cmp = 
				"¡Ü¡Û+++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"++++++++++++++¡Ü\n";
		assertEquals(cmp, board.toString());
		
		board.add(0, 14);
		cmp = 
				"¡Ü¡Û++++++++++++¡Û\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"++++++++++++++¡Ü\n";
		assertEquals(cmp, board.toString());
		
		board.add(14, 0);
		cmp = 
				"¡Ü¡Û++++++++++++¡Û\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"¡Ü+++++++++++++¡Ü\n";
		assertEquals(cmp, board.toString());
		
		board.add(14, 1);
		cmp = 
				"¡Ü¡Û++++++++++++¡Û\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"¡Ü¡Û++++++++++++¡Ü\n";
		assertEquals(cmp, board.toString());
		
		board.add(14, 2);
		cmp = 
				"¡Ü¡Û++++++++++++¡Û\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"+++++++++++++++\n" + 
				"¡Ü¡Û¡Ü+++++++++++¡Ü\n";
		assertEquals(cmp, board.toString());
	}
	@Test(expected=RuntimeException.class)
	public void addException1() {
		Board board = new Board();
		board.add(-1, -1);
	}
	@Test(expected=RuntimeException.class)
	public void addException2() {
		Board board = new Board();
		board.add(0, 30);
	}
	@Test(expected=RuntimeException.class)
	public void addException3() {
		Board board = new Board();
		board.add(0, 200);
	}
	@Test
	public void count() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Board board = new Board();
		Method method = board.getClass().getDeclaredMethod("count", int.class, int.class);
		method.setAccessible(true);
		
		int ret;
		
		board.add(0, 0);
		ret = (int) method.invoke(board, 0, 0);
		assertEquals(0, ret);
		
		board.add(0, 1);
		ret = (int) method.invoke(board, 0, 1);
		assertEquals(0, ret);
		
		board.add(2, 0);
		ret = (int) method.invoke(board, 2, 0);
		assertEquals(0, ret);
		
		board.add(1, 1);
		ret = (int) method.invoke(board, 1, 1);
		assertEquals(1, ret);
		
		board.add(4, 0);
		ret = (int) method.invoke(board, 4, 0);
		assertEquals(0, ret);
		
		board.add(2, 1);
		ret = (int) method.invoke(board, 2, 1);
		assertEquals(2, ret);
		
		board.add(6, 0);
		ret = (int) method.invoke(board, 6, 0);
		assertEquals(0, ret);
		
		board.add(3, 1);
		ret = (int) method.invoke(board, 3, 1);
		assertEquals(3, ret);
		
		board.add(4, 2);
		ret = (int) method.invoke(board, 4, 2);
		assertEquals(0, ret);
		
		board.add(4, 1);
		ret = (int) method.invoke(board, 4, 1);
		assertEquals(4, ret);
		
		board.add(6, 2);
		ret = (int) method.invoke(board, 6, 2);
		assertEquals(0, ret);
		
		board.add(5, 1);
		ret = (int) method.invoke(board, 5, 1);
		assertEquals(5, ret);
		
		ret = (int) method.invoke(board, 3, 0);
		assertEquals(0, ret);
	}
}
