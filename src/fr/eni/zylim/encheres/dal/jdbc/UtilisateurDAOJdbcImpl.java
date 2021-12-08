package fr.eni.zylim.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import fr.eni.zylim.encheres.dal.jdbc.ConnectionProvider;
import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String SQL_SELECT_ALL_UTILISATEUR = "select * from UTILISATEURS)" ;
	
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
		Utilisateur nouveauUtilisateur= null;
	
		int idRepasEnCours = -1; // "-1" signife "pas d'identifiant"
		
		
		while ( tableResulante.next() ) {
			
			int idRepas = tableResulante.getInt("id_repas");
			// si c'est un nouveau repas 
			if (idRepas != idRepasEnCours) {
				LocalDateTime momentRepas = tableResulante.getTimestamp("dateheure").toLocalDateTime();
				nouveauRepas = new Repas(idRepas, momentRepas);
				listeDesRepas.add(nouveauRepas); // ajouter le nouveau repas à la liste
				idRepasEnCours = idRepas; // ce repas devient le repas en cours
			}

			// Instancier l'Aliment 
			int idAliment = tableResulante.getInt("id_aliment");
			String nomAliment = tableResulante.getString("nom");
			
			nouvelAliment = new Aliment(idAliment, nomAliment);
			
			//Ajouter ce nouvel aliment au repas en cours
			nouveauUtilisateur.getListeAliments().add(nouvelAliment);
			}
		
		
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}	
		
		return listeUtilisateur;
	}

	@Override
	public List<fr.eni.zylim.encheres.bll.Utilisateur> selectUtilisateur() {
		// TODO Auto-generated method stub
		return null;
	}



}















