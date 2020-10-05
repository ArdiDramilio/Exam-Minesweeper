package game;

import player.Player;

public class Hard extends Game {
	private Player p;

	public Hard(Player p) {
		super(new Setting(12, 9, 15));
		this.p = p;
	}
	GamePrinter printer =  new GamePrinter();
	@Override
	public void win() {
		p.setHardSuccess(p.getHardSuccess() + 1);
		this.hideMine = false;
		
		printer.clear();
		printer.print(gameSetting, board);
		System.out.println("You win");
		scan.nextLine();
	}

	@Override
	public void lose() {
		p.setHardFailed(p.getHardFailed() + 1);
		this.hideMine = false;
		
		printer.clear();
		printer.print(gameSetting, board);
		System.out.println("You lose");
		scan.nextLine();
	}
}
