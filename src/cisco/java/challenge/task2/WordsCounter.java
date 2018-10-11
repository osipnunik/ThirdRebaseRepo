package cisco.java.challenge.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsCounter extends Thread {
	
	private final String[] arrOriginal;
	private Map<String, Integer> map;
	
	public WordsCounter(String[] arr) {
		this.arrOriginal = arr;
		start();
	}
		
	@Override
	public void run() {
		map = resultMap();	
	}
	
	public Map<String, Integer> getMap() {
		return map;
	}

	private Integer[] getFrequenes(){
		int size = arrOriginal.length;
		Integer[] freq = 
				new Integer[size];
		for (int i = 0; i < size; i++) {
			String el = arrOriginal[i];
			int k = 0;
			for (int j = 0; j < size; j++) {
				if(el.equals(arrOriginal[j])) {
					k++;
				}
			}
			freq[i]=k;
		}
		return freq;
	}
	
	public HashMap<String, Integer> resultMap(){
		Integer[] freq = getFrequenes();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < arrOriginal.length; i++) {
			map.put(arrOriginal[i], freq[i]);
		}
		return map;
	}
	
}
