package vn.test.bill.command.response.data;

import java.math.BigDecimal;

public class CashInCommandResponseData extends CommandResponseData {
	private BigDecimal currentBalance;

	public CashInCommandResponseData(BigDecimal currentBalance) {
		super();
		this.currentBalance = currentBalance;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
	
}
