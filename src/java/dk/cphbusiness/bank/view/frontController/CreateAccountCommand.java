/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.bank.view.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CheckingAccountDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.dto.TransferSummary;
import dk.cphbusiness.bank.contract.eto.CustomerBannedException;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import dk.cphbusiness.bank.view.Factory;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Hanan
 */
public class CreateAccountCommand extends TargetCommand {

    public CreateAccountCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request) {

        String cpr = request.getParameter("cpr");
        String number = request.getParameter("number");
        BigDecimal interest = new BigDecimal(request.getParameter("interest"));
        
        BankManager manager = Factory.getInstance().getManager();
        CustomerIdentifier ci = CustomerIdentifier.fromString(cpr);

        CheckingAccountDetail accountDetail = new CheckingAccountDetail(interest);
        try {
            manager.createAccount(ci, accountDetail);
        } catch (NoSuchCustomerException ex) {
            Logger.getLogger(CreateAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CustomerBannedException ex) {
            Logger.getLogger(CreateAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collection<AccountSummary> accounts = manager.listAccounts();
        request.setAttribute("accounts", accounts);
        
        return super.execute(request);
    }

}
