package fr.eni.zylim.encheres.bll;

import java.sql.SQLException;

import fr.eni.zylim.encheres.bo.Retrait;
import fr.eni.zylim.encheres.dal.RetraitDAO;
import fr.eni.zylim.encheres.dal.jdbc.RetraitDAOJdbcImpl;

public class RetraitManager {
	
	private static RetraitDAO retraitDAO = new RetraitDAOJdbcImpl();

	public RetraitManager() {
	}
	
	public static Retrait ajouterLieuRetrait(Retrait retrait) throws SQLException {
		retraitDAO.insert(retrait);
		return retrait;
		
	}

}
