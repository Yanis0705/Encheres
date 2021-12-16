package fr.eni.zylim.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.zylim.encheres.bll.QueyCollection;
import fr.eni.zylim.encheres.bo.ArticleVendu;
import fr.eni.zylim.encheres.bo.Retrait;
import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.ArticleVenduDAO;
import fr.eni.zylim.encheres.dal.DALException;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	private static final String SELECT_FILTER_NOM = "SELECT * FROM ARTICLES_VENDUS WHERE nom_article LIKE ?";
	private static final String SELECT_FILTER_CATEGORIE = "SELECT * FROM ARTICLES_VENDUS WHERE no_categorie LIKE ?";
	private static final String SELECT_ALL ="SELECT * FROM ARTICLES_VENDUS a INNER JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur " ;
	private static final String SELECT_ALL_RETRAIT ="SELECT * FROM ARTICLES_VENDUS a INNER JOIN RETRAITS r ON r.no_article= a.no_article ";
	private final static String SQL_SELECT_ALL="SELECT DISTINCT a.image_article, a.no_article,a.nom_article,a.description, g.libelle,a.date_debut_encheres,a.date_fin_encheres,r.rue,r.code_postal,r.ville,u.pseudo,a.prix_initial FROM ARTICLES_VENDUS a INNER JOIN RETRAITS r ON r.no_article= a.no_article INNER JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur INNER JOIN CATEGORIES g ON g.no_categorie=a.no_categorie INNER JOIN ENCHERES e ON e.no_utilisateur=u.no_utilisateur";
      


	public List<QueyCollection> selectAllArticleRetrait() throws DALException {
	List<QueyCollection> lesArticlesRetrait = new ArrayList<>();
	Connection cnx = ConnectionProvider.getConnection();
	Statement ordre = null;
	try {
	ordre = cnx.createStatement();
	ResultSet resultat = null;
	resultat = ordre.executeQuery(SQL_SELECT_ALL);



	QueyCollection quer = null;


	while (resultat.next()) {

	int no_article = resultat.getInt("no_article");
	String nom_article = resultat.getString("nom_article");
	String description =resultat.getString("description");
	String libelle =resultat.getString("libelle");
	
	Date date_debut_encheres = resultat.getDate("date_debut_encheres");
	Date date_fin_encheres = resultat.getDate("date_fin_encheres");
	String rue = resultat.getString("rue");
	String code_postal = resultat.getString("code_postal");
	String ville = resultat.getString("ville");
	String pseudo = resultat.getString("pseudo");
	int prix_initial = resultat.getInt("prix_initial");
	String image_article = resultat.getString("image_article");
	




	quer = new QueyCollection(no_article,nom_article, description,libelle,date_debut_encheres,date_fin_encheres,rue,code_postal,ville,pseudo, prix_initial,image_article);
	lesArticlesRetrait.add(quer);





	System.out.println("affichage article + Retrait " + quer );
	}



	}
	catch (SQLException e) {
	System.out.println("Echec");
	e.printStackTrace();
	throw new DALException(e.getMessage());
	}
	return lesArticlesRetrait;
	}


	@Override
	public ArticleVendu selectArticleById(int no_article) throws DALException {
		// TODO Auto-generated method stub
		return null;
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


	@Override
	public List<ArticleVendu> selectAllArticle() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
