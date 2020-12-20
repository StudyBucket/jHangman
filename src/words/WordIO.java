package words;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordIO implements IWordIO {
	
	private static final String BASE_PATH = "./src/resources/";
	private static final String TYPE = ".wrds";
	
	public WordIO(){
		
	}
	
	public List<String> loadWordFile(String fileName) {
		List<String> wordList = new ArrayList<String>();
		try {
			File file = new File(this.getFullPath(fileName));
			file.exists();
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				wordList.add(input.nextLine());
			}
			input.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return wordList;
	}
	
	public void saveWordFile(String fileName, List<String> wordList) {
		try {
			File file = new File(this.getFullPath(fileName));
			if(file.exists()) {
				file.delete();
			}
			FileWriter fileWriter = new FileWriter(this.getFullPath(fileName));
			for(String line : wordList) {
				fileWriter.write(line + "\n");
			}
			fileWriter.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private String getFullPath(String fileName) {
		return BASE_PATH + fileName + TYPE;
	}
	
}
