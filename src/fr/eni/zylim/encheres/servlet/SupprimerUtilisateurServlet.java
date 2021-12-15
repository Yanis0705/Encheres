package fr.eni.zylim.encheres.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.zylim.encheres.bll.UtilisateurManager;
import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;

/**
 * Servlet implementation class SupprimerUtilisateurServlet
 */
@WebServlet(name = "supprimerutilisateur", urlPatterns = { "/supprimerutilisateur" })

public class SupprimerUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilis = new UtilisateurManager();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupprimerUtilisateurServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Utilisateur use = (Utilisateur) request.getSession(false).getAttribute("userlogin");

		int no_utilisateur = use.getNo_utilisateur();
		System.out.println(no_utilisateur);
		try {
			utilis.authenticate_Pseudo_delete(no_utilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/Connexion.jsp").forward(request, response);

	}

}
