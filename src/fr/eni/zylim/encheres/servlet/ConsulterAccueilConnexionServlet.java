package fr.eni.zylim.encheres.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.zylim.encheres.bll.ArticleVenduManager;
import fr.eni.zylim.encheres.bll.QueyCollection;
import fr.eni.zylim.encheres.bo.ArticleVendu;
import fr.eni.zylim.encheres.dal.DALException;

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
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		List<QueyCollection> listeArticle = null;
		listeArticle = ArticleVenduManager.getInstance().selectAllArticleRetraitMang();


		
		System.out.println("listeArticle : " + listeArticle);
		// Déposer les objets nécessaires aux composants suivants
		request.setAttribute("lesArticles", listeArticle);
//		request.setAttribute("mesUtilisateurs", mesUtilisateurs );
	
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp").forward(request, response);
	
	}

}
