package fr.eni.zylim.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.zylim.encheres.bo.ArticleVendu;
import fr.eni.zylim.encheres.bo.Retrait;

import fr.eni.zylim.encheres.bo.Utilisateur;

import fr.eni.zylim.encheres.dal.ArticleVenduDAO;
import fr.eni.zylim.encheres.dal.DALException;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	private static final String SELECT_FILTER_NOM = "SELECT * FROM ARTICLES_VENDUS WHERE nom_article LIKE ?";
	private static final String SELECT_FILTER_CATEGORIE = "SELECT * FROM ARTICLES_VENDUS WHERE no_categorie LIKE ?";

	


	private static final String SELECT_ALL ="SELECT * FROM ARTICLES_VENDUS a INNER JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur " ;
	private static final String SQL_INSERT_TO_ARTICLE = "INSERT INTO ARTICLES_VENDUS VALUES (nom_article, description, date_debut_encheres," +
	"date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente )";
	private final static String SQL_UPDATE_ARTICLE = "UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, no_utilisateur=?, no_categorie=?," +
	", no_categorie=? WHERE no_Article=?";
	private final static String SQL_DELETE_ARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE no_Article=?";
	

	@Override
	public ArticleVendu selectArticleById(int no_article) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> selectAllArticle() throws DALException {
		List<ArticleVendu> lesArticlesVendus = new ArrayList<>();
		Connection cnx = ConnectionProvider.getConnection();
		Statement ordre = null;
			try  {
				ordre = cnx.createStatement();
				ResultSet resultat = null;
				resultat = ordre.executeQuery(SELECT_ALL);
				
				ArticleVendu article = null;

				Utilisateur user = null;

				
				while (resultat.next()) {
					
				    int no_article = resultat.getInt("no_article");
					String nom_article = resultat.getString("nom_article");
					String description =resultat.getString("description");
					Date date_debut_encheres = resultat.getDate("date_debut_encheres");
					Date date_fin_encheres = resultat.getDate("date_fin_encheres");
					int prix_initial = resultat.getInt("prix_initial");
					int prix_vente = resultat.getInt("prix_vente");
					int no_utilisateur = resultat.getInt("no_utilisateur");

					String pseudo = resultat.getString("pseudo");

					int no_categorie = resultat.getInt("no_categorie");
					boolean etat_vente = resultat.getBoolean("etat_vente");
//					Retrait retrait =  (Retrait) resultat.getObject("retrait");
					article = new ArticleVendu(no_article,nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente,  no_utilisateur, no_categorie, etat_vente);
					lesArticlesVendus.add(article);


			user = new Utilisateur(no_utilisateur,pseudo);
			System.out.println("affichage article + utilisateur " + article + user.getPseudo());


				}
				
				}
			catch (SQLException e) {
				System.out.println("Echec");
				e.printStackTrace();
				throw new DALException(e.getMessage());
			}
			return lesArticlesVendus;
		}
	

	@Override

	public List<ArticleVendu> selectByString(String filter) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void updateArticleVendu(ArticleVendu articleUpdate) throws DALException {
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
	public void deleteArticleVendu(int no_Article) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SQL_DELETE_ARTICLE);
			pStmt.setInt(1, no_Article);

			//n = nombre de lignes supprimées (ici, soit 1 soit 0).
			int n = pStmt.executeUpdate();

			//return n == 1;//si 1 ligne supprimée --> true, sinon false
			} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
			}


	}

	@Override
	public void insertArticleVendu(ArticleVendu nouvelArticle) throws DALException {
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
//			if(rs.next()) {
//			int no_article_Insere = rs.getInt(1);
//			nouvelArticle.setNo_article(no_article_Insere);
//			}

			} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
			}	
	}

	@Override
	public List<ArticleVendu> selectByCategorie(int no_categorie) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ArticleVendu> selectByString(String filter) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}
}
