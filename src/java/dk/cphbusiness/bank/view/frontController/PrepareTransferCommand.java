package dk.cphbusiness.bank.view.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.eto.InsufficientFundsException;
import dk.cphbusiness.bank.contract.eto.NoSuchAccountException;
import dk.cphbusiness.bank.contract.eto.TransferNotAcceptedException;
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
public class PrepareTransferCommand extends TargetCommand {

    public PrepareTransferCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
        
    }

    @Override
    public String execute(HttpServletRequest request) {

        String s = request.getParameter("source");
        String t = request.getParameter("target");
        
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        AccountIdentifier source = AccountIdentifier.fromString(s);
        AccountIdentifier target = AccountIdentifier.fromString(t);

        BankManager manager = Factory.getInstance().getManager();
        try {
            AccountDetail transfer = manager.transferAmount(amount, source, target);
            request.setAttribute("accountDetail", transfer);

        } catch (NoSuchAccountException ex) {
            Logger.getLogger(PrepareTransferCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransferNotAcceptedException ex) {
            Logger.getLogger(PrepareTransferCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InsufficientFundsException ex) {
            Logger.getLogger(PrepareTransferCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        return super.execute(request);
    }

}
