package vn.test.bill.command.arguments;

import vn.test.bill.enums.Commands;

public class CommandArgument {
	private Commands command;

	
	public CommandArgument(Commands command) {
		super();
		this.command = command;
	}


	public Commands getCommand() {
		return command;
	}
	
}
