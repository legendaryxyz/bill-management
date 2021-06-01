package vn.test.bill.command.arguments;

import java.math.BigDecimal;

import vn.test.bill.enums.Commands;

public class CashInCommandArgument extends CommandArgument {

	private BigDecimal amount;

	public CashInCommandArgument(Commands command, BigDecimal amount) {
		
		super(command);
		this.amount = amount;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	
}
