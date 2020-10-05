package game;

public class GameObject {
	private Type type;
	private Game game;
	private int number;
	boolean flagged;

	public GameObject(Game game, Type type) {
		this.game = game;
		this.type = type;
		this.flagged = false;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
	public Type getType() {
		return type;
	}
	
	public char toChar() {
		if(this.flagged) {
			return 'F';
		}
		
		if(type==Type.mine) {
			return game.hideMine ? 'X' : 'M';
		}
		
		if(type==Type.not_open) {
			return 'X';
		}
		
		if(type==Type.number) {
			if(number == 0) return '-';
			return (char) ('0' + number);
		}
		
		throw new IllegalArgumentException();
	}
}
