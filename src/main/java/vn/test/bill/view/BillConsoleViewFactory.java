package vn.test.bill.view;

import vn.test.bill.enums.Commands;

public class BillConsoleViewFactory {
	
	public static BillConsoleView getView(Commands command) {
		
		switch (command) {
		case CASH_IN: {
			
			return new CashInConsoleView();
		}
		case LIST_BILL: {
			
			return new ListBillConsoleView();
		}
		case ADD_BILL: {
			
			return new AddBillConsoleView();
		}
		case UPDATE_BILL: {
			
			return new UpdateBillConsoleView();
		}
		case REMOVE_BILL: {
			
			return new RemoveBillConsoleView();
		}
		case SEARCH_BILL_BY_PROVIDER: {
			
			return new SearchBillByProviderConsoleView();
		}
		case PAY: {
			
			return new PayConsoleView();
		}
		case SCHEDULE: {
			
			return new ScheduleConsoleView();
		}
		case LIST_PAYMENT: {
			
			return new ListPaymentConsoleView();
		}
		case DUE_DATE: {
			
			return new DueDateConsoleView();
		}
		default:
			throw new IllegalArgumentException("Unexpected command: ");
		}
	}
}
