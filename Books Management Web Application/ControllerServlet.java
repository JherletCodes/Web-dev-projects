package com.ICS2609JSPCRUDample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountDAO accountDAO;
	
	public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        accountDAO = new AccountDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
        try {
            switch (action) {
            case "/new":
                break;
            case "/insert":
                break;
            case "/delete":
                break;
            case "/edit":
                break;
            case "/update":
                break;
            default:
                listAccount(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	private void listAccount(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		//list object from the DAO object
		List<Account> listAccount = accountDAO.listAllAccounts();
		request.setAttribute("listAccount", listAccount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AccountList.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
