<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="fr.eni.zylim.encheres.bo.Utilisateur" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil</title>
</head>
<%
	Utilisateur utilisateur= request.get("listeUtilisateurs");

%>    
<body>
  
  <h3><a href="/WEB-INF/jsp/Inscription.jsp">Troc-enchères.org</a></h3>
  
   <h4>Créer un compte</h4>
   
  <form action="ModifierUtilisateurServlet.java" method="POST">
<table align=center cellspacing=10>

 <tr>
  <td class="column1">Pseudo:</td>
  <td>pseudo</td>
 </tr>

 
 <tr>
  <td class="column1">Nom:</td>
  <td>nom</td>
 </tr>


 <tr>
  <td class="column1">Prenom:</td>
  <td><%= utilisateur.getPrenom() %></td>
 </tr>


 <tr>
  <td class="column1">Email :</td>
  <td>email</td>
 </tr>


 <tr>
  <td class="column1">Téléphone :</td>
  <td>telephone></td>
 </tr>


 <tr>
  <td class="column1">Rue :</td>
  <td>rue></td>
 </tr>


 <tr>
  <td class="column1">Code Postal:</td>
  <td>code_postal></td>
 </tr>
 

 <tr>
  <td class="column1">Ville :</td>
  <td>ville></td>
 </tr>
 
 
</table>

<div class="boutonProfil">
	<div>
		<a href="<%=getServletContext().getContextPath()%>/Modifier.jsp">
			<button type="submit"  >Modifier</button>
		</a>
	</div>
	
</div>
</form>
  </body>
</html>