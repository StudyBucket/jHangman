package gamelogic;

import java.util.ArrayList;
import java.util.List;

import words.WordStorage;
import words.Word;

public class Core {
	
	private WordStorage wordStorage;
	private LifeManagement lifeManagement;
	private String currentWord;
	private boolean playing = false;
	private boolean displayMissedShots = false;
	private List<Character> missedShots = new ArrayList<Character>();
	private List<Character> hits = new ArrayList<Character>();
	
	public Core(int difficulty, String file){ 
		this.wordStorage = new WordStorage();
		this.wordStorage.loadWords(file);
		int lifePoints;
		switch(difficulty) {
		  case 2:
			  	lifePoints = 3;
			  	break;
		  case 1:
			  	lifePoints = 5;
			  	break;
		  default:
			  	lifePoints = 5;
			  	this.displayMissedShots = true;
			  	break;
		}
		this.lifeManagement = new LifeManagement(lifePoints);
	}
	
	private void setCurrentWord(String word) {
		this.currentWord = word;
		System.out.println(this.getCurrentWordCovered());
	}
	
	private String getCurrentWordUncoveredLowerCase() {
		return this.currentWord.toLowerCase();
	}
	
	private String getCurrentWordCovered() {
		Word cW = new Word(this.currentWord);
		// String coveredWord = this.currentWord.replaceAll("[a-zA-Z]", "_");
		return cW.toCoveredString(this.hits);
	}
	
	public void startRound() {
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
		System.out.println("HIT!");
	}
	
	private void handleMissed(Character c) {
		this.missedShots.add(c);
		this.lifeManagement.loseALife();
		System.out.println(	"MISSED! YOU LOST A LIFE: " 
							+ this.lifeManagement.getCurrentLifePoints() + "/" 
							+ this.lifeManagement.getMaxLifePoints()	);
		if( this.lifeManagement.isStillAlive() != true ) this.loseGame();
	}
	
	private void loseGame() {
		this.endRound();
		System.out.println("YOU LOST!");
	}
	
	public void shoot(String input) {
		System.out.print("\n\n");;
		if( !input.chars().allMatch(Character::isLetter) ) {
			System.out.println("NOT A VALID INPUT!");
		} else {
			Character c = input.toLowerCase().toCharArray()[0];
			if(this.getCurrentWordUncoveredLowerCase().contains(c.toString())) {
				if(this.hits.contains(c)) {
					System.out.println("DOUBLE CHECKED!");
					this.handleMissed(c);
				}
				this.handleHit(c);
			} else {
				this.handleMissed(c);
			}
		}
		System.out.println(this.getCurrentWordCovered() + " | " + this.lifeManagement.toString());
	}
}
