package cps542project.analyzer;

import java.math.BigDecimal;

public class TermStats implements Comparable<TermStats>{

	private String term;
	private Integer count;
	private BigDecimal termFreq;

	public TermStats() {
		// TODO Auto-generated constructor stub
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public BigDecimal getTermFreq() {
		return termFreq;
	}

	public void setTermFreq(BigDecimal termFreq) {
		this.termFreq = termFreq;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}

	@Override
	public String toString() {
		return term + "," + count + "," + termFreq.toPlainString();
	}

	@Override
	public boolean equals(Object obj) {
		TermStats ts = (TermStats) obj;
		if(ts.getTerm() == null || ts.getTermFreq() == null){
			return false;
		}
		return ts.getTerm().equalsIgnoreCase(this.term) && ts.getTermFreq() == this.getTermFreq();
	}

	@Override
	public int hashCode() {
		return term.hashCode();
	}

	@Override
	public int compareTo(TermStats o) {
		return o.getCount().compareTo(this.getCount());
	}

}
