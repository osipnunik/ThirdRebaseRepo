package cisco.java.challenge.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		FetcherFromFile f = new FetcherFromFile("resources/text.txt");
		f.join();
		List<String> words = f.getWords();
		String[] arr = new String[words.size()];
		arr = words.toArray(arr);					//transforming List to array
		WordsCounter c = new WordsCounter(arr);
		c.join();
		printMap(c);
	}

	private static void printMap(WordsCounter c) {
		for(Map.Entry<String, Integer> pair : c.getMap().entrySet()) {
			System.out.println(pair.getValue() + " " + pair.getKey());
		}
	}
			
}
