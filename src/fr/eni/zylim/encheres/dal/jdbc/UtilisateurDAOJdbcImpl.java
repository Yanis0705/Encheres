package fr.eni.zylim.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String SQL_SELECT_ALL_UTILISATEUR = "select * from UTILISATEURS";
	private static final String SQL_SELECT_UTILISATEUR_PROFILE = "select * from UTILISATEURS where pseudo=?";
	private static final String SQL_SELECT_UTILISATEUR_BY_ID = "SELECT * FROM UTILISATEURS    WHERE no_utilisateur = ?";
	private static final String SQL_SELECT_UTILISATEUR_SESSION_PSEUDO = "select * from UTILISATEURS where pseudo=pseudo AND mot_de_passe=password";
	private static final String SQL_SELECT_UTILISATEUR_SESSION_MAIL = "select * from UTILISATEURS where email=eMail AND mot_de_passe=password";
	private static final String SQL_INSERT_TO_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville, mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET nom=?, prenom=?,email=?,telephone=?,rue=?, code_postal=?, ville=?,mot_de_passe=?, credit=?, administrateur=? WHERE no_utilisateur=?";
	private static final String SQL_DELETE_UTILISATEUR = "DELETE UTILISATEURS WHERE no_utilisateur=?";
	
	private static final String SQL_GET_ARTICLES_VENDUS_BY_UTILISATEUR_ID = "select * from ARTICLES_VENDUS WHERE no_utilisateur=?";
	private static final String SQL_GET_ALL_PSEUDOS = "SELECT pseudo FROM UTILISATEURS";

