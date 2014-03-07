/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.bank.view.frontController;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Hanan
 */
public class GoToTransferCommand extends TargetCommand{

    public GoToTransferCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
        
    }
    

    @Override
    public String execute(HttpServletRequest request) {
        
        String cpr = request.getParameter("cpr");
        System.out.println("cpr ="+cpr);
        request.setAttribute("cpr", cpr);
        
          
        return super.execute(request);
    }
   
}
