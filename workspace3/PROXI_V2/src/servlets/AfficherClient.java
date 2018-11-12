package servlets;

import java.io.IOException;

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
 * Servlet implementation class AfficherClient
 */
@WebServlet("/AfficherClient")
public class AfficherClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IConseillerService service = new Services();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficherClient() {
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

			int id = Integer.parseInt(request.getParameter("id"));

			Client client = service.afficherClient(conseiller, id);
			request.setAttribute("client", client);
			
			// par defaut on affiche le client
			if(request.getParameter("action") == null || !request.getParameter("action").equals("modifier")){
				request.getRequestDispatcher("/afficherClient.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("/modifierClient.jsp").forward(request, response);
			}
		} else {
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
