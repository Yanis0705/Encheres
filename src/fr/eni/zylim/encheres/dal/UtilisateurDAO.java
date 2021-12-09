package fr.eni.zylim.encheres.dal;

import java.util.List;

import fr.eni.zylim.encheres.bo.Utilisateur;

public interface UtilisateurDAO {

	List<Utilisateur> selectAllUtilisateurs() throws DALException;

	List<Utilisateur> selectByPseudo(String pseudo) throws DALException;

}
