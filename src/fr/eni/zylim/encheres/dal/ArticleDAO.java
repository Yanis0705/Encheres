package fr.eni.zylim.encheres.dal;

import java.util.List;

import fr.eni.zylim.encheres.bo.Article;


public interface ArticleDAO {
	
	Article selectArticleById(int noUtilisateur) throws DALException;
	List<Article> selectAllArticle() throws DALException;
	void insertArticle(Article nouveauArticle) throws DALException;
	void updateArticle(Article data) throws DALException;
	void deleteArticle(int noArticle) throws DALException;
}
