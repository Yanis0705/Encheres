package fr.eni.zylim.encheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.UtilisateurDAO;
import fr.eni.zylim.encheres.dal.UtilisateurDAOFactory;

public class UtilisateurMAnager {
	private static UtilisateurMAnager instance;
	
	private static UtilisateurDAO dao;
	
	private UtilisateurMAnager() {
		dao = UtilisateurDAOFactory.getUtilisateurDAO();
	};

	public static UtilisateurMAnager getInstance() {
		if(instance == null) {
			instance = new UtilisateurMAnager();
		}
		return instance;
	}

	public static List<Utilisateur> listeUtilisateurs() {
		
		List<Utilisateur> lesUtilisateur = new ArrayList<Utilisateur>();
		
		try {
			lesUtilisateur = dao.selectAllUtilisateurs();
		} catch (DALException dale) {
			dale.printStackTrace();
		}
		
		return lesUtilisateur;
		
	}
}
