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
import fr.eni.zylim.encheres.bo.ArticleVendu;
import fr.eni.zylim.encheres.bo.Categorie;
import fr.eni.zylim.encheres.bo.Retrait;
import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;

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
		ArticleVendu article = new ArticleVendu();
		
		String nom = request.getParameter("article");
		String description = request.getParameter("description");
		
		ZoneId systemTimeZone = ZoneId.systemDefault();
		LocalDate utilDateDebutEncheres  = LocalDate.parse(request.getParameter("dateDebutEnchere"));
		ZonedDateTime zonedDateTime = utilDateDebutEncheres.atStartOfDay(systemTimeZone);
		Date dateDebutEncheres = Date.from(zonedDateTime.toInstant());
		
		LocalDate utilDateFinEncheres  = LocalDate.parse(request.getParameter("dateFinEnchere"));
		ZonedDateTime zonedDateTime2 = utilDateFinEncheres.atStartOfDay(systemTimeZone);
		Date dateFinEncheres = Date.from(zonedDateTime2.toInstant());
		
		int miseAPrix = Integer.parseInt(request.getParameter("prixBase"));
		int categorieId = Integer.parseInt(request.getParameter("categorie"));
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		Categorie categorie;

		try {
			categorie = CategorieManager.selectionnerCategorieById(categorieId);


		Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
		Retrait retrait = new Retrait();
			
		retrait = new Retrait();
		retrait.setRue(rue);
		retrait.setCode_postal(codePostal);
		retrait.setVille(ville);
			

		RetraitManager.ajouterLieuRetrait(retrait);			
		
		article.setNom_article(nom);
		article.setDescription(description);
		article.setDate_debut_encheres((java.sql.Date) dateDebutEncheres);
		article.setDate_fin_encheres((java.sql.Date) dateFinEncheres);
		article.setPrix_initial(miseAPrix);
		article.setCategorie(categorie);
		article.setRetrait(retrait);
		article.setVendeur(utilisateur);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ArticleVenduManager.nouvelleVente(article);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("ArticleAffiche", article);
		this.getServletContext().getRequestDispatcher("/detailventeservlet").forward(request, response);
		
	}
}
