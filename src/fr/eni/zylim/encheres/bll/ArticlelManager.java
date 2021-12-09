package fr.eni.zylim.encheres.bll;

import java.sql.Date;
import java.util.List;

import fr.eni.zylim.encheres.bo.Article;
import fr.eni.zylim.encheres.dal.ArticleDAO;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.DAOFactory;


public class ArticlelManager {
	
	private static ArticlelManager instance;
	
	public static ArticlelManager getInstance() {
		if(instance == null) {
			instance = new ArticlelManager();
		}
		return instance;
	}
	
	private ArticlelManager() { }
	
	private ArticleDAO dao = DAOFactory.getArticleDAO();
	
	public List<Article> getListeArticles() throws BLLException {
		try {
			return dao.selectAllArticle();
		} catch (DALException e) {
			e.printStackTrace();
			BLLException ex = new BLLException();
			throw ex;
		}
	}
	
	public Article getArticle(int id) throws BLLException {
		BLLException ex = new BLLException();
		
		validationId(id, ex);
		
		if(ex.hasErreur()) {
			throw ex;
		}
		
		try {
			return dao.selectArticleById(id);
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}
	}

	private void validationId(int no_Article, BLLException ex) throws BLLException {
		if(no_Article < 1) {
			ex.ajouterErreur(new ParameterException("Le no_article doit être un entier positif >= 1"));
		}
	}

//public Article addArticle(String nom_article, String description, Date date_debut_encheres,
//		Date date_fin_encheres, int prix_initial, int no_utilisateur, int no_categorie,
//		boolean etat_vente) throws BLLException {
//
//BLLException ex = new BLLException();
//
//validationNomArticle(nom_article, ex);
//validationDescription(description, ex);		
//validationDateDebutEnchere(date_debut_encheres, ex);
//validationDateFinEncheres(date_fin_encheres, ex);
//validationPrixInitial(prix_initial, ex);
//
//Article article;
//article = new Article(nom_article, description, date_debut_encheres,
//		date_fin_encheres, prix_initial, no_utilisateur, no_categorie,
//		etat_vente);
//
//// TODO intégrer le retrait
//
//if(ex.hasErreur()) {
//throw ex;
//}
//
//try {
//dao.insertArticle(article);
//} catch (DALException e) {
//e.printStackTrace();
//ex.ajouterErreur(e);
//throw ex;
//}
//
//return article;
//}

}
















