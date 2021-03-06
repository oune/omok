package main;

import java.util.Scanner;

public class Game {
	private Player winner;
	private Player player1;
	private Player player2;
	private Player nowPlayer;
	private Board board;
	
	public Game(Player player1, Player player2) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		
		this.board = new Board();
		this.winner = null;
		
		this.player1.addGame(this);
		this.player2.addGame(this);
		
		nowPlayer = player2;
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		int x, y;
		
		for (int turn = 0; turn < Board.BOARD_SIZE * Board.BOARD_SIZE; turn++) {
			System.out.print(board.toString());
			System.out.println(nowPlayer.getName() + "`s turn input x, y : ");
			
			x = sc.nextInt();
			y = sc.nextInt();

			board.add(x, y);
			System.out.println(board.toString());
			
			if (board.isWin(x, y)) {
				System.out.println("game over");
				break;
			}
			changePlayer();
		}
	}
	
	private void changePlayer() {
		nowPlayer = (nowPlayer == player1)? player2 : player1;
	}
	public Player getNowPlayer() {
		return nowPlayer;
	}
	
	public void play(int x, int y) {
		try {
			changePlayer();
			board.add(x, y);
		} catch (RuntimeException e) {
			
		}
	}
	
	public String toString() {
		return board.toString();
	}
	
	public boolean isWin(int x, int y) {
		if (board.isWin(x, y)) {
			return true;
		}
		return false;
	}
}
