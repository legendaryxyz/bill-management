package vn.test.bill.command;

import java.util.stream.Collectors;

import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.arguments.ListPaymentCommandArgument;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.command.response.data.ListPaymentCommandResponseData;
import vn.test.bill.models.Accounts;

public class ListPaymentCommand extends AbstractBillCommand implements BillCommand {

	public ListPaymentCommand(Accounts account) {
		super(account);
	}

	@Override
	public CommandResponse execute(CommandArgument arg) throws IllegalArgumentException {
		
		if(!(arg instanceof ListPaymentCommandArgument)) {
			throw new IllegalArgumentException();
		}
		
		ListPaymentCommandArgument payArg = (ListPaymentCommandArgument) arg;
		
		return CommandResponse.ok(new ListPaymentCommandResponseData(account.getPayments().stream().collect(Collectors.toList())));
	}
	
}
