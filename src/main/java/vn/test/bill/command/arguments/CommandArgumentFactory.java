package vn.test.bill.command.arguments;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import vn.test.bill.command.CashInCommand;
import vn.test.bill.command.ListBillCommand;
import vn.test.bill.enums.Commands;

public class CommandArgumentFactory {
	
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	public static CommandArgument getArgument(String[] consoleArgs) {
		
		try {
			
			Commands cmd = Commands.valueOf(consoleArgs[0]);
			
			switch (cmd) {
			case CASH_IN: {
				
				return new CashInCommandArgument(Commands.CASH_IN, BigDecimal.valueOf(Long.valueOf(consoleArgs[1])));
			}
			case LIST_BILL: {
				
				return new ListBillCommandArgument(Commands.LIST_BILL);
			}
			case ADD_BILL: {
				
				return new BillCreateCommandArgument(Commands.ADD_BILL,
						consoleArgs[1], 
						consoleArgs[2], 
						BigDecimal.valueOf(Long.valueOf(consoleArgs[3])), 
						LocalDate.parse(consoleArgs[4], DateTimeFormatter.ofPattern(DATE_FORMAT)));
			}
			case UPDATE_BILL: {
				
				return new BillCreateCommandArgument(Commands.UPDATE_BILL,
						consoleArgs[1], 
						consoleArgs[2], 
						BigDecimal.valueOf(Long.valueOf(consoleArgs[3])), 
						LocalDate.parse(consoleArgs[4], DateTimeFormatter.ofPattern(DATE_FORMAT)));
			}
			case REMOVE_BILL: {
				
				List<BigInteger> removeBillNoList = Stream.of(consoleArgs)
						.skip(1)
						.map(arg -> BigInteger.valueOf(Long.valueOf(arg)))
						.collect(Collectors.toList());
				return new BillRemoveCommandArgument(Commands.REMOVE_BILL, removeBillNoList);
			}
			case SEARCH_BILL_BY_PROVIDER: {
				
				return new SearchBillByProviderCommandArgument(Commands.SEARCH_BILL_BY_PROVIDER, consoleArgs[1]);
			}
			case PAY: {
				
				List<BigInteger> payableBillNoList = Stream.of(consoleArgs)
						.skip(1)
						.map(arg -> BigInteger.valueOf(Long.valueOf(arg)))
						.collect(Collectors.toList());
				return new PayCommandArgument(Commands.PAY, payableBillNoList);
			}
			case SCHEDULE: {
				
				return new ScheduleCommandArgument(Commands.SCHEDULE, 
						BigInteger.valueOf(Long.valueOf(consoleArgs[1])), 
						LocalDate.parse(consoleArgs[2], DateTimeFormatter.ofPattern(DATE_FORMAT)));
			}
			case LIST_PAYMENT: {
				
				return new ListPaymentCommandArgument(Commands.LIST_PAYMENT);
			}
			case DUE_DATE: {
				
				return new DueDatePaymentCommandArgument(Commands.DUE_DATE);
			}
			default:
				throw new IllegalArgumentException("Unexpected command: " + cmd);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Unexpected arguments");
		}
	}
}
