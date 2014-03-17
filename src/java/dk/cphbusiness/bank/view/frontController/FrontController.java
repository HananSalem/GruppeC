/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.bank.view.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.view.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
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
   // Step 2
    @EJB
    private BankManager manager;
    
    // STEP 1
    public FrontController() {
        
    }

    //STEP 3
    @Override
    public void init() throws ServletException {
        
        super.init();
        Factory.getInstance().setManager(manager);
    }

    
    // STEP 4, 5,...
    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String key = request.getParameter("command");
        if (key == null) {
            key = "main";
        }
        Command command =Factory.getInstance().getCommand(key,request);
        String target = command.execute(request); // får fat på vores target, navnet på jsp siden som vi vil over til
        RequestDispatcher dispatcher = request.getRequestDispatcher(target); // de sidste to linjer : det er her man rent faktisk bliver sendt videre til det target man vil hen til
        dispatcher.forward(request, response);
    }

}
