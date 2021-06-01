package vn.test.bill.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import vn.test.bill.enums.PaymentState;

public class Payments implements Comparable<Payments> {

	private BigInteger id;
	private Bills bill;
	private LocalDate paymentDate;
	private BigDecimal amount;
	private PaymentState state;
	
	public Payments(BigInteger id, Bills bill, LocalDate paymentDate, BigDecimal amount, PaymentState state) {
		super();
		this.id = id;
		this.bill = bill;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.state = state;
	}

	public BigInteger getId() {
		return id;
	}

	public Bills getBill() {
		return bill;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public PaymentState getState() {
		return state;
	}

	
	public void setId(BigInteger id) {
		this.id = id;
	}

	public void setBill(Bills bill) {
		this.bill = bill;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setState(PaymentState state) {
		this.state = state;
	}

	@Override
	public int compareTo(Payments o) {
		return this.getId().compareTo(o.getId());
	}
	
}
