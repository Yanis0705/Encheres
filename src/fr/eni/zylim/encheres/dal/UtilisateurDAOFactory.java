package fr.eni.zylim.encheres.dal;

import fr.eni.zylim.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

public class UtilisateurDAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		// TODO Auto-generated method stub
		UtilisateurDAO dao = new UtilisateurDAOJdbcImpl();
		return dao;

	}

}
