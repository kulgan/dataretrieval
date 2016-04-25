package cps542project.analyzer;

import java.math.BigDecimal;

public class TermStats {

	private String term;
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

	@Override
	public String toString() {
		return term + ", " + termFreq.toPlainString();
	}

}
