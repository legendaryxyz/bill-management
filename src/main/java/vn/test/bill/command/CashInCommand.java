package vn.test.bill.command;

import vn.test.bill.command.arguments.CashInCommandArgument;
import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.command.response.data.CashInCommandResponseData;
import vn.test.bill.models.Accounts;

public class CashInCommand extends AbstractBillCommand implements BillCommand {

	public CashInCommand(Accounts account) {
		super(account);
	}

	@Override
	public CommandResponse execute(CommandArgument arg) throws IllegalArgumentException {
		
		if(!(arg instanceof CashInCommandArgument)) {
			throw new IllegalArgumentException();
		}
		
		CashInCommandArgument cashInArg = (CashInCommandArgument) arg;
		
		account.addFund(cashInArg.getAmount());
		
		return CommandResponse.ok(new CashInCommandResponseData(account.getFund()));
	}

}
