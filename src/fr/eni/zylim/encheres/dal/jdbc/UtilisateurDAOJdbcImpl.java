package fr.eni.zylim.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import fr.eni.zylim.encheres.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements Utilisateur {

	private static final String SQL_SELECT_ALL_UTILISATEUR = "select * from UTILISATEURS)" ;
	
	public UtilisateurDAOJdbcImpl() {
		
	}

	@Override
	public List<Utilisateur> selectAllRepas() throws DALException {

		List<Utilisateur> listeDesRepas = new ArrayList<Utilisateur>();
		
		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();
		
		// Obtient une objet de commande (Statement) = ordre SQL
		Statement ordre = null;


}
}














