package vn.test.bill.view;

import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.command.response.data.CashInCommandResponseData;
import vn.test.bill.enums.CommandState;

public class CashInConsoleView implements BillConsoleView {

	@Override
	public void view(CommandResponse response) {
		
		CashInCommandResponseData data = (CashInCommandResponseData) response.getData();
		
		if(response.getStatus() == CommandState.OK) {
			System.out.println("Your available balance " + data.getCurrentBalance());
		} else {
			System.out.println("Sorry! Failed to add cash");
		}
	}

}
