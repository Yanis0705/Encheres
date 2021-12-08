package fr.eni.zylim.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.zylim.encheres.dal.jdbc.ConnectionProvider;

import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.UtilisateurDAO;

public abstract class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String SQL_SELECT_ALL_UTILISATEUR = "select * from UTILISATEURS)";

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
}
