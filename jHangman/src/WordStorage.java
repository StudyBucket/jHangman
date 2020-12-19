import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class WordStorage {
	
	private static final String BASE_PATH = "./src/resources/";
	boolean filesLoaded = false;
	List<String> wordList = new ArrayList<String>();
	
	
	public WordStorage(){
		
	}
	
	public String getRandomWord() {
		int randomNum = ThreadLocalRandom.current().nextInt(0, this.wordList.size());
		return this.wordList.get(randomNum);
	}
	
	public void loadWords(String fileName) {
		this.readWordsFromFileToArray(fileName);
	}
	
	public void resetWords() {
		this.wordList = new ArrayList<String>();
	}
	
	public int count() {
		return this.wordList.size();
	}
	
	private void readWordsFromFileToArray(String fileName) {
		try {
			File file = new File(BASE_PATH + fileName);
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				wordList.add(input.nextLine());
			}
			input.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}	
}
