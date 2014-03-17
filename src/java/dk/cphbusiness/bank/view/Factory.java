package dk.cphbusiness.bank.view;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.view.frontController.AccountDetailCommand;
import dk.cphbusiness.bank.view.frontController.Command;
import dk.cphbusiness.bank.view.frontController.CreateAccountCommand;
import dk.cphbusiness.bank.view.frontController.CreateCustomerCommand;
import dk.cphbusiness.bank.view.frontController.GoToTransferCommand;
import dk.cphbusiness.bank.view.frontController.ListCustomerAccountsCommand;
import dk.cphbusiness.bank.view.frontController.ListCustomersCommand;
import dk.cphbusiness.bank.view.frontController.LoginCommand;
import dk.cphbusiness.bank.view.frontController.LogoutCommand;
import dk.cphbusiness.bank.view.frontController.PrepareTransferCommand;
import dk.cphbusiness.bank.view.frontController.SayHelloCommand;
import dk.cphbusiness.bank.view.frontController.ShowCustomerDetailCommand;
import dk.cphbusiness.bank.view.frontController.ShowLoginCommand;
import dk.cphbusiness.bank.view.frontController.TargetCommand;
import dk.cphbusiness.dummy.bank.control.DummyBankManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

public class Factory {
   // BankManager bankManagerBean = lookupBankManagerBeanRemote();

    private static Factory instance = null;
    private BankManager manager;

    private final Map<String, Command> commands = new HashMap<>();

    private Factory() {
        
        //manager = new DummyBankManager();
        
        Map<SecurityRole, String> roles = new HashMap<>();
        roles.put(SecurityRole.Customer, "account-list.jsp");
        roles.put(SecurityRole.AccountManager, "main.jsp");

        // første del
        commands.put("back", new TargetCommand("main.jsp", Arrays.asList(SecurityRole.All)));
        commands.put("main", new TargetCommand("main.jsp", Arrays.asList(SecurityRole.All)));
        commands.put("list-customers", new ListCustomersCommand("customer-list.jsp", Arrays.asList(SecurityRole.Customer)));
        commands.put("customer-accounts", new ListCustomerAccountsCommand("account-list.jsp", Arrays.asList(SecurityRole.Customer)));
        commands.put("account-detail", new AccountDetailCommand("account-detail.jsp", Arrays.asList(SecurityRole.Customer)));
        commands.put("prepare-transfer", new GoToTransferCommand("transfer-edit.jsp", Arrays.asList(SecurityRole.Customer)));
        commands.put("transfer-amount", new PrepareTransferCommand("account-detail.jsp", Arrays.asList(SecurityRole.Customer)));

        //security 
        commands.put("login", new LoginCommand(roles, "login.jsp")); //den skiller sig ud, kig pp loginCommands konstruktør/arver ikke fra targetCommand, men fra command
        commands.put("logout", new LogoutCommand("main.jsp", Arrays.asList(SecurityRole.All)));
        commands.put("showlogin", new ShowLoginCommand("login.jsp", Arrays.asList(SecurityRole.All)));

        // anden del
        commands.put("showCreateCustomer", new TargetCommand("customer-edit.jsp", Arrays.asList(SecurityRole.AccountManager)));
        commands.put("create-customer", new CreateCustomerCommand("customer-list.jsp", Arrays.asList(SecurityRole.AccountManager)));
        commands.put("customerDetail", new ShowCustomerDetailCommand("customer-detail.jsp", Arrays.asList(SecurityRole.AccountManager)));
        commands.put("showCreateAccount", new TargetCommand("account-edit.jsp", Arrays.asList(SecurityRole.AccountManager)));
        commands.put("createCheckingAccount", new CreateAccountCommand("all-customer-accounts.jsp", Arrays.asList(SecurityRole.AccountManager)));
        commands.put("allcustomersaccounts", new TargetCommand("all-customer-accounts.jsp", Arrays.asList(SecurityRole.AccountManager)));
       
        // afprøver den nye backend
        commands.put("sayHello", new SayHelloCommand("hello.jsp", Arrays.asList(SecurityRole.All)));
    }
    

    private void securityCheck(Command command, HttpServletRequest request) throws SecurityException {
        if (command instanceof TargetCommand) {
            List<SecurityRole> requiredRoles = ((TargetCommand) command).getRoles();
            boolean requiredRoleFound = false;
            for (SecurityRole requiredRole : requiredRoles) {
                if (requiredRole == SecurityRole.All || request.isUserInRole(requiredRole.toString())) {
                    requiredRoleFound = true;
                    break;
                }
            }
            if (!requiredRoleFound) {
                throw new SecurityException("You don't have the necessary rights to perform this command");
            }
        }
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public BankManager getManager() {
        return manager;
    }
    
    public void setManager(BankManager manager){
    this.manager = manager;
    }

    public Command getCommand(String key, HttpServletRequest request) {
        Command command = commands.get(key);
        securityCheck(command, request);
        return commands.get(key);

    }

   

}