//	private static EnchereDAO enchereDao = new EnchereDAOJDBCImpl();
//	private static ArticleDAO articleDao = new ArticleDAOJDBCImpl();
//	private static CategorieDAO categorieDao = new CategorieDAOJDBCImpl();
//	private static RetraitDAO retraitDao = new RetraitDAOJDBCImpl();
	/********************************** constructeur vide ***********************/
	public UtilisateurDAOJdbcImpl() {

	}

	/******************* map for all data user ************************/

	public Utilisateur map(ResultSet tableResulante) throws SQLException {
		Utilisateur utilisateur = null;
		int no_utilisateur = tableResulante.getInt("no_utilisateur");
		String pseudo = tableResulante.getString("pseudo");
		String nom = tableResulante.getString("nom");
		String prenom = tableResulante.getString("prenom");
		String email = tableResulante.getString("email");
		String telephone = tableResulante.getString("telephone");
		String rue = tableResulante.getString("rue");
		String code_postal = tableResulante.getString("code_postal");
		String ville = tableResulante.getString("ville").trim();
		String mot_de_passe = tableResulante.getString("mot_de_passe").trim();
		int credit = tableResulante.getInt("credit");
		boolean administrateur = tableResulante.getBoolean("administrateur");
		utilisateur = new Utilisateur(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville,
				mot_de_passe, credit, administrateur);
		return utilisateur;
	}

	/******************* select all Users ****************************/

	@Override
	public List<Utilisateur> selectAllUtilisateurs() throws DALException {

		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();

		// Obtenir une connexion
		try (Connection cnx = ConnectionProvider.getConnection()) {

			// Obtient une objet de commande (Statement) = ordre SQL
			Statement Stmt = cnx.createStatement();

			// ParamÃ©trer l'objet de commande

			// Execute l'ordre SQL
			ResultSet tableResulante = Stmt.executeQuery(SQL_SELECT_ALL_UTILISATEUR);
			while (tableResulante.next()) {
				Utilisateur a = map(tableResulante);
				listeUtilisateurs.add(a); // !! ne pas oublier d'ajouter l'article dans la liste

				// System.out.println(a);
				 System.out.println(listeUtilisateurs);
				// System.out.println("test select :"+selectUtilisateurByPseudo("toto"));

				// System.out.println("test select by id:"+selectUtilisateurById(1));
				// deleteUtilisateur(2);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw new DALException(sqle.getMessage());
		}

		return listeUtilisateurs;

	}

	/******************** select by pseudo to show data profil user************************/
	@Override
	public Utilisateur selectUtilisateurByPseudo(String pseudo) throws DALException {
		Utilisateur utilisateur = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pStmt = cnx.prepareStatement(SQL_SELECT_UTILISATEUR_PROFILE);
			pStmt.setString(1, pseudo);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				utilisateur = map(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}

		return utilisateur;

	}

	/******************* select user by id ************************/

	@Override
	public Utilisateur selectUtilisateurById(int id_Utilisateur) throws DALException {

		Utilisateur utilisateur = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pStmt = cnx.prepareStatement(SQL_SELECT_UTILISATEUR_BY_ID);
			pStmt.setInt(1, id_Utilisateur);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				utilisateur = map(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}

		return utilisateur;

	}

	/***************************** Authentification BY PSEUDO******************************/
	@Override
	public boolean authenticate_Pseudo(String pseudo, String password) {

		Boolean result = false; // Set result to false
		try (Connection conn = ConnectionProvider.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(SQL_SELECT_UTILISATEUR_SESSION_PSEUDO);
			ps.setString(1, pseudo); // Set 1st WHERE to eMail
			ps.setString(2, password); // Set 2nd WHERE to password

			ResultSet rs = ps.executeQuery(); // Execute Query

			// Check if there is a db result matching the email and password
			if (!rs.next() && rs.getRow() == 0) {
				result = false; // If there is no result set false
				System.out.println("User details are incorrect.");
			} else {
				result = true; // If there is a result set true
				System.out.println("User logged in.");
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}

		return result;

	}
	
	/***************************** find profile BY PSEUDO
	 * @throws DALException ******************************/
	@Override
	public Utilisateur ProfileBy_Pseudo(String pseudo, String password) throws DALException {

		Utilisateur utilisateur = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pStmt = cnx.prepareStatement(SQL_SELECT_UTILISATEUR_SESSION_PSEUDO);
			pStmt.setString(1, pseudo);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				utilisateur = map(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}

		return utilisateur;

	}
		
		

	


	/***************************** Authentification BY MAIL **************************************/
	@Override
	public boolean authenticate_Mail(String eMail, String password) {

		Boolean result = false; // Set result to false
		try (Connection conn = ConnectionProvider.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(SQL_SELECT_UTILISATEUR_SESSION_MAIL);
			ps.setString(1, eMail); // Set 1st WHERE to eMail
			ps.setString(2, password); // Set 2nd WHERE to password

			ResultSet rs = ps.executeQuery(); // Execute Query

			// Check if there is a db result matching the email and password
			if (!rs.next() && rs.getRow() == 0) {
				result = false; // If there is no result set false
				System.out.println("User details are incorrect.");
			} else {
				result = true; // If there is a result set true
				System.out.println("User logged in.");
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}

		return result;

	}

	/******************************* Delete user **************************/
	@Override
	public void deleteUtilisateur(int id_Utilisateur) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SQL_DELETE_UTILISATEUR);
			pStmt.setInt(1, id_Utilisateur);

			// n = nombre de lignes supprimées (ici, soit 1 soit 0).
			int n = pStmt.executeUpdate();

			// return n == 1;//si 1 ligne supprimée --> true, sinon false
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}

	}

	/******************************************************/

	@Override
	public Utilisateur insertUtilisateur(Utilisateur nouvelUtilisateur) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement statement = cnx.prepareStatement(SQL_INSERT_TO_UTILISATEUR,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, nouvelUtilisateur.getPseudo());
			statement.setString(2, nouvelUtilisateur.getNom());
			statement.setString(3, nouvelUtilisateur.getPrenom());
			statement.setString(4, nouvelUtilisateur.getEmail());
			if (nouvelUtilisateur.getTelephone() != null) {
				statement.setString(5, nouvelUtilisateur.getTelephone());
			} else {
				statement.setNull(5, Types.VARCHAR);
			}
			statement.setString(6, nouvelUtilisateur.getRue());
			statement.setString(7, nouvelUtilisateur.getCode_postal());
			statement.setString(8, nouvelUtilisateur.getVille());
			statement.setString(9, nouvelUtilisateur.getMot_de_passe());
			statement.setInt(10, nouvelUtilisateur.getCredit());
			if ( nouvelUtilisateur.getCredit()!=0) {
				statement.setBoolean(11,nouvelUtilisateur.isAdministrateur());
		} else {
				statement.setBoolean(11, false);
			}
	

			int i=statement.executeUpdate();
			if(i > 0) {
                System.out.println("You are sucessfully registered");
            	System.out.println("User with following details was saved in DB: " + nouvelUtilisateur.toString());
			}
			statement.close();

		

		} catch (Exception e) {
			e.printStackTrace();
			DALException dalException = new DALException();
			throw dalException;

		}
		return nouvelUtilisateur;

	}

	/******************************************************************/
	@Override
	public void updateUtilisateur(Utilisateur user) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement statement = cnx.prepareStatement(SQL_UPDATE_UTILISATEUR);
			statement.setString(1, user.getNom());
			statement.setString(2, user.getPrenom());
			statement.setString(3, user.getEmail());
			if (user.getTelephone() != null) {
				statement.setString(4, user.getTelephone());
			} else {
				statement.setNull(4, Types.VARCHAR);
			}
			statement.setString(5, user.getRue());
			statement.setString(6, user.getCode_postal());
			statement.setString(7, user.getVille());
			statement.setString(8, user.getMot_de_passe());
			statement.setInt(9, user.getCredit());
			statement.setBoolean(10, user.isAdministrateur());
			statement.setInt(11, user.getNo_utilisateur());

			int rowsAffected = statement.executeUpdate();
			statement.close();
			System.out.println(rowsAffected + " Rows affected.");
			System.out.println("User with id " + user.getNo_utilisateur()
					+ " was updated in DB with following details: " + user.toString());
		} catch (Exception e) {
			e.printStackTrace();
			DALException dalException = new DALException();
			throw dalException;

		}

	}

	/*************************** Login *************************************/

	static Connection currentCon = null;
	static ResultSet rs = null;

	public Utilisateur login(Utilisateur bean) {

		// preparing some objects for connection
		Statement stmt = null;

		String username = bean.getPseudo();
		String password = bean.getMot_de_passe();

		// "System.out.println" prints in the console; Normally used to trace the
		// process
		System.out.println("Your user name is " + username);
		System.out.println("Your password is " + password);
		System.out.println("Query: " + SQL_SELECT_UTILISATEUR_PROFILE);

		try {
			// connect to DB
			currentCon = ConnectionProvider.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(SQL_SELECT_UTILISATEUR_PROFILE);
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("désoler vous n'étes pas enregister");

			}

			// if user exists set the isValid variable to true
			else if (more) {
				String firstName = rs.getString("nom");
				String lastName = rs.getString("prenom");

				System.out.println("Welcome " + firstName);
				bean.setNom(firstName);
				bean.setPrenom(lastName);

			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return bean;

	}

	public Utilisateur utilisateurBuilder(ResultSet rs) throws DALException {
		/*
		 * List<ArticleVendu> articlesVendus =
		 * this.getArticlesVendusUtilisateur(rs.getInt("no_utilisateur"));
		 * List<ArticleVendu> articlesAchetes =
		 * this.getArticlesAchetesUtilisateur(rs.getInt("no_utilisateur"));
		 * List<Enchere> encheres =
		 * this.getEncheresUtilisateur(rs.getInt("no_utilisateur"));
		 */

		Utilisateur utilisateur = new Utilisateur();

		try {
			utilisateur.setNo_utilisateur(rs.getInt("no_utilisateur"));

			utilisateur.setPseudo(rs.getString("pseudo"));
			utilisateur.setNom(rs.getString("nom"));
			utilisateur.setPrenom(rs.getString("prenom"));
			utilisateur.setEmail(rs.getString("email"));
			utilisateur.setTelephone(rs.getString("telephone"));
			utilisateur.setRue(rs.getString("rue"));
			utilisateur.setCode_postal(rs.getString("code_postal"));
			utilisateur.setVille(rs.getString("ville"));
			utilisateur.setMot_de_passe(rs.getString("mot_de_passe"));
			utilisateur.setCredit(rs.getInt("credit"));
			utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
//	utilisateur.setArticlesVendus(articlesVendus);
//	utilisateur.setArticlesAchetes(articlesAchetes);
//	utilisateur.setEncheres(encheres);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return utilisateur;

	}

	/*****************************************************/
	public Connection getConnection() {
		Connection conn = ConnectionProvider.getConnection();
		String dbURL = "jdbc:mysql://localhost:3306/db";
		String dbUser = "root";
		String dbPassword = "";

		try {
			if (conn == null) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}

		return conn;

	}

	/************************* fin ****************************/

}
