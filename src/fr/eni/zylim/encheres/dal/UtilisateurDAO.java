package fr.eni.zylim.encheres.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.zylim.encheres.bo.Article;
import fr.eni.zylim.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	

	List<Utilisateur> selectAllUtilisateurs() throws DALException;
	public List<String> getAllPseudos() throws DALException;
	public List<Article> getAllArticles(Utilisateur utilisateur) throws DALException;
	public Utilisateur selectUtilisateurById(int noUtilisateur) throws DALException;
	public Utilisateur selectUtilisateuByPseudo (String pseudoUtilisateur) throws DALException;
	void insertUtilisateur(Utilisateur nouvelUtilisateur);
	void updateUtilisateur(Utilisateur data) throws DALException;
	void deleteUtilisateur(int noUtilisateur) throws DALException;
	
	
	

	
	


	

}
