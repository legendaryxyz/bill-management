package vn.test.bill.command.arguments;

import vn.test.bill.enums.Commands;

public class SearchBillByProviderCommandArgument extends CommandArgument {

	private String providerName;

	public SearchBillByProviderCommandArgument(Commands command, String providerName) {
		
		super(command);
		this.providerName = providerName;
	}

	public String getProviderName() {
		return providerName;
	}
}
