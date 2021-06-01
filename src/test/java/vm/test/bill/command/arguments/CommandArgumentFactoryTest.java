package vm.test.bill.command.arguments;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import vn.test.bill.command.arguments.BillCreateCommandArgument;
import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.arguments.CommandArgumentFactory;

public class CommandArgumentFactoryTest {
	
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	@Test
	public void testCommandNotFound() {
		
		assertThrows(IllegalArgumentException.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				
				CommandArgument arg = CommandArgumentFactory.getArgument(new String[] { "ADD_BILL_XXXX", "ELECTRIC", "EVN HCM", "200000" });
			}
		});
	}

	@Test
	public void testAddBillSuccess() {
		
		CommandArgument arg = CommandArgumentFactory.getArgument(new String[] { "ADD_BILL", "ELECTRIC", "EVN HCM", "200000", "01/06/2021" });
		
		assertTrue(arg instanceof BillCreateCommandArgument);
		
		BillCreateCommandArgument cmdArg = (BillCreateCommandArgument) arg;
		assertTrue("ELECTRIC".equals(cmdArg.getServiceName()));
		assertTrue(BigDecimal.valueOf(Long.valueOf("200000")).equals(cmdArg.getAmount()));
		assertTrue(LocalDate.parse("01/06/2021", DateTimeFormatter.ofPattern(DATE_FORMAT)).equals(cmdArg.getDueDate()));
		assertTrue("EVN HCM".equals(cmdArg.getProvider()));
	}
	
	@Test
	public void testAddBillWithInvalidArgument() {
		
		assertThrows(IllegalArgumentException.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				
				CommandArgument arg = CommandArgumentFactory.getArgument(new String[] { "ADD_BILL", "ELECTRIC", "EVN HCM", "200000" });
			}
		});
		
		assertThrows(IllegalArgumentException.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				
				CommandArgument arg = CommandArgumentFactory.getArgument(new String[] { "ADD_BILL", "ELECTRIC", "EVN HCM", "ABCX", "01/06/2021" });
			}
		});
	}
}
