import java.util.Scanner;
import gamelogic.Core;

public class JHangman {

	public static void main(String[] args) {
		System.out.println("*** jHangman ***");

		boolean running = true;
		Scanner input = new Scanner(System.in);	
		
		while(running) {
		    System.out.println("type /s(tart) to play!");
		    if( new String(input.nextLine()).equals("/start") || new String(input.nextLine()).equals("/s") ) {
		    	Core game = new Core(0, "tech");
		    	game.startRound();
		    	while(game.isPlaying()) {
		    		System.out.println("Enter a char [a-z]!");
		    		try {
		    			game.shoot(input.nextLine());
		    		} catch (StringIndexOutOfBoundsException e) {
		    			System.out.println("NOT A VALID INPUT!");
		    		} catch(Exception e) {
		    			System.out.println(e.getMessage());
		    		}
		    	}
		    }
		}
		
	}

}


//WordStorage wordStorage = new WordStorage();
//wordStorage.loadWords("tech");
//
//System.out.println(wordStorage.getRandomWord());
//System.out.println(wordStorage.getRandomWord());
//System.out.println(wordStorage.getRandomWord());