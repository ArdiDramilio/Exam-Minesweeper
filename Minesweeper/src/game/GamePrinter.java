package game;

import player.Player;

public class GamePrinter {

	public GamePrinter() {
		// TODO Auto-generated constructor stub
	}
	public void clear() {
		for(int i = 0; i < 26; i++) System.out.println("");
	}
	public void howToPlay() {
		clear();
		System.out.println("Mines will be hidden on the closed squares");
		
		System.out.println("");
		
		System.out.println("If you open square with a mine inside, you lose");
		System.out.println("If you open all squares except mines, you win");
		
		System.out.println("");
		
		System.out.println("Open square using coordinate, example: E4");
		System.out.println("After opening, opened square can have a number. The number represents total mine(s) around the square");
		
		System.out.println("You can use 'switch' to switch to flagging command");
		System.out.println("Flagged square temporarily cannot be opened, until you unflagged it");
		System.out.println("Strategically, use flag when you sure the square is a mine. So you cannot accidentally open it");
		
		System.out.println("");
		
		System.out.println("Symbol Legend: ");
		symbolsLegend();
		
		System.out.println("");
		System.out.println("Press ENTER to start the game");
	}
	
	public void symbolsLegend() {
		System.out.println("'X' = Closed square");
		System.out.println("'M' = Mine");
		System.out.println("'F' = Flag");
		System.out.println("'-' = Open square without mine around");
		System.out.println("number 1 to 8 = Open square with N mine(s) around");
	}
	public void printHeaderGame(Player p) {
		System.out.println("Welcome, " + p.getName());
		System.out.println("Your current record: ");
		System.out.println("Easy: Win: "+ p.getEasySuccess() + " | Lose: " + p.getEasyFailed());
		System.out.println("Hard: Win: "+ p.getHardSuccess() + " | Lose: " + p.getHardFailed());
		System.out.println("");
		
		System.out.println("Choose level: ");
		System.out.println("1. Easy (7 x 5, 5 mines)");
		System.out.println("2. Hard (12 x 9, 15 mines)");		
		System.out.println("");
		
		System.out.println("Type 'exit' to exit from the game");
	}
	protected void print(Setting gameSetting,GameObject[][] board) {
		int h = gameSetting.getHeight();
		int w = gameSetting.getWidth();
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				System.out.print(board[i][j].toChar());
			}
			System.out.println(" " + (i + 1));
		}
		for(int i = 0; i < w; i++) {
			System.out.print((char) ('A' + i));
		}
		
		System.out.println("");
		System.out.println("");
	}
	
}
