package cps542project.store;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import cps542project.analyzer.TermStats;

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
		wordCount = wordCount.add(new BigDecimal("1"));
	}

	public Integer getFrequency(String word){
		return terms.get(word);
	}

	public List<TermStats> getAllFrequencies(){
		List<TermStats> stats = new ArrayList<>();
		Set<String> keys = terms.keySet();
		for (String key : keys) {
			TermStats ts = new TermStats();
			ts.setTerm(key);
			ts.setCount(getFrequency(key));
			ts.setTermFreq(termFrequency(key));
			stats.add(ts);
		}
		Collections.sort(stats);
		return stats;
	}

	public BigDecimal termFrequency(String word){
		Integer freq = getFrequency(word);
		return new BigDecimal(String.valueOf(freq), MathContext.DECIMAL32).divide(wordCount, MathContext.DECIMAL32);
	}

	public BigDecimal getWordCount() {
		return wordCount;
	}


}
