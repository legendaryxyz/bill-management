package vn.test.bill;

import java.util.Scanner;

import vn.test.bill.command.BillCommand;
import vn.test.bill.command.CommandFactory;
import vn.test.bill.command.arguments.CommandArgument;
import vn.test.bill.command.arguments.CommandArgumentFactory;
import vn.test.bill.command.response.CommandResponse;
import vn.test.bill.enums.Commands;
import vn.test.bill.models.Accounts;
import vn.test.bill.view.BillConsoleViewFactory;

public class BillManagementApplication {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String command = null;
		Accounts account = new Accounts();
		
		while(!Commands.EXIT.equals(command)) {
			
			System.out.println("Please type command?");
			command = in.nextLine();
			
			if("".equals(command)) {
				continue;
			}
			
			String[] arguments = command.split(" ");
			
			if(arguments.length == 0) {
				System.out.println("Please enter a valid command!!!");
			}
			
			try {
				CommandArgument commandArg = CommandArgumentFactory.getArgument(arguments);
				BillCommand billCommand = CommandFactory.getCommand(commandArg.getCommand());
				billCommand.withAccount(account);
				
				CommandResponse response = billCommand.execute(commandArg);
				BillConsoleViewFactory.getView(commandArg.getCommand()).view(response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		in.close();
		System.out.println("Good bye!");
	}
}
