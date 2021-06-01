package vn.test.bill.command.response;

import vn.test.bill.command.response.data.CommandResponseData;
import vn.test.bill.enums.CommandState;

public class CommandResponse {
	private CommandState status;
	private CommandResponseData data;
	public CommandResponse(CommandState status, CommandResponseData data) {
		super();
		this.status = status;
		this.data = data;
	}
	public CommandState getStatus() {
		return status;
	}
	public CommandResponseData getData() {
		return data;
	}
	
	public static CommandResponse ok() {
		
		return new CommandResponse(CommandState.OK, null);
	}
	
	public static CommandResponse ok(CommandResponseData data) {
		
		return new CommandResponse(CommandState.OK, data);
	}
	
	public static CommandResponse error(CommandResponseData data) {
		
		return new CommandResponse(CommandState.FAILED, data);
	}
}