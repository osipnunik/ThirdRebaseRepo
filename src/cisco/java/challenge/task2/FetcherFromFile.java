package cisco.java.challenge.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class FetcherFromFile extends Thread {

	private final File file;
	private LinkedList<String> words = new LinkedList<>();

	public FetcherFromFile(String file) {
		super();
		this.file = new File(file);
		start();
	}

	public LinkedList<String> getWords() {
		return words;
	}

	@Override
	public void run() {
		fetchFromFile();
		super.run();
	}

	private void fetchFromFile() {
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (sc.hasNextLine()) {
			String word = sc.nextLine();
			for (String el : word.split(" ")) {
				words.add(el);
			}
		}
		sc.close();
	}

}
