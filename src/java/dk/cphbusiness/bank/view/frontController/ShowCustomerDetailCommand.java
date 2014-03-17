/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.bank.view.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import dk.cphbusiness.bank.view.Factory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Hanan
 */
public class ShowCustomerDetailCommand extends TargetCommand {

    public ShowCustomerDetailCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request) {
        
        String cpr = request.getParameter("cpr");
        BankManager manager = Factory.getInstance().getManager();
        CustomerIdentifier customerIdentifier = CustomerIdentifier.fromString(cpr);
        
        
        try {
            
            CustomerDetail customerDetail = manager.showCustomer(customerIdentifier);
            request.setAttribute("customerDetail", customerDetail);
            
        } catch (NoSuchCustomerException ex) {
            Logger.getLogger(ShowCustomerDetailCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        return super.execute(request);
    }

}
