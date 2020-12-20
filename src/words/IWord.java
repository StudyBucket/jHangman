package words;

import java.util.List;

public interface IWord {
	
	public String toCoveredString(List<Character> notToCoverChars);
	
	public String toUncoveredString();
	
	public boolean isSolved(List<Character> hitsSoFar);
	
	public boolean contains(char c);
}
