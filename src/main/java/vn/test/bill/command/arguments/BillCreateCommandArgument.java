package vn.test.bill.command.arguments;

import java.math.BigDecimal;
import java.time.LocalDate;

import vn.test.bill.enums.Commands;

public class BillCreateCommandArgument extends CommandArgument {

	private String serviceName;
	private String provider;
	private BigDecimal amount;
	private LocalDate dueDate;
	
	public BillCreateCommandArgument(Commands command, String serviceName, String provider, BigDecimal amount,
			LocalDate dueDate) {
		
		super(command);
		this.serviceName = serviceName;
		this.provider = provider;
		this.amount = amount;
		this.dueDate = dueDate;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getProvider() {
		return provider;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}
	
}
