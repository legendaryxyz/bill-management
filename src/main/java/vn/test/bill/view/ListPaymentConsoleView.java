package vn.test.bill.view;

import java.util.List;

import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.command.response.data.ListBillCommandResponseData;
import vn.test.bill.command.response.data.ListPaymentCommandResponseData;
import vn.test.bill.models.Bills;
import vn.test.bill.models.Payments;
import vn.test.bill.utils.StringUtils;

public class ListPaymentConsoleView implements BillConsoleView {

	private static final int COLUMN_LEN = 20;
	private static final String[] headers = new String[] { "No.", "Amount", "Payment Date", "State", "Bill Id" };

	@Override
	public void view(CommandResponse response) {

		ListPaymentCommandResponseData data = (ListPaymentCommandResponseData) response.getData();
		viewHeader();
		viewBody(data.getPayments());
	}

	private void viewHeader() {
		
		for(String header : headers) {
			
			System.out.print(StringUtils.padStringRight(header, COLUMN_LEN));
		}
	}
	
	private void viewBody(List<Payments> payments) {
		
		for(Payments payment : payments) {
			
			System.out.println();
			System.out.print(StringUtils.padStringRight(String.valueOf(payment.getId()), COLUMN_LEN));
			System.out.print(StringUtils.padStringRight(String.valueOf(payment.getAmount()), COLUMN_LEN));
			System.out.print(StringUtils.padStringRight(String.valueOf(payment.getPaymentDate()), COLUMN_LEN));
			System.out.print(StringUtils.padStringRight(payment.getState().toString(), COLUMN_LEN));
			System.out.print(StringUtils.padStringRight(String.valueOf(payment.getBill().getBillNo()), COLUMN_LEN));
		}
		
		System.out.println();
	}
}
