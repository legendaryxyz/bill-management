package vm.test.bill.command;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import vn.test.bill.enums.BillState;
import vn.test.bill.models.Accounts;
import vn.test.bill.models.Bills;

public class CashInCommandTest {
	
	private Accounts account = new Accounts();
	
	public CashInCommandTest() {
		
		account.addBill(new Bills(BigInteger.valueOf(1), "INTERNET", BillState.NOT_PAID, LocalDate.of(2021, 6, 2), BigDecimal.valueOf(400000), "VNPT", null));
		account.addBill(new Bills(BigInteger.valueOf(2), "WATER", BillState.NOT_PAID, LocalDate.of(2021, 6, 3), BigDecimal.valueOf(5000000), "EVN", null));
		account.addFund(BigDecimal.valueOf(2_000_000));
	}

	@Test
	public void testAddCashOK() {
		
		account.addFund(BigDecimal.valueOf(500_000));
		
		assertTrue(account.getFund().equals(BigDecimal.valueOf(2_500_000)));
	}
}
