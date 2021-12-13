package fr.eni.zylim.encheres.bll;

import java.sql.Connection;
import java.util.List;

import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.UtilisateurDAO;
import fr.eni.zylim.encheres.dal.jdbc.ConnectionProvider;
import fr.eni.zylim.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

public class Testmetier {

	public static void main(String[] args) throws DALException {
		// TODO Auto-generated method stub

		UtilisateurDAOJdbcImpl utilisImplDao = new UtilisateurDAOJdbcImpl();
				// Instanciation du jeu d'essai
		Utilisateur user=new Utilisateur();	
		
		
						// Instanciation du jeu d'essai
						List<Utilisateur> Utils = (List<Utilisateur>) utilisImplDao.selectUtilisateurByPseudo("toto");
						for(Utilisateur U:Utils)
							System.out.println(U.getNom());
	
						 // Set user details before creating them
						user.setPseudo("pirate");
						user.setNom("toto");
				        user.setPrenom("tonguy");
				        user.setEmail("toto@yahoo.fr");
				        user.setTelephone("0645785423");
				        user.setRue("4 rue");
				        user.setCode_postal("44300");
				        user.setVille("Nantes");
				        user.setMot_de_passe("hihi852741");
				        user.setCredit(10);
				        user.setAdministrateur(false);
				       
				        
				        
				
				         
				        // Get MySQL Connection
				    
				      ConnectionProvider.getConnection();
				        // Save user in DB
				      utilisImplDao.insertUtilisateur(user);
				 
				        // Authenticate User
				  //    utilisImplDao.authenticate("email@test.com", "password1");
				         
				        // Display all Users         
				      utilisImplDao.selectAllUtilisateurs();
				         
				        // Get details of user with ID = 1
				        user = utilisImplDao.selectUtilisateurById(1);
				         
				        // Display users firstName and lastName
				        System.out.println("Firstname: " + user.getNom() + " Lastname: " + user.getPrenom());
				         
				        // Change user password from password 1 to password 2
				        user.setMot_de_passe("xxxxxx");
				 
				        // Execute update
				        utilisImplDao.updateUtilisateur(user);
				         
				        // Get details of user with ID = 1
				        user = utilisImplDao.selectUtilisateurById(1);
				         
				        
				         
				        // Delete user with ID = 1
				      //  utilisImplDao.deleteUtilisateur(1);
				         
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
