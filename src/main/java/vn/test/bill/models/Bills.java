package vn.test.bill.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Objects;

import vn.test.bill.enums.BillState;

public class Bills implements Comparable<Bills> {
	
	private BigInteger billNo;
	private String serviceName;
	private BillState state;
	private LocalDate dueDate;
	private BigDecimal amount;
	private String providerName;
	private Payments payment;
	
	public Bills(BigInteger billNo, 
			String serviceName, 
			BillState state, 
			LocalDate dueDate, 
			BigDecimal amount,
			String providerName,
			Payments payment) {
		super();
		this.billNo = billNo;
		this.serviceName = serviceName;
		this.state = state;
		this.dueDate = dueDate;
		this.amount = amount;
		this.providerName = providerName;
		this.payment = payment;
	}

	public BigInteger getBillNo() {
		return billNo;
	}

	public String getServiceName() {
		return serviceName;
	}

	public BillState getState() {
		return state;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getProviderName() {
		return providerName;
	}
	

	public Payments getPayment() {
		return payment;
	}

	public void setPayment(Payments payment) {
		this.payment = payment;
	}

	public void setBillNo(BigInteger billNo) {
		this.billNo = billNo;
	}

	public void setService(String serviceName) {
		this.serviceName = serviceName;
	}

	public void setState(BillState state) {
		this.state = state;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	@Override
	public boolean equals(Object o) {
		
		if(o == null || !(o instanceof Bills)) {
			return false;
		}
		
		Bills bill = (Bills) o;
		
		return Objects.equals(this.billNo, bill.billNo);
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(this.billNo);
	}
	
	@Override
	public String toString() {
		return "Bill#" + this.billNo;
	}

	@Override
	public int compareTo(Bills o) {
		
		return this.getBillNo().compareTo(o.getBillNo());
	}
}
