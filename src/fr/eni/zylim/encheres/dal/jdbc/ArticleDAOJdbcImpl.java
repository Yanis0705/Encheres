package fr.eni.zylim.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.zylim.encheres.bo.Retrait;
import fr.eni.zylim.encheres.bo.Article;
import fr.eni.zylim.encheres.dal.ArticleDAO;
import fr.eni.zylim.encheres.dal.DALException;

public class ArticleDAOJdbcImpl implements ArticleDAO{

	private static final String SQL_SELECT_ALL_ARTICLE =	"SELECT * FROM ARTICLES_VENDUS)" ;
	
	private static final String SQL_INSERT_TO_ARTICLE = 	"INSERT INTO ARTICLES_VENDUS VALUES (nom_article, description, date_debut_encheres," + 
																													"date_fin_encheres, prix_initial, prix_vente,  no_utilisateur, no_categorie, etat_vente )";
	
	private static final String SQL_SELECT_ARTICLE_BY_ID =  "SELECT * FROM ARTICLES_VENDUS a  INNER JOIN UTILISATEURS u on a.no_utilisateur = ? and a.no_utilisateur = u.no_utilisateur ";
	
	private final static String SQL_UPDATE_ARTICLE = "UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, no_utilisateur=?, no_categorie=?," +
																											", no_categorie=? WHERE no_Article=?";
	
	private final static String SQL_DELETE_ARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE no_Article=?";
	
	

	
	public  ArticleDAOJdbcImpl() {
		
	}


	@Override
	public Article selectArticleById(int id_utilisateur) throws DALException {
		Article article = null;
		
		try (Connection cnx = ConnectionProvider.getConnection();) {
					
			PreparedStatement pStmt = cnx.prepareStatement(SQL_SELECT_ARTICLE_BY_ID);
			pStmt.setInt(1, id_utilisateur);
			
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				
				int no_article = rs.getInt("no_article");
				String nom_article = rs.getString("nom_article");
				String description = rs.getString("description");
				Date date_debut_encheres = rs.getDate("date_debut_encheres");
				Date date_fin_encheres = rs.getDate("date_fin_encheres");
				int prix_initial = rs.getInt("prix_initial");
				int prix_vente = rs.getInt("prix_vente");
				int no_utilisateur = rs.getInt("no_utilisateur");
				int no_categorie = rs.getInt("qteStock");
				boolean etat_vente = rs.getBoolean("etat_vente");
				Retrait retrait =  (Retrait) rs.getObject("retrait");
				
				article = new Article(no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente,  no_utilisateur, no_categorie, etat_vente, retrait);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
				
			return article;
		}

	@Override
	public List<Article> selectAllArticle() throws DALException {
		List<Article> articles = new ArrayList<Article>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			Statement pStmt = cnx.createStatement();
			
			ResultSet rs = pStmt.executeQuery(SQL_SELECT_ALL_ARTICLE);
			while(rs.next()) {
				
				
				int no_article = rs.getInt("no_article");
				String nom_article = rs.getString("nom_article");
				String description = rs.getString("description");
				Date date_debut_encheres = rs.getDate("date_debut_encheres");
				Date date_fin_encheres = rs.getDate("date_fin_encheres");
				int prix_initial = rs.getInt("prix_initial");
				int prix_vente = rs.getInt("prix_vente");
				int no_utilisateur = rs.getInt("no_utilisateur");
				int no_categorie = rs.getInt("qteStock");
				boolean etat_vente = rs.getBoolean("etat_vente");
				Retrait retrait = (Retrait) rs.getObject("retrait");
				
				Article article = new Article(no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente,   no_utilisateur, no_categorie, etat_vente, retrait);
				
				articles.add(article);
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return articles;
	}

	@Override
	public void insertArticle(Article nouvelArticle) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmt = cnx.prepareStatement(SQL_INSERT_TO_ARTICLE, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, nouvelArticle.getNom_article());
			pStmt.setString(2, nouvelArticle.getDescription());
			pStmt.setDate(3, nouvelArticle.getDate_debut_encheres());
			pStmt.setDate(4, nouvelArticle.getDate_fin_encheres());
			pStmt.setInt(5, nouvelArticle.getPrix_initial());
			pStmt.setInt(6, nouvelArticle.getPrix_vente());
			pStmt.setInt(7, nouvelArticle.getNo_utilisateur());
			pStmt.setInt(8, nouvelArticle.getNo_categorie());
			pStmt.setBoolean(9, nouvelArticle.isEtat_vente());		
			
			pStmt.executeUpdate();
			
			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				int no_article_Insere = rs.getInt(1);
				nouvelArticle.setNo_article(no_article_Insere);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
	}

	@Override
	public void updateArticle(Article articleUpdate) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SQL_UPDATE_ARTICLE);
			pStmt.setString(1, articleUpdate.getNom_article());
			pStmt.setString(2, articleUpdate.getDescription());
			pStmt.setDate(3, articleUpdate.getDate_debut_encheres());
			pStmt.setDate(4, articleUpdate.getDate_fin_encheres());
			pStmt.setInt(5, articleUpdate.getPrix_initial());
			pStmt.setInt(6, articleUpdate.getPrix_vente());
			pStmt.setInt(7, articleUpdate.getNo_utilisateur());
			pStmt.setInt(8, articleUpdate.getNo_categorie());
			pStmt.setBoolean(9, articleUpdate.isEtat_vente());		
			pStmt.setInt(10, articleUpdate.getNo_article());
			
			pStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
	}

	@Override
	public void deleteArticle(int noArticle) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection()) {			
			PreparedStatement pStmt = cnx.prepareStatement(SQL_DELETE_ARTICLE);
			pStmt.setInt(1, noArticle);
			
			//n = nombre de lignes supprimées (ici, soit 1 soit 0).
			int n = pStmt.executeUpdate();
			
			//return n == 1;//si 1 ligne supprimée --> true, sinon false
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
	}
}






















