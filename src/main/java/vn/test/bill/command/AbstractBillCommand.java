package vn.test.bill.command;

import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.models.Accounts;

public abstract class AbstractBillCommand implements BillCommand {
	
	protected Accounts account;

	public AbstractBillCommand(Accounts account) {
		super();
		this.account = account;
	}
	
	public AbstractBillCommand() {
		super();
	}
	
	public void withAccount(Accounts account) {
		this.account = account;
	}

	public abstract CommandResponse execute(CommandArgument arg) throws IllegalArgumentException;

}
