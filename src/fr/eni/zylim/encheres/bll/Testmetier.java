package fr.eni.zylim.encheres.bll;

import java.util.List;

import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

public class Testmetier {

	public static void main(String[] args) throws DALException {
		// TODO Auto-generated method stub

		UtilisateurDAOJdbcImpl utilimpl = new UtilisateurDAOJdbcImpl();
				// Instanciation du jeu d'essai
					
						// Instanciation du jeu d'essai
						List<Utilisateur> Utils = (List<Utilisateur>) utilimpl.selectUtilisateuByPseudo("toto");
						for(Utilisateur U:Utils)
							System.out.println(U.getNom());
	}

}
