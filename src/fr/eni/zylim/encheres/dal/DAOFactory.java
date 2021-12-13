package fr.eni.zylim.encheres.dal;


import fr.eni.zylim.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;


public class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl() ;
	}
	
	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOJdbcImpl();
	}
	public static CategorieDAOJdbcImpl getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}
	public static EnchereDAO getEnchereDAO() {
		return new  EnchereDAOJdbcImpl();
	}
	public static RetraitDAO getRetraitDAO() {
		
		return new RetraitDAOJdbcImpl();
	}
}
