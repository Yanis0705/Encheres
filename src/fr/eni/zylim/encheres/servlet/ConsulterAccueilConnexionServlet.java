package fr.eni.zylim.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.zylim.encheres.bll.ArticleVenduManager;

import fr.eni.zylim.encheres.bll.BLLException;

import fr.eni.zylim.encheres.bo.ArticleVendu;

/**
 * Servlet implementation class ConsulterAvecConnexion
 */
@WebServlet("/consulteraccueilconnexion")
public class ConsulterAccueilConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterAccueilConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	
		List<ArticleVendu> listeArticle = ArticleVenduManager.getInstance().selectAllArticle();
	
		
		System.out.println("listeArticle : " + listeArticle);
		
		// Déposer les objets nécessaires aux composants suivants
		request.setAttribute("lesArticles", listeArticle);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
