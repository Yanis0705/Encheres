package fr.eni.zylim.encheres.dal;

import fr.eni.zylim.encheres.dal.jdbc.ArticleDAOJdbcImpl;
import fr.eni.zylim.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;


public class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl() ;
	}
	
	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOJdbcImpl();
	}

}
