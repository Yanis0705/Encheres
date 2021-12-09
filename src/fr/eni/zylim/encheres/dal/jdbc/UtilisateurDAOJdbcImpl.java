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

	private static final String SQL_SELECT_ALL_UTILISATEUR = "select * from UTILISATEURS )";
	private static final String SQL_SELECT_BYPSEUDO_UTILISATEUR = "select * from UTILISATEURS where pseudo like ?)";

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
			while (tableResulante.next()) {
				// Interpreter les resultats = contruire l'arborescence d'objets métier
				// à partir des informations de la base de données
				// Utilisateur u=new Utilisateur();
				Utilisateur a = map(tableResulante);

				listeUtilisateur.add(a);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return listeUtilisateur;

	}

	public Utilisateur map(ResultSet tableResulante) throws SQLException {
		Utilisateur utilisateur = null;

		int no_utilisateur = tableResulante.getInt("no_utilisateur");
		String pseudo = tableResulante.getString("pseudo");
		String nom = tableResulante.getString("nom");
		String prenom = tableResulante.getString("prenom");
		String email = tableResulante.getString("email");
		String telephone = tableResulante.getString("telephone");
		String rue = tableResulante.getString("rue");
		String code_postal = tableResulante.getString("code_postal");
		String ville = tableResulante.getString("ville");
		String mot_de_passe = tableResulante.getString("mot_de_passe");
		int credit = tableResulante.getInt("credit");
		boolean administrateur = tableResulante.getBoolean("administrateur");

		return utilisateur;
	}

	@Override
	public List<Utilisateur> selectByPseudo(String pseudo) throws DALException {
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de Utilisateur (Statement) = ordre SQL
		PreparedStatement ordre = null;

		try {
			ordre = cnx.prepareStatement(SQL_SELECT_BYPSEUDO_UTILISATEUR);

			// Paramétrer l'objet de Utilisateur

			// Execute l'ordre SQL
			ResultSet tableResulante = null;

			ordre.setString(1,"%"+pseudo +"%");
			tableResulante = ordre.executeQuery();
			while (tableResulante.next()) {
				// Interpreter les resultats = contruire l'arborescence d'objets métier
				// à partir des informations de la base de données
				Utilisateur a = map(tableResulante);

				listeUtilisateur.add(a);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw new DALException(sqle.getMessage());
		}
		return listeUtilisateur;
	}

	


}