package dk.cphbusiness.bank.view.frontController;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

public class TargetCommand implements Command {
  private final String target;
  private List<SecurityRole> roles;

  public TargetCommand(String target, List<SecurityRole> roles) {
    this.target = target;
    this.roles = roles;
    }
  
  @Override
  public String execute(HttpServletRequest request) {
    return target;
    }

    public List<SecurityRole> getRoles() {
        return roles;
    }

  
  
  }
