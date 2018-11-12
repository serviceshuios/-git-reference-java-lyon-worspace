package servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Client;
import metier.Conseiller;
import service.IConseillerService;
import service.Services;

/**
 * Servlet implementation class ListerClients
 */
@WebServlet("/ListerClients")
public class ListerClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IConseillerService service = new Services();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerClients() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// défini l'encodage des paramètres en UTF-8
		request.setCharacterEncoding("UTF-8");
		
		//vérifie la session
		HttpSession session = request.getSession();
		if(session.getAttribute("conseiller") != null){
			Conseiller conseiller = (Conseiller) session.getAttribute("conseiller");
			Collection<Client> clients = service.listerClients(conseiller);
			request.setAttribute("clients",	clients);
			
			request.getRequestDispatcher("/listerClients.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
