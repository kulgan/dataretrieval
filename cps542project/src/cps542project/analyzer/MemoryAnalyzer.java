package cps542project.analyzer;

public class MemoryAnalyzer {
	
	private long startMemory;
	
	public MemoryAnalyzer() {
		startMemory = Runtime.getRuntime().totalMemory();
	}
	
	public long getUsedMemory(){
		return startMemory - Runtime.getRuntime().freeMemory();
	}

}
