<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width,initial-scale=1.0" />
<style><%@include file="/style/Inscription.css"%></style>

<title>Inscription</title>


 
</head>
  <body>

 
  
  <h3><a href="/WEB-INF/jsp/Inscription.jsp">Troc-enchères.org</a></h3>
  
   <h4>Créer un compte</h4>
   
  <form action="AjouterUtilisateurServlet.java" method="POST">
<table align=center cellspacing=10>

 <tr>
  <td class="column1">Pseudo:</td>
  <td><input type="text" placeholder="Pseudo" name="pseudo"></td>
 </tr>

 
 <tr>
  <td class="column1">Nom:</td>
  <td><input type="text" placeholder="Nom" name="nom"></td>
 </tr>


 <tr>
  <td class="column1">Prenom:</td>
  <td><input type="text" placeholder="Prénom" name="prenom"></td>
 </tr>


 <tr>
  <td class="column1">Email :</td>
  <td><input type="text" placeholder="Email"name="email"></td>
 </tr>


 <tr>
  <td class="column1">Téléphone :</td>
  <td><input type="text" placeholder="Téléphone"name="telephone"></td>
 </tr>


 <tr>
  <td class="column1">Rue :</td>
  <td><input type="text" placeholder="Rue"name="rue"></td>
 </tr>


 <tr>
  <td class="column1">Code Postal:</td>
  <td><input type="text" placeholder="Code Postal"name="code_postal"></td>
 </tr>
 

 <tr>
  <td class="column1">Ville :</td>
  <td><input type="text" placeholder="Ville"name="ville"></td>
 </tr>
 

 <tr>
  <td class="column1">Mot de passe :</td>
  <td><input type="password" placeholder="Mot de passe"name="mot_de_passe"></td>
 </tr>
 

 <tr>
  <td class="column1">Confirmation :</td>
  <td><input type="password" placeholder="Confirmation"name="mot_de_passe"></td>
 </tr>
 
</table>

<div class="boutonsInscription">
	<div>
		<a href="/WEB-INF/jsp/Utilisateur.jsp">
			<button type="submit"  >Créer</button>
		</a>
	</div>
	

</div>
</form>
  <DIV class="item" "><form name="main0" action="consulteraccueilconnexion" method="get">
        <input type="submit" value="Annuler">
    </form></DIV>

  </body>
</html>