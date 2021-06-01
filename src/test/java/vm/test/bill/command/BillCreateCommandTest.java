package vm.test.bill.command;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import vn.test.bill.command.BillCommand;
import vn.test.bill.command.BillCreateCommand;
import vn.test.bill.command.arguments.BillCreateCommandArgument;
import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.enums.Commands;
import vn.test.bill.models.Accounts;

public class BillCreateCommandTest {

	private Accounts account = new Accounts();
	
	public BillCreateCommandTest() {
		
		//account.addBill(new Bills(BigInteger.ONE, "INTERNET", BillState.NOT_PAID, LocalDate.of(2021, 6, 2), BigDecimal.valueOf(400000), "VNPT", null));
		//account.addBill(new Bills(BigInteger.TWO, "WATER", BillState.NOT_PAID, LocalDate.of(2021, 6, 3), BigDecimal.valueOf(5000000), "EVN", null));
		account.addFund(BigDecimal.valueOf(2_000_000));
	}
	
	@Test
	public void testAddBillOK() {
		
		BillCommand addCmd = new BillCreateCommand(account);
		CommandArgument arg = new BillCreateCommandArgument(Commands.ADD_BILL, "ELECTRIC", "EVN", BigDecimal.valueOf(200000), LocalDate.of(2021, 6, 5));
		CommandResponse response = addCmd.execute(arg);
		
		assertTrue(account.getAllBills().size() == 1);
		assertTrue(account.findBillByNo(BigInteger.valueOf(1)).getAmount().equals(BigDecimal.valueOf(200000)));
	}
}
