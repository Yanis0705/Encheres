package fr.eni.zylim.encheres.dal;

import java.util.List;

import fr.eni.zylim.encheres.bll.QueyCollection;
import fr.eni.zylim.encheres.bo.ArticleVendu;


public interface ArticleVenduDAO {
	
	ArticleVendu selectArticleById(int no_article) throws DALException;
	List<ArticleVendu> selectAllArticle() throws DALException;
	List<ArticleVendu> selectByString(String filter) throws DALException;
	List<ArticleVendu> selectByCategorie(int  no_categorie) throws DALException;
	
	void insertArticleVendu(ArticleVendu nouveauArticle) throws DALException;
	void updateArticleVendu(ArticleVendu data) throws DALException;
	void deleteArticleVendu(int no_Article) throws DALException;

//	List<ArticleVendu> selectAllArticleRetrait() throws DALException;
	List<QueyCollection> selectAllArticleRetrait() throws DALException;
}
