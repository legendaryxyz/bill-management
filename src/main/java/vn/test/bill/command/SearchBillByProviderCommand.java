package vn.test.bill.command;

import java.util.List;
import java.util.stream.Collectors;

import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.arguments.SearchBillByProviderCommandArgument;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.command.response.data.SearchBillByProviderCommandResponseData;
import vn.test.bill.models.Accounts;
import vn.test.bill.models.Bills;

public class SearchBillByProviderCommand extends AbstractBillCommand implements BillCommand {

	public SearchBillByProviderCommand(Accounts account) {
		super(account);
	}

	@Override
	public CommandResponse execute(CommandArgument arg) throws IllegalArgumentException {
		
		if(!(arg instanceof SearchBillByProviderCommandArgument)) {
			throw new IllegalArgumentException();
		}
		
		SearchBillByProviderCommandArgument searchArg = (SearchBillByProviderCommandArgument) arg;
		
		List<Bills> bills = account.getAllBills().stream()
			.filter(bill -> bill.getProviderName().equals(searchArg.getProviderName()))
			.collect(Collectors.toList());
		
		return CommandResponse.ok(new SearchBillByProviderCommandResponseData(bills));
	}
	
}
