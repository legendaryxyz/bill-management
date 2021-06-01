package vm.test.bill.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vn.test.bill.enums.BillState;
import vn.test.bill.models.Accounts;
import vn.test.bill.models.Bills;

public class AccountsTest {
	
	private static final String SRV_NAME_INTERNET = "INTERNET";
	private static final String SRV_NAME_ELECTRIC = "ELECTRIC";
	private static final String SRV_NAME_WATER = "WATER";
	private static final String PROVIDER_VNPT = "VNPT";
	private static final String PROVIDER_EVN = "EVN HCM";
	private Accounts account = null;
	
	@BeforeEach
	public void setUp() {
		
		account = new Accounts();
	}

	@Test
	public void testConstruct() {
		
		Accounts account = new Accounts();
		
		assertEquals(account.getFund(), BigDecimal.ZERO);
		assertNotNull(account.getAllBills());
		assertEquals(account.getAllBills().size(), 0);
	}
	
	@Test
	public void testAddFundZero() {
		
		Accounts account = new Accounts();
		account.addFund(BigDecimal.ZERO);
		
		assertEquals(account.getFund(), BigDecimal.ZERO);
	}
	
	@Test
	public void testAddFundGreaterThanZero() {
		
		Accounts account = new Accounts();
		account.addFund(BigDecimal.TEN);
		
		assertEquals(account.getFund(), BigDecimal.TEN);
	}
	
	@Test
	public void testAddFundMultipleTimes() {
		
		Accounts account = new Accounts();
		account.addFund(BigDecimal.TEN);
		account.addFund(BigDecimal.ONE);
		
		BigDecimal ELEVEN = BigDecimal.TEN.add(BigDecimal.ONE);
		assertEquals(account.getFund(), ELEVEN);
	}
	
	@Test
	public void testAddBill() {
		
		
		
		account.addBill(new Bills(BigInteger.valueOf(1), 
				SRV_NAME_INTERNET, 
				BillState.NOT_PAID, 
				LocalDate.of(2021, 6, 2), 
				BigDecimal.valueOf(500_000), 
				PROVIDER_VNPT,
				null));
		
		account.addBill(new Bills(BigInteger.valueOf(2), 
				SRV_NAME_ELECTRIC, 
				BillState.NOT_PAID, 
				LocalDate.of(2021, 6, 3), 
				BigDecimal.valueOf(800_000), 
				PROVIDER_EVN,
				null));
		
		assertNotNull(account.getAllBills());
		assertEquals(account.getAllBills().size(), 2);
		
		// assert bill 1
		Bills bill1 = account.findBillByNo(BigInteger.valueOf(1));
		assertEquals(bill1.getServiceName(), SRV_NAME_INTERNET);
		assertEquals(bill1.getState(), BillState.NOT_PAID);
		assertEquals(bill1.getDueDate(), LocalDate.of(2021, 6, 2));
		assertEquals(bill1.getAmount(), BigDecimal.valueOf(500_000));
		assertEquals(bill1.getProviderName(), PROVIDER_VNPT);
		
		// assert bill 2
		Bills bill2 = account.findBillByNo(BigInteger.valueOf(2));
		assertEquals(bill2.getServiceName(), SRV_NAME_ELECTRIC);
		assertEquals(bill2.getState(), BillState.NOT_PAID);
		assertEquals(bill2.getDueDate(), LocalDate.of(2021, 6, 3));
		assertEquals(bill2.getAmount(), BigDecimal.valueOf(800_000));
		assertEquals(bill2.getProviderName(), PROVIDER_EVN);
	}
	
	@Test
	public void testRemoveBill() {
		
		Accounts accountTest = new Accounts();
		
		accountTest.addBill(new Bills(BigInteger.valueOf(1), 
				SRV_NAME_INTERNET, 
				BillState.NOT_PAID, 
				LocalDate.of(2021, 6, 2), 
				BigDecimal.valueOf(500_000), 
				PROVIDER_VNPT,
				null));
		
		assertNotNull(accountTest.getAllBills());
		assertEquals(accountTest.getAllBills().size(), 1);
		
		// assert bill 1
		Bills bill1 = accountTest.findBillByNo(BigInteger.valueOf(1));
		assertEquals(bill1.getServiceName(), SRV_NAME_INTERNET);
		assertEquals(bill1.getState(), BillState.NOT_PAID);
		assertEquals(bill1.getDueDate(), LocalDate.of(2021, 6, 2));
		assertEquals(bill1.getAmount(), BigDecimal.valueOf(500_000));
		assertEquals(bill1.getProviderName(), PROVIDER_VNPT);
		
	}
}
