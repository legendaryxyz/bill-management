package vn.test.bill.command.response.data;

import java.util.List;

import vn.test.bill.models.Payments;

public class ListPaymentCommandResponseData extends CommandResponseData {
	private List<Payments> payments;

	public ListPaymentCommandResponseData(List<Payments> payments) {
		super();
		this.payments = payments;
	}

	public List<Payments> getPayments() {
		return payments;
	}
	
}
