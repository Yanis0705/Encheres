package fr.eni.zylim.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.zylim.encheres.bll.BLLException;
import fr.eni.zylim.encheres.bll.UtilisateurManager;
import fr.eni.zylim.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ConsulterUtilisateurServlet
 */
@WebServlet("/consulterutilisateur")
public class ConsulterUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// Appel les traitements métier :
				// recuperer la liste de tous les utilisateurs
		
				
			
				
				try {
					Utilisateur utilisateur;
					UtilisateurManager.getInstance();
					utilisateur = UtilisateurManager.getUtilisateur(3);
					System.out.println(utilisateur);
				
				// enregistre les infos dans un Utilisateur
				
		
				
					String pseudo=request.getParameter("pseudo");
				//  recuperer les infos de l'utilisateur qu'on doit afficher
				request.setAttribute("pseudo", pseudo);
				
				// Déposer les objets nécessaires aux composants suivants
				request.setAttribute("utilisateur", utilisateur);
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				getServletContext().getRequestDispatcher("/WEB-INF/jsp/Profil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
