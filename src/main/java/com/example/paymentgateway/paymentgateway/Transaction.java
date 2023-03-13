package com.example.paymentgateway.paymentgateway;

import java.time.LocalDateTime;

public class Transaction {

	private int id;
	private int itemid;
	private double total;
	private LocalDateTime transactionAt;
	public Transaction(int id, int itemid, double total, LocalDateTime transactionAt) {
		super();
		this.id = id;
		this.itemid = itemid;
		this.total = total;
		this.transactionAt = transactionAt;
	}
	public Transaction() {
		super();
	}
	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", itemid=" + itemid + ", total=" + total + ", transactionAt=" + transactionAt
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public LocalDateTime getTransactionAt() {
		return transactionAt;
	}
	public void setTransactionAt(LocalDateTime transactionAt) {
		this.transactionAt = transactionAt;
	}
	
	
	
	
}
