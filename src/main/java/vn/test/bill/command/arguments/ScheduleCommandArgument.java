package vn.test.bill.command.arguments;

import java.math.BigInteger;
import java.time.LocalDate;

import vn.test.bill.enums.Commands;

public class ScheduleCommandArgument extends CommandArgument {

	private BigInteger billNo;
	private LocalDate scheduledDate;
	
	public ScheduleCommandArgument(Commands command, BigInteger billNo, LocalDate scheduledDate) {
		
		super(command);
		this.billNo = billNo;
		this.scheduledDate = scheduledDate;
	}

	public BigInteger getBillNo() {
		return billNo;
	}

	public LocalDate getScheduledDate() {
		return scheduledDate;
	}
	
}
