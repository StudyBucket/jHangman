package words;

import java.util.List;

public class Word {
	
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
	
}
