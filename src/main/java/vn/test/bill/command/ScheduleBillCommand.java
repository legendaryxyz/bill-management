package vn.test.bill.command;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.arguments.PayCommandArgument;
import vn.test.bill.command.arguments.ScheduleCommandArgument;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.command.response.data.PayCommandResponseData;
import vn.test.bill.enums.BillPayStatusCode;
import vn.test.bill.models.Accounts;
import vn.test.bill.models.Bills;

public class ScheduleBillCommand extends AbstractBillCommand implements BillCommand {

	public ScheduleBillCommand(Accounts account) {
		super(account);
	}

	@Override
	public CommandResponse execute(CommandArgument arg) throws IllegalArgumentException {
		
		if(!(arg instanceof ScheduleCommandArgument)) {
			throw new IllegalArgumentException();
		}
		
		ScheduleCommandArgument payArg = (ScheduleCommandArgument) arg;
		
		
		
		return CommandResponse.ok();
	}
	
}
