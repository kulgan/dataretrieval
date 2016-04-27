package cps542project.store;

import java.util.HashMap;
import java.util.Map;

import cps542project.store.tries.SuffixArray;

public class TableDataStore {

	private static TableDataStore store;
	private Map<String, TableTextDocument> docs;

	private TableDataStore() {
		docs = new HashMap<>();
	}

	public static TableDataStore getInstance(){
		if(store == null){
			synchronized(TableDataStore.class){
				if(store == null){
					store = new TableDataStore();
				}
			}
		}
		return store;
	}

	public TableTextDocument getDocument(String title){
		TableTextDocument doc = docs.get(title);
		if(doc == null){
			doc = new TableTextDocument();
			doc.setTitle(title.toLowerCase());
			docs.put(doc.getTitle(), doc);
		}
		return doc;
	}

	public void store(String doc, String word){
		TableTextDocument td = getDocument(doc);
		td.store(word);
	}

	public Integer getFrequency(String doc, String word){
		TableTextDocument td = getDocument(doc);
		return td.getFrequency(word);
	}
	
	public static void main(String[] args) {
		SuffixArray sa = new SuffixArray("");
	}

}
