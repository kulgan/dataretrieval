package cps542project.store;

import java.util.HashMap;
import java.util.Map;

public class TrieDataStore {

	private static TrieDataStore store;
	private Map<String, TrieDocument<Integer>> docs;

	private TrieDataStore() {
		docs = new HashMap<>();
	}

	public static TrieDataStore getInstance(){
		if(store == null){
			synchronized (TrieDataStore.class) {
				if(store == null){
					store = new TrieDataStore();
				}
			}
		}
		return store;
	}

	public TrieDocument<Integer> getDocument(String title){
		TrieDocument<Integer> doc = docs.get(title);
		if(doc == null){
			doc = new TrieDocument<Integer>();
			doc.setTitle(title.toLowerCase());
			docs.put(doc.getTitle(), doc);
		}
		return doc;
	}

	public void store(String doc, String word, int num){
		TrieDocument<Integer> td = getDocument(doc);
		td.put(word, num);
	}

	public Integer getFrequency(String doc, String word){
		TrieDocument<Integer> td = getDocument(doc);
		return td.getFrequency(word);
	}

}
