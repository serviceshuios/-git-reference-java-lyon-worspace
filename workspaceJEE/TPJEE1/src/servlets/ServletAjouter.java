package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Client;
import service.ClientService;
import service.IClientService;

/**
 * Servlet implementation class ServletAjouter
 */
@WebServlet("/ServletAjouter")
public class ServletAjouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IClientService service = new ClientService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjouter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1- récupérer les paramètres
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String yeux = request.getParameter("cy");
				String age = request.getParameter("age");
				//2- traitements avec couche service
				Client c = new Client();
				c.setNom(nom);
				c.setPrenom(prenom);
				c.setCouleurYeux(yeux);
				c.setAge(Integer.parseInt(age));
				service.ajouterClient(c);
				//3- préparation envoi
				request.setAttribute("lenom", nom);
				request.setAttribute("leprenom", prenom);
				
				//4- envoi
				request.getRequestDispatcher("/ajouter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
