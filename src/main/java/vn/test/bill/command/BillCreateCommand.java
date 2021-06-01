package vn.test.bill.command;

import vn.test.bill.command.arguments.BillCreateCommandArgument;
import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.enums.BillState;
import vn.test.bill.models.Accounts;
import vn.test.bill.models.BillSequences;
import vn.test.bill.models.Bills;

public class BillCreateCommand extends AbstractBillCommand implements BillCommand {

	public BillCreateCommand(Accounts account) {
		super(account);
	}

	@Override
	public CommandResponse execute(CommandArgument arg) throws IllegalArgumentException {
		
		if(!(arg instanceof BillCreateCommandArgument)) {
			throw new IllegalArgumentException();
		}
		
		BillCreateCommandArgument billCreateArg = (BillCreateCommandArgument) arg;
		
		Bills newBill = new Bills(BillSequences.nextSeq(), 
				billCreateArg.getServiceName(), 
				BillState.NOT_PAID, 
				billCreateArg.getDueDate(), 
				billCreateArg.getAmount(), 
				billCreateArg.getProvider(),
				null);
		
		account.addBill(newBill);
		
		return CommandResponse.ok();
	}

}
