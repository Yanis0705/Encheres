package fr.eni.zylim.encheres.bll;

import java.util.ArrayList;
import java.util.List;
import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.UtilisateurDAO;
import fr.eni.zylim.encheres.dal.UtilisateurDAOFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class UtilisateurMAnager.
 */
public class UtilisateurMAnager {

	/** The instance. */
	private static UtilisateurMAnager instance;

	/** The dao. */
	private static UtilisateurDAO dao;

	/**
	 * Instantiates a new utilisateur M anager.
	 */
	private UtilisateurMAnager() {
		dao = UtilisateurDAOFactory.getUtilisateurDAO();
	};

	/**
	 * Gets the single instance of UtilisateurMAnager.
	 *
	 * @return single instance of UtilisateurMAnager
	 */
	public static UtilisateurMAnager getInstance() {
		if (instance == null) {
			instance = new UtilisateurMAnager();
		}
		return instance;
	}

	/**
	 * Liste utilisateurs.
	 *
	 * @return the list
	 */
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
