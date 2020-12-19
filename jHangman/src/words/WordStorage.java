package words;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WordStorage {
	
	boolean verboseMode;
	String currentFileName = null;
	List<String> wordList = new ArrayList<String>();
	WordIO io = new WordIO();
	
	public WordStorage(boolean verboseMode){
		this.verboseMode = verboseMode;
	}
	
	public WordStorage(){
		this.verboseMode = false;
	}
	
	public void addWord(String word) {
		int tempSize = this.wordList.size();
		this.wordList.add(word);
		this.verboseMessage("[WordStorage] '" + word + "' added to current word list. List consists of " + this.wordList.size() + " words. (previously " + tempSize + " words)");
	}
	
	public String getRandomWord() {
		if(this.currentFileName != null) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, this.wordList.size());
			return this.wordList.get(randomNum);
		}
		return null;
	}
	
	public void loadWords(String fileName) {
		this.verboseMessage("[WordStorage] Loading words from '" + fileName + "' ...");
		this.currentFileName = fileName;
		this.wordList = io.loadWordFile(fileName);
		this.verboseMessage("[WordStorage] " + this.wordList.size() + " word loaded.");
	}
	
	public void discardChanges() {
		this.loadWords(currentFileName);
		this.verboseMessage("[WordStorage] Discarded changes to current word list.");
	}
		
	public void saveChanges() {
		this.io.saveWordFile(this.currentFileName, this.wordList);
		this.verboseMessage("[WordStorage] Changes to current word list saved.");
	}
	
	public void unloadWords() {
		this.currentFileName = null;
		this.wordList = new ArrayList<String>();
		this.verboseMessage("[WordStorage] Current word list unloaded.");
	}
	
	public int count() {
		return this.wordList.size();
	}
	
	private void verboseMessage(String message) {
		if(this.verboseMode) System.out.println(message);
	}
}
