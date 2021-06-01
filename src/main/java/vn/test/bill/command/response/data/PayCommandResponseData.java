package vn.test.bill.command.response.data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class PayCommandResponseData extends CommandResponseData {
	
	private BigDecimal currentBalance;
	private List<BigInteger> notfoundBillNoList;
	private List<BigInteger> outOfFundBillNoList;
	
	public PayCommandResponseData(List<BigInteger> notfoundBillNoList, 
			List<BigInteger> outOfFundBillNoList,
			BigDecimal currentBalance) {
		super();
		this.notfoundBillNoList = notfoundBillNoList;
		this.outOfFundBillNoList = outOfFundBillNoList;
		this.currentBalance = currentBalance;
	}
	
	public List<BigInteger> getNotfoundBillNoList() {
		return notfoundBillNoList;
	}
	
	public List<BigInteger> getOutOfFundBillNoList() {
		return outOfFundBillNoList;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}
	
}
