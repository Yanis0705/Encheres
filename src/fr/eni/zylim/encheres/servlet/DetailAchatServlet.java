package fr.eni.zylim.encheres.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.zylim.encheres.bll.CategorieManager;
import fr.eni.zylim.encheres.bll.RetraitManager;
import fr.eni.zylim.encheres.bll.UtilisateurManager;
import fr.eni.zylim.encheres.bo.ArticleVendu;
import fr.eni.zylim.encheres.bo.Categorie;
import fr.eni.zylim.encheres.bo.Retrait;
import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;

/**
 * Servlet implementation class DetailAchatServlet
 */
@WebServlet("/detailachatservlet")
public class DetailAchatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailAchatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("user");
	    Utilisateur utilisateurActuel = UtilisateurManager.getUtilisateurProfile(name);
		ArticleVendu articleAVendre;
		Categorie categorieArticle;
		Retrait retraitArticle;
		Utilisateur vendeur;
		
		articleAVendre = (ArticleVendu) request.getAttribute("ArticleAffiche");
		
		request.setAttribute("NomArticle", articleAVendre.getNom_article());
		request.setAttribute("Description", articleAVendre.getDescription());
		
		int noCategorie = articleAVendre.getNo_categorie();		
		try {
			categorieArticle = CategorieManager.selectionnerCategorieById(noCategorie);		
		request.setAttribute("Categorie", categorieArticle.getLibelle());
		
		///TODO Meilleure offre
//		request.setAttribute("MeilleurePrixVente", articleAVendre.getNom_article());
//		request.setAttribute("AcheteurMeilleurPrix", articleAVendre.getNom_article());
		
		request.setAttribute("MiseAPrix", articleAVendre.getPrix_initial());
		LocalDate date = articleAVendre.getDate_fin_encheres();
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String dateFormatFr = date.format(formatters);
		request.setAttribute("DateFinEnchere", dateFormatFr);
		
		int noArticle = articleAVendre.getNo_article();
		retraitArticle = RetraitManager.selectionnerRetraitByNoArticle(noArticle);
		
		request.setAttribute("RueRetrait", retraitArticle.getRue());
		request.setAttribute("CodePostalRetrait", retraitArticle.getCode_postal());
		request.setAttribute("VilleRetrait", retraitArticle.getVille());
		
		int noVendeur = articleAVendre.getNo_utilisateur();
		vendeur = UtilisateurManager.getUtilisateurById(noVendeur);
		request.setAttribute("PseudoVendeur", vendeur.getPseudo());
		
		request.setAttribute("NoUtilisateurActuel", utilisateurActuel.getNo_utilisateur());
		request.setAttribute("NoUtilisateurVendeur", vendeur.getNo_utilisateur());
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/DetailAchat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
