/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.bank.view.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import dk.cphbusiness.bank.view.Factory;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Hanan
 */
public class AccountDetailCommand extends TargetCommand {

    
    public AccountDetailCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
        
    }

    @Override
    public String execute(HttpServletRequest request) {
        
        BankManager manager = Factory.getInstance().getManager();
        
        String number = request.getParameter("number");
        AccountIdentifier accountIdentifier = AccountIdentifier.fromString(number);

        AccountDetail accountDetail = manager.showAccountHistory(accountIdentifier);

        request.setAttribute("accountDetail", accountDetail);
      
        return super.execute(request);  //returnerer den side man vil hen til
    }
}
