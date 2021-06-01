package vn.test.bill.view;

import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.enums.CommandState;

public class RemoveBillConsoleView implements BillConsoleView {

	@Override
	public void view(CommandResponse response) {
		// TODO Auto-generated method stub
		if(response.getStatus() == CommandState.OK) {
			System.out.println("Bill removed");
		} else {
			System.out.print("Failed to remove bill");
		}
	}

}
