package cps542project.reader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
		tr.read(new File("anna_karenina.txt"));
		String word = tr.next();
		while(word != null){
			System.out.println(word);
			word = tr.next();
		}
	}

}
