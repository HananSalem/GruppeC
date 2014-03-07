/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.bank.view.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.view.Factory;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author lida
 */
public class ListCustomerAccountsCommand extends TargetCommand {
    

    public ListCustomerAccountsCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
        
    }

   
    @Override
    public String execute(HttpServletRequest request) {
        
        String cpr = request.getParameter("cpr");
        System.out.println("cpr = "+cpr);
        BankManager manager = Factory.getInstance().getManager();
        CustomerIdentifier customer = CustomerIdentifier.fromString(cpr);
        Collection<AccountSummary> customerAccounts = manager.listCustomerAccounts(customer);

        request.setAttribute("customerAccounts", customerAccounts);
        request.setAttribute("cpr", cpr);
   
        return super.execute(request);
    }

}
