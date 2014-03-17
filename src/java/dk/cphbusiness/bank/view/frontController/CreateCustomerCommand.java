/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.bank.view.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.contract.dto.CustomerSummary;
import dk.cphbusiness.bank.view.Factory;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Hanan
 */
public class CreateCustomerCommand extends TargetCommand {

    public CreateCustomerCommand(String target, List<SecurityRole> roles) {
        super(target, roles);

    }

    @Override
    public String execute(HttpServletRequest request) {

        BankManager manager = Factory.getInstance().getManager();
        String cpr = request.getParameter("cpr");
        String title = request.getParameter("title");
        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");
        String street = request.getParameter("street");
        String postalcode = request.getParameter("postalCode");
        String postaldistrict = request.getParameter("postalDistrict");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        CustomerDetail customer = manager.saveCustomer(new CustomerDetail(cpr, title, firstname, lastname, street, postalcode, postaldistrict, phone, email));
        Collection<CustomerSummary> customerlist = manager.listCustomers(); 
        // den gemmer automatisk customer i listen med Customers
        
        request.setAttribute("customers", customerlist);
        
     
        return super.execute(request); 
    }

}
