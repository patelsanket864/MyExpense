package com.home.ExpenseCalculator.model;

import java.sql.Time;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class ExpenseEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int expenseId;
	private String expenseName;
	private String paymentType;
	private double amount;
	private int expenseCount;
	private int expenseQuantity;
	private double totalAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss")
	private Time expenseTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date expenseDate;

	public ExpenseEntry() {
	}

	public ExpenseEntry(String expenseName, double amount, String paymentType, Time expenseTime, Date expenseDate,
			int expenseCount, int expenseQuantity, double totalAmount) {
		super();
		this.expenseName = expenseName;
		this.amount = amount;
		this.paymentType = paymentType;
		this.expenseTime = expenseTime;
		this.expenseDate = expenseDate;
		this.expenseCount = expenseCount;
		this.expenseQuantity = expenseQuantity;
		this.totalAmount = totalAmount;
	}

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Time getExpenseTime() {
		return expenseTime;
	}

	public void setExpenseTime(Time expenseTime) {
		this.expenseTime = expenseTime;
	}

	public Date getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getExpenseCount() {
		return expenseCount;
	}

	public void setExpenseCount(int expenseCount) {
		this.expenseCount = expenseCount;
	}

	public int getExpenseQuantity() {
		return expenseQuantity;
	}

	public void setExpenseQuantity(int expenseQuantity) {
		this.expenseQuantity = expenseQuantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
