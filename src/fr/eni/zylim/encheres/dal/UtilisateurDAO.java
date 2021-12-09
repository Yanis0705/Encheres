package fr.eni.zylim.encheres.dal;

import java.util.List;

import fr.eni.zylim.encheres.bo.Article;
import fr.eni.zylim.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	

	List<Utilisateur> selectAllUtilisateurs() throws DALException;
	public List<Article> getAllArticles(Utilisateur utilisateur) throws DALException;
	public Utilisateur selectUtilisateurById(int noUtilisateur) throws DALException;
	public Utilisateur selectUtilisateuByPseudo (String pseudoUtilisateur) throws DALException;
	void insertUtilisateur(Utilisateur nouvelUtilisateur) throws DALException;
	void updateUtilisateur(Utilisateur data) throws DALException;
	void deleteUtilisateur(int noUtilisateur) throws DALException;
	
	
	

	
	


	

}
