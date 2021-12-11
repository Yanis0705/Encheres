package fr.eni.zylim.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.zylim.encheres.dal.jdbc.ConnectionProvider;
import fr.eni.zylim.encheres.bo.Article;
import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.EnchereDAO;
import fr.eni.zylim.encheres.dal.UtilisateurDAO;

public  class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String SQL_SELECT_ALL_UTILISATEUR = "select * from UTILISATEURS";
	private static final String SQL_INSERT_TO_UTILISATEUR = 	"INSERT INTO UTILISATEURS VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_SELECT_UTILISATEUR_BY_ID =  "SELECT * FROM UTILISATEURS u   WHERE u.no_utilisateur = ?";
	private static final String SQL_UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET nom=?, prenom=?,"
																														+ "email=?, telephone=?, rue=?, code_postal=?, ville=?," + " mot_de_passe=?, credit=?, administrateur=? WHERE no_utilisateur=?";
	private static final String SQL_DELETE_UTILISATEUR= "DELETE UTILISATEURS WHERE no_utilisateur=?";
	private static final String SQL_GET_ARTICLES_VENDUS_BY_UTILISATEUR_ID = "select * from ARTICLES_VENDUS WHERE no_utilisateur=?";
	private static final String SQL_GET_UTILISATEUR_BY_PSEUDO ="select * from UTILISATEURS WHERE pseudo=? ";
	private static final String SQL_GET_ALL_PSEUDOS = "SELECT pseudo FROM UTILISATEURS";
	
//	private static EnchereDAO enchereDao = new EnchereDAOJDBCImpl();
//	private static ArticleDAO articleDao = new ArticleDAOJDBCImpl();
//	private static CategorieDAO categorieDao = new CategorieDAOJDBCImpl();
//	private static RetraitDAO retraitDao = new RetraitDAOJDBCImpl();
	
	public UtilisateurDAOJdbcImpl() {

	}

	@Override
	public List<Utilisateur> selectAllUtilisateurs() throws DALException {

		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de Utilisateur (Statement) = ordre SQL
		Statement ordre = null;

		try {
			ordre = cnx.createStatement();

			// Paramétrer l'objet de Utilisateur

			// Execute l'ordre SQL
			ResultSet tableResulante = null;
			tableResulante = ordre.executeQuery(SQL_SELECT_ALL_UTILISATEUR);

			// Interpreter les resultats = contruire l'arborescence d'objets métier
			// à partir des informations de la base de données

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return listeUtilisateur;

	}

	
	@Override
	public Utilisateur selectUtilisateurById(int id_Utilisateur) throws DALException {
		Utilisateur utilisateur = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement statement = cnx.prepareStatement(SQL_SELECT_UTILISATEUR_BY_ID);
			statement.setInt(1, id_Utilisateur);
			ResultSet tableResulante = statement.executeQuery();

			if (tableResulante.next()) {
				utilisateur = utilisateurBuilder(tableResulante);
			}

		} catch (Exception e) {
			e.printStackTrace();
			DALException dalException = new DALException();

			throw dalException;

		}

		return utilisateur;
	}

	@Override
	public void insertUtilisateur(Utilisateur nouvelUtilisateur) {
		
			System.out.println("START insertUtilisateur");
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement ordre = null;
			try {
				ordre = cnx.prepareStatement(SQL_INSERT_TO_UTILISATEUR, Statement.RETURN_GENERATED_KEYS);

			ordre.setString(1, nouvelUtilisateur.getPseudo());
			ordre.setString(2, nouvelUtilisateur.getNom());
			ordre.setString(3, nouvelUtilisateur.getPrenom());
			ordre.setString(4, nouvelUtilisateur.getEmail());
			if (nouvelUtilisateur.getTelephone() != null) {
				ordre.setString(5, nouvelUtilisateur.getTelephone());
			} else {
				ordre.setNull(5, Types.VARCHAR);
				}
			ordre.setString(6, nouvelUtilisateur.getRue());
			ordre.setString(7, nouvelUtilisateur.getCode_postal());
			ordre.setString(8, nouvelUtilisateur.getVille());
			ordre.setString(9, nouvelUtilisateur.getMot_de_passe());
			ordre.setInt(10, 100);
			ordre.setBoolean(11, nouvelUtilisateur.isAdministrateur());
			ordre.executeUpdate();
			System.out.println("UPDATE OK");
			ResultSet tableResulante = ordre.getGeneratedKeys();

			if (tableResulante.next()) {
				nouvelUtilisateur.setNo_utilisateur(tableResulante.getInt(1));
			}

			ordre.close();
			cnx.commit();
			
			System.out.println("STOP insertUtilisateur");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void updateUtilisateur(Utilisateur data) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement statement = cnx.prepareStatement(SQL_UPDATE_UTILISATEUR);
			statement.setString(1, data.getNom());
			statement.setString(2, data.getPrenom());
			statement.setString(3, data.getEmail());
			if (data.getTelephone() != null) {
				statement.setString(4, data.getTelephone());
			} else {
				statement.setNull(4, Types.VARCHAR);
			}
			statement.setString(5, data.getRue());
			statement.setString(6, data.getCode_postal());
			statement.setString(7, data.getVille());
			statement.setString(8, data.getMot_de_passe());
			statement.setInt(9, data.getCredit());
			statement.setBoolean(10, data.isAdministrateur());
			statement.setInt(11, data.getNo_utilisateur());

			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			DALException dalException = new DALException();
	
			throw dalException;

		}
		
	}

	@Override
	public void deleteUtilisateur(int noUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public List<Article> getAllArticles(Utilisateur utilisateur) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur selectUtilisateuByPseudo(String pseudoUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}


public Utilisateur utilisateurBuilder(ResultSet rs) throws DALException
{
System.out.println("START utilisateurBuilder");
	Utilisateur utilisateur = new Utilisateur();
	
	try {
	utilisateur.setNo_utilisateur(rs.getInt("no_utilisateur"));
	utilisateur.setPseudo(rs.getString("pseudo"));
	utilisateur.setNom(rs.getString("nom"));
	utilisateur.setPrenom(rs.getString("prenom"));
	utilisateur.setEmail(rs.getString("email"));
	utilisateur.setTelephone(rs.getString("telephone"));
	utilisateur.setRue(rs.getString("rue"));
	utilisateur.setCode_postal(rs.getString("code_postal"));
	utilisateur.setVille(rs.getString("ville"));
	utilisateur.setMot_de_passe(rs.getString("mot_de_passe"));
	utilisateur.setCredit(rs.getInt("credit"));
	utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
// TODO A voir si besoin mais pas prioritaire pour le moment
//	utilisateur.setArticlesVendus(articlesVendus);
//	utilisateur.setArticlesAchetes(articlesAchetes);
//	utilisateur.setEncheres(encheres);
	} catch (SQLException e) {

		e.printStackTrace();
	}
	System.out.println("FIN utilisateurBuilder");
	return utilisateur;

}

@Override
public List<String> getAllPseudos() throws DALException {
	
	List<String> pseudos = new ArrayList<>();
	
	try(Connection cnx = ConnectionProvider.getConnection()) {
		PreparedStatement statement = cnx.prepareStatement(SQL_GET_ALL_PSEUDOS);
		
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			pseudos.add(rs.getString("pseudo"));
		}
				
	} catch (Exception e) {
		// TODO: handle exception
	}
	return pseudos;
}
}




