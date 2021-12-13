package fr.eni.zylim.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class AjouterUtilisateurServlet
 */
@WebServlet(name = "ajouterutilisateur",

		urlPatterns = { "/ajouterutilisateur" })
public class AjouterUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterUtilisateurServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO chemin si dessous provisoire
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/Inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		

}
}