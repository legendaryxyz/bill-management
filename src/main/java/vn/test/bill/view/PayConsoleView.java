package vn.test.bill.view;

import java.util.StringJoiner;
import java.util.stream.Collectors;

import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.command.response.data.PayCommandResponseData;
import vn.test.bill.enums.CommandState;

public class PayConsoleView implements BillConsoleView {

	@Override
	public void view(CommandResponse response) {
		
		PayCommandResponseData data = (PayCommandResponseData) response.getData();
		
		System.out.println("Your current balance " + data.getCurrentBalance());
		
		if(response.getStatus() != CommandState.OK) {
			
			if(data.getNotfoundBillNoList().size() > 0) {
				
				String billNoListText = data.getNotfoundBillNoList().stream().map(billNo -> String.valueOf(billNo)).collect(Collectors.joining(","));
			
				System.out.println("Sorry! No such bill with id " + billNoListText);
			}
			
			if(data.getOutOfFundBillNoList().size() > 0) {
				
				String billNoListText = data.getOutOfFundBillNoList().stream().map(billNo -> String.valueOf(billNo)).collect(Collectors.joining(","));
				
				System.out.println("Sorry! Cannot pay bill with id " + billNoListText + " due to out of fund");
			}
		}
	}

}
