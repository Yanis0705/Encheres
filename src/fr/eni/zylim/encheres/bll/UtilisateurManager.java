package fr.eni.zylim.encheres.bll;

import java.util.ArrayList;
import java.util.List;


import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.DAOFactory;
import fr.eni.zylim.encheres.dal.UtilisateurDAO;
import fr.eni.zylim.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;



public class UtilisateurManager {
	
/** The instance. */
	private static UtilisateurManager instance;

	/** The dao. */
	private static UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();

	/**
	 * Instantiates a new utilisateur Manager.
	 */
	public UtilisateurManager() {
		UtilisateurManager.utilisateurDAO = DAOFactory.getUtilisateurDAO();
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
	
	
	/***********************************************************************/
	
	public static List<Utilisateur> listeUtilisateurs() {

		List<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();

		try {
			lesUtilisateurs = utilisateurDAO.selectAllUtilisateurs();
		} catch (DALException dale) {
			dale.printStackTrace();
		}

		return lesUtilisateurs;

	}

	/***********************************************************************/
	
	public static Utilisateur getUtilisateurProfile(String  pseudoname) {
	
		Utilisateur user = new Utilisateur();

		try {
			user = utilisateurDAO.selectUtilisateurByPseudo(pseudoname);
		} catch (DALException dale) {
			dale.printStackTrace();
		}

		return user;

	}
	
/***********************************************************************/
	
	public static Utilisateur getUtilisateurById(int  iduser) {
	
		Utilisateur user = new Utilisateur();

		try {
			user = utilisateurDAO.selectUtilisateurById(iduser);
		} catch (DALException dale) {
			dale.printStackTrace();
		}

		return user;

	}
	
/***********************************************************************/
	
	public Utilisateur ajouterUtilisateur(Utilisateur nouveauUtilisateur) throws DALException {

		
		Utilisateur utilisateur = utilisateurDAO.insertUtilisateur(nouveauUtilisateur);
		
		return utilisateur;
	}
	/***********************************************************************/
	public static List<String> selectAllPseudos() throws DALException {
		return utilisateurDAO.getAllPseudos();
	}

	/***********************************************************************/
	
	public static Utilisateur inscriptionUtilisateur(Utilisateur utilisateur) throws DALException {
		validerCoordonnees(utilisateur);
		//TODO Creer If pour validation des coordonnées utilisateur
		utilisateurDAO.insertUtilisateur(utilisateur);
		return utilisateur;
	}
	
	

	
	/***********************************************************************/
	/***********************************************************************/
	private static void validerCoordonnees(Utilisateur utilisateur) {

		if (utilisateur.getPseudo().trim().equals("") || utilisateur.getNom().trim().equals("")
				|| utilisateur.getPrenom().trim().equals("") || utilisateur.getEmail().trim().equals("")
				|| utilisateur.getRue().trim().equals("") || utilisateur.getCode_postal().trim().equals("")
				|| utilisateur.getVille().trim().equals("") || utilisateur.getMot_de_passe().trim().equals("")) {
		}
	}
	/*********************************************************************************/
}
