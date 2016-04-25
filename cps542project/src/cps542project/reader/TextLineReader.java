package cps542project.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TextLineReader {

	private BufferedReader reader;
	private InputStreamReader isr;
	private FileInputStream fis;

	private boolean fileLoaded;

	public TextLineReader() {
		// TODO Auto-generated constructor stub
	}

	public void read(File source) throws FileNotFoundException{

		if(isFileLoaded()){
			return;
		}

		if(!source.exists()){
			return;
		}

		fis = new FileInputStream(source);
		isr = new InputStreamReader(fis);
		reader = new BufferedReader(isr);
		fileLoaded = true;
	}

	public void close() throws IOException{
		fis.close();
		isr.close();
		reader.close();
		fileLoaded = false;
	}

	public String readLine() throws IOException{
		String line = reader.readLine();
		if(line == null){
			close();
		}
		return line;
	}

	public List<String> readAllLines() throws IOException{
		List<String> lines = new ArrayList<>();
		String line = null;
		while((line = reader.readLine()) != null){
			lines.add(line);
		}
		close();
		return lines;
	}

	public boolean isFileLoaded() {
		return fileLoaded;
	}

	public void setFileLoaded(boolean fileLoaded) {
		this.fileLoaded = fileLoaded;
	}

	public static void main(String[] args) throws IOException {
		TextLineReader tlr = new TextLineReader();
		tlr.read(new File("anna_karenina.txt"));
		String line = tlr.readLine();
		while(line != null){
			System.out.println(line.trim());
			line = tlr.readLine();
		}
	}

}
