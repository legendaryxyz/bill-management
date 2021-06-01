package vn.test.bill.command;

import vn.test.bill.enums.Commands;

public class CommandFactory {

	public static BillCommand getCommand(Commands cmd) {
		switch (cmd) {
		case CASH_IN: {
			
			return new CashInCommand(null);
		}
		case LIST_BILL: {
			
			return new ListBillCommand(null);
		}
		case ADD_BILL: {
			
			return new BillCreateCommand(null);
		}
		case UPDATE_BILL: {
			
			return new BillUpdateCommand(null);
		}
		case REMOVE_BILL: {
			
			return new BillRemoveCommand(null);
		}
		case SEARCH_BILL_BY_PROVIDER: {
			
			return new SearchBillByProviderCommand(null);
		}
		case PAY: {
			
			return new PayCommand(null);
		}
		case SCHEDULE: {
			
			return new ScheduleBillCommand(null);
		}
		case LIST_PAYMENT: {
			
			return new ListPaymentCommand(null);
		}
		case DUE_DATE: {
			
			return new DueDatePaymentCommand(null);
		}
		default:
			throw new IllegalArgumentException("Unexpected command: " + cmd);
		}
	}
}
