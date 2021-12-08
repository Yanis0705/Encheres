package fr.eni.zylim.encheres.dal;


import fr.eni.zylim.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

public class UtilisateurDAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		// TODO Auto-generated method stub
		return new UtilisateurDAOJdbcImpl();

	}


//	/**
//	 * Fournit une instance d'une classe
//	 * se comportant comme un RepasDAO
//	 * 
//	 * @return Une instance
//	 */
//	public static UtilisateurDAO getRepasDAO() {
//		
//		return new UtilisateurDAOJdbcImpl();
//	}

}
