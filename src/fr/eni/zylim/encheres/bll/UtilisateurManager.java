package fr.eni.zylim.encheres.bll;

import java.util.ArrayList;
import java.util.List;
import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.DAOFactory;
import fr.eni.zylim.encheres.dal.UtilisateurDAO;



public class UtilisateurManager {
	
/** The instance. */
	private static UtilisateurManager instance;

	/** The dao. */
	private static UtilisateurDAO dao;

	/**
	 * Instantiates a new utilisateur Manager.
	 */
	private UtilisateurManager() {
		dao = DAOFactory.getUtilisateurDAO();
	};

	/**
	 * Gets the single instance of UtilisateurMAnager.
	 *
	 * @return single instance of UtilisateurMAnager
	 */
	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

	/**
	 * Liste utilisateurs.
	 *
	 * @return the list
	 */
	public static List<Utilisateur> listeUtilisateurs() {

		List<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();

		try {
			lesUtilisateurs = dao.selectAllUtilisateurs();
		} catch (DALException dale) {
			dale.printStackTrace();
		}

		return lesUtilisateurs;

	}

	public static Utilisateur getUtilisateur(int i) {
		// TODO Auto-generated method stub
		return null;
	}




}
