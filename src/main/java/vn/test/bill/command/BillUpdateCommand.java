package vn.test.bill.command;

import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.models.Accounts;

public class BillUpdateCommand extends AbstractBillCommand implements BillCommand {

	public BillUpdateCommand(Accounts account) {
		super(account);
	}
	
	@Override
	public CommandResponse execute(CommandArgument arg) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
