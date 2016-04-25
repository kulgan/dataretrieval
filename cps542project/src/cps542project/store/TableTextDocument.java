package cps542project.store;

import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Set;

public class TableTextDocument {

	private String title;
	private BigDecimal wordCount;
	private Hashtable<String, Integer> terms;

	public TableTextDocument() {
		terms = new Hashtable<>();
		wordCount = new BigDecimal("0");
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
		wordCount.add(new BigDecimal("1"));
	}

	public Integer getFrequency(String word){
		return terms.get(word);
	}

	public String getAllFrequencies(){
		String result = "";
		Set<String> keys = terms.keySet();
		for (String key : keys) {
			result += key + ", " + termFrequency(key) + "\n";
		}

		return result;
	}

	public BigDecimal termFrequency(String word){
		Integer freq = getFrequency(word);
		return new BigDecimal(freq + "").divide(wordCount);
	}

	public BigDecimal getWordCount() {
		return wordCount;
	}


}
