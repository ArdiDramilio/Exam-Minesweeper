package player;

import java.util.UUID;
import java.util.Vector;

public class Player {
	private UUID id;
	private String name;
	private int easywin;
	private int easylose;
	private int hardwin;
	private int hardlose;
	private Player() {
	}
	
	public Player(String name) {
		this.id = UUID.randomUUID();
		this.name = name;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setEasyFailed(int easyFailed) {
		this.easylose=easyFailed;
	}
	
	public void setEasySuccess(int easySuccess) {
		this.easywin=easySuccess;
	}
	
	public void setHardFailed(int hardFailed) {
		this.hardlose=hardFailed;
	}
	
	public void setHardSuccess(int hardSuccess) {
		this.hardwin=hardSuccess;
	}
	
	public int getEasyFailed() {
		return this.easylose;
	}
	
	public int getEasySuccess() {
		return this.easywin;
	}
	
	public int getHardFailed() {
		return this.hardlose;
	}
	
	public int getHardSuccess() {
		return this.hardwin;
	}
	
	public String toText() {
		Vector<String> data = new Vector<String>();
		data.add(id.toString());
		data.add(name);
		
		data.add("easy#" + this.getEasyFailed() + "#" +this.getEasySuccess() );
		data.add("hard#" + this.getHardFailed() + "#" + this.getHardSuccess() );
		
		return String.join(",", data);
	}
	
	public static Player fromText(String text) {
		Player p = new Player();
		String[] data = text.split(",");
		
		RuntimeException e = new RuntimeException("failed parse profile from text");
		if(data.length < 2) throw e;
		
		p.id = UUID.fromString(data[0]);
		p.name = data[1];
		
		splitAndValidateText(p, data, e);
		
		return p;
	}

	private static void splitAndValidateText(Player p, String[] data, RuntimeException e) {
		for(int i = 2; i < data.length; i++) {
			String[] data2 = data[i].split("#");
			if(data2.length != 3) throw e;
			
			String type = data2[0];
			
			try {			
				if(type.equalsIgnoreCase("easy")) {
					p.setEasyFailed(Integer.parseInt(data2[1]));
					p.setEasySuccess(Integer.parseInt(data2[2]));
				} else if(type.equalsIgnoreCase("hard")) {
					p.setHardFailed(Integer.parseInt(data2[1]));
					p.setHardSuccess(Integer.parseInt(data2[2]));
				}
			} catch (NumberFormatException e2) {
				throw e;
			}
		}
	}

}
