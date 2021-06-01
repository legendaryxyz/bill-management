package vn.test.bill.command;

import java.util.List;
import java.util.stream.Collectors;

import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.arguments.ListBillCommandArgument;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.command.response.data.ListBillCommandResponseData;
import vn.test.bill.models.Accounts;
import vn.test.bill.models.Bills;

public class ListBillCommand extends AbstractBillCommand implements BillCommand {

	public ListBillCommand(Accounts account) {
		super(account);
	}

	@Override
	public CommandResponse execute(CommandArgument arg) throws IllegalArgumentException {
		
		if(!(arg instanceof ListBillCommandArgument)) {
			throw new IllegalArgumentException();
		}
		
		//ListBillCommandArgument payArg = (ListBillCommandArgument) arg;
		
		List<Bills> bills = account.getAllBills().stream()
				.collect(Collectors.toList());
		
		return CommandResponse.ok(new ListBillCommandResponseData(bills));
	}
	
}
