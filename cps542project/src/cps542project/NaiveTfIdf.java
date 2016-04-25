package cps542project;

import java.util.Hashtable;

import cps542project.reader.TextReader;

public class NaiveTfIdf {

	private TextReader reader;
	private Hashtable<String, Integer> store;

	public NaiveTfIdf() {
		reader = new TextReader();
	}

}
