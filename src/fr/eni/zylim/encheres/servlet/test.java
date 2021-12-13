package fr.eni.zylim.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.zylim.encheres.bo.Utilisateur;
import fr.eni.zylim.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class test
 */
@WebServlet	(
		name = "test",urlPatterns = { "/test" }
		)
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//doGet(request, response);
		try
		{	    

		     Utilisateur user = new Utilisateur();
		     user.setPseudo(request.getParameter("un"));
		     user.setMot_de_passe(request.getParameter("pw"));
		  
		     user=UtilisateurDAOJdbcImpl.selectUtilisateurByPseudo(user);
		    
			boolean  bool=true;   		    
		 //    if (user.isValid())
			
		    	  if (bool)
		     {
			        
		          HttpSession session = request.getSession(true);	    
		          session.setAttribute("currentSessionUser",user); 
		          getServletContext().getRequestDispatcher("/WEB-INF/jsp/Utilisateur.jsp").forward(request, response);  
		          response.sendRedirect("/WEB-INF/jsp/Utilisateur.jsp?id="+user.getNom()+"&uname="+user.getPrenom());
		     }
			        
		     else 
		          response.sendRedirect("invalidLogin.jsp"); //error page 
		} 
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		
		
	}

}
