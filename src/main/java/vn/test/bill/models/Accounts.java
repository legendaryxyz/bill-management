package vn.test.bill.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import vn.test.bill.enums.BillPayStatusCode;
import vn.test.bill.enums.BillState;
import vn.test.bill.enums.PaymentState;

/**
 * 
 * @author phu.ngo
 *
 */
public class Accounts {
	
	private BigDecimal fund = BigDecimal.ZERO;
	private SortedMap<BigInteger, Bills> allBills = new TreeMap<BigInteger, Bills>();
	private SortedSet<Payments> payments = new TreeSet<Payments>();
	
	public Accounts() { }

	public BigDecimal getFund() {
		return fund;
	}

	public Collection<Bills> getAllBills() {
		return allBills.values();
	}

	public SortedSet<Payments> getPayments() {
		return payments;
	}

	public void setPayments(SortedSet<Payments> payments) {
		this.payments = payments;
	}

	/**
	 * 
	 * @param newFund
	 * @return
	 */
	public void addFund(BigDecimal newFund) {
		this.fund = this.fund.add(newFund);
	}
	
	public Bills findBillByNo(BigInteger billNo) {

		if(!allBills.containsKey(billNo)) {
			return null;
		}
		
		return allBills.get(billNo);
	}
	
	/**
	 * Create  new bill together with pending payment
	 * @param bill
	 */
	public void addBill(Bills bill) {
		
		this.allBills.put(bill.getBillNo(), bill);
		this.addPayment(bill);
	}
	
	public boolean removeBill(BigInteger billNo) {
		
		return this.allBills.remove(billNo) != null;
	}
	
	/**
	 * 
	 * @param billNo
	 * @return
	 */
	public BillPayStatusCode pay(Bills payableBill) {
		
		synchronized (fund) {
			
			if(fund.compareTo(payableBill.getAmount()) < 0) {
				return BillPayStatusCode.OUT_OF_FUND;
			}
			
			payableBill.getPayment().setPaymentDate(LocalDate.now());
			payableBill.getPayment().setState(PaymentState.PROCESSED);;
			payableBill.setState(BillState.PAID);
			this.fund = this.fund.subtract(payableBill.getAmount());
		}
		
		return BillPayStatusCode.OK;
	}
	
	private void addPayment(Bills bill) {
		
		Payments payment = new Payments(PaymentSequences.nextSeq(), bill, null, bill.getAmount(), PaymentState.PENDING);
		
		this.payments.add(payment);
		bill.setPayment(payment);
	}
}
