package cps542project.reader;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import cps542project.analyzer.TermStats;
import cps542project.store.TableDataStore;
import cps542project.store.TableTextDocument;

public class TextReader {

	private Scanner scanner;

	public TextReader() {
		// TODO Auto-generated constructor stub
	}

	public void read(File source) throws IOException{
		scanner = new Scanner(source);

	}

	public String next(){
		if(scanner.hasNext()){
			return scanner.next();
		}
		scanner.close();
		return null;
	}

	public static void main(String[] args) throws IOException {
		TextReader tr = new TextReader();
		TableDataStore tds = TableDataStore.getInstance();
		tr.read(new File("leipzig1m.txt"));
		String word = tr.next();
		while(word != null){
			tds.store("leipzig1m.txt", word.toLowerCase());
			word = tr.next();
		}
		TableTextDocument dmt = tds.getDocument("leipzig1m.txt");
		List<TermStats> freqs = dmt.getAllFrequencies();
		System.out.println("Title: " + dmt.getTitle());
		System.out.println("Total Words: " + dmt.getWordCount());
		System.out.println("#. \t \t Term \t \t Count \t \t Frequency");
		int z = 1;
		for (TermStats termStats : freqs) {
			System.out.println(z + " \t \t" + termStats);
			z +=1;
		}
	}

}
