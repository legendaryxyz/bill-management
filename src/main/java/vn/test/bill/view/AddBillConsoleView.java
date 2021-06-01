package vn.test.bill.view;

import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.enums.CommandState;

public class AddBillConsoleView implements BillConsoleView {

	@Override
	public void view(CommandResponse response) {
		// TODO Auto-generated method stub
		
		if(response.getStatus() == CommandState.OK) {
			System.out.println("New bill added");
		} else {
			System.out.print("Failed to add bill");
		}
	}

}
