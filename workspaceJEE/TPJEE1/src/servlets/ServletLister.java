package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Client;
import service.ClientService;
import service.IClientService;

/**
 * Servlet implementation class ServletLister
 */
@WebServlet("/ServletLister")
public class ServletLister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IClientService service = new ClientService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1- récupérer les éléments de la bdd
		//2- traitements avec couche service
		List<Client> lesClients = new ArrayList<Client>();
		lesClients = (List<Client>) service.listerClients();
	
		//3- préparation envoi
		request.setAttribute("lesClients", lesClients);
		//4- envoi
		request.getRequestDispatcher("/listerClientsjstl.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
