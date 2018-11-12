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
 * Servlet implementation class ModifierClient
 */
@WebServlet("/ModifierClient")
public class ModifierClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IConseillerService service = new Services();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifierClient() {
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

		// vérifie la session
		HttpSession session = request.getSession();
		if (session.getAttribute("conseiller") != null) {
			Conseiller conseiller = (Conseiller) session.getAttribute("conseiller");
			int idClient = Integer.parseInt(request.getParameter("id"));

			// récupération des paramètres
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");
			String ville = request.getParameter("ville");
			String codePostal = request.getParameter("codepostal");
			String telephone = request.getParameter("telephone");
			String email = request.getParameter("email");

			// modification du client
			if (service.modifierClient(conseiller, idClient, nom, prenom, email, adresse, codePostal, ville,
					telephone)) {
				request.setAttribute("alertSuccess", "Le client a bien été modifié");
			} else {
				request.setAttribute("alertDanger", "Le client n'a pas été modifié");
			}

			// récupération du client en base
			Client client = service.afficherClient(conseiller, id);

			request.setAttribute("client", client);
			request.getRequestDispatcher("/modifierClient.jsp").forward(request, response);

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
