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
	public void updateArticleVendu(ArticleVendu data) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteArticleVendu(int no_Article) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertArticleVendu(ArticleVendu nouveauArticle) throws DALException {
		// TODO Auto-generated method stub
		
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
