package cps542project.analyzer;

public class TimeAnalyzer {
	
	private long start;
	
	public TimeAnalyzer() {
		start = System.currentTimeMillis();
	}
	
	public long elapsedTime(){
		return System.currentTimeMillis() - start;
	}

}
