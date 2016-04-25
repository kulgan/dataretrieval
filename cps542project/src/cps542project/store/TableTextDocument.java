package cps542project.store;

import java.util.Hashtable;

public class TableTextDocument {

	private String title;
	private Hashtable<String, Integer> terms;

	public TableTextDocument() {
		terms = new Hashtable<>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void store(String word){
		Integer i = getFrequency(word);
		if(i == null)
			i = 1;
		else
			i +=1;
		terms.put(word, i);
	}

	public Integer getFrequency(String word){
		return terms.get(word);
	}


}
