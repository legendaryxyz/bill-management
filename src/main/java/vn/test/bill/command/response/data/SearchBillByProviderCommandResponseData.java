package vn.test.bill.command.response.data;

import java.util.List;

import vn.test.bill.models.Bills;

public class SearchBillByProviderCommandResponseData extends CommandResponseData {
	private List<Bills> bills;

	public SearchBillByProviderCommandResponseData(List<Bills> bills) {
		super();
		this.bills = bills;
	}

	public List<Bills> getBills() {
		return bills;
	}
	
}
