package fr.eni.zylim.encheres.bll;

import java.util.ArrayList;
import java.util.List;



import fr.eni.zylim.encheres.bo.ArticleVendu;

import fr.eni.zylim.encheres.dal.ArticleVenduDAO;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.DAOFactory;


public class ArticleVenduManager {
	
private static ArticleVenduManager instance;
	
	private static ArticleVenduDAO dao;
	
	private ArticleVenduManager() {
		dao = DAOFactory.getArticleVenduDAO();
	};

	public static ArticleVenduManager getInstance() {
		if(instance == null) {
			instance = new ArticleVenduManager();
		}
		return instance;
	}
	
	public static List<ArticleVendu> selectAllArticle(){
		List<ArticleVendu> lesArticles = new ArrayList<ArticleVendu>();
		try {
		lesArticles = dao.selectAllArticle();
		} catch (DALException e) {
			e.printStackTrace();
			
		}
		return lesArticles;
	}
	

}














	


