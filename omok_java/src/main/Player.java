package main;

import java.util.ArrayList;

public class Player {
	private String id;
	private String password;
	private String name;
	private ArrayList<Game> games;
	private int winCount;
	
	public Player(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.winCount = 0;
		this.games = new ArrayList<Game>();
	}

	public void addGame(Game game) {
		games.add(game);
	}
	
	public String getName() {
		return name;
	}
}
