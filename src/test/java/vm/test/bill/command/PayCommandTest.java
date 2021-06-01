package vm.test.bill.command;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import vn.test.bill.command.BillCommand;
import vn.test.bill.command.PayCommand;
import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.arguments.PayCommandArgument;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.command.response.data.PayCommandResponseData;
import vn.test.bill.enums.BillState;
import vn.test.bill.enums.CommandState;
import vn.test.bill.enums.Commands;
import vn.test.bill.models.Accounts;
import vn.test.bill.models.Bills;

public class PayCommandTest {
	
	private Accounts account = new Accounts();
	
	public PayCommandTest() {
		
		account.addBill(new Bills(BigInteger.valueOf(1), "INTERNET", BillState.NOT_PAID, LocalDate.of(2021, 6, 2), BigDecimal.valueOf(400000), "VNPT", null));
		account.addBill(new Bills(BigInteger.valueOf(2), "WATER", BillState.NOT_PAID, LocalDate.of(2021, 6, 3), BigDecimal.valueOf(5000000), "EVN", null));
		account.addFund(BigDecimal.valueOf(2_000_000));
	}
	
	@Test
	public void testPayBillNotFound() {
		
		BillCommand payCmd = new PayCommand(account);
		
		List<BigInteger> billNoList = new ArrayList<BigInteger>();
		billNoList.add(BigInteger.valueOf(10));
		CommandArgument arg = new PayCommandArgument(Commands.PAY, billNoList);
		
		CommandResponse response = payCmd.execute(arg);
		
		assertTrue(response.getStatus() == CommandState.FAILED);
		assertTrue(response.getData() instanceof PayCommandResponseData);
		assertTrue(((PayCommandResponseData) response.getData()).getNotfoundBillNoList().size() == 1);
	}
	
	@Test
	public void testPayBillOutOfFund() {
		
		BillCommand payCmd = new PayCommand(account);
		
		List<BigInteger> billNoList = new ArrayList<BigInteger>();
		billNoList.add(BigInteger.valueOf(2));
		CommandArgument arg = new PayCommandArgument(Commands.PAY, billNoList);
		
		CommandResponse response = payCmd.execute(arg);
		
		assertTrue(response.getStatus() == CommandState.FAILED);
		assertTrue(response.getData() instanceof PayCommandResponseData);
		assertTrue(((PayCommandResponseData) response.getData()).getOutOfFundBillNoList().size() == 1);
	}
	
	@Test
	public void testPaySuccess() {
		
		BillCommand payCmd = new PayCommand(account);
		
		List<BigInteger> billNoList = new ArrayList<BigInteger>();
		billNoList.add(BigInteger.valueOf(1));
		CommandArgument arg = new PayCommandArgument(Commands.PAY, billNoList);
		
		CommandResponse response = payCmd.execute(arg);
		
		assertTrue(response.getStatus() == CommandState.OK);
		assertTrue(account.getFund().equals(BigDecimal.valueOf(1600000)));
	}
}
