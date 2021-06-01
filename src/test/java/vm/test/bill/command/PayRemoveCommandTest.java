package vm.test.bill.command;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import vn.test.bill.command.BillCommand;
import vn.test.bill.command.BillRemoveCommand;
import vn.test.bill.command.arguments.BillRemoveCommandArgument;
import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.enums.BillState;
import vn.test.bill.enums.Commands;
import vn.test.bill.models.Accounts;
import vn.test.bill.models.Bills;

public class PayRemoveCommandTest {
	
	private Accounts account = new Accounts();
	
	public PayRemoveCommandTest() {
		
		account.addBill(new Bills(BigInteger.valueOf(1), "INTERNET", BillState.NOT_PAID, LocalDate.of(2021, 6, 2), BigDecimal.valueOf(400000), "VNPT", null));
		account.addBill(new Bills(BigInteger.valueOf(2), "WATER", BillState.NOT_PAID, LocalDate.of(2021, 6, 3), BigDecimal.valueOf(5000000), "EVN", null));
		account.addFund(BigDecimal.valueOf(2_000_000));
	}
	
	@Test
	public void testRemoveOK() {
		
		BillCommand removeCmd = new BillRemoveCommand(account);
		List<BigInteger> billNoList = new ArrayList<BigInteger>();
		billNoList.add(BigInteger.valueOf(1));
		CommandArgument arg = new BillRemoveCommandArgument(Commands.REMOVE_BILL, billNoList);
		
		CommandResponse response = removeCmd.execute(arg);
		
		assertTrue(account.getAllBills().size() == 1);
	}
	
	@Test
	public void testRemoveNotFound() {
		
		BillCommand removeCmd = new BillRemoveCommand(account);
		List<BigInteger> billNoList = new ArrayList<BigInteger>();
		billNoList.add(BigInteger.valueOf(10));
		CommandArgument arg = new BillRemoveCommandArgument(Commands.REMOVE_BILL, billNoList);
		
		CommandResponse response = removeCmd.execute(arg);
		
		assertTrue(account.getAllBills().size() == 2);
	}
}
