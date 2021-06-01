package vn.test.bill.view;

import java.util.List;

import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.command.response.data.ListBillCommandResponseData;
import vn.test.bill.models.Bills;
import vn.test.bill.utils.StringUtils;

public class ListBillConsoleView implements BillConsoleView {
	
	private static final int COLUMN_LEN = 20;
	private static final String[] headers = new String[] { "Bill No.", "Type", "Amount", "Due Date", "State", "PROVIDER" };

	@Override
	public void view(CommandResponse response) {

		ListBillCommandResponseData data = (ListBillCommandResponseData) response.getData();
		viewHeader();
		viewBody(data.getBills());
	}

	private void viewHeader() {
		
		for(String header : headers) {
			
			System.out.print(StringUtils.padStringRight(header, COLUMN_LEN));
		}
	}
	
	private void viewBody(List<Bills> bills) {
		
		for(Bills bill : bills) {
			
			System.out.println();
			System.out.print(StringUtils.padStringRight(String.valueOf(bill.getBillNo()), COLUMN_LEN));
			System.out.print(StringUtils.padStringRight(bill.getServiceName(), COLUMN_LEN));
			System.out.print(StringUtils.padStringRight(String.valueOf(bill.getAmount()), COLUMN_LEN));
			System.out.print(StringUtils.padStringRight(String.valueOf(bill.getDueDate()), COLUMN_LEN));
			System.out.print(StringUtils.padStringRight(bill.getState().toString(), COLUMN_LEN));
			System.out.print(StringUtils.padStringRight(bill.getProviderName(), COLUMN_LEN));
		}
		
		System.out.println();
	}
}
