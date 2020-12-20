package operation;

import java.util.Scanner;
import gamelogic.ICore;
import gamelogic.Core;

public class CLI {
	
	private ICore game;
	private Scanner input = new Scanner(System.in);
	
	boolean running;
	
	public void start() {
		System.out.println("CLI running!");
		this.running = true;
		
		while(this.running) {
		    System.out.println("\n\n Type /s(tart) to play or /e(xit)!");
		    String command = input.nextLine();
		    if( this.isStartCommand(command) ) this.startGame();
		    if( this.isExitCommand(command) ) this.exit();
		}
	}
	
	private void startGame() {
		Integer difficulty = this.selectDifficulty();
		// TODO: embed selection of word file
		
	    this.game = new Core(difficulty, "tech");
    	game.startRound();
    	this.drawingMenu();	
	}
	
	private void drawingMenu() {
		while(this.game.isPlaying()) {
    		System.out.println("\n\n Enter a char [a-z]!");
    		String command = input.nextLine();
    		if( this.isExitCommand(command) ) {
		    	this.exit();
		    	break;
		    } else {
		    	try {
					game.shoot(command);
				} catch (StringIndexOutOfBoundsException e) {
					System.out.println("NOT A VALID INPUT!");
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
		    }
    	}
	}
	
	private int selectDifficulty(){
		String tempInput;
		Integer difficulty = null;
	    while(difficulty == null) {
	    	System.out.println("Select your difficulty be typing 0, 1 or 2!");
		    tempInput = input.nextLine();
		    try {
		    	difficulty = Integer.parseInt(tempInput);
		    	if(difficulty < 0 || difficulty > 2) {
		    		difficulty = null;
		    		throw new Exception("Invalid value.");
		    	}
		    } catch(Exception e) {
    			System.out.println("Not a valid choice!");
		    }
	    }
	    return difficulty;
	}
	
	// TODO: implement selection for word file
	
	private void exit() {
		this.input.close();
		this.running = false;
	}
	
	private boolean isExitCommand(String cmd) {
		if(cmd.equals("/exit") || cmd.equals("/e")) return true;
		return false;
	}
	
	private boolean isStartCommand(String cmd) {
		if(cmd.equals("/start") || cmd.equals("/s")) return true;
		return false;
	}
	
}
