package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Conseiller;
import service.ILoginService;
import service.Services;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// mdéfini l'encodage des paramètres en UTF-8
		request.setCharacterEncoding("UTF-8");
		
		// 1- Récupération les paramètres
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");

		// 2- Traitement avec la couche service
		ILoginService ls = new Services();
		Conseiller conseiller = ls.verificationLogin(login, pwd);
		
		// verifie si le conseiller existe
		if (conseiller.getIdConseiller() != 0) {
			// creer session
			HttpSession session = request.getSession();
			session.setAttribute("conseiller", conseiller);
			
			// Redirige vers la servlet ListerClients
			//response.sendRedirect("ListerClients");
			request.getRequestDispatcher("ListerClients").forward(request, response);
		} else {
			// 3- Préparation de l'envoi
			request.setAttribute("alertDanger", "Echec identification conseiller, veuillez réessayer.");
			// 4 Envoi vers la JSP d'identification
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
