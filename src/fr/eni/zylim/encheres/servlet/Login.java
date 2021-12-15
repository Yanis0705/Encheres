package fr.eni.zylim.encheres.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.util.List;
import java.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.zylim.encheres.bll.ArticleVenduManager;
import fr.eni.zylim.encheres.bll.UtilisateurManager;
import fr.eni.zylim.encheres.bo.ArticleVendu;
import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.DALException;
import fr.eni.zylim.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "login", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/***********recuperer la liste d'article ******************/
		List<ArticleVendu> listeArticle = ArticleVenduManager.getInstance().selectAllArticle();
		
	
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		Utilisateur userlogin=UtilisateurManager.getInstance().getUtilisateurProfile(userName);
		// recuperer l'utilisateur en cours
		boolean auth = false;
		try {
			auth = UtilisateurManager.getInstance().authenticate_Pseudo_login(userName, password);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (auth) {
			
			out.print("Welcome, " + userName);
			
			
			
			HttpSession session = request.getSession(true); // reuse existing
			// session if exist
			// or create one
			session.setAttribute("user", userName);
			session.setAttribute("userlogin", userlogin);
			session.setAttribute("listeArticle", listeArticle);
			session.setMaxInactiveInterval(600); // 30 seconds

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/AccountUtil.jsp");
			dispatcher.forward(request, response);
			out.close();
		} else {
		
			out.println("<font color=red>Identifiant ou mot de passe incorrect.  .</font>");
			
			
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/Connexion.jsp").forward(request, response);
			out.close();
			

		} // TODO Auto-generated method stub

	}

}
