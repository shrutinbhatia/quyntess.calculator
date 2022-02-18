package com.quyntess.model;

import java.time.LocalDateTime;

public class MyCalculator {
	private long mySeq;
	private String result;
	private String myFormula;
	private LocalDateTime createdate;
	public long getMySeq() {
		return mySeq;
	}
	public void setMySeq(long mySeq) {
		this.mySeq = mySeq;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMyFormula() {
		return myFormula;
	}
	public void setMyFormula(String myFormula) {
		this.myFormula = myFormula;
	}
	public LocalDateTime getCreatedate() {
		return createdate;
	}
	public void setCreatedate(LocalDateTime localDateTime) {
		this.createdate = localDateTime;
	}
	

}
