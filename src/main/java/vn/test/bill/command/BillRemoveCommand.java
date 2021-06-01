package vn.test.bill.command;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import vn.test.bill.command.arguments.BillRemoveCommandArgument;
import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.command.response.data.BillRemoveCommandResponseData;
import vn.test.bill.models.Accounts;

public class BillRemoveCommand extends AbstractBillCommand implements BillCommand {

	public BillRemoveCommand(Accounts account) {
		super(account);
	}

	@Override
	public CommandResponse execute(CommandArgument arg) throws IllegalArgumentException {
		
		if(!(arg instanceof BillRemoveCommandArgument)) {
			throw new IllegalArgumentException();
		}
		
		BillRemoveCommandArgument billRemoveArg = (BillRemoveCommandArgument) arg;
		
		List<BigInteger> faliedRemoveBillNoList = new ArrayList<BigInteger>();
		
		for(BigInteger billNo : billRemoveArg.getBillNoList()) {		
			if(!account.removeBill(billNo)) {
				faliedRemoveBillNoList.add(billNo);
			}
		}
		
		if(faliedRemoveBillNoList.size() > 0) {
			return CommandResponse.error(new BillRemoveCommandResponseData(faliedRemoveBillNoList));
		}
		
		return CommandResponse.ok();
	}
}
