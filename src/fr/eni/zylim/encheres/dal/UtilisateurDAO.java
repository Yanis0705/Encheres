package fr.eni.zylim.encheres.dal;

import java.util.List;


import fr.eni.zylim.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	

	List<Utilisateur> selectAllUtilisateurs() throws DALException;
	Utilisateur selectUtilisateurById(int noUtilisateur) throws DALException;
	void insertArticle(Utilisateur nouvelUtilisateur) throws DALException;
	void updateUtilisateur(Utilisateur data) throws DALException;
	void deleteUtilisateur(int noUtilisateur) throws DALException;

}
