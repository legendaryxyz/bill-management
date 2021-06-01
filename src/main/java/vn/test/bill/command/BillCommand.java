package vn.test.bill.command;

import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.models.Accounts;

public interface BillCommand {
	CommandResponse execute(CommandArgument arg) throws IllegalArgumentException;
	void withAccount(Accounts account);
}
