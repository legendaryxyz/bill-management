package vn.test.bill.command;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.arguments.PayCommandArgument;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.command.response.data.PayCommandResponseData;
import vn.test.bill.enums.BillPayStatusCode;
import vn.test.bill.models.Accounts;
import vn.test.bill.models.Bills;

public class DueDatePaymentCommand extends AbstractBillCommand implements BillCommand {

	public DueDatePaymentCommand(Accounts account) {
		super(account);
	}

	@Override
	public CommandResponse execute(CommandArgument arg) throws IllegalArgumentException {
		
		if(!(arg instanceof PayCommandArgument)) {
			throw new IllegalArgumentException();
		}
		
		PayCommandArgument payArg = (PayCommandArgument) arg;
		
		List<BigInteger> notfoundBillNoList = new ArrayList<BigInteger>();
		List<BigInteger> outOfFundBillNoList = new ArrayList<BigInteger>();
		
		SortedSet<Bills> prioritizedBills = new TreeSet<Bills>(new Comparator<Bills>() {

			@Override
			public int compare(Bills o1, Bills o2) {
				
				return o1.getDueDate().compareTo(o2.getDueDate());
			}
		});
		
		for(BigInteger billNo : payArg.getBillNoList()) {
			
			Bills bill = account.findBillByNo(billNo);
			if(bill != null) {
				
				prioritizedBills.add(bill);
			} else {
				
				notfoundBillNoList.add(billNo);
			}
		}
		
		for(Bills bill : prioritizedBills) {
			
			BillPayStatusCode statusCode = account.pay(bill);
			
			if(statusCode == BillPayStatusCode.OUT_OF_FUND) {
				
				outOfFundBillNoList.add(bill.getBillNo());
			}
		}
		
		if(notfoundBillNoList.size() > 0 || outOfFundBillNoList.size() > 0) {
			return CommandResponse.error(new PayCommandResponseData(notfoundBillNoList, outOfFundBillNoList, account.getFund()));
		}
		
		return CommandResponse.ok();
	}
	
}
