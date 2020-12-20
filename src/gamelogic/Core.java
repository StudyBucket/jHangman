package gamelogic;

import java.util.ArrayList;
import java.util.List;

import words.WordStorage;
import words.Word;

public class Core {
	
	private WordStorage wordStorage;
	private Word currentWord;
	private LifeManagement lifeManagement;
	
	private List<Character> missedShots = new ArrayList<Character>();
	private List<Character> hits = new ArrayList<Character>();
	
	private int draws;
	
	private boolean playing = false;
	private boolean displayMissedShots = false;
	private boolean falseInputMeansLostLife = false;
	
	public Core(int difficulty, String file){ 
		this.wordStorage = new WordStorage();
		this.wordStorage.loadWords(file);
		int lifePoints;
		switch(difficulty) {
		  case 2:
			  	lifePoints = 5;
			  	this.falseInputMeansLostLife = true;
			  	break;
		  case 1:
			  	lifePoints = 7;
			  	break;
		  default:
			  	lifePoints = 9;
			  	this.displayMissedShots = true;
			  	break;
		}
		this.lifeManagement = new LifeManagement(lifePoints);
	}
	
	private void setCurrentWord(String word) {
		this.currentWord = new Word(word);
	}
	
	public void startRound() {
		this.draws = 0;
		this.setCurrentWord( this.wordStorage.getRandomWord() );
		this.playing = true;
	}
	
	public void endRound() {
		this.playing = false;
	}
	
	public boolean isPlaying() {
		return this.playing;
	}
	
	private void handleHit(Character c) {
		this.hits.add(c);
		System.out.println("[Game] That's a hit!");
	}
	
	private void handleMissed(Character c) {
		if( c != null) this.missedShots.add(c);
		this.lifeManagement.loseALife();
	}
	
	private void loseGame() {
		this.endRound();
		System.out.println("[Game] The word was '" + this.currentWord.toUncoveredString() + "'. You LOST after " + this.draws + " draws.");
	}
	
	private void winGame() {
		this.endRound();
		System.out.println("[Game] The word was '" + this.currentWord.toUncoveredString() + "'. You WON after " + this.draws + " draws.");
	}
	
	public void shoot(String input) {
		
		if( !input.chars().allMatch(Character::isLetter) ) {
			System.out.println("[Game] Not a valid character.");
			if(this.falseInputMeansLostLife == true) this.handleMissed(null);
		} else {
			Character c = input.toLowerCase().toCharArray()[0];
			if(this.hits.contains(c)|| this.missedShots.contains(c)) {
				System.out.println("[Game] You tried that one already!");
				this.handleMissed(null);
			} else {
				if(this.currentWord.contains(c)) {
					this.handleHit(c);
				} else {
					this.handleMissed(c);
				}
			}
		}
	
		++this.draws;
		this.printGameState();
		if( this.lifeManagement.isStillAlive() != true ) this.loseGame();
		if( this.currentWord.isSolved(this.hits) ) this.winGame();
	}
	
	private void printGameState() {
		System.out.println("[Game] " + this.currentWord.toCoveredString(this.hits));
		
		String message = 	this.lifeManagement.toString() 
							+ " | " + this.draws + " draws";
		if(this.isPlaying()) message += " so far.";
		else message += " in total.";
		System.out.println(message);
		
		if(this.displayMissedShots) {
			message = "Missed: " + this.missedShots.toString();
			System.out.println(message);
		}
	}
}
