package com.poc.tradestore;

import java.time.LocalDate;
import java.util.Date;

public class Trade {
	private String tradeId;
	private int version;
	private String counterPartId;
	private String bookId;
	private LocalDate maturityDate;
	private LocalDate createdDate;
	private boolean isExpired;
	
	public boolean isExpired() {
		return isExpired;
	}
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
	public Trade() {
		//Default constructor
	}
	public Trade(String tradeId, int version, String counterPartId, String bookId, LocalDate maturityDate, LocalDate createdDate) {
		super();
		this.tradeId = tradeId;
		this.version = version;
		this.counterPartId = counterPartId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCounterPartId() {
		return counterPartId;
	}
	public void setCounterPartId(String counterPartId) {
		this.counterPartId = counterPartId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public LocalDate getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", version=" + version + ", counterPartId=" + counterPartId + ", bookId="
				+ bookId + ", maturityDate=" + maturityDate + ", createdDate=" + createdDate + "]";
	}


}
