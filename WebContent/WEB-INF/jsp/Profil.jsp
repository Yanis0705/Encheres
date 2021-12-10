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
 Utilisateur utilisateur;
%>    
<body>
  
  <h3><a href="/WEB-INF/jsp/Inscription.jsp">Troc-enchères.org</a></h3>
  
   <h4>Créer un compte</h4>
   
  <form action="ModifierUtilisateurServlet.java" method="POST">
<table align=center cellspacing=10>

 <tr>
  <td class="column1">Pseudo:</td>
  <td>Pseudo></td>
 </tr>

 
 <tr>
  <td class="column1">Nom:</td>
  <td>nom</td>
 </tr>


 <tr>
  <td class="column1">Prenom:</td>
  <td>Prenom></td>
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
</form>

<DIV class="item" ">
  <form name="main0" action="modifierutilisateur" method="get">
        <input type="submit" value="Modifier">
    </form>
    </DIV>
  </body>
</html>