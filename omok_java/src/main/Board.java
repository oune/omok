package main;

public class Board {
	public static final int BOARD_SIZE = 19;
	public static final int WIN_CONDITION = 3;

	private int[][] board;
	private int lastStoneNum;

	public Board() {
		super();
		this.board = new int[BOARD_SIZE][BOARD_SIZE];
		this.lastStoneNum = 0;
	}

	public void add(int x, int y) throws RuntimeException {
		if (!isAvailable(x, y))
			throw new RuntimeException();
		if (board[x][y] != 0)
			throw new RuntimeException();

		board[x][y] = ++lastStoneNum;
	}

	private boolean isAvailable(int x, int y) {
		if (0 <= x && x < BOARD_SIZE && 0 <= y && y < BOARD_SIZE)
			return true;

		return false;
	}

	public boolean isWin(int x, int y) {// 라인들 중에서 5개 가 나오면 승리를 리턴
		if (count(x, y) > WIN_CONDITION)
			return true;

		return false;
	}
	private int count(int x, int y) {
		int max = 0;
		int now;
		
		if ((now = countLine(x, y, 1, -1)) > max)
			max = now;
		if ((now = countLine(x, y, 1, 1)) > max)
			max = now;
		if ((now = countLine(x, y, 1, 0)) > max)
			max = now;
		if ((now = countLine(x, y, 0, 1)) > max)
			max = now;
		
		return max;
	}

	private int countLine(int x, int y, int a, int b) {// 해당줄에 존재하는 같은 종류의 돌 개수를 리턴
		int count = 0;

		count += countDirection(x, y, a, b);
		count += countDirection(x, y, -a, -b);

		return count;
	}

	private int countDirection(int x, int y, int a, int b) {
		int type = getType(x, y);

		int count;
		for (count = 0; isAvailable(x += a, y += b) && (getType(x, y) == type); count++);

		return count;
	}
	
	private int getType(int x, int y) {
		int number = board[x][y];
		
		if (number == 0) {
			return 0;
		} else if (number % 2 == 0) {
			return 1;
		} else {
			return 2;
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (board[i][j] == 0) 
					sb.append("+");
				else if (board[i][j] % 2 == 0)
					sb.append("○");
				else
					sb.append("●");
			}
			sb.append('\n');
		}

	return sb.toString();
}}
