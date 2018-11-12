package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Client;
import metier.Compte;
import metier.Conseiller;
import service.IConseillerService;
import service.Services;

/**
 * Servlet implementation class EffectuerVirement
 */
@WebServlet("/EffectuerVirement")
public class EffectuerVirement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IConseillerService service = new Services();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EffectuerVirement() {
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

			// 1- Récupération les paramètres
			int idClient = Integer.parseInt(request.getParameter("idclient"));
			int idCompteDebiteur = Integer.parseInt(request.getParameter("idcomptedebiteur"));
			int idCompteCrediteur = Integer.parseInt(request.getParameter("idcomptecrediteur"));
			double montant = Double.parseDouble(request.getParameter("montant"));

			
			// 2- Traitement avec la couche service
			Client client = service.afficherClient(conseiller, idClient);
			Compte compteCred = service.recupererCompteParId(idCompteCrediteur);
			Compte compteDeb = service.recupererCompteParId(idCompteDebiteur);

			if (service.effectuerVirement(conseiller, client, compteCred, compteDeb, montant)) {
				request.setAttribute("alertSuccess", "Le virement a bien eu lieu");
			} else {
				request.setAttribute("alertDanger", "Le virement n'a pas fonctionné");
			}
			request.getRequestDispatcher("AfficherClient?id=" + idClient).forward(request, response);

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
