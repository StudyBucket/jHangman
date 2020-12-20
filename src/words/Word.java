package words;

import java.util.List;

public class Word implements IWord {
	
	char[] word;

	public Word(String word) {
		this.word = word.toCharArray();
	}
	
	public String toCoveredString(List<Character> notToCoverChars) {
		String coveredWord = new String();
		for( char c : this.word) {
			if(  notToCoverChars.contains(c) || c == '-' ) {
				coveredWord += c; 
			} else {
				coveredWord += " _ ";
			}
		} 
		return coveredWord;
	}
	
	public String toUncoveredString() {
		return new String(this.word);
	}
	
	public boolean isSolved(List<Character> hitsSoFar) {
		for( Character c : this.word ) {
			if(!hitsSoFar.contains(c)) return false;
		}
		return true;
	}
	
	public boolean contains(char c) {
	    for (char x : this.word) {
	        if (x == c) {
	            return true;
	        }
	    }
	    return false;
	}
	
}
