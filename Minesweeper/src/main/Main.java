package main;

import java.io.IOException;
import java.util.Scanner;

import game.*;
import player.Player;
import player.PlayerRepo;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main(new PlayerRepo());
	}
	
	public Main(PlayerRepo playerRepo) {
		Player p = playerRepo.loadOrNewPrompt();
		startGame(p, playerRepo);
	}

	private Scanner scan = new Scanner(System.in);
	private void startGame(Player p, PlayerRepo playerRepo) {		

		GamePrinter printer =  new GamePrinter();
		printer.clear();
		printer.printHeaderGame(p);
		
		Game game = null;
		game = choosingLevel(p, game);
		if(game==null)return;
		
		printer.howToPlay();
		scan.nextLine();
		
		game.play();
		try {
			playerRepo.save();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		startGame(p, playerRepo);
	}

	private Game choosingLevel(Player p, Game game) {
		do {
			System.out.print("level [1-2]: ");
			String input = scan.nextLine();
			if(input.equalsIgnoreCase("exit")) {
				return null;
			}

			try {
				int level = Integer.parseInt(input);
				if(level == 1) {
					game = new Easy(p);
					break;
				}
				if(level == 2) {
					game = new Hard(p);
					break;
				}
			} catch (Exception e) {
				continue;
			}
		}while(true);
		return game;
	}
}
