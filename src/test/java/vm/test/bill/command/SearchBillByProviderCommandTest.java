package vm.test.bill.command;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import vn.test.bill.command.BillCommand;
import vn.test.bill.command.SearchBillByProviderCommand;
import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.arguments.SearchBillByProviderCommandArgument;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.command.response.data.SearchBillByProviderCommandResponseData;
import vn.test.bill.enums.BillState;
import vn.test.bill.enums.Commands;
import vn.test.bill.models.Accounts;
import vn.test.bill.models.Bills;

public class SearchBillByProviderCommandTest {
	
	private Accounts account = new Accounts();
	
	public SearchBillByProviderCommandTest() {
		
		account.addBill(new Bills(BigInteger.valueOf(1), "INTERNET", BillState.NOT_PAID, LocalDate.of(2021, 6, 2), BigDecimal.valueOf(400000), "VNPT", null));
		account.addBill(new Bills(BigInteger.valueOf(2), "WATER", BillState.NOT_PAID, LocalDate.of(2021, 6, 3), BigDecimal.valueOf(5000000), "EVN", null));
		account.addFund(BigDecimal.valueOf(2_000_000));
	}

	@Test
	public void testSearchFound() {
		
		BillCommand searchCmd = new SearchBillByProviderCommand(account);
		
		CommandArgument arg = new SearchBillByProviderCommandArgument(Commands.SEARCH_BILL_BY_PROVIDER, "VNPT");
		
		CommandResponse response = searchCmd.execute(arg);
		
		assertTrue(response.getData() instanceof SearchBillByProviderCommandResponseData);
		assertTrue(((SearchBillByProviderCommandResponseData) response.getData()).getBills().size() == 1);
		assertTrue(((SearchBillByProviderCommandResponseData) response.getData()).getBills().get(0).getServiceName().equals("INTERNET"));
	}
	
	@Test
	public void testSearchNotFound() {
		
		BillCommand searchCmd = new SearchBillByProviderCommand(account);
		
		CommandArgument arg = new SearchBillByProviderCommandArgument(Commands.SEARCH_BILL_BY_PROVIDER, "FTP");
		
		CommandResponse response = searchCmd.execute(arg);
		
		assertTrue(response.getData() instanceof SearchBillByProviderCommandResponseData);
		assertTrue(((SearchBillByProviderCommandResponseData) response.getData()).getBills().size() == 0);
	}
}
