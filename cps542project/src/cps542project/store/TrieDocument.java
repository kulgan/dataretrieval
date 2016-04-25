package cps542project.store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class TrieDocument<T> {

	private int radix = 256; //
	private Node root;

	private BigDecimal wordCount;

	private String title;

	public TrieDocument() {
		wordCount = new BigDecimal("0");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public T get(String key){
		Node x = get(root, key, 0);
		if(x == null){
			return null;
		}
		return x.getValue();
	}

	private Node get(Node x, String key, int d){
		if(x == null){
			return null;
		}
		if(d == key.length()){
			return x;
		}
		char c = key.charAt(d);
		return get(x.next[c], key, d+1);
	}

	public void put(String key, T value){
		root = put(root, key, value, 0);
	}

	private TrieDocument<T>.Node put(Node x, String key, T val, int d){
		if(x == null){
			x = new Node();
		}
		if(d == key.length()){
			x.value = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d+1);

		return x;

	}

	class Node{

		private T value;

		@SuppressWarnings("unchecked")
		private Node[] next = new TrieDocument.Node[radix];

		public T getValue() {
			return value;
		}

		public Node[] getNext() {
			return next;
		}

	}

	public static void main(String[] args) throws IOException {
		File file = new File("words.shakespeare.txt");
		BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = null;
		TrieDocument<Integer> trie = new TrieDocument<>();
		int index = 0;
		while((line = bis.readLine()) != null){
			System.out.println(line);
			trie.put(line, index);
			index +=1;
		}

		System.out.println(trie.get("wouldest"));
		System.out.println(trie.get("rowland"));
		bis.close();
	}

	public Integer getFrequency(String word) {
		// TODO Auto-generated method stub
		return null;
	}


}

