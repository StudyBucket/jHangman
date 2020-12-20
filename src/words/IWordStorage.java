package words;

public interface IWordStorage {
	
	public void addWord(String word);
	
	public String getRandomWord();
	
	public void loadWords(String fileName);
	
	public void discardChanges();
		
	public void saveChanges();
	
	public void unloadWords();
	
	public int count();
	
}
