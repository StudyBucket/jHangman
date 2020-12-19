import words.WordStorage;

public class JHangman {

	public static void main(String[] args) {
		WordStorage wordStorage = new WordStorage();
		wordStorage.loadWords("tech");
		
		System.out.println(wordStorage.getRandomWord());
		System.out.println(wordStorage.getRandomWord());
		System.out.println(wordStorage.getRandomWord());
	}

}
