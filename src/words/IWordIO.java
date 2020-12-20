package words;

import java.util.List;

public interface IWordIO {
	
	public List<String> loadWordFile(String fileName);
	
	public void saveWordFile(String fileName, List<String> wordList);
}
