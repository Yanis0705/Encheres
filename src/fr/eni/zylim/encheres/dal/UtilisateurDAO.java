package fr.eni.zylim.encheres.dal;

import java.util.List;


import fr.eni.zylim.encheres.bo.Utilisateur;



public interface UtilisateurDAO {
	
	

	List<Utilisateur> selectAllUtilisateurs() throws DALException;
	public Utilisateur selectUtilisateurByPseudo(String pseudo) throws DALException;
	void deleteUtilisateur(int noUtilisateur) throws DALException;
	public Utilisateur selectUtilisateurById(int noUtilisateur) throws DALException;
	void updateUtilisateur(Utilisateur data) throws DALException;
	public Utilisateur insertUtilisateur(Utilisateur nouvelUtilisateur) throws DALException;
	boolean authenticate_Mail(String eMail, String password);
	boolean authenticate_Pseudo(String pseudo, String password);
	public Utilisateur ProfileBy_Pseudo(String pseudo, String password) throws DALException;



	
	
	

	
	


	

}
