package fr.eni.zylim.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.zylim.encheres.dal.jdbc.ConnectionProvider;
import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String SQL_SELECT_ALL_UTILISATEUR = "select * from UTILISATEURS";

	private static final String SQL_INSERT_TO_UTILISATEUR = 	"INSERT INTO UTILISATEURS VALUES (pseudo,nom, prenom,  email,telephone,rue, code_postal,ville, mot_de_passe, administrateur)";
	
	private static final String SQL_SELECT_ARTICLE_BY_ID =  "SELECT * FROM UTILISATEURS u   WHERE u.no_utilisateur = ?";
	
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
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
	PreparedStatement pStmt = cnx.prepareStatement(SQL_SELECT_ARTICLE_BY_ID);
	pStmt.setInt(1,id_Utilisateur);
	
	ResultSet rs = pStmt.executeQuery();
	if(rs.next()) {
				
				
				int no_utilisateur = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String code_postal = rs.getString("code_postal");
				String ville = rs.getString("ville");
			
				
				utilisateur = new Utilisateur( no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville);
				
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return utilisateur;
	}

	@Override
	public void insertArticle(Utilisateur nouvelUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUtilisateur(Utilisateur data) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUtilisateur(int noUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}
}
