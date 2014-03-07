/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.bank.view.frontController;

import dk.cphbusiness.bank.view.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import security.SecurityRole;

/**
 *
 * @author Hanan
 */
@WebServlet(name = "FrontController", urlPatterns = {"/Controller"})
public class FrontController extends HttpServlet {
//
//    private final Map<String, Command> commands = new HashMap<>();

    public FrontController() {
//        Map<SecurityRole, String> roles = new HashMap<>();
//        roles.put(SecurityRole.Customer, "account-list.jsp");
//
//        // commands.put("list-accounts", new ListAccountsCommand("account-list.jsp", Arrays.asList(SecurityRole.Customer)));
//        commands.put("back", new TargetCommand("main.jsp", Arrays.asList(SecurityRole.All)));
//        commands.put("main", new TargetCommand("main.jsp", Arrays.asList(SecurityRole.All)));
//        commands.put("list-customers", new ListCustomersCommand("customer-list.jsp", Arrays.asList(SecurityRole.Customer)));
//        commands.put("customer-accounts", new ListCustomerAccountsCommand("account-list.jsp", Arrays.asList(SecurityRole.Customer)));
//        commands.put("account-detail", new AccountDetailCommand("account-detail.jsp", Arrays.asList(SecurityRole.Customer)));
//        commands.put("prepare-transfer", new GoToTransferCommand("transfer-edit.jsp", Arrays.asList(SecurityRole.Customer)));
//        commands.put("transfer-amount", new PrepareTransferCommand("account-detail.jsp", Arrays.asList(SecurityRole.Customer)));
//        commands.put("login", new LoginCommand(roles, "login.jsp")); //den skiller sig ud, kig pp loginCommands konstruktør/arver ikke fra targetCommand, men fra command
//        commands.put("logout", new LogoutCommand("main.jsp", Arrays.asList(SecurityRole.All)));
//        commands.put("showlogin", new ShowLoginCommand("login.jsp", Arrays.asList(SecurityRole.All)));
    }

    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String key = request.getParameter("command");
        if (key == null) {
            key = "main";
        }
        Command command = commands.get(key); 
        String target = command.execute(request); // får fat på vores target, navnet på jsp siden som vi vil over til
        RequestDispatcher dispatcher = request.getRequestDispatcher(target); // de sidste to linjer : det er her man rent faktisk bliver sendt videre til det target man vil hen til
        dispatcher.forward(request, response);
    }

}
