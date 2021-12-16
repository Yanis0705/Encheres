<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<style>
<%@ include file="/style/Inscription.css"%></style>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
	rel="stylesheet">
<title>Inscription</title>

</head>

<body>
	
	<div>
			<a href="<%="/encheres/consulteraccueilconnexion"%>"><img class="ico" src="<%=getServletContext().getContextPath()%>/images/icone.png"></a>

			<h3 class="form_label">
			<p>	<a  href="/WEB-INF/jsp/Inscription.jsp">Troc-enchères</a></p>
	
			</h3>

			<h4>Créer un compte</h4>
	</div>
		
	<form action="<c:url value="/EnregisterUtilisateur" />" method="post">

				<table align="center">

					<tr>
						<td class="column1">Pseudo:</td>
						<td><input type="text" placeholder="Pseudo" name="pseudo"
							value="${param.pseudo}"></td>
					</tr>


					<tr>
						<td class="column1">Nom:</td>
						<td><input type="text" placeholder="Nom" name="nom"
							value="${param.nom}"></td>
					</tr>


					<tr>
						<td class="column1">Prénom:</td>
						<td><input type="text" placeholder="Prénom" name="prenom"
							value="${param.prenom}"></td>
					</tr>


					<tr>
						<td class="column1">Email :</td>
						<td><input type="text" placeholder="Email" name="email"
							value="${param.email}"></td>
					</tr>


					<tr>
						<td class="column1">Téléphone :</td>
						<td><input type="text" placeholder="Téléphone"
							name="telephone" value="${param.telephone}"></td>
					</tr>


					<tr>
						<td class="column1">Rue :</td>
						<td><input type="text" placeholder="Rue" name="rue"
							value="${param.rue}"></td>
					</tr>


					<tr>
						<td class="column1">Code Postal:</td>
						<td><input type="text" placeholder="Code Postal"
							name="code_postal" value="${param.code_postal}"></td>
					</tr>


					<tr>
						<td class="column1">Ville :</td>
						<td><input type="text" placeholder="Ville" name="ville"
							value="${param.ville}"></td>
					</tr>


					<tr>
						<td class="column1">Mot de passe :</td>
						<td><input type="password" placeholder="Mot de passe"
							name="mot_de_passe" value="${param.mot_de_passe}"></td>
					</tr>


					<tr>
						<td class="column1">Confirmation :</td>
						<td><input type="password" placeholder="Confirmation"
							name="confirmation" value="${param.confirmation}"></td>
					</tr>
					<tr>
						<td class="column1">Crédit :</td>
						<td><input type="text" placeholder="credit" name="credit"
							value="${param.credit}"></td>
					</tr>

				</table>
	</form>
	
	<form class="boutonInscription" method="post" action="connexionutilisateur">
		<div class="boutonInscription">
				<button id="btn-j" class="btn-creer" type="submit" href="/WEB-INF/jsp/Utilisateur.jsp">Créer</button>
		</div>		

	
		<div class="boutonInscription" action="consulteraccueilconnexion">
	
				<button  id="btn_i" class="btn-creer" type="button"  href="	/WEB-INF/jsp/Accueil.jsp">Annuler</button>
		</div>				
	</form>
				
	</body>
</html>


<!-- href="/WEB-INF/jsp/Accueil.jsp" -->