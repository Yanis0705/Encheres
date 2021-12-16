package fr.eni.zylim.encheres.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.zylim.encheres.bll.ArticleVenduManager;
import fr.eni.zylim.encheres.bll.CategorieManager;
import fr.eni.zylim.encheres.bll.RetraitManager;
import fr.eni.zylim.encheres.bll.UtilisateurManager;
import fr.eni.zylim.encheres.bo.ArticleVendu;
import fr.eni.zylim.encheres.bo.Categorie;
import fr.eni.zylim.encheres.bo.Retrait;
import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.jdbc.ArticleVenduDAOJdbcImpl;

/**
 * Servlet implementation class VendreArticleServler
 */
@WebServlet("/vendrearticle")
public class VendreArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/NouvelleVente.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		LocalDate dateDebutEncheres  = LocalDate.parse(request.getParameter("dateDebutEnchere"));
		LocalDate dateFinEncheres  = LocalDate.parse(request.getParameter("dateFinEnchere"));
		int miseAPrix = Integer.parseInt(request.getParameter("prixBase"));
		int categorieId = Integer.parseInt(request.getParameter("categorie"));
		
	    String name = (String) session.getAttribute("user");
	    Utilisateur utilisateur = UtilisateurManager.getUtilisateurProfile(name);
	     int noUtil =  utilisateur.getNo_utilisateur();

		ArticleVendu article = new ArticleVendu(nom, description, dateDebutEncheres, dateFinEncheres, miseAPrix, miseAPrix, noUtil, categorieId, false);

		
	

System.out.println(article);
		
			try {
				ArticleVenduManager articleVenduManager  = new ArticleVenduManager();
				ArticleVendu nouvelArticle = articleVenduManager.nouvelleVente(article);
				System.out.println(article);

				int noArticle = nouvelArticle.getNo_article();
				String rue = request.getParameter("rue");
				String codePostal = request.getParameter("codePostal");
				String ville = request.getParameter("ville");
				
				Retrait retrait = new Retrait(noArticle, rue, codePostal, ville);
				
				try {
					RetraitManager.ajouterLieuRetrait(retrait);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		request.setAttribute("ArticleAffiche", article);
		this.getServletContext().getRequestDispatcher("/detailachatservlet").forward(request, response);
		
	}
}
