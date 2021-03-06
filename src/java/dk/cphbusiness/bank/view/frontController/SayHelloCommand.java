
package dk.cphbusiness.bank.view.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.view.Factory;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Hanan
 */
public class SayHelloCommand extends TargetCommand{

    public SayHelloCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request) {
        
        BankManager manager = Factory.getInstance().getManager();
                String greeting = manager.sayHello("Kurt");
                request.setAttribute("greeting", greeting);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
