package vn.test.bill.command.response.data;

import java.math.BigInteger;
import java.util.List;

public class BillRemoveCommandResponseData extends CommandResponseData {
	
	private List<BigInteger> failedBillNoList;
	
	public BillRemoveCommandResponseData(List<BigInteger> failedBillNoList) {
		super();
		this.failedBillNoList = failedBillNoList;
	}

	public List<BigInteger> getFailedBillNoList() {
		return failedBillNoList;
	}
	
}
