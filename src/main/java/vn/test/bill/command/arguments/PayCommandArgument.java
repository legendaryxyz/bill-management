package vn.test.bill.command.arguments;

import java.math.BigInteger;
import java.util.List;

import vn.test.bill.enums.Commands;

public class PayCommandArgument extends CommandArgument {

	private List<BigInteger> billNoList;

	public PayCommandArgument(Commands command, List<BigInteger> billNoList) {
		
		super(command);
		this.billNoList = billNoList;
	}

	public List<BigInteger> getBillNoList() {
		return billNoList;
	}
	
}
